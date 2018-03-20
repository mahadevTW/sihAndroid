package com.example.bhakti.electricityapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class Registration extends AppCompatActivity implements View.OnClickListener{

    Button registerBtn;
    EditText txtName,txtPassword, txtContact, txtID;
    String name, password, cid, contact;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");

        txtName=(EditText)this.findViewById(R.id.editText);
        txtPassword=(EditText)this.findViewById(R.id.editText2);
        txtID=(EditText)this.findViewById(R.id.editText4);
        txtContact=(EditText)this.findViewById(R.id.editText5);
        registerBtn=(Button)this.findViewById(R.id.button1);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        checkValidation();
            }

    void checkValidation(){

        name = txtName.getText().toString();
        password = txtPassword.getText().toString();
        cid = txtID.getText().toString();
        contact = txtContact.getText().toString();



        if ((!name.equals("")) && name.matches("[a-zA-Z]+") ) {
            if ((!contact.equals(""))&&contact.length()==10&&contact.matches("^[7|8|9][0-9]+")) {
                    if (!password.equals("")) {

                        if (!cid.equals("")) {
                            registerOnServer();

                        } else {
                            txtID.setText("");
                            txtID.setHint("Please Enter Valid Customer ID");
                            txtID.requestFocus();
                        }

                    } else {
                        txtPassword.setText("");
                        txtPassword.setHint("Please Enter Password");
                        txtPassword.requestFocus();
                    }

            }else {
                txtContact.setText("");
                txtContact.setHint("Please Enter Contact");
                txtContact.requestFocus();
            }
        } else {
            txtName.setText("");
            txtName.setHint("Please Enter Valid Name");
            txtName.requestFocus();
        }

    }



    void registerOnServer(){


        progressDialog.show();

        name = txtName.getText().toString();
        password = txtPassword.getText().toString();
        cid = txtID.getText().toString();
        contact = txtContact.getText().toString();

        SharedPreferences sp=getSharedPreferences("IP", MODE_PRIVATE);

        String IP=sp.getString("IP","209.190.31.226:8080");

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        String url=ProjectConfig.REGISTRATION+"?username="+name+"&password="+password+"&customerid="+cid+"&contact="+contact;

       // http://localhost:8080/Toll_Plaza_Project/Adduserapi?username=divya&password=divya&emailId=divya10@gmail.com&mobileNumber=6767676767&address=pune&accountNumber=9999999&cvv=890890

        url=url.replace(" ","");
        JsonObjectRequest jsObjRequest = new JsonObjectRequest("http://"+IP+ url, null, new Response.Listener<JSONObject>() {

            public void onResponse(JSONObject jsonObject) {

                progressDialog.hide();

                Log.i("##", "##" + jsonObject.toString());
                System.out.println("## response:" + jsonObject.toString());

                try {
                    if(jsonObject.getString("result").equals("success")){

                        //start new activity
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(),"Registration Successful", Toast.LENGTH_SHORT).show();
                        finish();

                    }else
                    {
                        Toast.makeText(getApplicationContext(),"Registration Unsuccessful: "+jsonObject.getString("result"), Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, this.createRequestRegisterErrorListener());


        requestQueue.add(jsObjRequest);
    }

    /**
     * Error Listener of the requested url
     * @return Response.ErrorListener
     */
    private Response.ErrorListener createRequestRegisterErrorListener() {
        return new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("##", "##" + error.toString());
                System.out.println("eeeeeeeeeeeeeeeee"+error.toString());
                progressDialog.hide();

            }
        };
    }

}