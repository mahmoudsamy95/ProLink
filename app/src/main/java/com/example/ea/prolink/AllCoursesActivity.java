package com.example.ea.prolink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ea.prolink.Course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class AllCoursesActivity extends AppCompatActivity {

   /* private final String JSON_URL="http://172.20.10.4/server/server-2/prolink/public/api/apiControllers/v1/courses";
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private List<Course> courseList;
    RecyclerView  recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_courses);
        recyclerView =findViewById(R.id.courseRV);
        jsonrequest();
    }
    private void jsonrequest(){
        RequestQueue requestQueue;
        JsonArrayRequest request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                    try {
                        Toast.makeText(AllCoursesActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                        for(int i=0;i<response.length();i++) {
                            jsonObject = response.getJSONObject(i);
                            Course course = new Course();
                            course.setName(jsonObject.getString("name"));
                            course.setId(jsonObject.getString("id"));
                            courseList.add(course);


                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                setuprecyclerview(courseList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(AllCoursesActivity.this);
        requestQueue.add(request);
    }
    public void setuprecyclerview(List<Course> acceptedAppointment) {
        RecyclerViewAdapterCourse myadapter = new RecyclerViewAdapterCourse(this,courseList);

    }*/
}
