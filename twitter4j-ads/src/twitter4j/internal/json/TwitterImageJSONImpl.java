package twitter4j.internal.json;

import twitter4j.internal.models4j.Image;
import twitter4j.internal.org.json.JSONObject;

import static twitter4j.internal.json.z_T4JInternalParseUtil.getLong;
import static twitter4j.internal.json.z_T4JInternalParseUtil.getRawString;

/**
 * Created with IntelliJ IDEA.
 * User: vedsurtani
 * Date: 08/05/14
 * Time: 7:49 PM
 */
public class TwitterImageJSONImpl implements Image {
    private Long width;
    private Long height;
    private String imageType;

    public TwitterImageJSONImpl(JSONObject json) {
        width =  getLong("w",json);
        height = getLong("h",json);
        imageType = getRawString("image_type",json);
    }

    @Override
    public Long width() {
        return width;
    }

    @Override
    public Long height() {
        return height;
    }

    @Override
    public String imageType() {
        return imageType;
    }
}
