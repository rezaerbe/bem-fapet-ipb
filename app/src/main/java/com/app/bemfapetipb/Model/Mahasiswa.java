package com.app.bemfapetipb.Model;

import com.google.gson.annotations.SerializedName;

public class Mahasiswa {
    @SerializedName("id")
    private int id;
    @SerializedName("nim")
    private String nim;
    @SerializedName("nama")
    private String nama;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
