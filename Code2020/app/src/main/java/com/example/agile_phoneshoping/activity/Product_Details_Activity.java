package com.example.agile_phoneshoping.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.agile_phoneshoping.R;

public class Product_Details_Activity extends AppCompatActivity {
    String productId;
    String namePr;
   String colorPr;
    double pricePr;
    String brandPr;
     String detailPr;
    String imagePr;


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
      txt_Price_Product=findViewById(R.id.txt_Price_Product);
      txt_Bard_Product=findViewById(R.id.txt_Brand_Prouct);

        Intent intent= getIntent();
        Laydulieu(intent);
        Dodulieu();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(namePr);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Laydulieu(Intent intent){
        Bundle bundle= intent.getExtras();
        if(bundle!=null){
            namePr=bundle.getString("name");
            colorPr=bundle.getString("color");
            pricePr=Double.parseDouble(bundle.getString("price"));
            brandPr=bundle.getString("bard");
            detailPr=bundle.getString("detail");
            imagePr=bundle.getString("img");
        }
    }

    public void Dodulieu(){
        txt_Bard_Product.setText(brandPr);
        txt_Color_Product.setText(colorPr);
        txt_NameProduct.setText(namePr);
        txt_Price_Product.setText(pricePr+"");
    }

}

