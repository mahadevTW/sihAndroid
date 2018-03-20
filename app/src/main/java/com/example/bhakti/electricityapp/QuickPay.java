package com.example.bhakti.electricityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuickPay extends AppCompatActivity implements View.OnClickListener {
Button qr,payothers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_pay);
        qr=(Button)this.findViewById(R.id.qr);
        payothers=(Button)this.findViewById(R.id.payothers);
        qr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.qr) {
            Intent i = new Intent(this, ReaderActivity.class);
            startActivity(i);
        }

        if(v.getId() == R.id.payothers) {
            Intent i = new Intent(this, PayOthers.class);
            startActivity(i);
        }
    }
}
