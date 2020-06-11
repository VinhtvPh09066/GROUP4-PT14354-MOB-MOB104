package com.example.agile_phoneshoping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.fragment.CartFragment;

public class CardActivity extends AppCompatActivity {
    public static TextView hinhthucthanhtoan;
    TextView text1, text2, text3;
    ImageView img1, img2, img3;
    Button btnmastercard,btncard2,btnmoney;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        text1= findViewById(R.id.text1);
        final String tv1 = text1.getText().toString();
        text2= findViewById(R.id.text2);
        final String tv2 = text2.getText().toString();
        text3= findViewById(R.id.text3);
        final String tv3 = text3.getText().toString();
        hinhthucthanhtoan = findViewById(R.id.hinhthucthanhtoan);
        img1= findViewById(R.id.img1);
        img2= findViewById(R.id.img2);
        img3= findViewById(R.id.img3);
        btncard2= findViewById(R.id.btncard2);
        btnmastercard= findViewById(R.id.btnmastercard);
        btnmoney= findViewById(R.id.btnmoney);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Hình thức thanh toán");

        btnmastercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartFragment.imgcard.setImageDrawable(img1.getDrawable());
                CartFragment.hinhthuc.setText("Master card");
                intent = new Intent(CardActivity.this, PurchaseActivity.class);
                startActivity(intent);
            }
        });
        btncard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartFragment.imgcard.setImageDrawable(img2.getDrawable());
                CartFragment.hinhthuc.setText("Thẻ nội địa");
                intent = new Intent(CardActivity.this, PurchaseActivity.class);
                startActivity(intent);
            }
        });
        btnmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartFragment.imgcard.setImageDrawable(img3.getDrawable());
                CartFragment.hinhthuc.setText("Thanh toán khi nhận hàng");
                intent = new Intent(CardActivity.this, PurchaseActivity.class);
                startActivity(intent);
            }
        });

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
}