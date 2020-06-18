package com.example.agile_phoneshoping.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    @NonNull
    public String username;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "paymentmethod")
    public String paymentmethod;

    @ColumnInfo(name = "role")
    public String role;

    public User(@NonNull String username, String name, String password, String email, String phone, String address, String paymentmethod, String role) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.paymentmethod = paymentmethod;
        this.role = role;
    }
}
