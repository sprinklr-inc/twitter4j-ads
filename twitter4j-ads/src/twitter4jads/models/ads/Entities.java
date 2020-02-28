package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author niketkhandelwal
 */
public class Entities extends ExtendedEntities implements Serializable {

    @SerializedName("user_mentions")
    private List<UserMentionEntity> userMentions;

    @SerializedName("urls")
    private List<UrlEntity> urls;

    @SerializedName("symbols")
    private List<SymbolEntity> symbols;

    @SerializedName("hashtags")
    private List<HashtagEntity> hashtags;

    @SerializedName("polls")
    private List<PollEntity> polls;
}
