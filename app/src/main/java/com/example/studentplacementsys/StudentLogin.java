package com.example.studentplacementsys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class StudentLogin extends AppCompatActivity {
    EditText stuname,stupass;
    Button btnstu_login;
    final String Stu_loginUrl = "https://spsys.000webhostapp.com/studentlogin.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        stuname = findViewById(R.id.loginstu_name);
        stupass = findViewById(R.id.loginstu_pass);
        btnstu_login = findViewById(R.id.btn_stulogin);
        btnstu_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Student_Login(stuname.getText().toString(),stupass.getText().toString());

            }
        });
    }
    public void Student_Login(final String Student_name,final String Student_pass){
        final String stu_nam = stuname.getText().toString().trim();
        final String stu_pass = stupass.getText().toString().trim();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Student Logging...");
        if (stu_nam.isEmpty()) {
            Toast.makeText(this, "Enter Your Name", Toast.LENGTH_LONG).show();
            return;
        } else if (stu_pass.isEmpty()) {
            Toast.makeText(this, "Enter Your Password", Toast.LENGTH_LONG).show();
            return;
        } else {
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Stu_loginUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    if (response.trim().equals("Student Login Successfully")) {
                        Intent intent = new Intent(StudentLogin.this, StudentArea.class);
                        startActivity(intent);
                        finish();
                        progressDialog.dismiss();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> obj = new HashMap<>();
                    obj.put("stu_name", Student_name);
                    obj.put("stu_pass", Student_pass);
                    return obj;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}