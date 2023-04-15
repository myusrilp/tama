package com.example.gameedukasi.model;

public class ModelHewan {
    private String nama;
    private int icon;

    public ModelHewan(String nama, int icon) {
        this.nama = nama;
        this.icon = icon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
