
package com.example.catapi.models;


import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Weight implements Parcelable
{

    @SerializedName("imperial")
    @Expose
    private String imperial;
    @SerializedName("metric")
    @Expose
    private String metric;
    public final static Creator<Weight> CREATOR = new Creator<Weight>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Weight createFromParcel(android.os.Parcel in) {
            return new Weight(in);
        }

        public Weight[] newArray(int size) {
            return (new Weight[size]);
        }

    }
    ;

    protected Weight(android.os.Parcel in) {
        this.imperial = ((String) in.readValue((String.class.getClassLoader())));
        this.metric = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Weight() {
    }

    public String getImperial() {
        return imperial;
    }

    public void setImperial(String imperial) {
        this.imperial = imperial;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(imperial);
        dest.writeValue(metric);
    }

    public int describeContents() {
        return  0;
    }

}
