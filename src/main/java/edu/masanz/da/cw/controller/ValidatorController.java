package edu.masanz.da.cw.controller;

import io.javalin.http.Context;

public class ValidatorController {

    public static void validateLogin(Context context) {
        System.out.println("Validando");

        String alias = context.sessionAttribute("alias");
        System.out.println("alias = " + alias);

        if (alias == null){
            context.redirect("/");
            System.out.println("Validacion fallida");
        }
        System.out.println("Validado");
    }

}
