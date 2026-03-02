package edu.masanz.da.cw.service;

import edu.masanz.da.cw.model.Jugador;
import edu.masanz.da.cw.model.Liga;
import edu.masanz.da.cw.model.Mesa;
import edu.masanz.da.cw.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LigaLogicService {

    private static final int MIN_JUGADORES = 2;
    private static final int MAX_JUGADORES = 20;
    private static final int MIN_ROUNDS = 2;
    private static final int MAX_ROUNDS = 6;

    //Verificado :)
    public boolean calculoPartidas(Liga liga) {
        try {
            if (liga == null || liga.getJugadoresApuntados() == null) {
                System.out.println("Liga o jugadoresApuntados null");
                return false;
            }

            int numJugadores = liga.getJugadoresApuntados().size();
            if (numJugadores < MIN_JUGADORES || numJugadores > MAX_JUGADORES) {
                System.out.println("Cantidad de jugadores fuera de rango");
                return false;
            }

            if(numJugadores % 2 == 1){
                System.out.println("Jugadores impares");
                return false;
            }

            int rounds = 0;
            if(numJugadores <= 2){
                rounds = MIN_ROUNDS;
            } else if (numJugadores == 4) {
                rounds = 2;
            } else if (numJugadores <= 8) {
                rounds = 3;
            } else if (numJugadores <= 16) {
                rounds = 4;
            } else {
                rounds = MAX_ROUNDS;
            }

            liga.setNumPartidas(rounds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void iniciarLiga(int id){
        Liga liga = new Liga(id);
    }

    //Pruebas
    public static void main(String[] args) {
        Liga liga = new Liga(1);
        Usuario user1 = new Usuario();
        Usuario user2 = new Usuario();
        Usuario user3 = new Usuario();
        Usuario user4 = new Usuario();
        Usuario user5 = new Usuario();
        Usuario user6 = new Usuario();

        Jugador jugador1 = new Jugador(user1);
        Jugador jugador2 = new Jugador(user2);
        Jugador jugador3 = new Jugador(user3);
        Jugador jugador4 = new Jugador(user4);
        Jugador jugador5 = new Jugador(user5);
        Jugador jugador6 = new Jugador(user6);

        liga.agregarJugador(jugador1);
        liga.agregarJugador(jugador2);
        liga.agregarJugador(jugador3);
        liga.agregarJugador(jugador4);
        liga.agregarJugador(jugador5);
        liga.agregarJugador(jugador6);

        LigaLogicService logicaService = new LigaLogicService();
        logicaService.calculoPartidas(liga);
        System.out.println(liga.getNumPartidas());
        int numJugadores = liga.getNumPartidas();
        PartidaLogicService partidaService = new PartidaLogicService();
//        partidaService.iniciarPartida(numJugadores);
        List<Mesa> mesa1 = new ArrayList<>();
        List<Mesa> mesa2 = new ArrayList<>();
        List<Mesa> mesa3 = new ArrayList<>();

    }



}
