package com.example.agile_phoneshoping.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.model.User;
import com.example.agile_phoneshoping.database.AppDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class ProfileFragment extends Fragment {
    ImageView imageView1;
    TextInputEditText edtName, edtPhone, edtEmail, edtAddress, edtPaymentMethod;


    public ProfileFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, "user.db").allowMainThreadQueries().build();
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        edtName = view.findViewById(R.id.edtName);
        edtPhone = view.findViewById(R.id.edtPhone);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtAddress = view.findViewById(R.id.edtAddress);
        edtPaymentMethod = view.findViewById(R.id.edtMethod);

        imageView1 = view.findViewById(R.id.imageView1);
//lấy com.example.agile_phoneshoping.data từ SharedPreferences

        //lấy tài khoản đăng nhập về
        SharedPreferences preferences = getActivity().getSharedPreferences("SHAREDPREFS", getActivity().MODE_PRIVATE);
        String user_name = preferences.getString("text", null);
        Log.e("tài khoản đang online ", " : " + user_name);
        User u = db.userDAO().getUserByName("nguyễn văn tú");
        if (u == null) {
            Toast.makeText(getContext(), "không có tk nào", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "có tài khoản " + u.name, Toast.LENGTH_SHORT).show();
        }
        edtName.setText(u.name);
        edtPhone.setText(String.valueOf(u.phone));
        edtEmail.setText(u.email);
        edtAddress.setText(u.address);
        edtPaymentMethod.setText(u.paymentmethod);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogName();
            }
        });
        return view;
    }

    public void showDialogName() {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_updatename, null, false);
        build.setView(view1);
        final EditText edtName = view1.findViewById(R.id.edtUpdateName);

        build.setCancelable(false);
        build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                Toast.makeText(getContext(), "chưa cập nhật thông tin", Toast.LENGTH_SHORT).show();
            }
        });
        build.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AppDatabase db = Room.databaseBuilder(getContext(),
                        AppDatabase.class, "user.db").allowMainThreadQueries().build();
                String updateName = edtName.getText().toString().trim();
                User u = db.userDAO().getUserByName("nguyễn văn tú");
                update("nguyễn văn tú", 1, updateName, u.email, u.phone, u.address, u.paymentmethod);
//                Toast.makeText(getContext(), " cập nhật thông tin thành công " + updateName, Toast.LENGTH_SHORT).show();

            }
        });
        build.create().show();
    }

    public void update(String a, int userId, String name, String email, int phone, String address, String method) {
        AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, "user.db").allowMainThreadQueries().build();
        User u = db.userDAO().getUserByName(a);
        if (u == null) {
            Toast.makeText(getContext(), "không có tk nào", Toast.LENGTH_SHORT).show();
        } else {
//        Toast.makeText(getContext(),"có tài khoản "+u.name,Toast.LENGTH_SHORT).show();
            db.userDAO().update(new User(userId, name, email, phone, address, method));

        }

    }


}
