package twitter4j.api;

import com.google.common.base.Optional;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.cards.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:09 PM
 */
public interface TwitterAdsCardsApi {

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    Lead Generation Card identifier to fetch.
     * @return retrieved card details
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/lead_gen/%3Acard_id">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/lead_gen/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterLeadGenerationCard> getLeadGenerationCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Lead Generation Card Ids to fetch. If not provided returns all the Lead Generation Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Lead Generation Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of one or more Lead Generation Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/lead_gen">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/lead_gen</a>
     */
    BaseAdsListResponseIterable<TwitterLeadGenerationCard> getAllLeadGenerationCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                     Optional<Integer> count) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the card to be deleted.
     * @return details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/lead_gen/%3Acard_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/lead_gen/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterLeadGenerationCard> deleteLeadGenerationCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Image App Download Card identifiers to scope the request to. If not provided returns all the Image App Download Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Image App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return details of one or more Image App Download Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/image_app_download">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/image_app_download</a>
     */
    BaseAdsListResponseIterable<TwitterImageAppDownloadCard> getAllImageAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                         Optional<Integer> count) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Video App Download Card identifiers to fetch. If not provided returns all the Video App Download Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Video App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return details of one or more Video App Download Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/video_app_download">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/video_app_download</a>
     */
    BaseAdsListResponseIterable<TwitterVideoAppDownloadCard> getAllVideoAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                         Optional<Integer> count) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the card to be deleted.
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/website/%3Acard_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/website/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterWebsiteCard> deleteWebsiteCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Website Card identifiers to fetch. If not provided returns all the Website Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of website cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of one or more Website Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/website">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/website</a>
     */
    BaseAdsListResponseIterable<TwitterWebsiteCard> getAllWebsiteCards(String accountId, List<String> cardIds, boolean withDeleted, Optional<Integer> count)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    Website Card identifier to fetch.
     * @return retrieved card details
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/website/%3Acard_id">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/website/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterWebsiteCard> getWebsiteCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) App Download Card identifiers to fetch. If not provided returns all the App Download Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of ome or all App Download Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/app_download">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/app_download</a>
     */
    BaseAdsListResponseIterable<TwitterMobileAppCard> getAllAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                             Optional<Integer> count) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    App Download Card identifier to fetch.
     * @return retrieved card details
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/app_download/%3Acard_id">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/app_download/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterMobileAppCard> getAppDownloadCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the App Download Card to be deleted.
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/app_download/%3Acard_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/app_download/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterMobileAppCard> deleteAppDownloadCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the Video App Download Card to be deleted.
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/video_app_download/%3Aid">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/video_app_download/%3Aid</a>
     */
    BaseAdsResponse<TwitterVideoAppDownloadCard> deleteVideoAppDownloadCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the Image App Download Card to be deleted.
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/image_app_download/%3Acard_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/image_app_download/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterImageAppDownloadCard> deleteImageAppDownloadCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param imageTonLocation The TON server location of image file to be used.
     * @return response of posting the video card image file
     * @throws TwitterException
     */
    String postVideoCardImage(String imageTonLocation) throws TwitterException;

    // ---  Stats  ---
    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardId      Lead Generation Card identifier to fetch stats for.
     * @param startTime   The time to collect stats from.
     * @param endTime     The time to collect stats until.
     * @param granularity (optional) The granularity such as DAY or HOUR as String.
     * @param metric      (optional) Specifies the number of App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @param withDeleted (optional) Specifies the number of App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of ome or all App Download Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/1/get/stats/accounts/%3Aaccount_id">https://dev.twitter.com/ads/reference/1/get/stats/accounts/%3Aaccount_id</a>
     */
    BaseAdsResponse<TwitterLeadGenerationStat> getTwitterLeadGenerationStat(String accountId, String cardId, String startTime, Optional<String> endTime,
                                                                            Optional<String> granularity, Optional<String> metric, Optional<Boolean> withDeleted)
            throws TwitterException;

    /**
     * @param accountId           The identifier for the leveraged account. (required)
     * @param name                The name identifier for card. Maximum length: 80 characters. (required)
     * @param title               Title (string) of the lead generation card. Maximum length: 255 characters. (required)
     * @param cta                 Call to Action text of the submit button. Maximum length: 20 characters. (required)
     * @param fallbackUrl         The URL to redirect users to when a card cannot be presented. Maximum length: 255 characters. (required)
     * @param privacyPolicyUrl    URL describing privacy policy of this advertiser. Maximum length: 255 characters. (required)
     * @param imageUrl            URL of an image file uploaded and already hosted by Twitter. Maximum length: 255 characters. When image_data is not passed,
     *                            this parameter is required. (sometimes required)
     * @param imageData           The raw or Base64 encoded image file being uploaded. This is a write-only field. In response, the API will provide a Twitter URL for this image, that can be reused.
     *                            When image is not passed, this parameter is required. (sometimes required)
     * @param submitMethod        HTTP method (GET/POST) for the HTTPS endpoint (submit_url). Maximum length: 255 characters. (optional)
     * @param submitUrl           HTTPS endpoint that will accept the leads. Maximum length: 255 characters. (optional)
     * @param customKeyScreenName Override the parameter used for the 'screen_name' field. When not passed,
     *                            will default to 'screen_name'. Maximum length: 255 characters. (optional)
     * @param customKeyName       Override the parameter used for the 'name' field. When not passed, will default to 'name'. Maximum length: 255
     *                            characters. (optional)
     * @param customKeyEmail      Override the parameter used for the 'email' field. When not passed, will default to 'email'. Maximum length: 255
     *                            characters. (optional)
     * @return details of the created card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterLeadGenerationCard> createLeadGenerationCard(String accountId, String name, String title, String cta, String fallbackUrl,
                                                                        String privacyPolicyUrl, String imageUrl, String imageData,
                                                                        String submitMethod, String submitUrl, String customKeyScreenName,
                                                                        String customKeyName, String customKeyEmail,
                                                                        Map<String, String> customParamKeys) throws TwitterException;

    BaseAdsResponse<TwitterLeadGenerationCard> updateLeadGenerationCard(String accountId, String cardId, String name, String title, String cta,
                                                                        String fallbackUrl, String privacyPolicyUrl, String imageUrl,
                                                                        String imageData, String submitMethod, String submitUrl,
                                                                        String customKeyScreenName, String customKeyName, String customKeyEmail,
                                                                        Map<String, String> customParamKeys) throws TwitterException;



    BaseAdsListResponseIterable<TwitterImageConversationCard> getAllImageConversationCards(String accountId, List<String> cardIds,
                                                                                           boolean withDeleted, Integer count)
            throws TwitterException;

    BaseAdsListResponseIterable<TwitterVideoConversationCard> getAllVideoConversationCards(String accountId, List<String> cardIds,
                                                                                           boolean withDeleted, Integer count)
            throws TwitterException;

    /**
     * @param accountId        The identifier for the leveraged account. (required)
     * @param name             The name identifier for card. Maximum length: 80 characters. (required)
     * @param cardId           The identifier of the card to be updated. (required)
     * @param websiteTitle     The title of the website card. Maximum length: 70 characters. (required)
     * @param websiteUrl       The URL of the website to redirect a user to. Maximum length: 200 characters. (required)
     * @param channelImage     URL of an image file uploaded and already hosted by Twitter. Maximum length: 255 characters. When image_data is not
     *                         passed, this parameter is required. (required)
     * @param channelImageData The raw or Base64 encoded image file being uploaded. This is a write-only field. In response, the API will provide a Twitter URL for this image, that can be reused.
     *                         When image is not passed, this parameter is required. (sometimes required)
     * @return details of the updated card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterWebsiteCard> updateWebsiteCard(String accountId, String name, String cardId, String websiteTitle, String websiteUrl,
                                                          String channelImage, String channelImageData) throws TwitterException;

    /**
     * @param accountId        The identifier for the leveraged account. (required)
     * @param name             The name identifier for card. Maximum length: 80 characters. (required)
     * @param websiteTitle     The title of the website card. Maximum length: 70 characters. (required)
     * @param websiteUrl       The URL of the website to redirect a user to. Maximum length: 200 characters. (required)
     * @param channelImage     URL of an image file uploaded and already hosted by Twitter. Maximum length: 255 characters. When image_data is not passed, this parameter is required. (required)
     * @param channelImageData The raw or Base64 encoded image file being uploaded. This is a write-only field. In response,
     *                         the API will provide a Twitter URL for this image, that can be reused. When image is not passed,
     *                         this parameter is required. (sometimes required)
     * @return details of the created card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterWebsiteCard> createWebsiteCard(String accountId, String name, String websiteTitle, String websiteUrl, String channelImage,
                                                          String channelImageData) throws TwitterException;

    /**
     * @param accountId            The identifier for the leveraged account. (required)
     * @param name                 The name identifier for card. Maximum length: 80 characters. (required)
     * @param appCountryCode       2 letter ISO code for the country where the App is sold. (required)
     * @param iphoneAppId          This is usually numeric and available in your app store URL. For example,
     *                             333903271 is the id for twitter. You can retrieve the id from Apple App Store URL - https://itunes.apple.com/us/app/twitter/id<IPHONE_APP_ID>
     * @param ipadAppId            This is usually numeric and available in your app store URL. For example,
     *                             333903271 is the id for twitter. You can retrieve the id from Apple App Store URL - https://itunes.apple.com/us/app/twitter/id<IPAD_APP_ID>
     * @param googlePlayAppId      This ID is googleplay’s application package name. For example, twitter’s google play app id is com.twitter.android.
     * @param iphoneDeepLink       This is your app's deep link.
     * @param ipadDeepLink         This is your app's deep link.
     * @param googlePlayDeepLink   This is your app's deep link.
     * @param customIcon           An image URL hosted by Twitter which will be used instead of the app store's icon. This is a write-only field.
     *                             This needs to be minimum of 144px wide/height with the aspect ratio 1:1. This param cannot be passed when custom_icon_data is passed.
     * @param customIconData       The raw or Base64 encoded icon image file being uploaded, which will be used instead of the app store's icon.
     *                             This is a write-only field. This needs to be minimum of 144px wide/height with the aspect ratio 1:1. In
     *                             response, the API will provide a Twitter URL for this image, that can be reused. This param cannot be passed when custom_icon is passed.
     * @param customAppDescription This is a custom description of the app. If supplied, it will be used instead of the description from the app store.
     * @return details of the created card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterMobileAppCard> createAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                                String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink,
                                                                String googlePlayDeepLink, String customIcon, String customIconData,
                                                                String customAppDescription, String callToAction) throws TwitterException;

    /**
     * @param accountId            The identifier for the leveraged account. (required)
     * @param name                 The name identifier for card. Maximum length: 80 characters. (required)
     * @param cardId               The identifier of the card to be updated
     * @param appCountryCode       2 letter ISO code for the country where the App is sold. (required)
     * @param iphoneAppId          This is usually numeric and available in your app store URL. For example,
     *                             333903271 is the id for twitter. You can retrieve the id from Apple App Store URL - https://itunes.apple.com/us/app/twitter/id<IPHONE_APP_ID>
     * @param ipadAppId            This is usually numeric and available in your app store URL. For example,
     *                             333903271 is the id for twitter. You can retrieve the id from Apple App Store URL - https://itunes.apple.com/us/app/twitter/id<IPAD_APP_ID>
     * @param googlePlayAppId      This ID is googleplay’s application package name. For example, twitter’s google play app id is com.twitter.android.
     * @param iphoneDeepLink       This is your app's deep link.
     * @param ipadDeepLink         This is your app's deep link.
     * @param googlePlayDeepLink   This is your app's deep link.
     * @param customIcon           An image URL hosted by Twitter which will be used instead of the app store's icon. This is a write-only field.
     *                             This needs to be minimum of 144px wide/height with the aspect ratio 1:1. This param cannot be passed when custom_icon_data is passed.
     * @param customIconData       The raw or Base64 encoded icon image file being uploaded, which will be used instead of the app store's icon.
     *                             This is a write-only field. This needs to be minimum of 144px wide/height with the aspect ratio 1:1. In
     *                             response, the API will provide a Twitter URL for this image, that can be reused. This param cannot be passed when custom_icon is passed.
     * @param customAppDescription This is a custom description of the app. If supplied, it will be used instead of the description from the app store.
     * @return details of the updated card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterMobileAppCard> updateAppDownloadCard(String accountId, String name, String cardId, String appCountryCode,
                                                                String iphoneAppId, String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                String ipadDeepLink, String googlePlayDeepLink, String customIcon,
                                                                String customIconData, String customAppDescription, String callToAction)
            throws TwitterException;


    BaseAdsResponse<TwitterImageAppDownloadCard> createImageAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                                            String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                            String ipadDeepLink, String googlePlayDeepLink, String wideAppImage,
                                                                            String wideAppImageData, String callToAction) throws TwitterException;

    BaseAdsResponse<TwitterImageAppDownloadCard> updateImageAppDownloadCard(String accountId, String name, String cardId, String appCountryCode,
                                                                            String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                            String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                            String wideAppImage, String wideAppImageData, String callToAction)
            throws TwitterException;

    BaseAdsResponse<TwitterVideoAppDownloadCard> createVideoAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                                            String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                            String ipadDeepLink, String googlePlayDeepLink, String videoUrl,
                                                                            String imageUrl, String callToAction)
            throws TwitterException, IOException, InterruptedException;

    BaseAdsResponse<TwitterVideoAppDownloadCard> updateVideoAppDownloadCard(String accountId, String name, String cardId, String appCountryCode,
                                                                            String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                            String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                            String updatedImageUrl, String updatedVideoUrl, String originalImageId,
                                                                            String originalVideoId, String callToActionValue)
            throws TwitterException, IOException, InterruptedException;


    BaseAdsResponse<TwitterImageConversationCard> createImageConversationCard(String accountId, String name, String title, String firstCta,
                                                                              String firstCtaTweet, String secondCta, String secondCtaTweet,
                                                                              String thanksText, String thanksUrl, String imageUrl)
            throws TwitterException;

    BaseAdsResponse<TwitterImageConversationCard> updateImageConversationCard(String accountId, String cardId, String name, String title,
                                                                              String firstCta, String firstCtaTweet, String secondCta,
                                                                              String secondCtaTweet, String thanksText, String thanksUrl,
                                                                              String imageUrl) throws TwitterException;

    BaseAdsResponse<TwitterImageConversationCard> deleteImageConversationCard(String accountId, String cardId) throws TwitterException;

    BaseAdsResponse<TwitterVideoConversationCard> createVideoConversationCard(String accountId, String name, String title, String firstHashtag,
                                                                              String firstTweet, String secondHashtag, String secondTweet,
                                                                              String thanksText, String thanksUrl, String imageUrl, String videoUrl)
            throws TwitterException;

    BaseAdsResponse<TwitterVideoConversationCard> updateVideoConversationCard(String accountId, String cardId, String name, String title,
                                                                              String firstCta, String firstCtaTweet, String secondCta,
                                                                              String secondCtaTweet, String thanksText, String thanksUrl,
                                                                              String updatedImageUrl, String updatedVideoUrl) throws TwitterException;

    BaseAdsResponse<TwitterVideoConversationCard> deleteVideoConversationCard(String accountId, String cardId) throws TwitterException;

}
