package com.example.bunnytoyshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id, name, purchase , cost, date;

    public MyAdapter(Context context, ArrayList id, ArrayList name, ArrayList purchase, ArrayList cost, ArrayList date) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.purchase = purchase;
        this.cost = cost;
        this.date = date;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.saleentry,parent,false);
        return new MyViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
        holder.purchase.setText(String.valueOf(purchase.get(position)));
        holder.cost.setText(String.valueOf(cost.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, name,purchase,cost,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tId);
            name = itemView.findViewById(R.id.tName);
            purchase = itemView.findViewById(R.id.tPurchase);
            cost = itemView.findViewById(R.id.tCost);
            date = itemView.findViewById(R.id.tdate);

        }
    }

}
