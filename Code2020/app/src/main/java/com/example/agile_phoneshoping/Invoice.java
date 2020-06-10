package com.example.agile_phoneshoping;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Invoice {
    @PrimaryKey
    @NonNull
    public  String invoiceId;

    @ColumnInfo(name = "userId")
    public String name;

    @ColumnInfo(name = "total")
    public double total;

    @ColumnInfo(name = "date")
    public String date;

    public Invoice(String invoiceId, String name, double total, String date) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.total = total;
        this.date = date;
    }
}
