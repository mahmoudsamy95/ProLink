package com.example.ea.prolink;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapterMaterial extends RecyclerView.Adapter<RecyclerViewAdapterMaterial.MaterialViewHolder> {
    private Context ctx;
    private List<Material> materialList;

    public RecyclerViewAdapterMaterial(Context ctx,List<Material> materialListt) {
        this.ctx = ctx;
        this.materialList = materialListt;
    }

    @Override
    public RecyclerViewAdapterMaterial.MaterialViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.item_material,null);
        return new MaterialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterMaterial.MaterialViewHolder holder,int position) {
        Material material = materialList.get(position);
        holder.material_name.setText(material.getName());


    }

    @Override
    public int getItemCount() {
        return materialList.size();
    }

    public class MaterialViewHolder extends RecyclerView.ViewHolder {
        TextView material_name;

        public MaterialViewHolder(View itemView) {
            super(itemView);
            material_name = itemView.findViewById(R.id.material_name);


        }
    }
}