package edu.masanz.da.cw.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String idUser;
    private String password;
    private String nombre;
    private String apellido;

    public Usuario(String idUser, String password) {
        this.idUser = idUser;
        this.password = password;
    }

    public String getIdUser() { return idUser; }
    public String getPassword() { return password; }

    //region getter and setters

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //endregion
}