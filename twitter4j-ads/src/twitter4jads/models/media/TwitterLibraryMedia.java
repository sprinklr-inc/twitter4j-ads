package twitter4jads.models.media;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * User: abhishekanand
 * Date: 07/11/17 2:32 PM.
 */
public class TwitterLibraryMedia {

    @SerializedName("tweeted")
    private Boolean tweeted;

    @SerializedName("duration")
    private Long duration;

    @SerializedName("name")
    private String name;

    @SerializedName("file_name")
    private String fileName;

    @SerializedName("description")
    private String description;

    @SerializedName("media_url")
    private String mediaUrl;

    @SerializedName("media_category")
    private String mediaCategory;

    @SerializedName("media_status")
    private String mediaStatus;

    @SerializedName("poster_image_url")
    private String posterImageUrl;

    @SerializedName("poster_image_media_key")
    private String posterImageMediaKey;

    @SerializedName("media_key")
    private String mediaKey;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("title")
    private String title;

    @SerializedName("media_type")
    private String mediaType;

    @SerializedName("aspect_ratio")
    private String aspectRatio;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("deleted")
    private boolean deleted;

    public Boolean getTweeted() {
        return tweeted;
    }

    public void setTweeted(Boolean tweeted) {
        this.tweeted = tweeted;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMediaCategory() {
        return mediaCategory;
    }

    public void setMediaCategory(String mediaCategory) {
        this.mediaCategory = mediaCategory;
    }

    public String getMediaStatus() {
        return mediaStatus;
    }

    public void setMediaStatus(String mediaStatus) {
        this.mediaStatus = mediaStatus;
    }

    public String getMediaKey() {
        return mediaKey;
    }

    public void setMediaKey(String mediaKey) {
        this.mediaKey = mediaKey;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterImageMediaKey() {
        return posterImageMediaKey;
    }

    public void setPosterImageMediaKey(String posterImageMediaKey) {
        this.posterImageMediaKey = posterImageMediaKey;
    }

    public String getPosterImageUrl() {
        return posterImageUrl;
    }

    public void setPosterImageUrl(String posterImageUrl) {
        this.posterImageUrl = posterImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
