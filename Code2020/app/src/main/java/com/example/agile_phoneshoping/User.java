package com.example.agile_phoneshoping;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public  int userId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "phone")
    public int phone;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "paymentmethod")
    public String paymentmethod;

    @ColumnInfo(name = "role")
    public String role;

    public User(int userId, String name, String email, int phone, String address, String paymentmethod, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.paymentmethod = paymentmethod;
        this.role = role;
    }
}
