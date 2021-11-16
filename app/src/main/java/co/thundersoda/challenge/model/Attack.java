package co.thundersoda.challenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Attack implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("cost")
    private List<String> cost = null;

    @SerializedName("convertedEnergyCost")
    private Integer convertedEnergyCost;

    @SerializedName("damage")
    private String damage;

    @SerializedName("text")
    private String text;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCost() {
        return cost;
    }

    public void setCost(List<String> cost) {
        this.cost = cost;
    }

    public Integer getConvertedEnergyCost() {
        return convertedEnergyCost;
    }

    public void setConvertedEnergyCost(Integer convertedEnergyCost) {
        this.convertedEnergyCost = convertedEnergyCost;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
