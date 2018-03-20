package com.example.bhakti.electricityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Complaint extends AppCompatActivity implements View.OnClickListener{

    Spinner sp;
    ArrayAdapter adp;
    String str[];
    Button sendBtn, sendBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        sp=(Spinner)this.findViewById(R.id.spinner2);
        sendBtn=(Button)this.findViewById(R.id.button14) ;
        sendBtn2=(Button)this.findViewById(R.id.button16) ;

        str= new String[]{"--Select--","Wrong and disproportionate bills ","Bill without consumption","Disconnection without notice and without reason","Complaint is not resolved"};

        adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,str);
        sp.setAdapter(adp);

        sendBtn.setOnClickListener(this);
        sendBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button14 || v.getId() == R.id.button16) {

            Toast.makeText(this, "Your Complaint is successfully submitted.",Toast.LENGTH_LONG).show();
        }
    }
}
