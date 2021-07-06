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

public class AddTpoAccount extends AppCompatActivity {
    EditText tponame, tpoemail, tpopass;
    Button btnaddtpo;
    final String addtpo_url = "https://spsys.000webhostapp.com/addtpodetail.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tpo_account);
        tponame = findViewById(R.id.addtponame);
        tpoemail = findViewById(R.id.addtpoemail);
        tpopass = findViewById(R.id.addtpopass);
        btnaddtpo = findViewById(R.id.btnaddtpoaccount);
        btnaddtpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Addtpo_credential(tponame.getText().toString(), tpoemail.getText().toString(), tpopass.getText().toString());
            }
        });
    }

    public void Addtpo_credential(final String Tponame, final String Tpoemail, final String Tpopass) {
        final String tname = tponame.getText().toString().trim();
        final String temail = tpoemail.getText().toString().trim();
        final String tpass = tpopass.getText().toString().trim();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Creating TPO Account...");

        if (tname.isEmpty()) {
            Toast.makeText(this, "Enter TPO Name", Toast.LENGTH_LONG).show();
            return;
        } else if (temail.isEmpty()) {
            Toast.makeText(this, "Enter TPO Email", Toast.LENGTH_LONG).show();
            return;
        } else if (tpass.isEmpty()) {
            Toast.makeText(this, "Enter TPO Password", Toast.LENGTH_LONG).show();
            return;
        } else {
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, addtpo_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    if (response.trim().equals("Added TPO Successfully")) {
                        Intent intent = new Intent(AddTpoAccount.this, AdminArea.class);
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
                    obj.put("tponame", Tponame);
                    obj.put("tpoemail", Tpoemail);
                    obj.put("tpopass", Tpopass);
                    return obj;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}