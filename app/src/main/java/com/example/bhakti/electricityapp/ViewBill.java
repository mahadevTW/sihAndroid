package com.example.bhakti.electricityapp;

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
import android.widget.Toast;

public class ViewBill extends AppCompatActivity {

    String months[],txt;
    ArrayAdapter adp;
    Spinner sp;
    TextView t4,t5,t6;
    Button payBtn, pdfBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bill);
        setTitle("My Bill");

        sp=(Spinner)this.findViewById(R.id.spinner3);
        t4=(TextView)this.findViewById(R.id.t4);
        t5=(TextView) this.findViewById(R.id.t5);
        t6=(TextView)this.findViewById(R.id.t6);
        payBtn=(Button)this.findViewById(R.id.button);
        pdfBtn=(Button)this.findViewById(R.id.button3);

        months= new String[]{"--Select--","January","February","March","April","May",
                "June","July","August","September","October","November","December"};



        adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,months);
        sp.setAdapter(adp);

        sp.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                txt = sp.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }));


        t4.setText("Your name");


        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Successful paid",Toast.LENGTH_LONG).show();
            }
        });

        pdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        ActionBar actionBar = getSupportActionBar();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

}
