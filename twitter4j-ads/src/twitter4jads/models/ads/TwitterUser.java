package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author niketkhandelwal
 * @date Dec 20, 2019
 */
public class TwitterUser implements Serializable {

    @SerializedName("id")
    private Long id;

    @SerializedName("id_str")
    private String idString;

    @SerializedName("name")
    private String name;

    @SerializedName("screen_name")
    private String screenName;

    @SerializedName("description")
    private String description;

    @SerializedName("profile_link_color")
    private String profileLinkColor;

    @SerializedName("profile_text_color")
    private String profileTextColor;

    @SerializedName("default_profile")
    private Boolean defaultProfile;

    @SerializedName("default_profile_image")
    private Boolean defaultProfileImage;

    @SerializedName("profile_image_url")
    private String profileImageUrl;

    @SerializedName("profile_image_url_https")
    private String profileImageUrlHttps;

    @SerializedName("profile_background_tile")
    private Boolean profileBackgroundTile;

    @SerializedName("profile_background_color")
    private String profileBackgroundColor;

    @SerializedName("profile_use_background_image")
    private Boolean profileUseBackgroundImage;

    @SerializedName("profile_background_image_url")
    private String profileBackgroundImageUrl;

    @SerializedName("profile_background_image_url_https")
    private String profileBackgroundImageUrlHttps;

    @SerializedName("profile_sidebar_border_color")
    private String profileSidebarBorderColor;

    @SerializedName("profile_sidebar_fill_color")
    private String profileSidebarFillColor;

    @SerializedName("profile_banner_url")
    private String profileBannerUrl;

    @SerializedName("url")
    private String url;

    @SerializedName("location")
    private String location;

    @SerializedName("time_zone")
    private String timeZone;

    @SerializedName("utc_offset")
    private Integer utcOffset;

    @SerializedName("protected")
    private Boolean isProtected;

    @SerializedName("lang")
    private String lang;

    @SerializedName("verified")
    private Boolean verified;

    @SerializedName("is_translator")
    private Boolean isTranslator;

    @SerializedName("is_translation_enabled")
    private Boolean isTranslationEnabled;

    @SerializedName("translator_type")
    private String translatorType;

    @SerializedName("geo_enabled")
    private Boolean geoEnabled;

    @SerializedName("contributors_enabled")
    private Boolean contributorsEnabled;

    @SerializedName("friends_count")
    private Long friendsCount;

    @SerializedName("listed_count")
    private Long listedCount;

    @SerializedName("followers_count")
    private Long followersCount;

    @SerializedName("favourites_count")
    private Long favoritesCount;

    @SerializedName("statuses_count")
    private Long statusesCount;

    @SerializedName("following")
    private String following;

    @SerializedName("follow_request_sent")
    private String followRequestSent;

    @SerializedName("notifications")
    private String notifications;

    @SerializedName("created_at")
    private String createdAt;

}
