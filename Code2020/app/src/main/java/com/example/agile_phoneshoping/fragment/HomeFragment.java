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

import com.example.agile_phoneshoping.Product;
import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.activity.LoginActivity;
import com.example.agile_phoneshoping.activity.MainActivity;
import com.example.agile_phoneshoping.adapter.ProductAdapter;
import com.example.agile_phoneshoping.database.AppDatabase;

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
            db.productDAO().insertProduct(new Product("ss j6","ss j6","red",2000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j7","ss j6","red",3000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j8","ss j6","red",4000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j9","ss j6","red",5000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j10","ss j6","red",6000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j16","ss j6","red",7000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j26","ss j6","red",8000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j36","ss j6","red",9000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j46","ss j6","red",1000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j19","ss j6","red",1000,"samsung","chitiet","image"));
            db.productDAO().insertProduct(new Product("ss j56","ss j6","red",1000,"samsung","chitiet","image"));

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
