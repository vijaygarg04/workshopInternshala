package com.example.vijaygarg.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vijaygarg.workshop.Database.DashBoardDatabase;

public class QuestionAnswer extends AppCompatActivity {
EditText answer1,answer2;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);
        answer1=findViewById(R.id.answer1);
        answer2=findViewById(R.id.answer2);
        submit=findViewById(R.id.submit);
        Intent i=getIntent();
        Bundle b=i.getExtras();
       final DashBoardDatabase dashBoardDatabase=new DashBoardDatabase(this);
       final String scompanyname,sdescription,sdate,sprofile,susername,sdetails;
        scompanyname=b.getString("companyname");
        sdescription=b.getString("description");
        sdate=b.getString("profile");
        sprofile=b.getString("date");
        susername=b.getString("username");
        sdetails=b.getString("details");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sans1=answer1.getText().toString();
                String sans2=answer2.getText().toString();
                if(sans1.length()<10){
                    answer1.setError("Answer Should be of min 10 character");
                    return;
                }
                if(sans2.length()<10){
                    answer2.setError("Answer Should be of min 10 character");
                    return;
                }

                dashBoardDatabase.insertdata(scompanyname,sprofile,sdescription,sdate,susername,sans1,sans2,sdetails);
                Toast.makeText(QuestionAnswer.this,"Successfully Applied",Toast.LENGTH_LONG).show();
                Intent i=new Intent(QuestionAnswer.this,Workshop.class);
                i.putExtra("login",susername);
                startActivity(i);
            }
        });

    }
}
