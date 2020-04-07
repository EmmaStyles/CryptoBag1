package infs3634.cryptobag1.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class CoinLoreResponse implements Serializable
{

    @SerializedName("data")
    @Expose
    private List<Coin> data = new ArrayList<Coin>();
    @SerializedName("info")
    @Expose
    private Info info;
    private final static long serialVersionUID = 7208982404491618160L;

    /**
     * No args constructor for use in serialization
     *
     */
    public CoinLoreResponse() {
    }

    /**
     *
     * @param data
     * @param info
     */
    public CoinLoreResponse(List<Coin> data, Info info) {
        super();
        this.data = data;
        this.info = info;
    }

    public List<Coin> getData() {
        return data;
    }

    public void setData(List<Coin> data) {
        this.data = data;
    }

    public CoinLoreResponse withData(List<Coin> data) {
        this.data = data;
        return this;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public CoinLoreResponse withInfo(Info info) {
        this.info = info;
        return this;
    }


}