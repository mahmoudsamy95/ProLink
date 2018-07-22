package com.example.ea.prolink.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ea.prolink.models.Appointment;
import com.example.ea.prolink.views.Adapters.RecyclerViewAdapterAccepted;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ea on 6/30/2018.
 */

public class AppointmentController {

    public void reserveAppointment(Context context,final String date, final String time, final int instructor_id, final int student_id){

        String url="http://192.168.1.71:81/postAppointment.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("date",date);
                params.put("time",time);
                params.put("student_id",String.valueOf(student_id));
                params.put("instructor_id",String.valueOf(instructor_id));


                return params;
            }
        }
                ;

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


    }


}
