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
    public  static  final  String SHARED_PREFS="SHAREDPREFS";
    public  static  final  String USERNAME="text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        AppDatabase db = Room.databaseBuilder(this,
                AppDatabase.class, "user.db").allowMainThreadQueries().build();
        //test data
    db.userDAO().delete(new User(1,"nguyễn văn tú","tunvph",5555,"hà nam","tiền mặt"));
    db.userDAO().insert(new User(1,"nguyễn văn tú","tunvph",5555,"hà nam","tiền mặt"));
        // Login navigate
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                if (validater()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

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
            Toast.makeText(this, "Hãy nhập tài khoản !", Toast.LENGTH_SHORT).show();
            edtUsername.requestFocus();
            return false;
        } else if (username.length() < 6 || username.length() > 30) {
            Toast.makeText(this, "Tài khoản phải từ 6 - 30 kí tự !", Toast.LENGTH_SHORT).show();
            edtUsername.requestFocus();
            return false;

        } else if (password.equals("")) {
            Toast.makeText(this, "Hãy nhập mật khẩu !", Toast.LENGTH_SHORT).show();
            edtPassword.requestFocus();
            return false;

        } else if (password.length() < 6 || password.length() > 10) {
            Toast.makeText(this, "Mật khẩu phải từ 6 - 10 kí tự !", Toast.LENGTH_SHORT).show();
            edtPassword.requestFocus();
            return false;
        }

        return true;
    }
    //save data
    public void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS, MODE_PRIVATE );
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(USERNAME,edtUsername.getText().toString());
        editor.apply();

//        editor.commit();
        String userName=sharedPreferences.getString(USERNAME,"not found");
        Log.e("user đăng nhập  là ", ":"+userName );
        Toast.makeText(getApplicationContext(),"user đăng nhập  là "+userName,Toast.LENGTH_SHORT).show();


    }
}
