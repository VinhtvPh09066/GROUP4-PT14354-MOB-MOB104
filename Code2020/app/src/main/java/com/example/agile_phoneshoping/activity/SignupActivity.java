package com.example.agile_phoneshoping.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.database.AppDatabase;
import com.example.agile_phoneshoping.model.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    private EditText edtsignupUsername, edtsignupEmail, edtsignupPassword;
    private Button btnSignup;
    Pattern pattern;
    boolean checkdialog = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "user.db").allowMainThreadQueries().build();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // dung het , show dialog thoong bao loi hoac thanh cong
                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "user.db").allowMainThreadQueries().build();
                String checkemail = edtsignupEmail.getText().toString().trim();
                String checkuser = edtsignupUsername.getText().toString().trim();
                String checkpassword = edtsignupPassword.getText().toString().trim();
                String emailRegEx = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";

                pattern = Pattern.compile(emailRegEx);

                if (checkemail.length() == 0) {
                    edtsignupEmail.setError("Vui Lòng Nhập Email !");
                    edtsignupEmail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(checkemail).matches()) {
                    edtsignupEmail.setError("Email Sai định dạng !");
                    edtsignupEmail.requestFocus();
                }
                else if (checkuser.length() == 0) {
                    edtsignupUsername.setError("Vui Lòng Nhập Username!");
                } else if (checkuser.length() < 6) {
                    edtsignupUsername.setError("Username phải lớn hơn 6 ký tự , vui lòng thử lại");
                } else if (checkuser.length() > 30) {
                    edtsignupUsername.setError("Username phải nhỏ hơn 30 ký tự, vui lòng thử lại");
                }  else if (checkpassword.length() == 0) {
                    edtsignupPassword.setError("Vui Lòng Nhập Password !");
                } else if (checkpassword.length() < 6) {
                    edtsignupPassword.setError("Password tối thiểu phải 6 ký tự, vui lòng thử lại");
                } else if (checkpassword.length() > 10) {
                    edtsignupPassword.setError("Password không được vượt quá 10 ký tự, vui lòng thử lại");
                } else {
                        if (!checkIsBlank(checkuser)){
                            edtsignupUsername.setError("Username có khoảng trắng, vui lòng thử lại");
                        } else if (!checkIsBlank(checkpassword)){
                            edtsignupPassword.setError("Username có khoảng trắng, vui lòng thử lại");
                        } else {

                            User user = new User(checkuser,checkuser,checkpassword,checkemail,"cập nhật","cập nhật","tiền mặt","user");
                            user.username = checkuser;
                            user.name = checkuser;
                            user.password = checkpassword;
                            user.email = checkemail;
                            long[] result = db.userDAO().insert(user);
                            if (result[0] > 0) {
                                Toast.makeText(SignupActivity.this, "Thêm Thành Công Username : " + checkuser, Toast.LENGTH_SHORT).show();
                                checkdialog = true;
                            } else {
                                Toast.makeText(SignupActivity.this, "Thất bại, User : " + checkuser + " Đã tồn tại", Toast.LENGTH_SHORT).show();
                                checkdialog = false;
                            }
                        }
                }

                checkSignup();
            }
        });
    }

    private void initView() {
        edtsignupEmail = (TextInputEditText) findViewById(R.id.edtsignupEmail);
        edtsignupUsername = (TextInputEditText) findViewById(R.id.edtsignupUsername);
        edtsignupPassword = (TextInputEditText) findViewById(R.id.edtsignupPassword);
        btnSignup = (Button) findViewById(R.id.btnSignup);
    }


    private void checkSignup() {
        // thanh cong hoac that bai
        if (checkdialog == true) {
            Dialog dialog = new Dialog(SignupActivity.this);
            dialog.setContentView(R.layout.dialog_signupsuccess);
            dialog.setCancelable(true);
            Button backlogin = dialog.findViewById(R.id.backlogin);
            backlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
            dialog.show();
        } else {
            final Dialog dialog = new Dialog(SignupActivity.this);
            dialog.setContentView(R.layout.dialog_signupfail);
            dialog.setCancelable(true);
            Button cancelsignup = dialog.findViewById(R.id.cancel_signup);
            cancelsignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }

    public boolean checkIsBlank(String text) {

        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}