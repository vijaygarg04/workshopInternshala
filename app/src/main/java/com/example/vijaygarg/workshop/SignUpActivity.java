package com.example.vijaygarg.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vijaygarg.workshop.Database.CredentialDatabase;

public class SignUpActivity extends AppCompatActivity {
CredentialDatabase credentialDatabase;
    EditText email,password,fname,lname;
    Button signup;
    TextView loginhere;
    ScrollView scrollView;
    TextView tnc;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        credentialDatabase=new CredentialDatabase(this);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        signup=findViewById(R.id.signup);
        loginhere=findViewById(R.id.loginhere);
        tnc=findViewById(R.id.tnc);
        scrollView=findViewById(R.id.sv);
        scrollView.setVisibility(View.GONE);
        tnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                scrollView.setVisibility(View.VISIBLE);
                }else{
                    scrollView.setVisibility(View.GONE);
                }
            }
        });


        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sfname,slname,semail,spass;
                sfname=fname.getText().toString().trim();
                slname=lname.getText().toString().trim();
                semail=email.getText().toString().trim();
                spass=password.getText().toString().trim();
                if(sfname.length()==0){
                    fname.setError("Enter First Name here");
                    return;
                }
                if(slname.length()==0){
                    lname.setError("Enter Last Name here");
                    return;
                }
                if(semail.length()==0){
                    fname.setError("Enter Email here");
                    return;
                }
                if(spass.length()==0){
                    fname.setError("Enter password here");
                    return;
                }

                boolean result=credentialDatabase.insertdata(sfname,slname,semail,spass);
                if(result==true){
                    Toast.makeText(SignUpActivity.this,"Account Created Successfully",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
                }else{
                    Toast.makeText(SignUpActivity.this,"Account Creation Failed",Toast.LENGTH_LONG).show();

                }
                finish();
            }
        });


    }
}
