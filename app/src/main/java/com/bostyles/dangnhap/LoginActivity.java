package com.bostyles.dangnhap;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = edtUsername.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                            "Vui lòng nhập đầy đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tài khoản đúng (giả lập)
                if (user.equals("admin") && pass.equals("123")) {

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("USERNAME", user);
                    startActivity(intent);
                    finish(); // không quay lại login khi bấm Back

                } else {
                    Toast.makeText(LoginActivity.this,
                            "Đăng nhập sai, vui lòng đăng nhập lại",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
