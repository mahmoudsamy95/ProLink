package com.example.ea.prolink;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class RecyclerViewAdapterPost extends RecyclerView.Adapter<RecyclerViewAdapterPost.MyViewHolder>{


    Context mContext;
    List<Post> mData;
    Dialog myDialog;

    public RecyclerViewAdapterPost(Context mContext, List<Post> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_posts,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(view);


        //Dialog ini
        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_post);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.item_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_name_tv=(TextView) myDialog.findViewById(R.id.dialog_name);
                TextView dialog_postContent_tv= (TextView)myDialog.findViewById(R.id.dialog_postContent);
                ImageView dialog_pp_img=(ImageView)myDialog.findViewById(R.id.dialog_pp);
               // dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_postContent_tv.setText(mData.get(vHolder.getAdapterPosition()).getContent());
              //  dialog_pp_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());

                Toast.makeText(mContext,"Test Click" + String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                myDialog.show();
            }

        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_postContent.setText(mData.get(position).getContent());
       // holder.imageView.setImageResource(mData.get(position).getPhoto());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item_posts;
        private TextView tv_postContent;
       // private ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            item_posts = (LinearLayout)itemView.findViewById(R.id.post_item);
            tv_postContent = (TextView)itemView.findViewById(R.id.post_content);
           // imageView = (ImageView)itemView.findViewById(R.id.profile_picture_image);
        }
    }

}
