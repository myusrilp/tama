package com.example.gameedukasi.model;

public class ModelAbjad {
    private String nama;
    private int icon;
    private int sound;

    public ModelAbjad(String nama, int icon, int sound) {
        this.nama = nama;
        this.icon = icon;
        this.sound = sound;
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

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
