package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ImageView logo;
    EditText correo , password;
    Button iniciar,registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correo = (EditText)findViewById(R.id.correo);
        password = (EditText)findViewById(R.id.password);

        this.InicializarControles();


    }

    //metodo que se encarga de encontrar los controladores

    private void InicializarControles(){
        registrar = (Button)findViewById(R.id.resgistro);
        EscucharBotones();


    }

    //Enviar valores es como mi loguear
    public void EnviarValores(View view){

        SharedPreferences pref = getSharedPreferences("Login", Context.MODE_PRIVATE);

        String userRegistrado = pref.getString("User","N/R");
        String passRegistrado = pref.getString("Pass","N/R");

        String correoLogin = correo.getText().toString();
        String passwordLogin = password.getText().toString();

        if(userRegistrado.equals("N/R")){
            Toast.makeText(getApplicationContext(),"No existe un usuario registrado",Toast.LENGTH_LONG).show();

            System.out.println(userRegistrado);
            System.out.println(correoLogin);
        }else{//Logica para logear
            if(userRegistrado.equals(correoLogin) && passRegistrado.equals(passwordLogin)){




                Toast.makeText(getApplicationContext(),"Encontrado",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),PrincipalActivity.class);
                startActivity(i);

            }else{
                Toast.makeText(getApplicationContext(),"No coinciden el usuario y la contraseña",Toast.LENGTH_LONG).show();
            }

        }


    }

    private void EscucharBotones(){

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PrincipalActivity.class));
            }
        });



    }
}
