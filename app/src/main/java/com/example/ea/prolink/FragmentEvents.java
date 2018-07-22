package com.example.ea.prolink;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class FragmentEvents extends Fragment{
    private static final String URL_DATA="http://172.20.10.5/temp/prolink/public/api/apiControllers/v1/events";
    View view;
    private RecyclerView recyclerView;
    private List<Event> events;
    RecyclerViewAdapterEvent recyclerViewAdapterEvent;
    Context ctx;
    public FragmentEvents() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activities_fragment,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.eventContentRV);
        // recyclerViewAdapterCourse = new RecyclerViewAdapterCourse(getContext(),c);
        recyclerView.setAdapter(recyclerViewAdapterEvent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        events=new ArrayList<>();
        ctx=getContext();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject object=new JSONObject(response);
                            JSONArray array=object.getJSONArray("data");
                            for(int i=0;i<array.length();i++) {
                                JSONObject o = array.getJSONObject(i);
                                String date=o.getString("day")+o.getString("month");
                                Event event = new Event(
                                        o.getString("name"),
                                        o.getString("place"),
                                        o.getString("description"),
                                        o.getString("duration"),
                                        o.getString("day"),
                                        o.getString("month"));
                                events.add(event);
                            }


                            recyclerViewAdapterEvent=new RecyclerViewAdapterEvent(ctx,events);
                            recyclerView.setAdapter(recyclerViewAdapterEvent);
                        } catch (JSONException e) {
                            e.printStackTrace();}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ctx, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(ctx).add(stringRequest);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    /*    c.add(new Course("Artificial Intelligence",R.drawable.course_icon));
        c.add(new Course("Software Engineering",R.drawable.course_icon));
        c.add(new Course("Semantic Web",R.drawable.course_icon));
        c.add(new Course("Software Process Management",R.drawable.course_icon));
        c.add(new Course("Software Security",R.drawable.course_icon));
        c.add(new Course("Web Engineering",R.drawable.course_icon));*/

    }

}
