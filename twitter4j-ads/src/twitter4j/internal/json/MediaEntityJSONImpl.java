/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package twitter4j.internal.json;

import twitter4j.internal.models4j.MediaEntity;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static twitter4j.internal.json.z_T4JInternalParseUtil.getLong;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.2.3
 */
public class MediaEntityJSONImpl extends EntityIndex implements MediaEntity {
    private static final long serialVersionUID = 224487082931268487L;
    private long id;
    private String url;
    private String mediaURL;
    private String mediaURLHttps;
    private String expandedURL;
    private String displayURL;
    private Map<Integer, MediaEntity.Size> sizes;
    private String type;
    private VideoInfo videoInfo;

    MediaEntityJSONImpl(JSONObject json) throws TwitterException {
        try {
            JSONArray indicesArray = json.getJSONArray("indices");
            setStart(indicesArray.getInt(0));
            setEnd(indicesArray.getInt(1));
            this.id = getLong("id", json);

            this.url = json.getString("url");
            this.expandedURL = json.getString("expanded_url");
            this.mediaURL = json.getString("media_url");
            this.mediaURLHttps = json.getString("media_url_https");
            this.displayURL = json.getString("display_url");

            JSONObject sizes = json.getJSONObject("sizes");
            this.sizes = new HashMap<Integer, MediaEntity.Size>(4);
            // thumbworkarounding API side issue
            addMediaEntitySizeIfNotNull(this.sizes, sizes, MediaEntity.Size.LARGE, "large");
            addMediaEntitySizeIfNotNull(this.sizes, sizes, MediaEntity.Size.MEDIUM, "medium");
            addMediaEntitySizeIfNotNull(this.sizes, sizes, MediaEntity.Size.SMALL, "small");
            addMediaEntitySizeIfNotNull(this.sizes, sizes, MediaEntity.Size.THUMB, "thumb");
            if (!json.isNull("type")) {
                this.type = json.getString("type");
            }

            if (json.has("video_info")) {
                JSONObject videoInfoJSONObject = json.getJSONObject("video_info");
                this.videoInfo = new VideoInfoImpl(videoInfoJSONObject);
            }
        } catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }

    private void addMediaEntitySizeIfNotNull(Map<Integer, MediaEntity.Size> sizes, JSONObject sizesJSON, Integer size, String key)
            throws JSONException {
        if (!sizesJSON.isNull(key)) {
            sizes.put(size, new Size(sizesJSON.getJSONObject(key)));
        }
    }

    /* For serialization purposes only. */
    /* package */ MediaEntityJSONImpl() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMediaURL() {
        return mediaURL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMediaURLHttps() {
        return mediaURLHttps;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getURL() {
        return url;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayURL() {
        return displayURL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getExpandedURL() {
        return expandedURL;
    }

    @Override
    public Map<Integer, MediaEntity.Size> getSizes() {
        return sizes;
    }

    @Override
    public VideoInfo getVideoInfo() {
        return videoInfo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getStart() {
        return super.getStart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getEnd() {
        return super.getEnd();
    }

    static class Size implements MediaEntity.Size {
        private static final long serialVersionUID = 8681853416159361581L;
        int width;
        int height;
        int resize;

        Size(JSONObject json) throws JSONException {
            width = json.getInt("w");
            height = json.getInt("h");
            resize = "fit".equals(json.getString("resize")) ? MediaEntity.Size.FIT : MediaEntity.Size.CROP;
        }

        @Override
        public int getWidth() {
            return width;
        }

        @Override
        public int getHeight() {
            return height;
        }

        @Override
        public int getResize() {
            return resize;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Size)) {
                return false;
            }

            Size size = (Size) o;

            if (height != size.height) {
                return false;
            }
            if (resize != size.resize) {
                return false;
            }
            if (width != size.width) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = width;
            result = 31 * result + height;
            result = 31 * result + resize;
            return result;
        }

        @Override
        public String toString() {
            return "Size{" +
                   "width=" + width +
                   ", height=" + height +
                   ", resize=" + resize +
                   '}';
        }
    }

    static class VideoInfoImpl implements MediaEntity.VideoInfo {
        List<Integer> aspectRatio;
        List<Variant> variants;
        Long millis;

        VideoInfoImpl(JSONObject jsonObject) throws TwitterException {
            aspectRatio = new ArrayList<>();
            variants = new ArrayList<>();
            try {
                if (jsonObject.has("aspect_ratio")) {
                    JSONArray aspectRationArray = jsonObject.getJSONArray("aspect_ratio");
                    for (int i = 0; i < aspectRationArray.length(); i++) {
                        aspectRatio.add(aspectRationArray.getInt(i));
                    }
                }
                if (jsonObject.has("duration_millis")) {
                    millis = jsonObject.getLong("duration_millis");
                }

                if (jsonObject.has("variants")) {
                    JSONArray variantJSONArray = jsonObject.getJSONArray("variants");
                    for (int i = 0; i < variantJSONArray.length(); i++) {
                        variants.add(new VariantImpl(variantJSONArray.getJSONObject(i)));
                    }
                }
            } catch (JSONException e) {
                throw new TwitterException(e);
            }
        }

        public List<Integer> getAspectRatio() {
            return aspectRatio;
        }

        public Long getMillis() {
            return millis;
        }


        public void setMillis(Long millis) {
            this.millis = millis;
        }

        @Override
        public List<Variant> getVariants() {
            return this.variants;
        }
    }

    static class VariantImpl implements MediaEntity.Variant {
        String contentType;
        String url;
        Long bitrate;

        public Long getbitrate() {
            return bitrate;
        }

        @Override
        public String getContentType() {
            return contentType;
        }

        @Override
        public String getUrl() {
            return url;
        }

        VariantImpl(JSONObject json) throws JSONException {
            if (json.has("content_type")) {
                contentType = json.getString("content_type");
            }
            if (json.has("url")) {
                url = json.getString("url");
            }
            if (json.has("bitrate")) {
                bitrate = json.getLong("bitrate");
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            VariantImpl variantImpl = (VariantImpl) o;

            if (contentType != null ? !contentType.equals(variantImpl.contentType) : variantImpl.contentType != null) {
                return false;
            }
            if (url != null ? !url.equals(variantImpl.url) : variantImpl.url != null) {
                return false;
            }
            return !(bitrate != null ? !bitrate.equals(variantImpl.bitrate) : variantImpl.bitrate != null);

        }

        @Override
        public int hashCode() {
            int result = contentType != null ? contentType.hashCode() : 0;
            result = 31 * result + (url != null ? url.hashCode() : 0);
            result = 31 * result + (bitrate != null ? bitrate.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "VariantImpl{" +
                   "contentType='" + contentType + '\'' +
                   ", url='" + url + '\'' +
                   ", bitrate=" + bitrate +
                   '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MediaEntityJSONImpl)) {
            return false;
        }

        MediaEntityJSONImpl that = (MediaEntityJSONImpl) o;

        if (id != that.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "MediaEntityJSONImpl{" +
               "id=" + id +
               ", url=" + url +
               ", mediaURL=" + mediaURL +
               ", mediaURLHttps=" + mediaURLHttps +
               ", expandedURL=" + expandedURL +
               ", displayURL='" + displayURL + '\'' +
               ", sizes=" + sizes +
               ", type=" + type +
               '}';
    }
}
