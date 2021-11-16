package co.thundersoda.challenge.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MonResponse {

    @SerializedName("data")
    private List<Pokemon> data;

    public List<Pokemon> getData() {
        return data;
    }

    @NonNull
    @Override
    public String toString() {
        return data.toString();
    }
}
