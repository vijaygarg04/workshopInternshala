package com.example.vijaygarg.workshop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.vijaygarg.workshop.Database.DashBoardDatabase;
import com.example.vijaygarg.workshop.WorkshopFragment.OnListFragmentInteractionListener;

import java.util.List;

public class MyWorkshopAdapter extends RecyclerView.Adapter<MyWorkshopAdapter.ViewHolder> {

    private final List<WorkShopModel> mValues;
    private final OnListFragmentInteractionListener mListener;
    Context context;

    DashBoardDatabase dashBoardDatabase;

    public MyWorkshopAdapter(Context context, List<WorkShopModel> items, OnListFragmentInteractionListener listener, DashBoardDatabase dashboard_database) {
        mValues = items;
        mListener = listener;
        this.context = context;
        this.dashBoardDatabase = dashboard_database;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_workshop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.companyname.setText(mValues.get(position).getCompanyname());
        holder.description.setText(mValues.get(position).getDescription());
        holder.date.setText(mValues.get(position).getDate());
        holder.profile.setText(mValues.get(position).getProfile());

        holder.apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(mValues.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView companyname, profile, description, date;
        WorkShopModel mItem;
        Button apply;

        public ViewHolder(View itemView) {
            super(itemView);
            companyname = itemView.findViewById(R.id.companyname);
            profile = itemView.findViewById(R.id.profile);
            description = itemView.findViewById(R.id.shortdescription);
            date = itemView.findViewById(R.id.date);
            apply = itemView.findViewById(R.id.btnapply);


        }

    }
}
