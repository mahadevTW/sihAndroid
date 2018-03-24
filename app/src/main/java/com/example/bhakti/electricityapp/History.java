package com.example.bhakti.electricityapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class History extends AppCompatActivity {

    private ProgressDialog progressDialog;
    String h1;
    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("History");

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

        t1=(TextView)this.findViewById(R.id.t1);
        t2=(TextView)this.findViewById(R.id.t2);
        t3=(TextView)this.findViewById(R.id.t3);
        t4=(TextView)this.findViewById(R.id.t4);

        ActionBar actionBar = getSupportActionBar();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            String url="http://192.168.0.130:8090/user";

            JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST,url, null, new Response.Listener<JSONObject>() {

                public void onResponse(JSONObject jsonObject) {

                    progressDialog.hide();

                    Log.i("##", "##" + jsonObject.toString());
                    System.out.println("## response:" + jsonObject.toString());

                    try {

                        h1 = jsonObject.getString("history");
                        t1.setText(h1);







                        if(jsonObject.getString("result").equals("success")){

                            //start new activity
                            Intent i=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                            Toast.makeText(getApplicationContext(),"Registration Successful", Toast.LENGTH_SHORT).show();
                            finish();

                        }else
                        {
                            Toast.makeText(getApplicationContext(),"Registration Unsuccessful: "+jsonObject.getString("result"), Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, this.createRequestRegisterErrorListener());



            requestQueue.add(jsObjRequest);


    }

    private Response.ErrorListener createRequestRegisterErrorListener() {

        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("##", "##" + error.toString());
                System.out.println("eeeeeeeeeeeeeeeee" + error.toString());
                progressDialog.hide();

            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
