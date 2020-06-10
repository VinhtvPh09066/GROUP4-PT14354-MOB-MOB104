package com.example.agile_phoneshoping.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agile_phoneshoping.model.Cart;
import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.activity.PurchaseActivity;
import com.example.agile_phoneshoping.CartAdapter;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    public TextView tvSoluong;
    public static TextView tvTongtien,hinhthuc;
    public TextView tvTong;
    public Button btnpurchase;
    public static ImageView imgcard;

    Intent intent;
    RecyclerView recyclerView;
    public static CartAdapter adapter;
    public static ArrayList<Cart> cart;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        btnpurchase = view.findViewById(R.id.btnPurchase);
        tvSoluong = view.findViewById(R.id.tvSoluong);
        tvTong = view.findViewById(R.id.tvTong);
        tvTongtien = view.findViewById(R.id.tvTongtien);
        hinhthuc = view.findViewById(R.id.hinhthuc);
        imgcard = view.findViewById(R.id.imgcard);
        recyclerView = view.findViewById(R.id.cartList);
        cart = new ArrayList<Cart>();
        Tongtien();

        //Tự phát sinh 50 dữ liệu mẫu




        adapter = new CartAdapter(cart, getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        btnpurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), PurchaseActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public static void Tongtien() {
        int tong = 0;
        cart = new ArrayList<Cart>();
        for (int i = 1; i <= 3; i++) {
            cart.add(new Cart(R.drawable.ip11promax,"iPhone11","Red",50,1));
            tong =tong + (cart.get(i-1).getGiaSP());

        }

        tvTongtien.setText( String.valueOf(tong));
    }

}
