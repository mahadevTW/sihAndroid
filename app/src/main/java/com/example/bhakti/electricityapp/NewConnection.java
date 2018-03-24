package com.example.bhakti.electricityapp;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class NewConnection extends AppCompatActivity implements View.OnClickListener {

    Spinner sp,sp1;
    ArrayAdapter adp,adp1;
    String str[];
    String str1[];
    String consumerCat, supplyTy;
    TextView txtname, txtcontact, txtemail, txtaadhar,txtplot, txtcity,txtpincode;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_connection);
        setTitle("New Connection");

        sp=(Spinner)this.findViewById(R.id.spinner);
        sp1=(Spinner)this.findViewById(R.id.spinner1);
        txtname=(TextView)this.findViewById(R.id.editText8);
        txtcontact=(TextView)this.findViewById(R.id.editText5);
        txtemail=(TextView)this.findViewById(R.id.editText2);
        txtaadhar=(TextView)this.findViewById(R.id.editText6);
        txtplot=(TextView)this.findViewById(R.id.editText9);
        txtcity=(TextView)this.findViewById(R.id.editText4);
        txtpincode=(TextView)this.findViewById(R.id.editText);
        reg=(Button)this.findViewById(R.id.button1);

        str= new String[]{"--Select--","LT-SUPPLY","HT-SUPPLY","EHV"};
        str1= new String[]{"--Select--","Single Phase","Three Phase","HT Supply"};

        adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,str);
        sp.setAdapter(adp);

        sp.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                consumerCat = sp.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }));


        adp1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,str1);
        sp1.setAdapter(adp1);

        sp1.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                supplyTy = sp1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }));


        ActionBar actionBar = getSupportActionBar();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        reg.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        String name=txtname.getText().toString();
        String contact=txtname.getText().toString();
        String email=txtname.getText().toString();
        String aadhar=txtname.getText().toString();
        String plot=txtname.getText().toString();
        String city=txtname.getText().toString();
        String pincode = txtpincode.getText().toString();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url="http://192.168.0.130:8090/login";

//        Map<String, String> params = new HashMap<>();
//        params = new HashMap<>();
//        params.put("username", Username);
//        params.put("password", Userpassword);
//        final Context me = this;
    }
}
