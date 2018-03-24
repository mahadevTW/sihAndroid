package com.example.bhakti.electricityapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserHome extends AppCompatActivity implements View.OnClickListener{

    TextView viewBillBtn, historyBtn, complaintBtn, notificationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        setTitle("User Home");

        viewBillBtn=(TextView)this.findViewById(R.id.t5);
        historyBtn = (TextView) this.findViewById(R.id.t6);
        complaintBtn = (TextView) this.findViewById(R.id.t7);
        notificationBtn = (TextView) this.findViewById(R.id.t8);

        viewBillBtn.setOnClickListener(this);
        historyBtn.setOnClickListener(this);
        complaintBtn.setOnClickListener(this);
        notificationBtn.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.t5) {
            Intent i = new Intent(this, ViewBill.class);
            startActivity(i);
        }

        if(v.getId() == R.id.t6) {
            Intent i = new Intent(this, History.class);
            startActivity(i);
        }
        if(v.getId() == R.id.t7) {
            Intent i = new Intent(this, MyComplaint.class);
            startActivity(i);
        }
        if(v.getId() == R.id.t8) {
            Intent i = new Intent(this, Notifications.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
