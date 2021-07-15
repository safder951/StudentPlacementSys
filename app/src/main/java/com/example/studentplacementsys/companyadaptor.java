package com.example.studentplacementsys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class companyadaptor extends RecyclerView.Adapter<companyadaptor.ViewHolder> {
    private Context context;
    private List<Companylist> list;

    public companyadaptor(Context context, List<Companylist> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fetchcompany,  null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Companylist companylist = list.get(position);
        holder.companyname.setText(companylist.getCompanyName());
        holder.companydecsp.setText(companylist.getCompanyDescrption());
        holder.companyjobdescp.setText(companylist.getCompanyJobDescp());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView companyname, companydecsp, companyjobdescp;

        public ViewHolder(View itemView) {
            super(itemView);

            companyname = itemView.findViewById(R.id.dbname);
            companydecsp = itemView.findViewById(R.id.dbdescrption);
            companyjobdescp = itemView.findViewById(R.id.dbjobdescp);
        }
    }
}
