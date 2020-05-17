package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {


    ImageView logo;
    EditText correo , password;
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
        correo = (EditText)findViewById(R.id.correo);
        password = (EditText)findViewById(R.id.password);
        EscucharBotones();


    }

    //Enviar valores es como mi loguear
    public void EnviarValores(View view){

        int x=0;
        int ctr=0;

        SharedPreferences pref = getSharedPreferences("Login", Context.MODE_PRIVATE);

        String userRegistrado = pref.getString("User","N/R");
        String passRegistrado = pref.getString("Pass","N/R");

        String correoLogin = correo.getText().toString();
        String passwordLogin = password.getText().toString();




        String paraAdmin = correoLogin+passwordLogin;

        try
        {
            BufferedReader fin = new BufferedReader( new InputStreamReader(
                openFileInput("login_int.txt")));
            String texto = fin.readLine();

            System.out.println("Esto es del archivo "+texto);
            System.out.println("Esto es del edittext: "+paraAdmin);

             x = paraAdmin.length();
            int y;
            boolean t;
             ctr=0;

           for( y = 0; y<=x; y++){
                if(paraAdmin.charAt(y)==texto.charAt(y)){
                    ctr++;
                    System.out.println("Aqui es cuando entra en mi primer if");
                    System.out.println(ctr);
                    System.out.println(x);
                }
            }





            fin.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
        }

        //Variables para comparar el login de administrador

        if((ctr == x) && (x !=0)){

            Intent i = new Intent(getApplicationContext(),PrincipalActivity.class);
            startActivity(i);
        }


<<<<<<< HEAD
=======


        if(userRegistrado.equals("N/R")){
            Toast.makeText(getApplicationContext(),"No existe un usuario registrado",Toast.LENGTH_LONG).show();


        }else{//Logica para logear
            if(userRegistrado.equals(correoLogin) && passRegistrado.equals(passwordLogin)){

                Toast.makeText(getApplicationContext(),"Encontrado",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),PrincipalActivity.class);
                startActivity(i);

            }else{
                Toast.makeText(getApplicationContext(),"No coinciden el usuario y la contraseña",Toast.LENGTH_LONG).show();
            }

        }




>>>>>>> 171d35728d29da3cb3171a1db8f7eae9ce9a4aa2
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
