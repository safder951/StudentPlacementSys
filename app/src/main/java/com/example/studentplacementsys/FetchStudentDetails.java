package com.example.studentplacementsys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FetchStudentDetails extends AppCompatActivity {
    final String FETCH_Student_DATA = "https://spsys.000webhostapp.com/fetchselectedStudent.php";
    RecyclerView recyclerView;
    List<Studentlist> mystulist;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_company_details);
        recyclerView = findViewById(R.id.rvfetchstudentdetail);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mystulist = new ArrayList<>();
        fetchStudentData();
    }

    private void fetchStudentData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Student Data from Server...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, FETCH_Student_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("selectedstudent");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        Studentlist StudentlistS = new Studentlist(object.getString("name_of_student"),
                                object.getString("student_skill"),
                                object.getString("student_number"),
                                object.getString("student_address"));
                        mystulist.add(StudentlistS);
                    }
                    adapter = new studentAdaptor(getApplicationContext(), mystulist);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}