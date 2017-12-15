package com.example.clinto.ida;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clinto on 26-Sep-17.
 */

public class News {
    @SerializedName("id_media")
    @Expose
    private String idMedia;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("add_date")
    @Expose
    private String addDate;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("media_img")
    @Expose
    private Object mediaImg;

    public String getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(String idMedia) {
        this.idMedia = idMedia;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Object getMediaImg() {
        return mediaImg;
    }

    public void setMediaImg(Object mediaImg) {
        this.mediaImg = mediaImg;
    }
}

