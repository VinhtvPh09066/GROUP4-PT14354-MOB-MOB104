package com.example.agile_phoneshoping.model;

public class Cart {

    private String TenSP, MauSP;
    private int ImangeSP,slSP;
    private double giaSP;

    public Cart(int imangeSP,String tenSP, String mauSP, double giaSP,  int slSP) {
        TenSP = tenSP;
        MauSP = mauSP;
        ImangeSP = imangeSP;
        this.slSP = slSP;
        this.giaSP = giaSP;
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

    public int getSlSP() {
        return slSP;
    }

    public void setSlSP(int slSP) {
        this.slSP = slSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }
}
