package com.example.agile_phoneshoping.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
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

    public static TextView tvcard,tvSonha,tvPhuong,tvQuan,tvTinh;
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
        edtSale = findViewById(R.id.edtSale);
        img = findViewById(R.id.img);
        img.setImageDrawable(CartFragment.imgcard.getDrawable());
        tvSonha = findViewById(R.id.tvsonha);
        tvPhuong = findViewById(R.id.tvphuong);
        tvQuan = findViewById(R.id.tvquan);
        tvTinh = findViewById(R.id.tvtinh);
        tvcard = findViewById(R.id.tvcard);
        tvcard.setText(CartFragment.hinhthuc.getText().toString());
        final String tongtien = CartFragment.tvTongtien.getText().toString();
        final int[] tt = {Integer.parseInt(tongtien)};
        tvTongtien2.setText(tongtien);
        recyclerView2 = findViewById(R.id.cartList2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Checkout");

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
            public void onClick(View v) {

                AlertDialog.Builder build= new AlertDialog.Builder(PurchaseActivity.this);
                final View view1 = LayoutInflater.from(PurchaseActivity.this).inflate(R.layout.dialog_updateadd, null);
//                View view1 =  getLayoutInflater().// inflater view
//                        inflate(R.layout.dialog_updatename, null, false);
                build.setView(view1);
                final EditText edtSonha = view1.findViewById(R.id.edtUpdatesonha);
                final EditText edtPhuong = view1.findViewById(R.id.edtUpdatePhuong);
                final EditText edtQuan = view1.findViewById(R.id.edtUpdateQuan);
                final EditText edtTinh = view1.findViewById(R.id.edtUpdateTinh);
                edtSonha.setText(tvSonha.getText().toString());
                edtPhuong.setText(tvPhuong.getText().toString());
                edtQuan.setText(tvQuan.getText().toString());
                edtTinh.setText(tvTinh.getText().toString());

                build.setCancelable(false);
                build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        Toast.makeText(PurchaseActivity.this,"Chưa cập nhật thông tin",Toast.LENGTH_SHORT).show();
                    }
                });
                build.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String updateSonha=edtSonha.getText().toString().trim();
                        tvSonha.setText(updateSonha);
                        String updatePhuong=edtPhuong.getText().toString().trim();
                        tvPhuong.setText(updatePhuong);
                        String updateQuan=edtQuan.getText().toString().trim();
                        tvQuan.setText(updateQuan);
                        String updateTinh=edtTinh.getText().toString().trim();
                        tvTinh.setText(updateTinh);
                        Toast.makeText(PurchaseActivity.this," Cập nhật thông tin thành công ",Toast.LENGTH_SHORT).show();

                    }
                });
                build.create().show();

            }
        });
        btncard.setOnClickListener(new View.OnClickListener() {
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