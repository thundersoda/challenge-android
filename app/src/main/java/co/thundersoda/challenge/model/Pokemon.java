package co.thundersoda.challenge.model;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Pokemon implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("supertype")
    private String supertype;

    @SerializedName("subtypes")
    private List<String> subtypes = null;

    @SerializedName("level")
    private String level;

    @SerializedName("hp")
    private String hp;

    @SerializedName("types")
    private List<String> types = null;

    @SerializedName("attacks")
    private List<Attack> attacks;

    @SerializedName("weaknesses")
    private List<Weakness> weaknesses = null;

    @SerializedName("resistances")
    private List<Resistance> resistances = null;

    @SerializedName("retreatCost")
    private List<String> retreatCost = null;

    @SerializedName("convertedRetreatCost")
    private Integer convertedRetreatCost;

    @SerializedName("set")
    private Set set;

    @SerializedName("number")
    private String number;

    @SerializedName("artist")
    private String artist;

    @SerializedName("rarity")
    private String rarity;

    @SerializedName("nationalPokedexNumbers")
    private List<Integer> nationalPokedexNumbers = null;

    @SerializedName("legalities")
    private Legalities legalities;

    @SerializedName("images")
    private Images images;

    public Pokemon() {
    }

    public Pokemon(String id, String name, List<Attack> attacks) {
        this.id = id;
        this.name = name;
        this.attacks = attacks;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupertype() {
        return supertype;
    }

    public void setSupertype(String supertype) {
        this.supertype = supertype;
    }

    public List<String> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<String> subtypes) {
        this.subtypes = subtypes;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public List<Weakness> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<Weakness> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<Resistance> getResistances() {
        return resistances;
    }

    public void setResistances(List<Resistance> resistances) {
        this.resistances = resistances;
    }

    public List<String> getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(List<String> retreatCost) {
        this.retreatCost = retreatCost;
    }

    public Integer getConvertedRetreatCost() {
        return convertedRetreatCost;
    }

    public void setConvertedRetreatCost(Integer convertedRetreatCost) {
        this.convertedRetreatCost = convertedRetreatCost;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public List<Integer> getNationalPokedexNumbers() {
        return nationalPokedexNumbers;
    }

    public void setNationalPokedexNumbers(List<Integer> nationalPokedexNumbers) {
        this.nationalPokedexNumbers = nationalPokedexNumbers;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
