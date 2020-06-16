package com.example.agile_phoneshoping.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DetailProduct {
    @PrimaryKey
    @NonNull
    public  String invoiceId;

    @ColumnInfo(name = "userId")
    public String name;

    @ColumnInfo(name = "total")
    public double total;

    @ColumnInfo(name = "date")
    public String date;
}
