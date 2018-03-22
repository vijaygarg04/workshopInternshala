package com.example.vijaygarg.workshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.vijaygarg.workshop.Database.DashBoardDatabase;
import com.example.vijaygarg.workshop.Database.WorkShopDataBase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WorkshopFragment extends Fragment {

    private int mColumnCount = 1;
    WorkShopDataBase workShopDataBase;
    String login;
    TinyDB tinyDB;
    Context context;
    DashBoardDatabase dashBoardDatabase;
    private OnListFragmentInteractionListener mListener;


    public WorkshopFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        workShopDataBase=new WorkShopDataBase(context);
         dashBoardDatabase=new DashBoardDatabase(context);
         tinyDB = new TinyDB(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        ArrayList<WorkShopModel> arr=workShopDataBase.getData();
        if(arr.size()==0){
            adddata();
            arr=workShopDataBase.getData();
        }
        login = tinyDB.getString("login");
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyWorkshopAdapter(context,arr, mListener,dashBoardDatabase));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void adddata() {
        workShopDataBase.insertdata("amazon",   "android development", "online marketting company",     "16/03/2018","online marketting");
        workShopDataBase.insertdata("flipcart", "android development", "online marketting company",     "15/03/2018","online marketting");
        workShopDataBase.insertdata("microsoft","android development", "software development company",  "13/03/2018","software development");
        workShopDataBase.insertdata("TCS",      "web development",     "software development company",  "10/03/2018","SERVICES");
        workShopDataBase.insertdata("Adobe",    "web development",     "software development company",  "07/03/2018","Content Writing");
        workShopDataBase.insertdata("Mozila",   "web development",     "software development company",  "09/03/2018","online marketting");
        workShopDataBase.insertdata("Lenskart", "android development", "online marketting company",     "28/02/2018","online marketting");
        workShopDataBase.insertdata("Hp",       "Content Writing",     "software development company",  "02/03/2018","online marketting");
        workShopDataBase.insertdata("DRDO",     "android development", "software development company",  "11/03/2018","online marketting");
        workShopDataBase.insertdata("Tata",     "web development",     "software development company",  "25/02/2018","online marketting");

//        workShopDataBase.insertdata("hi","hi","hi","10MARCH2018","We are an innovative startup in the area of hyperlocal home ");
//        workShopDataBase.insertdata("hi","hi","hi","22FEBRUARY2018","Zen Tech Lab is a startup, established in the United States of America with a vision ");
//        workShopDataBase.insertdata("hi","hi","hi","12MARCH2018"," doing business as Amazon is an American electronic ");
//        workShopDataBase.insertdata("hi","hi","GOLD BUSINESS","15MARCH2018","We provide services in software consultancy  software marketing  development of web application  and \n");

    }
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(WorkShopModel item);

    }
}
