package com.example.ea.prolink;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ea on 6/26/2018.
 */

public class RecyclerViewAdapterAppointment extends RecyclerView.Adapter<RecyclerViewAdapterAppointment.AppointmentViewHolder>{
    private Context mCtx;
    private List<Appointment> appointmentList;

    public RecyclerViewAdapterAppointment(Context mCtx, List<Appointment> appointmentList) {
        this.mCtx = mCtx;
        this.appointmentList = appointmentList;
    }

    @Override
    public RecyclerViewAdapterAppointment.AppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.appointments_list, null);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterAppointment.AppointmentViewHolder holder, int position) {
        Appointment appointment=appointmentList.get(position);


        holder.tvStudentName.setText(appointment.getUser_id());
        holder.tvAppointmentDate.setText(appointment.getDate());
        holder.tvAppointmentTime.setText(appointment.getDate());

    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    public class AppointmentViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudentName,tvAppointmentDate,tvAppointmentTime;
        public AppointmentViewHolder(View itemView) {
            super(itemView);
     /*       tvStudentName=itemView.findViewById(R.id.tvStudentName);
            tvAppointmentDate=itemView.findViewById(R.id.tvAppointmentDate);
            tvAppointmentTime=itemView.findViewById(R.id.tvAppointmentTime);*/

        }
    }
}
