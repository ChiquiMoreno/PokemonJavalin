package edu.masanz.da.cw;

import java.io.File;
import java.util.Locale;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;

import org.eclipse.jetty.server.session.DefaultSessionCache;
import org.eclipse.jetty.server.session.FileSessionDataStore;
import org.eclipse.jetty.server.session.SessionCache;
import org.eclipse.jetty.server.session.SessionHandler;

import edu.masanz.da.cw.controller.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        logger.info("ARRANCANDO APLICACION");

        Locale.setDefault(Locale.FRENCH);// Para las unidades de millar sin coma

        Javalin app1 = Javalin.create(config -> {
            config.jetty.modifyServletContextHandler(handler -> handler.setSessionHandler(fileSessionHandler("session1")));
            config.staticFiles.add("/public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(4444);

        setJavalinAppRoutes(app1);

    }

    private static void setJavalinAppRoutes(Javalin app) {

//        app.before("/{.+}", ValidatorController::validateLogin);


        app.get("/", AuthController::login);
        app.post("/autenticar", AuthController::procesarLogin);
        app.get("/logout", AuthController::logout);

        app.get("/torneos", Controller::torneos);
//        app.get("/add/{id}", CarritoController::agregarProducto);
//        app.get("/cart", CarritoController::verCarrito);
//        app.get("/clear", CarritoController::vaciarCarrito);
//
//        app.get("/cart/increment/{id}", CarritoController::incrementarProducto);
//        app.get("/cart/decrement/{id}", CarritoController::disminuirProducto);
//        app.get("/cart/remove/{id}", CarritoController::eliminarProducto);

    }

    public static SessionHandler fileSessionHandler(String sessionName) {
        SessionHandler sessionHandler = new SessionHandler();
        SessionCache sessionCache = new DefaultSessionCache(sessionHandler);
        sessionCache.setSessionDataStore(fileSessionDataStore());
        sessionHandler.setSessionCache(sessionCache);
        sessionHandler.setHttpOnly(true);
        // make additional changes to your SessionHandler here
        sessionHandler.setSessionCookie(sessionName);
        return sessionHandler;
    }

    private static FileSessionDataStore fileSessionDataStore() {
        FileSessionDataStore fileSessionDataStore = new FileSessionDataStore();
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        File storeDir = new File(baseDir, "javalin-session-store");
        //C:\Users\USUARIO\AppData\Local\Temp\javalin-session-store
        storeDir.mkdir();
        fileSessionDataStore.setStoreDir(storeDir);
        return fileSessionDataStore;
    }

}