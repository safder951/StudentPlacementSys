package com.example.studentplacementsys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentArea extends AppCompatActivity {

    CardView card1,card2,card3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_area);
        card1 = findViewById(R.id.company);
        card2 = findViewById(R.id.prevoiuspapers);
        card3 = findViewById(R.id.selectedstudent);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentArea.this, FetchCompanyDetails.class);
                startActivity(i);
                finish();
            }
        });
    }
}