package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author akashMaurya
 * @Date 20/04/16.
 */
public class TwitterEntityStatistics {

    private static final String ID = "id";
    private static final String ID_DATA = "id_data";

    @SerializedName(ID)
    private String id;

    @SerializedName(ID_DATA)
    private List<TwitterMetricsBySegmentation> idData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TwitterMetricsBySegmentation> getIdData() {
        return idData;
    }

    public void setIdData(List<TwitterMetricsBySegmentation> idData) {
        this.idData = idData;
    }

    @Override
    public String toString() {
        return "TwitterEntityStatistics{" +
               "id='" + id + '\'' +
               ", idData=" + idData +
               '}';
    }
}
