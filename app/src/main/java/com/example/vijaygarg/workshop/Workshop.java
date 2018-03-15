package com.example.vijaygarg.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vijaygarg.workshop.Database.DashBoardDatabase;
import com.example.vijaygarg.workshop.Database.WorkShopDataBase;

import java.util.ArrayList;

public class Workshop extends AppCompatActivity {
    RecyclerView rv;
    WorkShopDataBase workShopDataBase;
    String login;
    Button dashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        login=b.getString("login");
        rv=findViewById(R.id.rv);
        dashboard=findViewById(R.id.btndashboard);
        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Workshop.this,DashBoard.class);
                i.putExtra("login",login);
                startActivity(i);
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(this));

        workShopDataBase=new WorkShopDataBase(this);
        ArrayList<WorkShopModel>arr=workShopDataBase.getData();


        DashBoardDatabase dashBoardDatabase=new DashBoardDatabase(this);
        MyAdapter myAdapter=new MyAdapter(arr,this,login,dashBoardDatabase,login);

        rv.setAdapter(myAdapter);

    }

    private void adddata() {
        workShopDataBase.insertdata("amazon",   "android development", "online marketting",     "16/03/2018","online marketting");
        workShopDataBase.insertdata("flipcart", "android development", "online marketting",     "15/03/2018","online marketting");
        workShopDataBase.insertdata("microsoft","android development", "software development",  "13/03/2018","software development");
        workShopDataBase.insertdata("TCS",      "web development",     "software development",  "10/03/2018","SERVICES");
        workShopDataBase.insertdata("Adobe",    "web development",     "software development",  "07/03/2018","Content Writing");
        workShopDataBase.insertdata("Mozila",   "web development",     "software development",  "09/03/2018","online marketting");
        workShopDataBase.insertdata("Lenskart", "android development", "online marketting",     "28/02/2018","online marketting");
        workShopDataBase.insertdata("Hp",       "Content Writing",     "software development",  "02/03/2018","online marketting");
        workShopDataBase.insertdata("DRDO",     "android development", "software development",  "11/03/2018","online marketting");
        workShopDataBase.insertdata("Tata",     "web development",     "software development",  "25/02/2018","online marketting");

//        workShopDataBase.insertdata("hi","hi","hi","10MARCH2018","We are an innovative startup in the area of hyperlocal home ");
//        workShopDataBase.insertdata("hi","hi","hi","22FEBRUARY2018","Zen Tech Lab is a startup, established in the United States of America with a vision ");
//        workShopDataBase.insertdata("hi","hi","hi","12MARCH2018"," doing business as Amazon is an American electronic ");
//        workShopDataBase.insertdata("hi","hi","GOLD BUSINESS","15MARCH2018","We provide services in software consultancy  software marketing  development of web application  and \n");

    }
}
