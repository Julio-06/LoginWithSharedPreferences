package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {

    EditText correo, contraseña;
    Spinner tipoUsuario;
    Button guardar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        this.InicializarControles();
    }

    private void InicializarControles(){

        correo = (EditText)findViewById(R.id.correo);
        contraseña = (EditText)findViewById(R.id.contraseña);
        tipoUsuario = (Spinner)findViewById(R.id.opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,LoadSpinner());
        tipoUsuario.setAdapter(adapter);
        AttachEventToSpinner();
    }


    //Método para enviar valores.

    public void Guardar(View view){
        String nombre = correo.getText().toString();
        String pass = contraseña.getText().toString();
        String tipo = tipoUsuario.getSelectedItem().toString();


        if(tipo=="Administrador"){

        }
        else {
            SharedPreferences prefs = getSharedPreferences("Login", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("User", nombre);
            editor.putString("Pass", pass);
            editor.putString("Tipo", tipo);
            editor.commit();

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

        }
    }



    private void AttachEventToSpinner(){
        tipoUsuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                String operacion = adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(getApplicationContext(),"Operación seleccionada: "+operacion,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private List<String> LoadSpinner(){

        List<String> list = new ArrayList<String>();

        list.add("Administrador");
        list.add("Usuario");
        list.add("Registrador");

        return list;

    }
}
