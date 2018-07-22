package com.example.ea.prolink;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    // Creating EditText.
    EditText Email, Password;
    CardView  cv_login;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    // Creating button;

    // Storing server url into String variable.
    String HttpUrl = "http://172.20.10.5/temp/prolink/public/api/apiControllers/v1/login";



    Boolean CheckEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Assigning ID's to EditText.
        Email = (EditText) findViewById(R.id.et_email);
        Password = (EditText) findViewById(R.id.et_password);
        cv_login=findViewById(R.id.cv_login);

        requestQueue=Volley.newRequestQueue(this);

        cv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringRequest postRequest = new StringRequest(Request.Method.POST, HttpUrl,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                              //  Toast.makeText(LoginActivity.this,"this is response: "+response,Toast.LENGTH_SHORT).show();

                                try {
                                    JSONObject user = new JSONObject(response);
                                    String id = user.getString("id");
                                    String userType=user.getString("type");
                                   /* Toast.makeText(LoginActivity.this,id,Toast.LENGTH_SHORT).show();
                                    Toast.makeText(LoginActivity.this,userType,Toast.LENGTH_SHORT).show();*/
                                    SharedPreferences prefs = getSharedPreferences("userInfo",MODE_PRIVATE);
                                    SharedPreferences.Editor editor=prefs.edit();
                                    editor.putString("userId", id);
                                    editor.putString("userType", userType);
                                    editor.apply();
                                    Toast.makeText(LoginActivity.this,"id and user type saved",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                                    }
                                 catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Toast.makeText(LoginActivity.this,"Errorrrrrrr: "+error,Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("email", Email.getText().toString());
                        params.put("password", Password.getText().toString());

                        return params;
                    }
                };
                Volley.newRequestQueue(LoginActivity.this).add(postRequest);


    }});}

    public void login(View view) {

    }





















 /*   private CardView cardView;
    private EditText et_email;
    private EditText et_password;
    private String url = "http://192.168.1.71:81/login.php";

    public final static String KEY_USERNAME = "username";
    public final static String KEY_PASSWORD = "password";
    public final static String LOGIN_SUCCESS = "success";
    public final static String SHARED_PREF_NAME = "tech";



    public final static String LOGGEDIN_SHARED_PREF = "loggedin";
    public final static String USERNAME_SHARED_PREF = "username";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cardView = (CardView)findViewById(R.id.cv_login);
        et_email = (EditText)findViewById(R.id.et_email);
        et_password = (EditText)findViewById(R.id.et_password);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "login clicked", Toast.LENGTH_SHORT).show();
                loginFunction();
            }
        });



    }
    public void loginFunction(){
        final int userType=1;
        final String username = et_email.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        String url="http://192.168.1.71:81/login.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equalsIgnoreCase(LOGIN_SUCCESS)){
                    Toast.makeText(LoginActivity.this, "Login sucessfully", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedpreferences = LoginActivity.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(LOGGEDIN_SHARED_PREF,true);
                    editor.putBoolean(USERNAME_SHARED_PREF, Boolean.parseBoolean(username));
                    editor.commit();
                    if(userType==1){
                        Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
                        intent.putExtra(USERNAME_SHARED_PREF, username);
                        finish();
                        startActivity(intent);

                    }
                    else{
                        Intent intent = new Intent(LoginActivity.this, InstructorActivity.class);
                        intent.putExtra(USERNAME_SHARED_PREF, username);
                        finish();
                        startActivity(intent);
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("username",username);
                params.put("password",password);
                return params;
            }
        }
                ;

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }*/
}
