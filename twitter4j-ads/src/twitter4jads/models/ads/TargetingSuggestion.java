package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * Date: 26/03/14
 * Time: 12:45 AM
 */
public class TargetingSuggestion {

    @SerializedName("suggestion_value")
    private String suggestionValue;

    @SerializedName("suggestion_type")
    private SuggestionType suggestionType;

    public String getSuggestionValue() {
        return suggestionValue;
    }

    public void setSuggestionValue(String suggestionValue) {
        this.suggestionValue = suggestionValue;
    }

    public SuggestionType getSuggestionType() {
        return suggestionType;
    }

    public void setSuggestionType(SuggestionType suggestionType) {
        this.suggestionType = suggestionType;
    }
}
