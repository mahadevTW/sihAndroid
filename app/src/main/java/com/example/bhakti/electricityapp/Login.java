package com.example.bhakti.electricityapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button loginBtn;
    EditText txtUserName,txtUserPassword;
    String Username, Userpassword;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUserName=(EditText)this.findViewById(R.id.editText3);
        txtUserPassword=(EditText)this.findViewById(R.id.editText6);
        loginBtn=(Button)this.findViewById(R.id.button2);

        loginBtn.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

    }

    @Override
    public void onClick(View v) {

            Intent i = new Intent(this, UserHome.class);
            startActivity(i);

        //checkValidation();
    }

//    void checkValidation(){
//
//        Username = txtUserName.getText().toString();
//        Userpassword = txtUserPassword.getText().toString();
//
//
//        if ((!Username.equals("")) && Username.matches("[a-zA-Z]+") ) {
//            if (!Userpassword.equals("")) {
//
//                checkLogin();
//
//            } else {
//                txtUserPassword.setText("");
//                txtUserPassword.setHint("Please Enter Password");
//                txtUserPassword.requestFocus();
//            }
//        } else {
//            txtUserName.setText("");
//            txtUserName.setHint("Please Enter Valid Name");
//            txtUserName.requestFocus();
//        }
//
//    }
//
//    void checkLogin(){
//
//
//        progressDialog.show();
//
//        Username = txtUserName.getText().toString();
//        Userpassword = txtUserPassword.getText().toString();
//
//        SharedPreferences sp=getSharedPreferences("IP", MODE_PRIVATE);
//
//        String IP=sp.getString("IP","209.190.31.226:8080");
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//
//        String url="http://"+IP+ ProjectConfig.LOGIN;
//        url=url.replace(" ","%20");
//
//
//    //------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//    StringRequest jsObjRequest = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
//
//        public void onResponse(String string) {
//
//            progressDialog.hide();
//
//            try {
//
//                JSONObject jsonObject=new JSONObject(string);
//                Log.i("##", "##" + jsonObject.toString());
//                System.out.println("## response:" + jsonObject.toString());
//
//                if(jsonObject.getString("result").equals("success")){
//
//
//                    Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
//                    SharedPreferences pref = getApplicationContext().getSharedPreferences("isLogin", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = pref.edit();
//                    editor.putString("isLogin", "1");
//                    editor.commit();
//
//                    SharedPreferences sp=getSharedPreferences("myPref",MODE_PRIVATE);
//                    Log.d("######## ","  id  :  "+jsonObject.getInt("id"));
//                    SharedPreferences.Editor e=sp.edit();
//                    e.putString("id",jsonObject.getInt("id")+"");
//                    e.apply();
//
//
//                    Intent i=new Intent(getApplicationContext(),UserHome.class);
//                    startActivity(i);
//                    finish();
//
//
//                }else{
//                    Toast.makeText(getApplicationContext(), "Login Unsuccessfull", Toast.LENGTH_SHORT).show();
//
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//    }, this.createRequestRegisterErrorListener());
//
//        requestQueue.add(jsObjRequest);
//}
//
//    /**
//     * Error Listener of the requested url
//     * @return Response.ErrorListener
//     */
//    private Response.ErrorListener createRequestRegisterErrorListener() {
//        return new Response.ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.i("##", "##" + error.toString());
//                progressDialog.hide();
//
//            }
//        };
//    }
//
//
//
//

}
