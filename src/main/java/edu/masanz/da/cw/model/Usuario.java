package edu.masanz.da.cw.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String alias;
    private String password;
    private String nombre;
    private String apellido;

    public Usuario(String alias, String password, String nombre, String apellido) {
        this.alias = alias;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario() {
        this("","","","");
    }

    public String getAlias() { return alias; }
    public String getPassword() { return password; }

    //region getter and setters

    public void setAlias(String alias) {
        this.alias = alias;
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