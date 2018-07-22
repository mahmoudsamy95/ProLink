package com.example.ea.prolink;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

import static android.content.Context.MODE_PRIVATE;


public class FragmentCourses extends Fragment {


    View view;
    private RecyclerView recyclerView;
    private List<Course> c;
    RecyclerViewAdapterCourse recyclerViewAdapterCourse;
    Context ctx;
    String courseName;
    public FragmentCourses() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.courses_fragment,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.courseContentRV);

       // recyclerViewAdapterCourse = new RecyclerViewAdapterCourse(getContext(),c);
        recyclerView.setAdapter(recyclerViewAdapterCourse);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        c=new ArrayList<>();
        ctx=getContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        String id=prefs.getString("userId","");
      //  Toast.makeText(ctx,id,Toast.LENGTH_SHORT).show();
        jsonParse(id);
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

    private void jsonParse(String id){
        String URL_DATA="http://172.20.10.5/temp/prolink/public/api/apiControllers/v1/students/1/courses";

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Toast.makeText(ctx,response,Toast.LENGTH_SHORT).show();
                            JSONObject object=new JSONObject(response);
                            JSONArray array=object.getJSONArray("data");
                            for(int i=0;i<array.length();i++) {
                                JSONObject o = array.getJSONObject(i);
                                Course course = new Course(
                                        o.getString("name"), o.getString("id"));
                                c.add(course);




                            }
                            recyclerViewAdapterCourse=new RecyclerViewAdapterCourse(ctx,c);
                            recyclerView.setAdapter(recyclerViewAdapterCourse);
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
    }


}
