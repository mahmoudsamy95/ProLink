package com.example.ea.prolink.controllers;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ea.prolink.Material;
import com.example.ea.prolink.RecyclerViewAdapterMaterial;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahmoud on 7/6/2018.
 */

public class MaterialController {
    public ArrayList<Material> jsonParse(final Context context, String id){
        final ArrayList<Material> materialList;
        materialList= new ArrayList<>();
        String URL_DATA="http://197.164.219.142/server/server-2/prolink/public/api/apiControllers/v1/materials/"+id;

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
                            JSONObject object=new JSONObject(response);
                            JSONArray array=object.getJSONArray("data");
                            for(int i=0;i<array.length();i++) {
                                JSONObject o = array.getJSONObject(i);
                                Material material = new Material(
                                        o.getString("name"), o.getString("location"));
                                materialList.add(material);




                            }

                        } catch (JSONException e) {
                            e.printStackTrace();}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(context).add(stringRequest);
        return materialList;
    }
}
