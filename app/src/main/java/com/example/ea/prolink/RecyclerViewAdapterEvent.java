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

import java.util.List;


public class RecyclerViewAdapterEvent extends RecyclerView.Adapter<RecyclerViewAdapterEvent.MyViewHolder> {
    private Context mContext;
    private List<Event> mData;
    private Dialog myDialog;

    public RecyclerViewAdapterEvent(Context mContext, List<Event> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_events,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(view);

        vHolder.item_event.setOnClickListener(    new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext,CourseActivity.class));

            }

        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapterEvent.MyViewHolder holder,int position) {
        holder.event_name.setText(mData.get(position).getEvent_name());
        holder.event_place.setText(mData.get(position).getEvent_place());
        holder.event_desc.setText(mData.get(position).getEvent_desc());
        holder.event_duration.setText(mData.get(position).getEvent_duration());
        holder.event_day.setText(mData.get(position).getEvent_day());
        holder.event_month.setText(mData.get(position).getEvent_month());
        // holder.imageView.setImageResource(mData.get(position).getCourseIcon());




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item_event;
        private TextView event_name;
        private TextView event_desc;
        private TextView event_place;
        private TextView event_duration;
        private TextView event_day;
        private TextView event_month;
        public MyViewHolder(View itemView) {
            super(itemView);
            item_event = (LinearLayout)itemView.findViewById(R.id.event_item);
            event_name=itemView.findViewById(R.id.event_name);
            event_desc=itemView.findViewById(R.id.event_description);
            event_place=itemView.findViewById(R.id.event_place);
            event_duration=itemView.findViewById(R.id.event_duration);
            event_day=itemView.findViewById(R.id.event_day);
            event_month=itemView.findViewById(R.id.event_month);

            // imageView = (ImageView)itemView.findViewById(R.id.course_icon);
        }
    }
}
