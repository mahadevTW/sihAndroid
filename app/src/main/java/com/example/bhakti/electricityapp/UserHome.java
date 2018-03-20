package com.example.bhakti.electricityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHome extends AppCompatActivity implements View.OnClickListener{

    Button viewBillBtn, historyBtn, complaintBtn, notificationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        viewBillBtn=(Button)this.findViewById(R.id.button);
        historyBtn = (Button) this.findViewById(R.id.button9);
        complaintBtn = (Button) this.findViewById(R.id.button12);
        notificationBtn = (Button) this.findViewById(R.id.button13);

        viewBillBtn.setOnClickListener(this);
        historyBtn.setOnClickListener(this);
        complaintBtn.setOnClickListener(this);
        notificationBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button) {
            Intent i = new Intent(this, ViewBill.class);
            startActivity(i);
        }

        if(v.getId() == R.id.button9) {
            Intent i = new Intent(this, History.class);
            startActivity(i);
        }
        if(v.getId() == R.id.button12) {
            Intent i = new Intent(this, Complaint.class);
            startActivity(i);
        }
        if(v.getId() == R.id.button13) {
            Intent i = new Intent(this, Notifications.class);
            startActivity(i);
        }
    }
}
