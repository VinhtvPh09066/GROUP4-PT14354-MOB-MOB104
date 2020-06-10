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
import com.example.agile_phoneshoping.User;
import com.example.agile_phoneshoping.database.AppDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class ProfileFragment extends Fragment {
    ImageView imageView1;
    TextInputEditText edtName,edtPhone,edtEmail,edtAddress,edtPaymentMethod;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        edtName=view.findViewById(R.id.edtName);
        edtPhone=view.findViewById(R.id.edtPhone);
        edtEmail=view.findViewById(R.id.edtEmail);
        edtAddress=view.findViewById(R.id.edtAddress);
        edtPaymentMethod=view.findViewById(R.id.edtMethod);

        imageView1=view.findViewById(R.id.imageView1);
//lấy com.example.agile_phoneshoping.data từ SharedPreferences
        AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, "user.db").allowMainThreadQueries().build();
        List<User> users=  db.userDAO().getUserByName("nguyễn văn tú");
        String a=users.get(0).name;
        int b=users.get(0).phone;
        String c=users.get(0).email;
        String d=users.get(0).address;
        String e=users.get(0).paymentmethod;
        edtName.setText(a);
        edtPhone.setText(String.valueOf(b));
        edtEmail.setText(c);
        edtAddress.setText(d);
        edtPaymentMethod.setText(e);
        SharedPreferences preferences = getActivity().getSharedPreferences("SHAREDPREFS",getActivity().MODE_PRIVATE);
        String user_name = preferences.getString("text",null);
        Log.e("userName ", " : "+user_name );



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder build= new AlertDialog.Builder(getActivity());
                final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_updatename, null);
//                View view1 =  getLayoutInflater().// inflater view
//                        inflate(R.layout.dialog_updatename, null, false);
                build.setView(view1);
                final EditText edtName = view1.findViewById(R.id.edtUpdateName);

                build.setCancelable(false);
                build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        Toast.makeText(getContext(),"chưa cập nhật thông tin",Toast.LENGTH_SHORT).show();
                    }
                });
                build.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String updateName=edtName.getText().toString().trim();
                        Toast.makeText(getContext()," cập nhật thông tin thành công "+updateName,Toast.LENGTH_SHORT).show();

                    }
                });
                build.create().show();

            }
        });
        return view;
    }

}
