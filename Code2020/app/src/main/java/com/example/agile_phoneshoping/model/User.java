package com.example.agile_phoneshoping.model;


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

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    public User(int userId,String username,String password, String name, String email, int phone, String address, String paymentmethod) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.paymentmethod = paymentmethod;

    }
}
