package com.example.catapi.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Vote {

    @SerializedName("country_code")
    @Expose
    private Object countryCode;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("image_id")
    @Expose
    private String imageId;
    @SerializedName("sub_id")
    @Expose
    private Object subId;
    @SerializedName("value")
    @Expose
    private int value;

    /**
     * No args constructor for use in serialization
     *
     */
    public Vote() {
    }

    /**
     *
     * @param subId
     * @param createdAt
     * @param imageId
     * @param countryCode
     * @param id
     * @param value
     */
    public Vote(Object countryCode, String createdAt, int id, String imageId, Object subId, int value) {
        super();
        this.countryCode = countryCode;
        this.createdAt = createdAt;
        this.id = id;
        this.imageId = imageId;
        this.subId = subId;
        this.value = value;
    }

    public Object getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Object countryCode) {
        this.countryCode = countryCode;
    }

    public Vote withCountryCode(Object countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Vote withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vote withId(int id) {
        this.id = id;
        return this;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Vote withImageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

    public Object getSubId() {
        return subId;
    }

    public void setSubId(Object subId) {
        this.subId = subId;
    }

    public Vote withSubId(Object subId) {
        this.subId = subId;
        return this;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Vote withValue(int value) {
        this.value = value;
        return this;
    }

}
