package edu.masanz.da.cw.controller;

import io.javalin.http.Context;

public class TestController {

    public static void prueba(Context ctx) {
            System.out.println("ENTREEEE");
            ctx.json("HOLA MECHE");
    }
    public static void otro(Context ctx){
        String viene = "";
    }

}
