package com.example.ea.prolink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UndefinedAppointmentActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Appointment> appointmentList;
    RecyclerViewAdapterUndefined recyclerViewAdapterUndefined;
    TextView tv_appointmentDateAndTime;
    TextView tv_instructorName;
    RequestQueue requestQueue;
    String status;
    String url="http://172.20.10.5/temp/prolink/public/api/apiControllers/v1/appointments/1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointments_list);
        tv_appointmentDateAndTime = findViewById(R.id.tv_AppointmentDate);
        tv_instructorName = findViewById(R.id.tv_InstructorName);

        appointmentList = new ArrayList<>();
        recyclerView = findViewById(R.id.accepted_appointmentRV);
       recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = Volley.newRequestQueue(this);
        sendjsonrequest("Undefined");
    }
    public void sendjsonrequest(final String givenStatus){


        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray jsonArray = response.getJSONArray("data");
                    for(int i=0;i<jsonArray.length();i++) {

                        JSONObject appointmentJSONObject = jsonArray.getJSONObject(i);
                        status = appointmentJSONObject.getString("status");
                        if (status.equals(givenStatus)) {
                            String date = appointmentJSONObject.getString("date");
                            String instructor_id = appointmentJSONObject.getString("instructor_id");
                            Appointment appointment = new Appointment(instructor_id,date);
                            appointmentList.add(appointment);
                            recyclerViewAdapterUndefined = new RecyclerViewAdapterUndefined(getApplicationContext(),appointmentList);
                            recyclerView.setAdapter(recyclerViewAdapterUndefined);
                    }}




                }catch(JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);

    }
}
