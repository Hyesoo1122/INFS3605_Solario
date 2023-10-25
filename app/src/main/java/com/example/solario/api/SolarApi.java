package com.example.solario.api;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class SolarApi implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("postalCode")
    @Expose
    private String postalCode;

    @SerializedName("maxSunshineHoursPerYear")
    @Expose
    private float maxSunshineHoursPerYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public float getMaxSunshineHoursPerYear() {
        return maxSunshineHoursPerYear;
    }

    public void setMaxSunshineHoursPerYear(float maxSunshineHoursPerYear) {
        this.maxSunshineHoursPerYear = maxSunshineHoursPerYear;
    }

    /*@SerializedName("solarPanelConfigs")
    @Expose
    private List<SolarPanelConfig> solarPanelConfigs;  // You need to create this model too

    // Other getters and setters

    // Create a getter and setter for solarPanelConfigs
    public List<SolarPanelConfig> getSolarPanelConfigs() {
        return solarPanelConfigs;
    }

    public void setSolarPanelConfigs(List<SolarPanelConfig> solarPanelConfigs) {
        this.solarPanelConfigs = solarPanelConfigs;
    }*/

    protected SolarApi(Parcel in) {
        name = in.readString();
        postalCode = in.readString();
        maxSunshineHoursPerYear = in.readFloat();
        //solarPanelConfigs = in.readInt();
    }

    public static final Creator<SolarApi> CREATOR = new Creator<SolarApi>() {
        @Override
        public SolarApi createFromParcel(Parcel in) {
            return new SolarApi(in);
        }

        @Override
        public SolarApi[] newArray(int size) {
            return new SolarApi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(postalCode);
        dest.writeFloat(maxSunshineHoursPerYear);
        //dest.writeInt(panelsCount);
    }


}
