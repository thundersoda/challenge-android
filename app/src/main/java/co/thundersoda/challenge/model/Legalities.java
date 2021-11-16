package co.thundersoda.challenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Legalities implements Serializable {

    @SerializedName("unlimited")
    private String unlimited;

    public String getUnlimited() {
        return unlimited;
    }

    public void setUnlimited(String unlimited) {
        this.unlimited = unlimited;
    }
}
