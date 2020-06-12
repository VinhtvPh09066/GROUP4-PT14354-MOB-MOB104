package com.example.agile_phoneshoping.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.activity.MainActivity;
import com.example.agile_phoneshoping.model.User;
import com.example.agile_phoneshoping.database.AppDatabase;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ProfileFragment extends Fragment {
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
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
        imageView2 = view.findViewById(R.id.imageView2);
        imageView3 = view.findViewById(R.id.imageView3);
        imageView4 = view.findViewById(R.id.imageView4);
        imageView5 = view.findViewById(R.id.imageView5);


//lấy com.example.agile_phoneshoping.data từ SharedPreferences

        //lấy tài khoản đăng nhập về
        SharedPreferences preferences = getActivity().getSharedPreferences("SHAREDPREFS", getActivity().MODE_PRIVATE);
        String user_name = preferences.getString("text", null);
        Log.e("tài khoản đang online ", " : " + user_name);
        User u = db.userDAO().getUserByName("nguyễn văn tú");
        if (u == null) {
            Toast.makeText(getContext(), "không có tk nào", Toast.LENGTH_SHORT).show();
            edtName.setText("loading....");
            edtPhone.setText(String.valueOf("loading...."));
            edtEmail.setText("loading....");
            edtAddress.setText("loading....");
            edtPaymentMethod.setText("loading....");
        } else {
            Toast.makeText(getContext(), "có tài khoản " + u.name, Toast.LENGTH_SHORT).show();
            edtName.setText(u.name);
            edtPhone.setText(String.valueOf(u.phone));
            edtEmail.setText(u.email);
            edtAddress.setText(u.address);
            edtPaymentMethod.setText(u.paymentmethod);
        }


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogEmail();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogEmail();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogPhone();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAddress();
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogPayment();
            }
        });

        return view;
    }

    public void showDialogName() {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_updatename, null, false);
        build.setView(view1);
        final EditText edtName = view1.findViewById(R.id.edtUpdateName);
        TextInputLayout layout=view1.findViewById(R.id.layout);
        layout.setHint("mời nhập Name");
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
                int result = db.userDAO().update(new User(1, u.name, updateName, u.phone, u.address, u.paymentmethod));
                if (result > 0) {
                    Toast.makeText(getContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                    // thông báo cho thay đổi
                    edtEmail.setText(edtName.getText().toString().trim());

                } else {
                    Toast.makeText(getContext(), "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        build.create().show();
    }

    public void showDialogEmail() {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_updatename, null, false);
        build.setView(view1);
        final EditText edtName = view1.findViewById(R.id.edtUpdateName);
        TextInputLayout layout=view1.findViewById(R.id.layout);
        layout.setHint("mời nhập Email");
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
                String updateEmail = edtName.getText().toString().trim();
                User u = db.userDAO().getUserByName("nguyễn văn tú");
                int result = db.userDAO().update(new User(1, u.name, updateEmail, u.phone, u.address, u.paymentmethod));
                if (result > 0) {
                    Toast.makeText(getContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                    // thông báo cho thay đổi
                    edtEmail.setText(updateEmail);
                } else {
                    Toast.makeText(getContext(), "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        build.create().show();
    }

    public void showDialogPhone() {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_updatename, null, false);
        build.setView(view1);
        final EditText edtName = view1.findViewById(R.id.edtUpdateName);
        TextInputLayout layout=view1.findViewById(R.id.layout);
        layout.setHint("mời nhập Phone");
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
                int updatePhone = Integer.parseInt(edtName.getText().toString().trim());
                User u = db.userDAO().getUserByName("nguyễn văn tú");
                int result = db.userDAO().update(new User(1, u.name, u.email, updatePhone, u.address, u.paymentmethod));
                if (result > 0) {
                    Toast.makeText(getContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                    // thông báo cho thay đổi
                    edtPhone.setText(String.valueOf(updatePhone));
                } else {
                    Toast.makeText(getContext(), "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        build.create().show();
    }

    public void showDialogAddress() {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_updatename, null, false);
        build.setView(view1);
        final EditText edtName = view1.findViewById(R.id.edtUpdateName);
        TextInputLayout layout=view1.findViewById(R.id.layout);
        layout.setHint("mời nhập Address");
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
                String updateAddress = edtName.getText().toString().trim();
                User u = db.userDAO().getUserByName("nguyễn văn tú");
                int result = db.userDAO().update(new User(1, u.name, u.email, u.phone, updateAddress, u.paymentmethod));
                if (result > 0) {
                    Toast.makeText(getContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                    // thông báo cho thay đổi
                    edtAddress.setText(updateAddress);
                } else {
                    Toast.makeText(getContext(), "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        build.create().show();
    }

    public void showDialogPayment() {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_updatename, null, false);
        build.setView(view1);
        final EditText edtName = view1.findViewById(R.id.edtUpdateName);
        TextInputLayout layout=view1.findViewById(R.id.layout);
        layout.setHint("mời nhập Payment Method");
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
                String updatePayment = edtName.getText().toString().trim();
                User u = db.userDAO().getUserByName("nguyễn văn tú");
                int result = db.userDAO().update(new User(1, u.name, u.email, u.phone, u.address, updatePayment));
                if (result > 0) {
                    Toast.makeText(getContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                    // thông báo cho thay đổi
                    edtPaymentMethod.setText(updatePayment);
                } else {
                    Toast.makeText(getContext(), "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        build.create().show();
    }
}
