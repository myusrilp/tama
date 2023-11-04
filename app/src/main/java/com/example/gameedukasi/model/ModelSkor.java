package com.example.gameedukasi.model;

public class ModelSkor {
    int id;
    int skor;
    String skorType;
    String name;

    public ModelSkor(int id, int skor, String skorType, String name) {
        this.id = id;
        this.skor = skor;
        this.skorType = skorType;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public String getSkorType() {
        return skorType;
    }

    public void setSkorType(String skorType) {
        this.skorType = skorType;
    }
}
