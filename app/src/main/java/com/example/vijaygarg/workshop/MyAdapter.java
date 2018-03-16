package com.example.vijaygarg.workshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vijaygarg.workshop.Database.DashBoardDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vijaygarg on 13/03/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {
ArrayList<WorkShopModel> arr;
Context context;
String login;
DashBoardDatabase dashBoardDatabase;
String username;
    public MyAdapter(ArrayList<WorkShopModel> arr, Context context,String login,DashBoardDatabase dashBoardDatabase,String username) {
        this.arr = arr;
        this.context = context;
        this.login=login;
        this.dashBoardDatabase=dashBoardDatabase;
        this.username=username;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.view_workshop,parent,false);

        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewholder holder, final int position) {
        holder.companyname.setText(arr.get(position).getCompanyname());
        holder.description.setText(arr.get(position).getDescription());
        holder.date.setText(arr.get(position).getDate());
        holder.profile.setText(arr.get(position).getProfile());
        holder.apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
                if(!login.equals("false")){

                    Intent i=new Intent(context,QuestionAnswer.class);
                    String scompanyname,sdescription,sdate,sprofile,sdetails;
                    scompanyname=holder.companyname.getText().toString().trim();
                    sdescription=holder.description.getText().toString().trim();
                    sdate=holder.date.getText().toString().trim();
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
                    sdate=sdf.format(date).toString();
                    sprofile=holder.profile.getText().toString().trim();
                    sdetails=arr.get(position).getDetails();
                    i.putExtra("companyname",scompanyname);
                    i.putExtra("description",sdescription);
                    i.putExtra("profile",sprofile);
                    i.putExtra("date",sdate);
                    i.putExtra("username",username);
                    i.putExtra("details",sdetails);
                    context.startActivity(i);

                    //                    dashBoardDatabase.insertdata(scompanyname,sprofile,sdescription,sdate,username);
//
//                    Toast.makeText(context,"Added successfully",Toast.LENGTH_LONG).show();

                }else{
                    context.startActivity(new Intent(context,SignInActivity.class));

                    Toast.makeText(context,"Sorry sign in to apply workshop",Toast.LENGTH_LONG).show();
                }
                ((Activity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        TextView companyname,profile,description,date;
        Button apply;
        public MyViewholder(View itemView) {
            super(itemView);
            companyname=itemView.findViewById(R.id.companyname);
            profile=itemView.findViewById(R.id.profile);
            description=itemView.findViewById(R.id.shortdescription);
            date=itemView.findViewById(R.id.date);
            apply=itemView.findViewById(R.id.btnapply);


        }
    }
}
