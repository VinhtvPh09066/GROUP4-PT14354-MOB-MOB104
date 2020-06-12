package com.example.agile_phoneshoping.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class OrderProduct {


    @PrimaryKey
    @NonNull
    public  String orderId;

    @ColumnInfo(name = "productId")
    public String productId;

    @ColumnInfo(name = "amount")
    public int amount;

    public OrderProduct(String orderId, String productId, int amount) {
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
    }
}
