package com.example.agile_phoneshoping.fragment;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.room.Room;


import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.activity.LoginActivity;
import com.example.agile_phoneshoping.activity.MainActivity;
import com.example.agile_phoneshoping.adapter.ProductAdapter;
import com.example.agile_phoneshoping.database.AppDatabase;
import com.example.agile_phoneshoping.model.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
ProductAdapter productAdapter;
List<Product> products;
    RecyclerView rv;
    private EditText editText;
    private TextView tvLabel;
    private ImageView imgPhone;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getData(view);
        imgPhone=view.findViewById(R.id.imgPhone);
        return view;
    }

    public void getData(View view) {
        try {
            rv=view.findViewById(R.id.rv);
            AppDatabase db = Room.databaseBuilder(getContext(),
                    AppDatabase.class, "user.db").allowMainThreadQueries().build();

            //mỗi lần chạy lại app thì xóa bảng đi thêm mới đỡ phải xóa app
            db.productDAO().delAll();
            //xóa xong thêm mới lại
            db.productDAO().insertProduct(new Product("phone01","OPPO A92","red",6490000,"OPPO","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone02","Iphone 11 Pro Max 64GB","black",29990000,"APPLE","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone03","Samsung Galaxy A21s","white",5390000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone04","OPPO A52","red",5690000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone05","Iphone 11 64GB","red",19990000,"Apple","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone06","Samsung Galaxy A31","black",6490000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone05","Nokia 5.3","black",3690000,"nokia","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone06","Xiaomi Redmi Note9s","red",5990000,"xiaomi","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone07","Vivo Y30","white",46900000,"vivo","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone08","OPPO Reno3","white",8490000,"oppo","chitiet","image"));
            db.productDAO().insertProduct(new Product("phone09","OPPO Reno2 F","white",6990000,"oppo","chitiet","image"));

            products=new ArrayList<>();
            products=db.productDAO().getAllProduct();
            productAdapter=new ProductAdapter(products,getContext());
            StaggeredGridLayoutManager layoutManager= new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
            rv.setHasFixedSize(true);
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(productAdapter);
        } catch (Exception X) {
            X.printStackTrace();
        }

    }
}
