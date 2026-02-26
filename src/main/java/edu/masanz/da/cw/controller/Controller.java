package edu.masanz.da.cw.controller;

import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class Controller {
    public static void torneos(@NotNull Context ctx) {
        ctx.render("/templates/torneos.ftl");
    }
}
