package com.example.bhakti.electricityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView regBtn, newConnBtn, logBtn, payOthersBtn;
    ImageView i1,i2,i3,i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regBtn=(TextView) this.findViewById(R.id.t1);
        newConnBtn = (TextView) this.findViewById(R.id.t2);
        logBtn = (TextView) this.findViewById(R.id.t3);
        payOthersBtn = (TextView) this.findViewById(R.id.t4);

        i1=(ImageView)this.findViewById(R.id.i1);
        i2=(ImageView)this.findViewById(R.id.i2);
        i3=(ImageView)this.findViewById(R.id.i3);
        i4=(ImageView)this.findViewById(R.id.i4);

        regBtn.setOnClickListener(this);
        logBtn.setOnClickListener(this);
        newConnBtn.setOnClickListener(this);
        payOthersBtn.setOnClickListener(this);
        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);

    }

    public void onClick(View v) {

        if(v.getId() == R.id.t1) {
            Intent i = new Intent(this, Registration.class);
            startActivity(i);
        }

        if(v.getId() == R.id.t2 ) {
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }
        if(v.getId() == R.id.t3 ) {
            Intent i = new Intent(this, NewConnection.class);
            startActivity(i);
        }
        if(v.getId() == R.id.t4) {
            Intent i = new Intent(this, QuickPay.class);
            startActivity(i);
        }
        if(v.getId() == R.id.i1) {
            Intent i = new Intent(this, Registration.class);
            startActivity(i);
        }
        if(v.getId() == R.id.i2) {
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }
        if(v.getId() == R.id.i3) {
            Intent i = new Intent(this, NewConnection.class);
            startActivity(i);
        }
        if(v.getId() == R.id.i4) {
            Intent i = new Intent(this, QuickPay.class);
            startActivity(i);
        }
    }
}
