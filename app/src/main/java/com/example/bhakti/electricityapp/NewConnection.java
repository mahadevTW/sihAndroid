package com.example.bhakti.electricityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewConnection extends AppCompatActivity {

    Spinner sp,sp1;
    ArrayAdapter adp,adp1;
    String str[];
    String str1[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_connection);

        str= new String[]{"--Select--","LT-SUPPLY","HT-SUPPLY","EHV"};
        str1= new String[]{"--Select--","Single Phase","Three Phase","HT Supply"};
        sp=(Spinner)this.findViewById(R.id.spinner);
        adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,str);
        sp.setAdapter(adp);

        sp1=(Spinner)this.findViewById(R.id.spinner1);
        adp1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,str1);
        sp1.setAdapter(adp1);



    }

}
