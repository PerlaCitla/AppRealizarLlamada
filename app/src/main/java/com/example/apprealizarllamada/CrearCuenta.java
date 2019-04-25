package com.example.apprealizarllamada;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearCuenta extends AppCompatActivity {

    EditText edtUsuario;
    EditText edtContraseña;
    ArrayList<Cuenta> cuentasContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        edtContraseña=findViewById(R.id.edtContraseña);
        edtUsuario=findViewById(R.id.edtUsuario);
        cargarPreferencias();

    }
    private  void cargarPreferencias()
    {
        SharedPreferences preferences=getSharedPreferences("credencial",Context.MODE_PRIVATE);
        //Extraer informacion del archivo XML
        String Usuario = preferences.getString("usario", "");
        String Contraseña=preferences.getString("Contrase","");
        edtUsuario.setText(Usuario);
        edtContraseña.setText(Contraseña);
    }



    public void onClick2(View v)
    {
        cuentasContactos= new ArrayList<>();

        String ccusuario= edtUsuario.getText().toString();
        String cccontraseña=edtContraseña.getText().toString();

        if(ccusuario.equals("") || cccontraseña.equals(""))
        {
           Toast.makeText(this, "Error \n Contraseña o/y usuario invalidos", Toast.LENGTH_SHORT).show();

        }
        else
        {
            cuentasContactos.add(new Cuenta(ccusuario,cccontraseña));

            if(cuentasContactos.size()<1)
            {
                for(int i=0; i<=cuentasContactos.size(); i++)
                {
                    String auxUsuario=cuentasContactos.get(i).getUsuario();

                    if (auxUsuario.equals(ccusuario))
                    {
                        Toast.makeText(this, "Usuario existente. \nRegistra otro", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this, "Cuenta registrada", Toast.LENGTH_SHORT).show();
                        guardarPreferencias();
                        finish();
                    }

                }
            }
            else
            {
                Toast.makeText(this, "Cuenta registrada", Toast.LENGTH_SHORT).show();
                guardarPreferencias();
                finish();

            }



        }
    
    }


    private void guardarPreferencias() {
        //Declarando objeto y crando archivos credencial en modo privado para la aploicacion
        SharedPreferences preferences= getSharedPreferences("credencial", Context.MODE_PRIVATE);
        //Extraer valor de los EditText respecticos
        String Usuario=edtUsuario.getText().toString();
        String Contraseña=edtContraseña.getText().toString();
        //editor objeto para editar el archivo XML
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("usuario", Usuario);
        editor.putString("contraseña", Contraseña);
        //Cierra la etiqueta de contenido
        editor.commit();
        Toast.makeText(this, "Datos guardados \n" + Usuario +"\n"+Contraseña, Toast.LENGTH_SHORT).show();
    }

    private void agregarUsuario()
    {

    }

}

