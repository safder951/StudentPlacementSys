package com.example.studentplacementsys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AllLoginArea extends AppCompatActivity {
    Button btnadminlogin,btntpologin,btnstudentlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_login_area);
        btnadminlogin = findViewById(R.id.btnadminlogin);
        btntpologin = findViewById(R.id.btntpologin);
        btnstudentlogin = findViewById(R.id.btnstudentlogin);
        btnadminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllLoginArea.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btntpologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllLoginArea.this, TpoLogin.class);
                startActivity(intent);
                finish();
            }
        });
        btnstudentlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllLoginArea.this, StudentLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }
}