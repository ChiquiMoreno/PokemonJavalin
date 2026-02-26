package edu.masanz.da.cw.service;

import edu.masanz.da.cw.model.Usuario;

import java.util.Map;

public class UsuarioService {

    private Map<String, Usuario> usuarios = Map.of(
            "alvaro", new Usuario("alvaro", "1234"),
            "urko", new Usuario("urko", "1234"),
            "chiqui", new Usuario("chiqui", "1234")
    );

    public Usuario autenticar(String idUser, String password) {
        Usuario user = usuarios.get(idUser.toLowerCase());
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}