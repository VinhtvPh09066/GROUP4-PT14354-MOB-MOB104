package com.example.agile_phoneshoping.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.agile_phoneshoping.Invoice;
import com.example.agile_phoneshoping.OrderProduct;
import com.example.agile_phoneshoping.Product;
import com.example.agile_phoneshoping.User;

@Database(entities = {User.class, Product.class, OrderProduct.class, Invoice.class}, version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract ProductDAO productDAO();
    public abstract InvoiceDAO invoiceDAO();
    public abstract OrderDAO orderDAO();
}
