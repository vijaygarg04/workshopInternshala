package com.example.vijaygarg.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vijaygarg.workshop.Database.DashBoardDatabase;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity {
    RecyclerView rv;
    DashBoardDatabase dashBoardDatabase;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        rv=findViewById(R.id.rv);
        dashBoardDatabase=new DashBoardDatabase(this);
        Intent i=getIntent();
        username=i.getExtras().getString("login");
        ArrayList<WorkShopModel>arr=dashBoardDatabase.getData(username);
        MyDashBoardAdapter myDashBoardAdapter=new MyDashBoardAdapter(arr,this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(myDashBoardAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
