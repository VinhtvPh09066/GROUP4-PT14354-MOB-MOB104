package com.example.agile_phoneshoping.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.activity.Product_Details_Activity;
import com.example.agile_phoneshoping.itemClick.ClickItemListener;
import com.example.agile_phoneshoping.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> implements ClickItemListener {
    List<Product> products;
    Context context;
    public ProductAdapter (List<Product> products,Context context){
        this.products = products;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Product_Details_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Id", products.get(position).getProductId());
                bundle.putString("name", products.get(position).getName());
                bundle.putString("color", products.get(position).getColor());
                bundle.putString("price",String.valueOf(products.get(position).getPrice()));
                bundle.putString("bard",products.get(position).getBrand());
                bundle.putString("detail",products.get(position).getDetail());
                bundle.putString("img",products.get(position).getImage());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
//        holder.nameproduct.setText(products.get(position).getName());
//        holder.price.setText(String.valueOf(products.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onClick(View view, int position) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView img;
        public TextView nameproduct;
        public TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img =  itemView.findViewById(R.id.imgProduct);
            nameproduct=itemView.findViewById(R.id.txtName);
            price=itemView.findViewById(R.id.txtPrice);

        }
    }
}
