package com.example.ecommoblie_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecommoblie_app.Model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity {
    Button btn_login, bt_redirect_logout, btn_login_admin;
    EditText userName_login, password_login;
    String parentDbName = "User";
    int role_id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

    }

    public void init() {
        userName_login = findViewById(R.id.userName_login);
        password_login = findViewById(R.id.password_login);
        btn_login = findViewById(R.id.btn_login);
        bt_redirect_logout = findViewById(R.id.bt_redirect_register);
        btn_login_admin = findViewById(R.id.btn_login_admin);

        bt_redirect_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        btn_login_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login_Admin();
            }
        });
    }

    private void Login_Admin() {

    }

    private void Login() {
        String userName = userName_login.getText().toString();
        String password = password_login.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "Vui lòng nhập tên đăng nhập !!!", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Vui lòng nhập mật khẩu !!!", Toast.LENGTH_SHORT).show();
        } else {
            final DatabaseReference data;
            data = FirebaseDatabase.getInstance().getReference();
            data.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.child(parentDbName).child(userName).exists()) {
                        Users dataUsers = snapshot.child(parentDbName).child(userName).getValue(Users.class);
                        if (dataUsers.getUserName().contains(userName)) {
                            if (dataUsers.getPassword().contains(password)) {
                                Toast.makeText(LoginActivity.this, "Đăng nhập thành công !!!!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }

                        }

                    } else {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thất bạt:", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

    }

}