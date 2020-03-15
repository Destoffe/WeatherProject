package com.stoffe.weatherproject;

import com.google.gson.annotations.SerializedName;

public class TempModel {

    @SerializedName("temperature")
    private Float temperature;

    public  TempModel(Float temperature){
        this.temperature = temperature;
    }

    public float getTemperature(){
        return temperature;
    }
    public String getTempString(){
        return Float.toString(temperature);
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
    }
}
