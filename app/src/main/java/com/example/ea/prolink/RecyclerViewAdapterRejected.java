package com.example.ea.prolink;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



import java.util.List;

/**
 * Created by ea on 7/7/2018.
 */

public class RecyclerViewAdapterRejected  extends RecyclerView.Adapter<RecyclerViewAdapterRejected.MyViewHolder> {
    Context mContext;
    List<Appointment> mData;

    public RecyclerViewAdapterRejected(Context mContext, List<Appointment> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_accepted_appointment,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(view);


        vHolder.item_appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext,"Test Click" + String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }

        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_instructorName.setText(mData.get(position).getInstructor_id());
        holder.tv_appointmentDate.setText(mData.get(position).getDate());
        holder.cv_accepted_appointment.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item_appointments;
        private CardView cv_accepted_appointment;
        private TextView tv_instructorName;
        private TextView tv_appointmentDate;
        public MyViewHolder(View itemView) {
            super(itemView);
            item_appointments = (LinearLayout)itemView.findViewById(R.id.appointment_item);
            cv_accepted_appointment = (CardView)itemView.findViewById(R.id.cv_accepted_appointment);
            tv_instructorName = (TextView)itemView.findViewById(R.id.tv_InstructorName);
            tv_appointmentDate = (TextView)itemView.findViewById(R.id.tv_AppointmentDate);


        }
    }
}
