package com.example.bhakti.electricityapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Notifications extends AppCompatActivity implements View.OnClickListener {

    TextView t1,t2,t3;
    boolean ist2Clicked = false;
    boolean ist3Clicked = false;
    boolean ist1Clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        setTitle("Notifications");

        t1 = (TextView) findViewById(R.id.t1);
        String str = "If your view subclass is displaying its own Drawable objects, it should override this function and return true for any Drawable it is displaying. This allows animations for those drawables to be scheduled." +
                "I made the expandable list view acc to your tutorial but what i have to do if I want to populate Expandable List View with values from database?Means what changes I have to do in ";
        t1.setText(str);

        t2 = (TextView) findViewById(R.id.t2);
         str = "If your view subclass is displaying its own Drawable objects, it should override this function and return true for any Drawable it is displaying. This allows animations for those drawables to be scheduled." +
                "I made the expandable list view acc to your tutorial but what i have to do if I want to populate Expandable List View with values from database?Means what changes I have to do in ";
        t2.setText(str);

        t3 = (TextView) findViewById(R.id.t3);
         str = "If your view subclass is displaying its own Drawable objects, it should override this function and return true for any Drawable it is displaying. This allows animations for those drawables to be scheduled." +
                "I made the expandable list view acc to your tutorial but what i have to do if I want to populate Expandable List View with values from database?Means what changes I have to do in ";
        t3.setText(str);

        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.t1 :
                if(ist1Clicked){
                    //This will shrink textview to 2 lines if it is expanded.
                    t1.setMaxLines(2);
                    ist1Clicked = false;
                } else {
                    //This will expand the textview if it is of 2 lines
                    t1.setMaxLines(Integer.MAX_VALUE);
                    ist1Clicked = true;
                }
                break;

            case R.id.t2 :
                if(ist2Clicked){
                    //This will shrink textview to 2 lines if it is expanded.
                    t2.setMaxLines(2);
                    ist2Clicked = false;
                } else {
                    //This will expand the textview if it is of 2 lines
                    t2.setMaxLines(Integer.MAX_VALUE);
                    ist2Clicked = true;
                }
                break;

            case R.id.t3 :
                if(ist3Clicked){
                    //This will shrink textview to 2 lines if it is expanded.
                    t3.setMaxLines(2);
                    ist3Clicked = false;
                } else {
                    //This will expand the textview if it is of 2 lines
                    t3.setMaxLines(Integer.MAX_VALUE);
                    ist3Clicked = true;
                }
                break;
        }
    }
}
