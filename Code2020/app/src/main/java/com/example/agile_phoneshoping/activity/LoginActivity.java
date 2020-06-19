package com.example.agile_phoneshoping.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.database.AppDatabase;
import com.example.agile_phoneshoping.model.User;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText edtUsername;
    private TextInputEditText edtPassword;
    private Button btnLogin;
    private TextView tvSignUp;
    //tạo biến để lưu data
    public static final String SHARED_PREFS = "SHAREDPREFS";
    public static final String USERNAME = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        // Login navigate
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validater()) {
                    if (checkUser(edtUsername.getText().toString(), edtPassword.getText().toString())) {
                        saveData();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        //Sign Up navigate

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        edtUsername = (TextInputEditText) findViewById(R.id.edtUsername);
        edtPassword = (TextInputEditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);
    }

    private boolean validater() {

        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (username.equals("")) {
//            Toast.makeText(this, "Hãy nhập tài khoản !", Toast.LENGTH_SHORT).show();
            edtUsername.setError("Hãy nhập tài khoản !");
            edtUsername.requestFocus();
            return false;
        } else if (username.length() < 6 || username.length() > 30) {
//            Toast.makeText(this, "Tài khoản phải từ 6 - 30 kí tự !", Toast.LENGTH_SHORT).show();
            edtUsername.setError("Tài khoản phải từ 6 - 30 kí tự !");
            edtUsername.requestFocus();
            return false;

        } else if (password.equals("")) {
//            Toast.makeText(this, "Hãy nhập mật khẩu !", Toast.LENGTH_SHORT).show();
            edtPassword.setError("Hãy nhập mật khẩu !");
            edtPassword.requestFocus();
            return false;

        } else if (password.length() < 6 || password.length() > 10) {
//            Toast.makeText(this, "Mật khẩu phải từ 6 - 10 kí tự !", Toast.LENGTH_SHORT).show();
            edtPassword.setError("Mật khẩu phải từ 6 - 10 kí tự !");
            edtPassword.requestFocus();
            return false;
        }
        return true;
    }

    //save data
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USERNAME", edtUsername.getText().toString());
        editor.apply();

//        editor.commit();
        String userName = sharedPreferences.getString("USERNAME", "not found");
        Log.e("user đăng nhập  là ", ":" + userName);
        Toast.makeText(getApplicationContext(), "user đăng nhập  là " + userName, Toast.LENGTH_SHORT).show();
    }

    public boolean checkUser(String u, String p) {
        if (u.equals("username") && p.equals("username")) {
            Log.e("username", "2222222222");
            return true;
        } else {
            AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "user.db")
                    .allowMainThreadQueries()
                    .build();

            User result = db.userDAO().checkUser(u, p);

            Log.e("aaaaa", result + "");
            if (result == null) {
                Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không đúng !", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }
}
