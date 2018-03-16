package com.example.vijaygarg.workshop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vijaygarg on 15/03/18.
 */

public class MyDashBoardAdapter extends RecyclerView.Adapter<MyDashBoardAdapter.MyViewholder>{
    ArrayList<WorkShopModel> arr;
    Context context;
    public MyDashBoardAdapter(ArrayList<WorkShopModel> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @Override
    public MyDashBoardAdapter.MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.view_dashboard,parent,false);

        return new MyDashBoardAdapter.MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(final MyDashBoardAdapter.MyViewholder holder, final int position) {
        holder.companyname.setText(arr.get(position).getCompanyname());
        holder.description.setText(arr.get(position).getDescription());
        holder.date.setText(arr.get(position).getDate());
        holder.profile.setText(arr.get(position).getProfile());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent i=new Intent(context,Details.class);
                i.putExtra("companyname",arr.get(position).getCompanyname());
                i.putExtra("description",arr.get(position).getDescription());
                i.putExtra("date",arr.get(position).getDate());
                i.putExtra("profile",arr.get(position).getProfile());
                i.putExtra("details",arr.get(position).getDetails());
                i.putExtra("ans1",arr.get(position).getAnswer1());
                i.putExtra("ans2",arr.get(position).getAnswer2());

                context.startActivity(i);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        TextView companyname,profile,description,date;
        View myview;

        public MyViewholder(View itemView) {
            super(itemView);
            myview=itemView;
            companyname=itemView.findViewById(R.id.dcompanyname);
            profile=itemView.findViewById(R.id.dprofile);
            description=itemView.findViewById(R.id.dshortdescription);
            date=itemView.findViewById(R.id.ddate);


        }
    }
}
