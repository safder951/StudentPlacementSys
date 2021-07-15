package com.example.studentplacementsys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class studentAdaptor extends RecyclerView.Adapter<studentAdaptor.ViewHolder> {
    private Context context;
    private List<Studentlist> StudentLists;

    public studentAdaptor(Context context, List<Studentlist> StudentLists) {
        this.context = context;
        this.StudentLists = StudentLists;
    }

    @Override
    public studentAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fetchstudentdetail,  null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(studentAdaptor.ViewHolder holder, int position) {
        Studentlist studentlist = StudentLists.get(position);
        holder.Stu_Name.setText(studentlist.getStudentName());
        holder.Stu_Skill.setText(studentlist.getStudentSkill());
        holder.Stu_Number.setText(studentlist.getStudentNumber());
        holder.Stu_Address.setText(studentlist.getStudentAddress());

    }

    @Override
    public int getItemCount() {
        return StudentLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Stu_Name, Stu_Skill, Stu_Number,Stu_Address;

        public ViewHolder(View itemView) {
            super(itemView);

            Stu_Name = itemView.findViewById(R.id.dbstudentname);
            Stu_Skill = itemView.findViewById(R.id.dbstudentskill);
            Stu_Number = itemView.findViewById(R.id.dbstudentnumber);
            Stu_Address = itemView.findViewById(R.id.dbstudentaddress);

        }
    }
}

