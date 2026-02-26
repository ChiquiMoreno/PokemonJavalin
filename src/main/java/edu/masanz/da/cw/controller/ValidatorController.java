package edu.masanz.da.cw.controller;

import io.javalin.http.Context;

public class ValidatorController {

    public static void validateLogin(Context context) {
        System.out.println("Validando");

        String idUser = context.sessionAttribute("idUser");
        System.out.println("idUser = " + idUser);

        if (idUser == null){
            context.redirect("/");
            System.out.println("Validacion fallida");
        }
        System.out.println("Validado");
    }

}
