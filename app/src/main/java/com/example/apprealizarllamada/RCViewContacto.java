package com.example.apprealizarllamada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RCViewContacto extends AppCompatActivity {
    ArrayList<Contacto> contactos;
    RecyclerView rcListaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcview_contacto);
        rcListaContactos=findViewById(R.id.rcListaContactos);
        LinearLayoutManager lim=new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        rcListaContactos.setLayoutManager(lim);
        InicializarContactos();
        iniciarAdaptador();
    }
    public void iniciarAdaptador(){
        ContactoAdaptador adaptador= new ContactoAdaptador(contactos, this);
        rcListaContactos.setAdapter(adaptador);
    }

    public  void  InicializarContactos(){
        contactos= new ArrayList<>();
        contactos.add(new Contacto("2 38 38 89 747", "perla@gmail.com", R.drawable.goku_power_2_by_saodvd_d9qdk73_239x300));
        contactos.add(new Contacto("55 54 42 78 44", "citla@gmail.com", R.drawable.homeropng_699505));
        contactos.add(new Contacto("55 49 33 05 52", "perla.citla@gmail.com", R.drawable.mariopng));

    }
}
