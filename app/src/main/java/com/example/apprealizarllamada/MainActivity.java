package com.example.apprealizarllamada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtxtUsuario;
    EditText edtxtContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxtContraseña=findViewById(R.id.edtxtContraseña);
        edtxtUsuario=findViewById(R.id.edtxtUsuario);
    }

    //Crear cuenta
    public void onClick(View v)
    {
        Intent intentCrearCuenta=new Intent(this, CrearCuenta.class);
        startActivity(intentCrearCuenta);
    }

    //Ingresar a la cuenta
    public void onClick1(View v)
    {
        String icontraseña=edtxtContraseña.getText().toString();
        String iusuario=edtxtUsuario.getText().toString();

        if (icontraseña.equals("")||iusuario.equals(""))
        {
            Toast.makeText(this, "Error en los datos.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Iniciando sesión. \n Bienvenido", Toast.LENGTH_SHORT).show();
            Intent intentContacto=new Intent(this, RCViewContacto.class);
            startActivity(intentContacto);
        }

    }

}
