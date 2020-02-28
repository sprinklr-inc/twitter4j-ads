package twitter4jads.api;

import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.cards.*;
import twitter4jads.models.media.TwitterLibraryMedia;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:09 PM
 */
public interface TwitterAdsCardsApi {

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
     * @param cardIds     (optional) Image Conversation Card identifiers to scope the request to. If not provided returns all the Image Conversation Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Image Conversation Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return details of one or more Image Conversation Cards associated with the account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterImageConversationCard> getAllImageConversationCards(String accountId, List<String> cardIds,
                                                                                           boolean withDeleted, Integer count)
            throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Video Conversation Card identifiers to scope the request to. If not provided returns all the Image Conversation Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Video Conversation Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return details of one or more Video Conversation Cards associated with the account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterVideoConversationCard> getAllVideoConversationCards(String accountId, List<String> cardIds,
                                                                                           boolean withDeleted, Integer count)
            throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Video Website Card identifiers to scope the request to. If not provided returns all the Image Conversation Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Video Website Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return details of one or more Video Website Cards associated with the account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterVideoWebsiteCard> getAllVideoWebsiteCards(String accountId, List<String> cardIds,
                                                                                 boolean withDeleted, Integer count)
            throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Video Direct Message Card identifiers to scope the request to. If not provided returns all the Image Conversation Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Video Direct Message Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return details of one or more Video Direct Message Cards associated with the account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterVideoDMCard> getAllVideoDMCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                       Integer count)
            throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Image Direct Message Card identifiers to scope the request to. If not provided returns all the Image Conversation Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Image Direct Message Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return details of one or more Image Conversation Cards associated with the account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterImageDMCard> getAllImageDMCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                       Integer count)
            throws TwitterException;

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
     * @param accountId    The identifier for the leveraged account. (required)
     * @param name         The name identifier for card. Maximum length: 80 characters. (required)
     * @param cardId       The identifier of the card to be updated. (required)
     * @param websiteTitle The title of the website card. Maximum length: 70 characters. (required)
     * @param websiteUrl   The URL of the website to redirect a user to. Maximum length: 200 characters. (required)
     * @return details of the updated card if successful
     */
    BaseAdsResponse<TwitterWebsiteCard> updateWebsiteCard(String accountId, String name, String cardId, String websiteTitle, String websiteUrl,
                                                          String imageMediaKey) throws TwitterException;

    /**
     * @param accountId    The identifier for the leveraged account. (required)
     * @param name         The name identifier for card. Maximum length: 80 characters. (required)
     * @param websiteTitle The title of the website card. Maximum length: 70 characters. (required)
     * @param websiteUrl   The URL of the website to redirect a user to. Maximum length: 200 characters. (required)
     * @return details of the created card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterWebsiteCard> createWebsiteCard(String accountId, String name, String websiteTitle, String websiteUrl, String imageMediaKey)
            throws TwitterException;


    /**
     * @param accountId          The identifier for the leveraged account.
     * @param name               The name for the card.
     * @param countryCode        The two-letter ISO code for the country where the app is sold.
     * @param iphoneAppId        The iPhone app ID.
     * @param ipadAppId          The iPad app ID.
     * @param googlePlayAppId    The Google Play application package name.
     * @param iphoneDeepLink     A deep link into the iPhone app you're promoting.
     * @param ipadDeepLink       A deep link into the iPad app you're promoting.
     * @param googlePlayDeepLink A deep link into the Android app you're promoting.
     * @param imageMediaKey      The media key for an image to be used in this card.
     * @param callToAction       The Call-To-Action (CTA) text for the card button.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterImageAppDownloadCard> createImageAppDownloadCard(String accountId, String name, String countryCode, String iphoneAppId,
                                                                            String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                            String ipadDeepLink, String googlePlayDeepLink, String imageMediaKey,
                                                                            String callToAction) throws TwitterException;

    /**
     * @param accountId          The identifier for the leveraged account.
     * @param name               The name for the card.
     * @param cardId             A reference to the image app download card you are operating with in the request.
     * @param countryCode        The two-letter ISO code for the country where the app is sold.
     * @param iphoneAppId        The iPhone app ID.
     * @param ipadAppId          The iPad app ID.
     * @param googlePlayAppId    The Google Play application package name.
     * @param iphoneDeepLink     A deep link into the iPhone app you're promoting.
     * @param ipadDeepLink       A deep link into the iPad app you're promoting.
     * @param googlePlayDeepLink A deep link into the Android app you're promoting.
     * @param imageMediaKey      The media key for an image to be used in this card.
     * @param callToAction       The Call-To-Action (CTA) text for the card button.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterImageAppDownloadCard> updateImageAppDownloadCard(String accountId, String name, String cardId, String countryCode,
                                                                            String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                            String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                            String imageMediaKey, String callToAction)
            throws TwitterException;

    /**
     * @param accountId          The identifier for the leveraged account.
     * @param name               The name for the card.
     * @param countryCode        The two-letter ISO code for the country where the app is sold.
     * @param iphoneAppId        The iPhone app ID.
     * @param ipadAppId          The iPad app ID.
     * @param googlePlayAppId    The Google Play application package name.
     * @param iphoneDeepLink     A deep link into the iPhone app you're promoting.
     * @param ipadDeepLink       A deep link into the iPad app you're promoting.
     * @param googlePlayDeepLink A deep link into the Android app you're promoting.
     * @param posterMediaKey     The media key for a poster image to be used in this card. If not specified, the first frame will be used.
     * @param callToAction       The Call-To-Action (CTA) text for the card button.
     * @param twitterVideo       The object with video details to be used in the Video App Download Card
     * @return
     * @throws TwitterException
     * @throws IOException
     * @throws InterruptedException
     */
    BaseAdsResponse<TwitterVideoAppDownloadCard> createVideoAppDownloadCard(String accountId, String name, String countryCode, String iphoneAppId,
                                                                            String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                            String ipadDeepLink, String googlePlayDeepLink, String posterMediaKey,
                                                                            String callToAction, TwitterLibraryMedia twitterVideo)
            throws TwitterException, IOException, InterruptedException;

    /**
     * @param accountId          The identifier for the leveraged account.
     * @param name               The name for the card.
     * @param cardId             A reference to the video app download card you are operating with in the request.
     * @param countryCode        The two-letter ISO code for the country where the app is sold.
     * @param iphoneAppId        The iPhone app ID.
     * @param ipadAppId          The iPad app ID.
     * @param googlePlayAppId    The Google Play application package name.
     * @param iphoneDeepLink     A deep link into the iPhone app you're promoting.
     * @param ipadDeepLink       A deep link into the iPad app you're promoting.
     * @param googlePlayDeepLink A deep link into the Android app you're promoting.
     * @param posterMediaKey     The media key for a poster image to be used in this card. If not specified, the first frame will be used.
     * @param callToActionValue  The Call-To-Action (CTA) text for the card button.
     * @param video              The object with video details to be used in the Video App Download Card
     * @return
     * @throws TwitterException
     * @throws IOException
     * @throws InterruptedException
     */
    BaseAdsResponse<TwitterVideoAppDownloadCard> updateVideoAppDownloadCard(String accountId, String name, String cardId, String countryCode,
                                                                            String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                            String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                            String posterMediaKey, String callToActionValue, TwitterLibraryMedia video)
            throws TwitterException, IOException, InterruptedException;


    /**
     * @param accountId     The identifier for the leveraged account.
     * @param name          The name for the card.
     * @param title         The title for the card, which appears below the video and above the CTAs. Maximum length: 23 characters.
     * @param firstHashtag  The Call-To-Action (CTA) hashtag for the first option. Maximum length: 20 characters (not counting the #).
     * @param firstTweet    The Tweet text to be used when the first CTA is clicked.
     * @param secondHashtag The Call-To-Action (CTA) hashtag for the second option. Maximum length: 20 characters (not counting the #).
     * @param secondTweet   The Tweet text to be used when the second CTA is clicked.
     * @param thirdHashtag  The Call-To-Action (CTA) hashtag for the third option. Maximum length: 20 characters (not counting the #).
     * @param thirdTweet    The Tweet text to be used when the third CTA is clicked.
     * @param fourthHashtag The Call-To-Action (CTA) hashtag for the fourth option. Maximum length: 20 characters (not counting the #).
     * @param fourthTweet   The Tweet text to be used when the fourth CTA is clicked.
     * @param thanksText    The text to be displayed after the CTA is clicked. Maximum length: 23 characters.
     * @param thanksUrl     The URL to be displayed with the thank you text.
     * @param imageUrl
     * @param imageMediaKey The media key for an image to be used in this card.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterImageConversationCard> createImageConversationCard(String accountId, String name, String title, String firstHashtag,
                                                                              String firstTweet, String secondHashtag, String secondTweet,
                                                                              String thirdHashtag, String thirdTweet, String fourthHashtag,
                                                                              String fourthTweet, String thanksText, String thanksUrl,
                                                                              String imageUrl, String imageMediaKey) throws TwitterException;

    /**
     * @param accountId     The identifier for the leveraged account.
     * @param cardId        A reference to the image conversation card you are operating with in the request.
     * @param name          The name for the card.
     * @param title         The title for the card, which appears below the video and above the CTAs. Maximum length: 23 characters.
     * @param firstHashtag  The Call-To-Action (CTA) hashtag for the first option. Maximum length: 20 characters (not counting the #).
     * @param firstTweet    The Tweet text to be used when the first CTA is clicked.
     * @param secondHashtag The Call-To-Action (CTA) hashtag for the second option. Maximum length: 20 characters (not counting the #).
     * @param secondTweet   The Tweet text to be used when the second CTA is clicked.
     * @param thirdHashtag  The Call-To-Action (CTA) hashtag for the third option. Maximum length: 20 characters (not counting the #).
     * @param thirdTweet    The Tweet text to be used when the third CTA is clicked.
     * @param fourthHashtag The Call-To-Action (CTA) hashtag for the fourth option. Maximum length: 20 characters (not counting the #).
     * @param fourthTweet   The Tweet text to be used when the fourth CTA is clicked.
     * @param thanksText    The text to be displayed after the CTA is clicked. Maximum length: 23 characters.
     * @param thanksUrl     The URL to be displayed with the thank you text.
     * @param imageUrl
     * @param imageMediaKey The media key for an image to be used in this card.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterImageConversationCard> updateImageConversationCard(String accountId, String cardId, String name, String title,
                                                                              String firstHashtag, String firstTweet, String secondHashtag,
                                                                              String secondTweet, String thirdHashtag, String thirdTweet,
                                                                              String fourthHashtag, String fourthTweet, String thanksText,
                                                                              String thanksUrl, String imageUrl, String imageMediaKey)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    A reference to the iamge conversation card you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterImageConversationCard> deleteImageConversationCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId      The identifier for the leveraged account.
     * @param name           The name for the card.
     * @param title          The title for the card, which appears below the video and above the CTAs. Maximum length: 23 characters.
     * @param firstHashtag   The Call-To-Action (CTA) hashtag for the first option. Maximum length: 20 characters (not counting the #).
     * @param firstTweet     The Tweet text to be used when the first CTA is clicked.
     * @param secondHashtag  The Call-To-Action (CTA) hashtag for the second option. Maximum length: 20 characters (not counting the #).
     * @param secondTweet    The Tweet text to be used when the second CTA is clicked.
     * @param thirdHashtag   The Call-To-Action (CTA) hashtag for the third option. Maximum length: 20 characters (not counting the #).
     * @param thirdTweet     The Tweet text to be used when the third CTA is clicked.
     * @param fourthHashtag  The Call-To-Action (CTA) hashtag for the fourth option. Maximum length: 20 characters (not counting the #).
     * @param fourthTweet    The Tweet text to be used when the fourth CTA is clicked.
     * @param thanksText     The text to be displayed after the CTA is clicked. Maximum length: 23 characters.
     * @param thanksUrl      The URL to be displayed with the thank you text.
     * @param posterMediaKey The media key for a poster image to be used in this card. If not specified, the first frame will be used.
     * @param twitterVideo   The object with video details to be used in the Video Conversation Card
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterVideoConversationCard> createVideoConversationCard(String accountId, String name, String title, String firstHashtag,
                                                                              String firstTweet, String secondHashtag, String secondTweet,
                                                                              String thirdHashtag, String thirdTweet, String fourthHashtag,
                                                                              String fourthTweet, String thanksText, String thanksUrl,
                                                                              String posterMediaKey, TwitterLibraryMedia twitterVideo)
            throws TwitterException;

    /**
     * @param accountId      The identifier for the leveraged account.
     * @param cardId         A reference to the video conversation card you are operating with in the request.
     * @param name           The name for the card.
     * @param title          The title for the card, which appears below the video and above the CTAs. Maximum length: 23 characters.
     * @param firstHashtag   The Call-To-Action (CTA) hashtag for the first option. Maximum length: 20 characters (not counting the #).
     * @param firstTweet     The Tweet text to be used when the first CTA is clicked.
     * @param secondHashtag  The Call-To-Action (CTA) hashtag for the second option. Maximum length: 20 characters (not counting the #).
     * @param secondTweet    The Tweet text to be used when the second CTA is clicked.
     * @param thirdHashtag   The Call-To-Action (CTA) hashtag for the third option. Maximum length: 20 characters (not counting the #).
     * @param thirdTweet     The Tweet text to be used when the third CTA is clicked.
     * @param fourthHashtag  The Call-To-Action (CTA) hashtag for the fourth option. Maximum length: 20 characters (not counting the #).
     * @param fourthTweet    The Tweet text to be used when the fourth CTA is clicked.
     * @param thanksText     The text to be displayed after the CTA is clicked. Maximum length: 23 characters.
     * @param thanksUrl      The URL to be displayed with the thank you text.
     * @param posterMediaKey The media key for a poster image to be used in this card. If not specified, the first frame will be used.
     * @param twitterVideo   The object with video details to be used in the Video Conversation Card
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterVideoConversationCard> updateVideoConversationCard(String accountId, String cardId, String name, String title,
                                                                              String firstHashtag, String firstTweet, String secondHashtag,
                                                                              String secondTweet, String thirdHashtag, String thirdTweet,
                                                                              String fourthHashtag, String fourthTweet, String thanksText,
                                                                              String thanksUrl, String posterMediaKey, TwitterLibraryMedia twitterVideo)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    A reference to the video conversation card you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterVideoConversationCard> deleteVideoConversationCard(String accountId, String cardId) throws TwitterException;


    /**
     * @param accountId              The identifier for the leveraged account.
     * @param name                   The name for the card.
     * @param firstCta               The Call-To-Action (CTA) text for the first option. Maximum length: 20 characters.
     * @param firstWelcomeMessageId  The welcome message ID to associate with the first CTA.
     * @param secondCta              The Call-To-Action (CTA) text for the second option. Maximum length: 20 characters.
     * @param secondWelcomeMessageId The welcome message ID to associate with the second CTA.
     * @param thirdCta               The Call-To-Action (CTA) text for the third option. Maximum length: 20 characters.
     * @param thirdWelcomeMessageId  The welcome message ID to associate with the third CTA.
     * @param fourthCta              The Call-To-Action (CTA) text for the fourth option. Maximum length: 20 characters.
     * @param fourthWelcomeMessageId The welcome message ID to associate with the fourth CTA.
     * @param recipientAccountId     The user to start a conversation with, from the perspective of the user interacting with the card.
     * @param imageUrl
     * @param imageMediaKey          The media key for an image to be used in this card.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterImageDMCard> createImageDMCard(String accountId, String name, String firstCta, Long firstWelcomeMessageId,
                                                          String secondCta, Long secondWelcomeMessageId,
                                                          String thirdCta, Long thirdWelcomeMessageId, String fourthCta, Long fourthWelcomeMessageId,
                                                          Long recipientAccountId,
                                                          String imageUrl, String imageMediaKey) throws TwitterException;

    /**
     * @param accountId              The identifier for the leveraged account.
     * @param name                   The name for the card.
     * @param firstCta               The Call-To-Action (CTA) text for the first option. Maximum length: 20 characters.
     * @param firstWelcomeMessageId  The welcome message ID to associate with the first CTA.
     * @param secondCta              The Call-To-Action (CTA) text for the second option. Maximum length: 20 characters.
     * @param secondWelcomeMessageId The welcome message ID to associate with the second CTA.
     * @param thirdCta               The Call-To-Action (CTA) text for the third option. Maximum length: 20 characters.
     * @param thirdWelcomeMessageId  The welcome message ID to associate with the third CTA.
     * @param fourthCta              The Call-To-Action (CTA) text for the fourth option. Maximum length: 20 characters.
     * @param fourthWelcomeMessageId The welcome message ID to associate with the fourth CTA.
     * @param recipientAccountId     The user to start a conversation with, from the perspective of the user interacting with the card.
     * @param imageUrl
     * @param videoUrl
     * @param posterMediaKey         The media key for a poster image to be used in this card. If not specified, the first frame will be used.
     * @param videoMediaKey          The media key for a video to be used in this card.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterVideoDMCard> createVideoDMCard(String accountId, String name, String firstCta, Long firstWelcomeMessageId,
                                                          String secondCta, Long secondWelcomeMessageId, String thirdCta,
                                                          Long thirdWelcomeMessageId, String fourthCta, Long fourthWelcomeMessageId,
                                                          Long recipientAccountId, String imageUrl, String videoUrl,
                                                          String posterMediaKey, String videoMediaKey) throws TwitterException;

    /**
     * @param accountId              The identifier for the leveraged account.
     * @param name                   The name for the card.
     * @param firstCta               The Call-To-Action (CTA) text for the first option. Maximum length: 20 characters.
     * @param firstWelcomeMessageId  The welcome message ID to associate with the first CTA.
     * @param secondCta              The Call-To-Action (CTA) text for the second option. Maximum length: 20 characters.
     * @param secondWelcomeMessageId The welcome message ID to associate with the second CTA.
     * @param thirdCta               The Call-To-Action (CTA) text for the third option. Maximum length: 20 characters.
     * @param thirdWelcomeMessageId  The welcome message ID to associate with the third CTA.
     * @param fourthCta              The Call-To-Action (CTA) text for the fourth option. Maximum length: 20 characters.
     * @param fourthWelcomeMessageId The welcome message ID to associate with the fourth CTA.
     * @param imageUrl
     * @param imageMediaKey          The media key for an image to be used in this card.
     * @param channelId              A reference to the image direct message card you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterImageDMCard> updateImageDMCard(String accountId, String name, String firstCta, Long firstWelcomeMessageId,
                                                          String secondCta, Long secondWelcomeMessageId,
                                                          String thirdCta, Long thirdWelcomeMessageId, String fourthCta, Long fourthWelcomeMessageId,
                                                          String imageUrl, String imageMediaKey, String channelId) throws TwitterException;

    /**
     * @param accountId              The identifier for the leveraged account.
     * @param name                   The name for the card.
     * @param firstCta               The Call-To-Action (CTA) text for the first option. Maximum length: 20 characters.
     * @param firstWelcomeMessageId  The welcome message ID to associate with the first CTA.
     * @param secondCta              The Call-To-Action (CTA) text for the second option. Maximum length: 20 characters.
     * @param secondWelcomeMessageId The welcome message ID to associate with the second CTA.
     * @param thirdCta               The Call-To-Action (CTA) text for the third option. Maximum length: 20 characters.
     * @param thirdWelcomeMessageId  The welcome message ID to associate with the third CTA.
     * @param fourthCta              The Call-To-Action (CTA) text for the fourth option. Maximum length: 20 characters.
     * @param fourthWelcomeMessageId The welcome message ID to associate with the fourth CTA.
     * @param imageUrl
     * @param videoUrl
     * @param posterMediaKey         The media key for a poster image to be used in this card. If not specified, the first frame will be used.
     * @param videoMediaKey          The media key for a video to be used in this card.
     * @param channelId              A reference to the video direct message card you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterVideoDMCard> updateVideoDMCard(String accountId, String name, String firstCta, Long firstWelcomeMessageId,
                                                          String secondCta, Long secondWelcomeMessageId, String thirdCta,
                                                          Long thirdWelcomeMessageId, String fourthCta, Long fourthWelcomeMessageId,
                                                          String imageUrl, String videoUrl, String posterMediaKey, String videoMediaKey,
                                                          String channelId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    A reference to the image direct message card you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterImageDMCard> deleteImageDMCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    A reference to the image direct message card you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterVideoDMCard> deleteVideoDMCard(String accountId, String cardId) throws TwitterException;


    /**
     * @param accountId     The identifier for the leveraged account.
     * @param name          The name for the card.
     * @param title         The title for the card, which appears below the video and above the CTAs. Maximum length: 23 characters.
     * @param videoMediaKey The media key for a video to be used in this card.
     * @param websiteUrl    The URL of the website to redirect a user to.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterVideoWebsiteCard> createVideoWebsiteCard(String accountId, String name, String title, String videoMediaKey, String websiteUrl)
            throws TwitterException;

    /**
     * @param accountId     The identifier for the leveraged account.
     * @param cardId        A reference to the video website card you are operating with in the request.
     * @param name          The name for the card.
     * @param title         The title for the card, which appears below the video and above the CTAs. Maximum length: 23 characters.
     * @param videoMediaKey The media key for a video to be used in this card.
     * @param websiteUrl    The URL of the website to redirect a user to.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterVideoWebsiteCard> updateVideoWebsiteCard(String accountId, String cardId, String name, String title, String videoMediaKey,
                                                                    String websiteUrl) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    A reference to the video website card you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterVideoWebsiteCard> deleteVideoWebsiteCard(String accountId, String cardId) throws TwitterException;

}
