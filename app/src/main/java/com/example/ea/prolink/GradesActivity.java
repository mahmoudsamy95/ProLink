package com.example.ea.prolink;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class GradesActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    String yearwork_grade,final_grade;
    TextView tv_yearwork,tv_final;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        tv_yearwork=findViewById(R.id.tvYearWork);
        tv_final=findViewById(R.id.tvFinal);
        requestQueue = Volley.newRequestQueue(this);
        jsonParse();
    }
    private void jsonParse(){
        SharedPreferences prefs = getSharedPreferences("userInfo",MODE_PRIVATE);
        String userID=prefs.getString("userId","");
        Toast.makeText(this, userID,Toast.LENGTH_SHORT).show();
        String url = "http://172.20.10.5/temp/prolink/public/api/apiControllers/v1/course/" + getIntent().getExtras().getString("courseID") + "/grades/" + userID;
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    Toast.makeText(GradesActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                    tv_yearwork.setText(response.getString("year_work"));
                    tv_final.setText(response.getString("final_grade"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}
