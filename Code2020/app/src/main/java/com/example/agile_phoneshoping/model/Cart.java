package com.example.agile_phoneshoping.model;

public class Cart {

    private String TenSP, MauSP;
    private int ImangeSP,giaSP,slSP;

    public Cart(int imangeSP, String tenSP, String mauSP, int giaSP, int slSP) {
        TenSP = tenSP;
        MauSP = mauSP;
        ImangeSP = imangeSP;
        this.giaSP = giaSP;
        this.slSP = slSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getMauSP() {
        return MauSP;
    }

    public void setMauSP(String mauSP) {
        MauSP = mauSP;
    }

    public int getImangeSP() {
        return ImangeSP;
    }

    public void setImangeSP(int imangeSP) {
        ImangeSP = imangeSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }

    public int getSlSP() {
        return slSP;
    }

    public void setSlSP(int slSP) {
        this.slSP = slSP;
    }
}
