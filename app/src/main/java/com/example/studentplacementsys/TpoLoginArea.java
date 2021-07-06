package com.example.studentplacementsys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TpoLoginArea extends AppCompatActivity {
    Button btnaddcompany,btnaddpastpaer,btnaddselectedstudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_login_area);
        btnaddcompany = findViewById(R.id.btnaddcompany);
        btnaddpastpaer = findViewById(R.id.btnpastpaper);
        btnaddselectedstudent = findViewById(R.id.btnselectedstudent);
        btnaddcompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TpoLoginArea.this, AddCompanyDetails.class);
                startActivity(intent);
//                finish();
            }
        });
        btnaddpastpaer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TpoLoginArea.this, AddPastPaper.class);
                startActivity(intent);
//                finish();
            }
        });
        btnaddselectedstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TpoLoginArea.this, AddSelectedStudent.class);
                startActivity(intent);
//                finish();
            }
        });
    }
}