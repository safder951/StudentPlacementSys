package com.example.studentplacementsys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminArea extends AppCompatActivity {
    Button btnaddtpo,btnaddstudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_area);
        btnaddtpo = findViewById(R.id.btnaddcompanydetail);
        btnaddstudent = findViewById(R.id.btnaddstuent);
        btnaddtpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminArea.this, AddTpoAccount.class);
                startActivity(i);
            }
        });
        btnaddstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminArea.this, AddStudentAccount.class);
                startActivity(i);
            }
        });
    }
}