package com.example.ea.prolink;
import android.content.Context;
import android.app.DownloadManager;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
//import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StudentActivity extends DrawerActivity {

    private RequestQueue requestQueue;
    private TextView tv_studentName;
    private TextView tv_level;
    private TextView tv_email;
    private TextView tv_phone;
    private TextView tv_birthday;
    private ImageView iv_profile_photo;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_student);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_student, null, false);
        mDrawerLayout.addView(contentView, 0);

        tv_studentName = findViewById(R.id.tv_studentName);
       // tv_level = findViewById(R.id.tv_level);
        tv_email = findViewById(R.id.tv_studentEmail);
      //  tv_phone = findViewById(R.id.tv_studentPhone);
        tv_birthday = findViewById(R.id.tv_studentBD);
        iv_profile_photo = findViewById(R.id.iv_studentPP);
        SharedPreferences prefs = getSharedPreferences("userInfo",MODE_PRIVATE);
        String id=prefs.getString("userId","");

        requestQueue = Volley.newRequestQueue(this);
        jsonParse(id);


    }


    private void jsonParse(String id){


        String url = "http://172.20.10.5/temp/prolink/public/api/apiControllers/v1/userById/" +id;
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    Toast.makeText(StudentActivity.this, "Hussein",Toast.LENGTH_SHORT).show();
                        tv_studentName.setText(response.getString("name"));
                        tv_email.setText(response.getString("email"));
//                        tv_level.setText(response.getString("level"));
                        tv_birthday.setText(response.getString("date_of_birth"));
                    //Picasso.with(getBaseContext()).load(response.getString("photo")).into(iv_profile_photo);


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
