package com.example.vijaygarg.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.vijaygarg.workshop.R;

public class Details extends AppCompatActivity {
TextView tvcompany,tvdesc,tvdetails,tvprofile,tvdate,tvans1,tvans2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        putdata();
    }

    private void putdata() {
        Intent i=getIntent();
        Bundle b=i.getExtras();

        String comanyname=b.getString("companyname");
        String description=b.getString("description");
        String profile=b.getString("date");
        String date=b.getString("profile");
        String details=b.getString("details");
        String answer1=b.getString("ans1");
        String answer2=b.getString("ans2");
        tvcompany=findViewById(R.id.companyname);
        tvdesc=findViewById(R.id.description);
        tvdetails=findViewById(R.id.details);
        tvprofile=findViewById(R.id.profile);
        tvdate=findViewById(R.id.date);
        tvans1=findViewById(R.id.answer1);
        tvans2=findViewById(R.id.answer2);
        tvcompany.setText(comanyname);
        tvdesc.setText(description);
        tvprofile.setText(profile);
        tvdate.setText(date);
        tvdetails.setText(details);
        tvans1.setText(answer1);
        tvans2.setText(answer2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
