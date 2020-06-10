package com.example.agile_phoneshoping.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.agile_phoneshoping.User;

import java.util.List;

@Dao
public interface UserDAO {
 @Insert
    void insert(User... users);

 @Delete
    void delete(User user);

@Update
    void update(User user);

    @Query("SELECT * FROM User")
   List<User> getAll();

@Query("SELECT * FROM User WHERE name =:name ")
    List<User> getUserByName(String name);


}
