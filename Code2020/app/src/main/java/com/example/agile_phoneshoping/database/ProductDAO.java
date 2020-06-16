package com.example.agile_phoneshoping.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.agile_phoneshoping.model.Product;
import com.example.agile_phoneshoping.model.User;

import java.util.List;

@Dao
public interface ProductDAO {

    @Insert
    long[] insertProduct(Product... products);

    @Delete
    void delete(Product product);

    @Update
    void update(Product product);

    @Query("SELECT * FROM Product")
    List<Product> getAllProduct();


    @Query("Delete from Product")
    int delAll();



}
