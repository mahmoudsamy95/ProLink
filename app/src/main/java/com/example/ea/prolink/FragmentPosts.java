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



public class FragmentPosts extends Fragment{
    private static final String URL_DATA="http://172.20.10.5/temp/prolink/public/api/apiControllers/v1/posts";
    View view;
    private RecyclerView recyclerView;
    private List<Post> p;
    RecyclerViewAdapterPost recyclerViewAdapterPost;
    Context ctx;

    public FragmentPosts() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.posts_fragment,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.postContentRV);
      //  final RecyclerViewAdapterPost recyclerViewAdapterPost = new RecyclerViewAdapterPost(getContext(),p);
        recyclerView.setAdapter(recyclerViewAdapterPost);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        p=new ArrayList<>();
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
                               // String date=o.getString("day")+o.getString("month");
                                Post post = new Post(
                                        o.getString("content"),
                                        o.getString("id"));
                                p.add(post);
                            }


                            recyclerViewAdapterPost=new RecyclerViewAdapterPost(ctx,p);
                            recyclerView.setAdapter(recyclerViewAdapterPost);
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
   //     p = new ArrayList<>();
      //  p.add(new Post("Dear 4th year students, Today's lecture is cancelled",R.drawable.profilepic,"Ahmed Saeed"));
      //  p.add(new Post("Assignment delivery postponed",R.drawable.pp,"Hager Sobeah"));
    }
}
