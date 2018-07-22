package com.example.ea.prolink;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAdapterAssignment extends RecyclerView.Adapter<RecyclerViewAdapterAssignment.MyViewHolder> {
    private Context ctx;
    private List<Assignment> assignmentList;

    public RecyclerViewAdapterAssignment(Context ctx,List<Assignment> assignmentList){
        this.ctx = ctx;
        this.assignmentList=assignmentList;
    }
    @Override
    public RecyclerViewAdapterAssignment.MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.item_assignment,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterAssignment.MyViewHolder holder,int position) {
        Assignment assignment=assignmentList.get(position);
        holder.assignmentName.setText(assignment.getName());
        holder.assignmentDesc.setText(assignment.getDescription());
        holder.assignmentDeadline.setText(assignment.getDue());
    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView assignmentName,assignmentDesc,assignmentDeadline;
        public MyViewHolder(View itemView) {
            super(itemView);
            assignmentName=itemView.findViewById(R.id.assignment_title);
            assignmentDesc=itemView.findViewById(R.id.assignment_Desc);
            assignmentDeadline=itemView.findViewById(R.id.assignment_deadline);
        }
    }
}
