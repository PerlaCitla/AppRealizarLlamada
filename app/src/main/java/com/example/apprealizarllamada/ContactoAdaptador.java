package com.example.apprealizarllamada;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter <ContactoAdaptador.ContactoViewHoler> {

    ArrayList<Contacto> contactos;
    Activity activity;



    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity)
    {
        this.contactos=contactos;
        this.activity=activity;
    }

    @NonNull
    @Override
    public ContactoViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_contactos,viewGroup,false);
        return new ContactoViewHoler((v));
    }


    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHoler contactoViewHoler, int posicion) {
        final Contacto contacto= contactos.get(posicion);
        contactoViewHoler.txtv_correo.setText(contacto.getCorreo());
        contactoViewHoler.txtv_telefono.setText(contacto.getTelefono());
        contactoViewHoler.imgFoto.setImageResource(contacto.getIdFoto());

        contactoViewHoler.tlbContacto.inflateMenu(R.menu.menu_layout);

        contactoViewHoler.tlbContacto.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {


                    case R.id.miEditar:
                        Intent edtIntent = new Intent(activity,EditarContacto.class);
                        edtIntent.putExtra("Telefono", contacto.getTelefono());
                        edtIntent.putExtra("Correo",contacto.getCorreo());
                        activity.startActivity((edtIntent));
                        Toast.makeText(activity.getApplicationContext(), "Editando...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.miCompartir:
                        Toast.makeText(activity.getApplicationContext(), "Compartiendo...", Toast.LENGTH_SHORT).show();
                        break;


                }


                return false;
            }
        });

        contactoViewHoler.imgbTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telefono=contacto.getTelefono();
                if(ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    return;

                }
                activity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));
            }
        });
        contactoViewHoler.imgbCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo=contacto.getCorreo();
                if(ActivityCompat.checkSelfPermission(v.getContext(),Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                Intent mailIntent=new Intent(Intent.ACTION_SEND);
                mailIntent.setData(Uri.parse("malito:"));
                mailIntent.setType("text/plain");

                mailIntent.putExtra(Intent.EXTRA_EMAIL, correo);

                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mi mensaje de ocontacto." );

                mailIntent.putExtra(Intent.EXTRA_TEXT,"Este mensaje es enviado desde mi AppRealizarLlamadas ");

                try
                {
                    activity.startActivity(Intent.createChooser(mailIntent, "Enviar mensaje" )); //
                    activity.finish();
                    Log.i("Finaliza enviado", "Proceso de envio");
                }
                catch (ActivityNotFoundException ex)
                {
                    Toast.makeText(v.getContext(),R.string.string_correo_toast, Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    @Override
    public int getItemCount() {

        return contactos.size();
    }

    public static  class ContactoViewHoler extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView txtv_correo;
        private TextView txtv_telefono;
        private ImageButton imgbTelefono;
        private ImageButton imgbCorreo;
        private Toolbar tlbContacto;



        public ContactoViewHoler(@NonNull View itemView) {
            super(itemView);
            imgFoto =itemView.findViewById(R.id.imgFoto);
            txtv_telefono=itemView.findViewById(R.id.txtvTelefono);
            txtv_correo=itemView.findViewById(R.id.txtvCorreo);
            imgbTelefono=itemView.findViewById(R.id.imageTelefono);
            imgbCorreo=itemView.findViewById((R.id.imgbCorreo));
            tlbContacto=itemView.findViewById(R.id.tlbContacto);

        }
    }


}
