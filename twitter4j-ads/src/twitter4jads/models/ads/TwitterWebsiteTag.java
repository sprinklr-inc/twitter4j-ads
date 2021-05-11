package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2016-2017 Sprinklr, Inc. All rights reserved.
 * Created with Intellij IDEA.
 * User: ratneshjd
 * Date: 03/04/17
 * Time: 3:34 PM
 */
public class TwitterWebsiteTag extends TwitterEntity {

    public static final String TAG_TYPE = "tag_type";
    public static final String EMBED_CODE = "embed_code";
    public static final String DELETED = "deleted";
    public static final String STATUS = "status";
    @SerializedName(TAG_TYPE)
    private WebsiteTagType tagType;
    @SerializedName(EMBED_CODE)
    private String embedCode;
    @SerializedName(DELETED)
    private String deleted;
    @SerializedName(STATUS)
    private WebsiteTagStatus status;

    public WebsiteTagType getTagType() {
        return tagType;
    }

    public void setTagType(WebsiteTagType tagType) {
        this.tagType = tagType;
    }

    public String getEmbedCode() {
        return embedCode;
    }

    public void setEmbedCode(String embedCode) {
        this.embedCode = embedCode;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public WebsiteTagStatus getStatus() {
        return status;
    }

    public void setStatus(WebsiteTagStatus status) {
        this.status = status;
    }

    public enum WebsiteTagType {
        UNIVERSAL, SINGLE_EVENT
    }

    public enum WebsiteTagStatus {
        ACTIVE, DORMANT, INACTIVE
    }
}
