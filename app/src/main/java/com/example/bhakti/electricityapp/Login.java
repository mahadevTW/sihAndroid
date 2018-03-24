package com.example.bhakti.electricityapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button loginBtn;
    EditText txtUserName,txtUserPassword;
    String Username, Userpassword;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Log In");

        txtUserName=(EditText)this.findViewById(R.id.editText3);
        txtUserPassword=(EditText)this.findViewById(R.id.editText6);
        loginBtn=(Button)this.findViewById(R.id.button2);

        loginBtn.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

        ActionBar actionBar = getSupportActionBar();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

    }

    @Override
    public void onClick(View v) {

        checkValidation();
    }

   void checkValidation(){

        Username = txtUserName.getText().toString();
        Userpassword = txtUserPassword.getText().toString();

        if ((!Username.equals("")) && Username.matches("[a-zA-Z]+") ) {
            if (!Userpassword.equals("")) {

                checkLogin();

            } else {
                txtUserPassword.setText("");
                txtUserPassword.setHint("Please Enter Password");
                txtUserPassword.requestFocus();
            }
        } else {
            txtUserName.setText("");
            txtUserName.setHint("Please Enter Valid Name");
            txtUserName.requestFocus();
        }

    }

    void checkLogin(){
        progressDialog.show();

        Username = txtUserName.getText().toString();
        Userpassword = txtUserPassword.getText().toString();

        //SharedPreferences sp=getSharedPreferences("IP", MODE_PRIVATE);
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url="http://192.168.0.130:8090/login";

        Map<String, String> params = new HashMap<>();
        params = new HashMap<>();
        params.put("username", Username);
        params.put("password", Userpassword);
        final Context me = this;

        JsonObjectRequest request = new JsonObjectRequest(url,new JSONObject(params), new Response.Listener<JSONObject>() {

        public void onResponse(JSONObject response) {
            progressDialog.hide();

           try {
                if(response.getString("result").equals("success")){


                    Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                    /*SharedPreferences pref = getApplicationContext().getSharedPreferences("isLogin", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("isLogin", "1");
                    editor.commit();

                    SharedPreferences sp=getSharedPreferences("myPref",MODE_PRIVATE);
                    Log.d("######## ","  id  :  "+response.getInt("id"));
                    SharedPreferences.Editor e=sp.edit();
                    e.putString("id",response.getInt("id")+"");
                    e.apply();*/

                    Intent i=new Intent(getApplicationContext(),UserHome.class);
                    startActivity(i);
                    finish();


                }else{
                    Toast.makeText(getApplicationContext(), "Login Unsuccessfull", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
                    finish();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(me,"Error came",Toast.LENGTH_LONG).show();
        }
    });
        requestQueue.add(request);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

}
