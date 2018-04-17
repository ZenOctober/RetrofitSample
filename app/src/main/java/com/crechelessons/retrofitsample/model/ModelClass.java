package com.crechelessons.retrofitsample.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelClass {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;

    @SerializedName("iss_position")
    @Expose
    private ISSPosition iss_position;

    public ModelClass(String message, Integer timestamp, ISSPosition iss_position) {
        this.message = message;
        this.timestamp = timestamp;
        this.iss_position = iss_position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public ISSPosition getIss_position() {
        return iss_position;
    }

    public void setIss_position(ISSPosition iss_position) {
        this.iss_position = iss_position;
    }

}

