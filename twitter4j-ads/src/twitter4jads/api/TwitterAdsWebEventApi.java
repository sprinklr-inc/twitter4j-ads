package twitter4jads.api;

import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.tags.WebEventTag;
import twitter4jads.models.ads.tags.WebEventTagType;

/**
 * User: abhay
 * Date: 4/7/16
 * Time: 12:15 PM
 */
public interface TwitterAdsWebEventApi {

    /**
     * @param accountId   The identifier for the leveraged account. (required)
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of web event tags to retrieve, up to a maximum of 1000 per distinct request.
     * @param cursor      (optional) Specify a cursor to retrieve data from a specific page (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return Web Event Tags for the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/web_event_tags">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/web_event_tags</a>
     */
    BaseAdsListResponseIterable<WebEventTag> getAllWebEventTags(String accountId, boolean withDeleted, Integer count, String cursor)
            throws TwitterException;

    /**
     * @param accountId     The identifier for the leveraged account. (required)
     * @param withDeleted   Include deleted results in your request. Defaults to false.
     * @param webEventTagId The identifier for the web event tag to retrieve
     * @return Queried web event tag
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/web_event_tags/%3Aid">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/web_event_tags/%3Aid</a>
     */
    BaseAdsResponse<WebEventTag> getWebEventTag(String accountId, boolean withDeleted, String webEventTagId) throws TwitterException;

    /**
     * @param accountId          The identifier for the leveraged account. (required)
     * @param name               The name of the web tag
     * @param clickWindow        The click window for this web tag. Possible values are 1, 7, 14, 30, 60 or 90.
     * @param viewThroughWindow  The view through window for this web tag. This value must always be less than or equal to the click_window value. Possible values are 0, 1, 7, 14, 30, 60 or 90.
     * @param type               The type of web tag.
     * @param retargetingEnabled Boolean indicating if retargeting should be enabled for this web tag. Possible values are true, 1, false, 0
     * @return created Event Tag
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/web_event_tags">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/web_event_tags</a>
     */
    BaseAdsResponse<WebEventTag> createWebEventTag(String accountId, String name, Integer clickWindow, Integer viewThroughWindow,
                                                   WebEventTagType type, boolean retargetingEnabled) throws TwitterException;

    /**
     * @param accountId          The identifier for the leveraged account. (required)
     * @param webEventTagId      The identifier for a web tag on the current account
     * @param name               The name of the web tag
     * @param clickWindow        The click window for this web tag. Possible values are 1, 7, 14, 30, 60 or 90
     * @param viewThroughWindow  The view through window for this web tag. This value must always be less than or equal to the click_window value.
     *                           Possible values are 0, 1, 7, 14, 30, 60 or 90.
     * @param type               The type of web tag
     * @param retargetingEnabled Boolean indicating if retargeting should be enabled for this web tag. Possible values are true, 1, false, 0
     * @return Updated Event Tag
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/put/accounts/%3Aaccount_id/web_event_tags/%3Aid">https://dev.twitter.com/ads/reference/put/accounts/%3Aaccount_id/web_event_tags/%3Aid</a>
     */
    BaseAdsResponse<WebEventTag> updateWebEventTag(String accountId, String webEventTagId, String name, Integer clickWindow,
                                                   Integer viewThroughWindow, WebEventTagType type, boolean retargetingEnabled)
            throws TwitterException;

    /**
     * Delete a specific web event tag associated to the current account.
     *
     * @param accountId     The identifier for the leveraged account. (required)
     * @param webEventTagId The identifier for the web event tag
     * @return Deleted Tag
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/web_event_tags/%3Aid">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/web_event_tags/%3Aid</a>
     */
    BaseAdsResponse<WebEventTag> deleteWebEventTag(String accountId, String webEventTagId) throws TwitterException;

}
