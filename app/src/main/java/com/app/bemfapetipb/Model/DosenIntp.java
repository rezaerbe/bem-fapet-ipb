package com.app.bemfapetipb.Model;

import com.google.gson.annotations.SerializedName;

public class DosenIntp {
    @SerializedName("id")
    private int id;
    @SerializedName("nip")
    private String nip;
    @SerializedName("nama")
    private String nama;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
