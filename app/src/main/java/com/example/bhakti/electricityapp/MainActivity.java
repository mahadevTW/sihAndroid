package com.example.bhakti.electricityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView regBtn, newConnBtn, logBtn, payOthersBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regBtn=(TextView) this.findViewById(R.id.t1);
        newConnBtn = (TextView) this.findViewById(R.id.t2);
        logBtn = (TextView) this.findViewById(R.id.t3);
        payOthersBtn = (TextView) this.findViewById(R.id.t4);

        regBtn.setOnClickListener(this);
        logBtn.setOnClickListener(this);
        newConnBtn.setOnClickListener(this);
        payOthersBtn.setOnClickListener(this);

    }

    public void onClick(View v) {

        if(v.getId() == R.id.t1) {
            Intent i = new Intent(this, Registration.class);
            startActivity(i);
        }

        if(v.getId() == R.id.t2) {
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }
        if(v.getId() == R.id.t3) {
            Intent i = new Intent(this, NewConnection.class);
            startActivity(i);
        }
        if(v.getId() == R.id.t4) {
            Intent i = new Intent(this, QuickPay.class);
            startActivity(i);
        }
    }
}
