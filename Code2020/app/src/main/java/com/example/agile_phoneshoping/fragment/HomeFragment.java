package com.example.agile_phoneshoping.fragment;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    List<Product> mDataFitered = new ArrayList<>();
    RecyclerView rv;
    EditText edtSearch;
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
        imgPhone = view.findViewById(R.id.imgPhone);
        edtSearch = view.findViewById(R.id.edtSearch);
        searchDate();
        return view;
    }

    public void getData(View view) {
        try {
            rv = view.findViewById(R.id.rv);
            AppDatabase db = Room.databaseBuilder(getContext(),
                    AppDatabase.class, "user.db").allowMainThreadQueries().build();

            //mỗi lần chạy lại app thì xóa bảng đi thêm mới đỡ phải xóa app
            db.productDAO().delAll();
            //xóa xong thêm mới lại
            db.productDAO().insertProduct(new Product("OPPO A92", "OPPO A92", "red", 6490000, "OPPO", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("Iphone Pro Max", "Iphone Pro Max", "black", 2999000, "APPLE", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("Galaxy A21s", "Galaxy A21s", "white", 5390000, "samsung", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("OPPO A52", "OPPO A52", "red", 5690000, "samsung", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("Iphone 11", "Iphone 11", "red", 19990000, "Apple", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("Galaxy A31", "Galaxy A31", "black", 6490000, "samsung", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("Nokia 5.3", "Nokia 5.3", "black", 3690000, "nokia", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("Redmi Note9s", "Redmi Note9s", "red", 5990000, "xiaomi", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("Vivo Y30", "Vivo Y30", "white", 4690000, "vivo", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("OPPO Reno3", "OPPO Reno3", "white", 8490000, "oppo", "chitiet", "image"));
            db.productDAO().insertProduct(new Product("OPPO Reno2F", "OPPO Reno2F", "white", 6990000, "oppo", "chitiet", "image"));

            products = new ArrayList<>();
            products = db.productDAO().getAllProduct();
            mDataFitered = products;
            productAdapter = new ProductAdapter(products, getContext());
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            rv.setHasFixedSize(true);
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(productAdapter);
        } catch (Exception X) {
            X.printStackTrace();
        }

    }

    public void searchDate() {
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterData(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void filterData(String text) {
        List<Product> newList = new ArrayList<>();
        if (text.isEmpty()) {
            productAdapter.filterList(mDataFitered);
            products = mDataFitered;
            productAdapter.notifyDataSetChanged();
        } else {
            for (Product item : mDataFitered){
                if (item.name.toLowerCase().contains(text.toLowerCase())){
                    newList.add(item);
                }
            }
            productAdapter.filterList(newList);
            products = newList;
            productAdapter.notifyDataSetChanged();
        }
    }
}
