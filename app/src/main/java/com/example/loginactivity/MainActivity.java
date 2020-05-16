package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ImageView logo;
    EditText correo , contraseña;
    Button iniciar,registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InicializarControles();


    }

    //metodo que se encarga de encontrar los controladores

    private void InicializarControles(){
        registrar = (Button)findViewById(R.id.resgistro);
        EscucharBotones();


    }
    private void EscucharBotones(){

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistroActivity.class));
            }
        });



    }
}
