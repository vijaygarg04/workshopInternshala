package com.example.vijaygarg.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vijaygarg.workshop.Database.CredentialDatabase;

public class SignInActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    TextView signup,guest;
    CredentialDatabase credentialDatabase;
    TinyDB tinyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username=findViewById(R.id.userid);
        password=findViewById(R.id.signinpassword);
        login=findViewById(R.id.btnlogin);
        signup=findViewById(R.id.tvcreate);
        guest=findViewById(R.id.tvguest);
        tinyDB = new TinyDB(SignInActivity.this);

        credentialDatabase=new CredentialDatabase(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suname=username.getText().toString().trim();
                String spass=password.getText().toString().trim();
                password.setText("");
                if(suname.length()==0){
                    username.setError("Enter username ");
                 return;
                }
                if(spass.length()==0){
                    password.setError("Enter password");
                    return;
                }
                // todo
                boolean b=credentialDatabase.searchuser(suname,spass);
                if(b) {
                    Toast.makeText(SignInActivity.this,"LogIn Successfull",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignInActivity.this, Workshop.class);

                    i.putExtra("login",suname);
                    tinyDB.putString("login",suname);
                    startActivity(i);
                    finish();
                }else{

                    Toast.makeText(SignInActivity.this,"LogIn Failed",Toast.LENGTH_LONG).show();
                }
                username.setText("");

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
                finish();
            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignInActivity.this,Workshop.class);
                i.putExtra("login","false");
                tinyDB.putString("login","false");
                startActivity(i);

            }
        });
    }
}
