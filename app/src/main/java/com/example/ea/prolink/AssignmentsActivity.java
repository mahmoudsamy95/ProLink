package com.example.ea.prolink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AssignmentsActivity extends AppCompatActivity {
    private List<Assignment> assignmentList;
    RecyclerView recyclerView;
    RecyclerViewAdapterAssignment recyclerViewAdapterAssignment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);
        recyclerView = (RecyclerView) findViewById(R.id.assignmentRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        assignmentList=new ArrayList<>();
        jsonParse("1");
    }

    private void jsonParse(String id){
        String URL_DATA="http://172.20.10.5/temp/prolink/public/api/apiControllers/v1/assignments/"+id;

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                           // Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                            JSONObject object=new JSONObject(response);
                            JSONArray array=object.getJSONArray("data");
                            for(int i=0;i<array.length();i++) {
                                JSONObject o = array.getJSONObject(i);
                                Assignment assignment = new Assignment(
                                        o.getString("name"),
                                        o.getString("description"),
                                        o.getString("due"));
                                assignmentList.add(assignment);




                            }
                            recyclerViewAdapterAssignment=new RecyclerViewAdapterAssignment(getApplicationContext(),assignmentList);
                            recyclerView.setAdapter(recyclerViewAdapterAssignment);
                        } catch (JSONException e) {
                            e.printStackTrace();}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }
}
