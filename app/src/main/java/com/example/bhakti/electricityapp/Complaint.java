package com.example.bhakti.electricityapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Complaint extends AppCompatActivity implements View.OnClickListener{

    Spinner sp;
    ArrayAdapter adp;
    String str[];
    Button sendBtn, sendBtn2;
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        setTitle("Complaint");

        sp=(Spinner)this.findViewById(R.id.spinner2);
        sendBtn=(Button)this.findViewById(R.id.button14) ;
        sendBtn2=(Button)this.findViewById(R.id.button16) ;

        str= new String[]{"--Select--","Wrong and disproportionate bills ","Bill without consumption","Disconnection without notice and without reason","Complaint is not resolved"};

        adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,str);
        sp.setAdapter(adp);

        sp.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                txt = sp.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }));

        sendBtn.setOnClickListener(this);
        sendBtn2.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button14 || v.getId() == R.id.button16) {
            registerOnServer(txt);
        }
    }

    void registerOnServer(String txtComplaint){

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url="http://192.168.0.130:8090/user";

        Map<String, String> params = new HashMap<>();
        params = new HashMap<>();
        params.put("complaint", txtComplaint);
        final Context me = this;

        JsonObjectRequest request = new JsonObjectRequest(url, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("result").equals("success")){

                        Intent i=new Intent(getApplicationContext(),UserHome.class);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(),"Complaint Successfully Submitted", Toast.LENGTH_SHORT).show();
                        finish();

                    }else
                    {
                        Toast.makeText(getApplicationContext(),"Complaint is not submitted ", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(me,"Error came",Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(request);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
