package com.example.agile_phoneshoping.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.agile_phoneshoping.model.OrderProduct;

import java.util.List;

@Dao
public interface OrderDAO {
    @Insert
    long[] insertOrder(OrderProduct... orders);

    @Delete
    void delOrder(OrderProduct order);

    @Update
    void updateOrder(OrderProduct order);

@Query("SELECT * FROM OrderProduct")
    List<OrderProduct> getAllOrder();


}
