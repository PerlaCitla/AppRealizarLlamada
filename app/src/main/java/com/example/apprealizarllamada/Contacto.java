package com.example.apprealizarllamada;

public class Contacto {
    private String nombreContacto;
    private String telefono;
    private String correo;
    private int idFoto;

    public Contacto(String telefono, String correo, int idFoto) {
        this.telefono = telefono;
        this.correo = correo;
        this.idFoto = idFoto;
    }
    public int getIdFoto() { return idFoto;  }

    public void setIdFoto(int idFoto) { this.idFoto = idFoto;}



    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
