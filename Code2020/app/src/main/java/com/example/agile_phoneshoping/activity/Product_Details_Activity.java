package com.example.agile_phoneshoping.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.database.AppDatabase;
import com.example.agile_phoneshoping.model.OrderProduct;

public class Product_Details_Activity extends AppCompatActivity {
    String productId;
    String namePr;
    String colorPr;
    double pricePr;
    String brandPr;
    String detailPr;
    String imagePr;
    Button btnAdd;

    public TextView txt_NameProduct;
    public TextView txt_Color_Product;
    public TextView txt_Price_Product;
    public TextView txt_Bard_Product;
    public TextView txt_Detail_Product;
    public TextView txt_Img_Product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__details_);
        txt_NameProduct = findViewById(R.id.txt_Name_Product);
        txt_Color_Product = findViewById(R.id.txt_Color_Product);
        txt_Price_Product = findViewById(R.id.txt_Price_Product);
        txt_Bard_Product = findViewById(R.id.txt_Brand_Prouct);
        btnAdd = findViewById(R.id.btnAdd);
        Intent intent = getIntent();
        Laydulieu(intent);
        Dodulieu();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(namePr);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(Product_Details_Activity.this,
                        AppDatabase.class, "user.db").allowMainThreadQueries().build();
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    //lay id ve day
                    namePr = bundle.getString("name");
                    colorPr = bundle.getString("color");
                    pricePr = Double.parseDouble(bundle.getString("price"));
                    brandPr = bundle.getString("bard");
                    detailPr = bundle.getString("detail");
                    imagePr = bundle.getString("img");
                }
                //ADD vo gio hang
//           long[] a=     db.orderDAO().insertOrder(new OrderProduct("46464", "464646", Integer.parseInt("1")));
//                if (a[0]>0){
//                    Toast.makeText(Product_Details_Activity.this,"add thanh cong",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(Product_Details_Activity.this,"da ton tai",Toast.LENGTH_SHORT).show();
//
//                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Laydulieu(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            namePr = bundle.getString("name");
            colorPr = bundle.getString("color");
            pricePr = Double.parseDouble(bundle.getString("price"));
            brandPr = bundle.getString("bard");
            detailPr = bundle.getString("detail");
            imagePr = bundle.getString("img");
        }
    }


    public void Dodulieu() {
        txt_Bard_Product.setText(brandPr);
        txt_Color_Product.setText(colorPr);
        txt_NameProduct.setText(namePr);
        txt_Price_Product.setText(pricePr + "");
    }

}

