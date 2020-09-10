package com.app.bemfapetipb.Model;

import com.google.gson.annotations.SerializedName;

public class Report {
    @SerializedName("id")
    private int id;
    @SerializedName("fasilitas")
    private String fasilitas;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("picture")
    private String picture;
    @SerializedName("value")
    private String value;
    @SerializedName("message")
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


