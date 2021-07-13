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

public class AddStudentAccount extends AppCompatActivity {
    EditText studentname,studentbranch,studentpecent,studentpass;
    Button addstudent;
    final String addstu_url= "https://spsys.000webhostapp.com/addstudent.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_account);
        studentname = findViewById(R.id.addstuname);
        studentbranch = findViewById(R.id.addstubranch);
        studentpecent = findViewById(R.id.addstupercent);
        studentpass = findViewById(R.id.addstupass);
        addstudent = findViewById(R.id.btnaddstudetail);
        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Addstu_credential(studentname.getText().toString(),studentbranch.getText().toString(),studentpecent.getText().toString(),studentpass.getText().toString());
            }
        });
    }
    public void Addstu_credential(final String stuname,final String stubranch,final String stupercent, final String stupass) {
        final String Stuname = studentname.getText().toString().trim();
        final String Stubranch = studentbranch.getText().toString().trim();
        final String Stupercent = studentpecent.getText().toString().trim();
        final String Stupass = studentpass.getText().toString().trim();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Creating Student Account...");

        if (Stuname.isEmpty()) {
            Toast.makeText(this, "Enter Student Name", Toast.LENGTH_LONG).show();
            return;
        } else if (Stubranch.isEmpty()) {
            Toast.makeText(this, "Enter Student Branch", Toast.LENGTH_LONG).show();
            return;
        } else if (Stupercent.isEmpty()) {
            Toast.makeText(this, "Enter Student Percent", Toast.LENGTH_LONG).show();
            return;
        } else if (Stupass.isEmpty()) {
            Toast.makeText(this, "Enter Student Password", Toast.LENGTH_LONG).show();
            return;
        } else {
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, addstu_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    if (response.trim().equals("Student Account Created Successfully!!")) {
                        Intent intent = new Intent(AddStudentAccount.this, AdminArea.class);
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
                    obj.put("stuname", stuname);
                    obj.put("stubranch", stubranch);
                    obj.put("stupercent", stupercent);
                    obj.put("stupass", stupass);
                    return obj;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}