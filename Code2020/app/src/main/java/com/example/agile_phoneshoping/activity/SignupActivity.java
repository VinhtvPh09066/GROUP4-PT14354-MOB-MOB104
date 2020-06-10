package com.example.agile_phoneshoping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.agile_phoneshoping.R;
import com.google.android.material.textfield.TextInputEditText;

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

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (validater()){
                   // dung het , show dialog thoong bao loi hoac thanh cong
                   checkSignup();
               }


            }
        });
    }

    private void initView() {
        edtsignupEmail = (TextInputEditText) findViewById(R.id.edtsignupEmail);
        edtsignupUsername = (TextInputEditText) findViewById(R.id.edtsignupUsername);
        edtsignupPassword = (TextInputEditText) findViewById(R.id.edtsignupPassword);
        btnSignup = (Button) findViewById(R.id.btnSignup);
    }

    private boolean validater() {

        String checkemail = edtsignupEmail.getText().toString().trim();
        String checkuser = edtsignupUsername.getText().toString().trim();
        String checkpassword = edtsignupPassword.getText().toString().trim();
        String emailRegEx = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";

        pattern = Pattern.compile(emailRegEx);

        if (checkemail.length() == 0) {
            edtsignupEmail.setError("Vui Lòng Nhập Email !");
            edtsignupEmail.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(checkemail).matches()) {
            edtsignupEmail.setError("Email Sai định dạng !");
            edtsignupEmail.requestFocus();
            return false;
        }
        else if (checkuser.length() == 0) {
            edtsignupUsername.setError("Vui Lòng Nhập Username!");
            return false;
        } else if (checkuser.length() < 5){
            edtsignupUsername.setError("Username Không Đúng Định Dạng!");
            return false;
        }
        else if (checkpassword.length() == 0) {
            edtsignupPassword.setError("Vui Lòng Nhập Password !");
            return  false;
        } else if (checkpassword.length() < 5) {
            edtsignupPassword.setError("Password Không Đúng Định Dạng!");
            return  false;
        }
        else {
            if (checkuser.equals("thatbai")){
                checkdialog=false;
            }else if (checkuser.equals("thanhcong")){
                checkdialog=true;
            }
        }

        return true;
    }

    private void checkSignup(){
        // thanh cong hoac that bai
        if (checkdialog==true){
            Dialog dialog = new Dialog(SignupActivity.this);
            dialog.setContentView(R.layout.dialog_signupsuccess);
            dialog.setCancelable(true);
            Button backlogin = dialog.findViewById(R.id.backlogin);
            backlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            });
            dialog.show();
        }else {
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

}