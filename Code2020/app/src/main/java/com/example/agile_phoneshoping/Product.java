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
    public String nvarchar;

    @ColumnInfo(name = "detail")
    public String detail;

    @ColumnInfo(name = "image")
    public String image;

    public Product(String productId, String name, String color, double price, String nvarchar, String detail, String image) {
        this.productId = productId;
        this.name = name;
        this.color = color;
        this.price = price;
        this.nvarchar = nvarchar;
        this.detail = detail;
        this.image = image;
    }
}
