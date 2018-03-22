package com.example.vijaygarg.workshop;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vijaygarg.workshop.Database.WorkShopDataBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Workshop extends AppCompatActivity implements WorkshopFragment.OnListFragmentInteractionListener{
    RecyclerView rv;
    String login;
    Button dashboard;
    TinyDB tinyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        Intent i=getIntent();
        tinyDB = new TinyDB(Workshop.this);
        Bundle b=i.getExtras();
        login=b.getString("login");
        //TODO :
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
        tinyDB.putString("login",login);

        WorkshopFragment workshopFragment = new WorkshopFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.frame,workshopFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onListFragmentInteraction(WorkShopModel item) {

        if(!login.equals("false")){

            Intent i=new Intent(this,QuestionAnswer.class);
            String scompanyname,sdescription,sdate,sprofile,sdetails;
            scompanyname=item.getCompanyname().toString().trim();
            sdescription=item.getDescription().toString().trim();
            sdate=item.getDate().toString().trim();
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
            sdate=sdf.format(date).toString();
            sprofile=item.getProfile().toString().trim();
            sdetails=item.getDetails();
            i.putExtra("companyname",scompanyname);
            i.putExtra("description",sdescription);
            i.putExtra("profile",sprofile);
            i.putExtra("date",sdate);
            i.putExtra("username",login);
            i.putExtra("details",sdetails);
            startActivity(i);

            //                    dashBoardDatabase.insertdata(scompanyname,sprofile,sdescription,sdate,username);
//
//                    Toast.makeText(context,"Added successfully",Toast.LENGTH_LONG).show();

        }else{
            startActivity(new Intent(this,SignInActivity.class));

            Toast.makeText(this,"Sorry sign in to apply workshop",Toast.LENGTH_LONG).show();
        }
        finish();
    }


}
