package com.example.agile_phoneshoping.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.agile_phoneshoping.Invoice;

import java.util.List;

@Dao
public interface InvoiceDAO {


    @Insert
    void insertInvoice(Invoice... invoices);

    @Delete
    void delInvoice(Invoice invoice);

    @Update
    void updateInvoice(Invoice invoice);

    @Query("SELECT * FROM Invoice")
    List<Invoice> getAllInvoice();

}
