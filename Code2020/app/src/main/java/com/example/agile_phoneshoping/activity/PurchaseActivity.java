package com.example.agile_phoneshoping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.fragment.CartFragment;

public class PurchaseActivity extends AppCompatActivity {

    public static TextView tvcard;
    public TextView tvTongtien2;
    public Button btnplaceorder,btnupdateadd,btncard,btnsale;
    RecyclerView recyclerView2;
    public static ImageView img,backpurchase;
    public EditText edtSale;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        tvTongtien2 = findViewById(R.id.tvTongtien2);
        btnplaceorder = findViewById(R.id.btnPlaceorder);
        btnupdateadd = findViewById(R.id.btnupdateadd);
        btncard = findViewById(R.id.btncard);
        btnsale = findViewById(R.id.btnsale);
        backpurchase = findViewById(R.id.backpurchase2);
        edtSale = findViewById(R.id.edtSale);
        img = findViewById(R.id.img);
        img.setImageDrawable(CartFragment.imgcard.getDrawable());
        tvcard = findViewById(R.id.tvcard);
        tvcard.setText(CartFragment.hinhthuc.getText().toString());
        final String tongtien = CartFragment.tvTongtien.getText().toString();
        final int[] tt = {Integer.parseInt(tongtien)};
        tvTongtien2.setText(tongtien);
        recyclerView2 = findViewById(R.id.cartList2);

        //Tự phát sinh 50 dữ liệu mẫu




//        CartFragment.adapter = new CartAdapter(CartFragment.cart, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView2.setAdapter(CartFragment.adapter);
        recyclerView2.setLayoutManager(linearLayoutManager);
        btnplaceorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(PurchaseActivity.this, OrderPlaceActivity.class);
                startActivity(intent);
            }
        });
        btnupdateadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(PurchaseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btncard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(PurchaseActivity.this, CardActivity.class);
                startActivity(intent);
            }
        });
        backpurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(PurchaseActivity.this, CardActivity.class);
                startActivity(intent);
            }
        });
        btnsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtSale.getText().toString().equals("KM001")){
                    tt[0] = tt[0] *9/10;
                    tvTongtien2.setText(String.valueOf(tt[0]));
                    Toast.makeText(view.getContext(),
                                    " Nhập mã khuyến mãi thành công bạn được giảm 10%", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(view.getContext(),
                            " Mã khuyến mãi hết hạn hoặc không tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}