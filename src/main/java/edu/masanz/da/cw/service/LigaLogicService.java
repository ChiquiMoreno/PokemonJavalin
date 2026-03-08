package edu.masanz.da.cw.service;

import edu.masanz.da.cw.dao.TorneosDaoDb;
import edu.masanz.da.cw.model.Jugador;
import edu.masanz.da.cw.model.Liga;
import edu.masanz.da.cw.model.Partida;
import edu.masanz.da.cw.model.Usuario;

import java.util.*;

public class LigaLogicService {

    private static final int MIN_JUGADORES = 2;
    private static final int MAX_JUGADORES = 20;
    private static final int MIN_ROUNDS = 2;
    private static final int MAX_ROUNDS = 6;

    private static TorneosDaoDb dao = new TorneosDaoDb();

    // TODO
    public static Liga getLiga(int idLiga) {
        return  dao.getLiga(idLiga);
    }

    // TODO
    public static void comprobarCantidadLiga(int idLiga) {

    }

    public ArrayList<Liga> getAllLigas(){
        return dao.getAllLigas();
    }

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


    public void runLiga(int id, List<Jugador> jugadoresApuntados){
        Liga liga = new Liga(id);
        for (int i = 0; i < jugadoresApuntados.size(); i++) {
            liga.agregarJugador(jugadoresApuntados.get(i));

        }
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
        user1.setAlias("Paco");
        user2.setAlias("Julian");
        user3.setAlias("Urko");
        user4.setAlias("Chiqui");
        user5.setAlias("Andrés");
        user6.setAlias("JJ");
        System.out.println(user1.getAlias());
        System.out.println(user2.getAlias());
        System.out.println(user3.getAlias());
        System.out.println(user4.getAlias());
        System.out.println(user5.getAlias());
        System.out.println(user6.getAlias());

        System.out.println("-----------------------------");

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
        System.out.println(liga.getJugadoresApuntados().size());

        System.out.println(liga.getJugadoresApuntados().toString());
        System.out.println("-----------------------------");

        LigaLogicService logicaService = new LigaLogicService();

        logicaService.calculoPartidas(liga);
        System.out.println(liga.getNumPartidas());
        int numPartidas = liga.getNumPartidas();
        PartidaLogicService partidaService = new PartidaLogicService();
        //inicio partida con el set que devuelve el liga get jugadores
        System.out.println(liga.getJugadoresApuntados().toString());
        System.out.println("-----------------------------");

        partidaService.ordenarJugadores(liga.getJugadoresApuntados());
        System.out.println(liga.getJugadoresApuntados().toString());


    }

    public Map<Integer, String> crearPodio(List<Jugador> jugadoresOrdenados){
       Map<Integer, String> podio = new HashMap<>();
        for (int i = 0; i < jugadoresOrdenados.size() - 1; i++) {
            podio.put(i,jugadoresOrdenados.get(i).getAliasJugador());
        }
        return podio;
    }

    private Map<Integer, Usuario> productos = Map.of(
            //TODO
    );

    public Collection<Usuario> listarUsuarios() {
        return productos.values();
    }
}
