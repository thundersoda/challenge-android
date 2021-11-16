package co.thundersoda.challenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Set implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("series")
    private String series;

    @SerializedName("printedTotal")
    private Integer printedTotal;

    @SerializedName("total")
    private Integer total;

    @SerializedName("legalities")
    private Legalities legalities;

    @SerializedName("ptcgoCode")
    private String ptcgoCode;

    @SerializedName("releaseDate")
    private String releaseDate;

    @SerializedName("updatedAt")
    private String updatedAt;

    @SerializedName("images")
    private Images images;

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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getPrintedTotal() {
        return printedTotal;
    }

    public void setPrintedTotal(Integer printedTotal) {
        this.printedTotal = printedTotal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public String getPtcgoCode() {
        return ptcgoCode;
    }

    public void setPtcgoCode(String ptcgoCode) {
        this.ptcgoCode = ptcgoCode;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
