package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;


public class PrincipalActivity extends AppCompatActivity {

    TextView email, pass , user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        InicializarControles();
    }

    private void InicializarControles(){

        email = (TextView)findViewById(R.id.email);
        pass = (TextView)findViewById(R.id.pass);
        user = (TextView)findViewById(R.id.user);
    }

    public void Registro(View view){

        Intent i = new Intent(getApplicationContext(),RegistroActivity.class);
        startActivity(i);
    }




}
