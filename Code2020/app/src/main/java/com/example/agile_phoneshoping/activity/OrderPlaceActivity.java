package com.example.agile_phoneshoping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agile_phoneshoping.R;

public class OrderPlaceActivity extends AppCompatActivity {
    Button btnbackhome;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_place);
        btnbackhome = findViewById(R.id.btnbackhome);
        btnbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(OrderPlaceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}