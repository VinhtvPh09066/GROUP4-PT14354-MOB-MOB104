package com.example.agile_phoneshoping;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey
    @NonNull
    public  String productId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "color")
    public String color;

    @ColumnInfo(name = "price")
    public double price;

    @ColumnInfo(name = "brand")
    public String brand;

    @ColumnInfo(name = "detail")
    public String detail;

    @ColumnInfo(name = "image")
    public String image;

    public Product(@NonNull String productId, String name, String color, double price, String brand, String detail, String image) {
        this.productId = productId;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
        this.detail = detail;
        this.image = image;
    }

    @NonNull
    public String getProductId() {
        return productId;
    }

    public void setProductId(@NonNull String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
