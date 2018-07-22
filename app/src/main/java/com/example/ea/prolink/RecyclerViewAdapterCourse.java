package com.example.ea.prolink;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class RecyclerViewAdapterCourse extends RecyclerView.Adapter<RecyclerViewAdapterCourse.MyViewHolder>{


    private Context mContext;
    private List<Course> mData;
    private Dialog myDialog;
    String courseName;

    public RecyclerViewAdapterCourse(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_courses,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(view);

        vHolder.item_courses.setOnClickListener(    new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mContext.startActivity(new Intent(mContext,CourseActivity.class));

            }

        });
        return vHolder;
    }



    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv_courseName.setText(mData.get(position).getCourseName());
        final String course_id = mData.get(position).getCourseId();

        // holder.imageView.setImageResource(mData.get(position).getCourseIcon());

        holder.item_courses.setOnClickListener(    new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//        Toast.makeText(mContext, course_id,Toast.LENGTH_SHORT).show();
                Intent newActivity = new Intent(mContext, CourseActivity.class);
                newActivity.putExtra("courseID", course_id);
                mContext.startActivity(newActivity);
                //  mContext.startActivity(new Intent(mContext,CourseActivity.class));

            }

        });


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item_courses;
        private TextView tv_courseName;
        private ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            item_courses = (LinearLayout)itemView.findViewById(R.id.course_item);
            tv_courseName = (TextView)itemView.findViewById(R.id.course_name);
            // imageView = (ImageView)itemView.findViewById(R.id.course_icon);
        }
    }


    /*extends RecyclerView.Adapter<RecyclerViewAdapterCourse.MyViewHolder>{
    private Context mContext;
    private List<Course> mData;

    public RecyclerViewAdapterCourse(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.course_row_item,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_courseName.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_courseName;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv_courseName = itemView.findViewById(R.id.course_name);

        }
    }*/







}
