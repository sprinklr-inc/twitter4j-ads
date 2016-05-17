package twitter4j.api;

import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.video.AssociateVideoToAccountResponse;
import twitter4j.models.video.TwitterAccountMediaResponse;
import twitter4j.models.video.TwitterCreativeType;
import twitter4j.models.video.UploadMediaObjectResponse;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:40 AM
 */
public interface TwitterAdsVideoApi {

    /**
     * @param accountId             The identifier for the leveraged account.
     * @param mediaId               The media ID to be used.
     * @param videoId               The video ID to be used.
     * @param twitterCreativeType   An enum of creative type being used (e.g. INTERSTITIAL).
     * @return response of transforming media in account to promoted video
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/account_media">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/account_media</a>
     */
    BaseAdsResponse<TwitterAccountMediaResponse> transformMediaInAccount(String accountId, String mediaId, String videoId,
                                                                         TwitterCreativeType twitterCreativeType) throws TwitterException;

    /**
     * @param accountId             The identifier for the leveraged account.
     * @param mediaId               The media ID being used to create promoted video.
     * @param title                 Title of video creative being created.
     * @param description           Description of video creative being created.
     * @return response of associating promoted video with account
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/videos">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/videos</a>
     */
    BaseAdsResponse<AssociateVideoToAccountResponse> associateVideoWithAccount(String accountId, String mediaId, String title, String description)
            throws TwitterException;
}
