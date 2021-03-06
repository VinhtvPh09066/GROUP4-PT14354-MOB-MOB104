package com.example.agile_phoneshoping.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.agile_phoneshoping.model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    long[] insert(User... users);

    @Delete
    void delete(User user);

    @Update
    int update(User user);

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE username =:username ")
    User getUserByName(String username);




    @Query("SELECT * FROM User WHERE username =:username and password =:password ")
    User checkUser(String username, String password);

    @Query("DELETE  FROM User where name =:name")
    int dellUserByName(String name);


}
