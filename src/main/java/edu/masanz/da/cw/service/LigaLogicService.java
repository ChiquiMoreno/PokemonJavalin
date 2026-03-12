package edu.masanz.da.cw.service;

import edu.masanz.da.cw.dao.LigaDaoDb;
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

    private static LigaDaoDb dao = new LigaDaoDb();


    /**
     * Nueva liga
     * @param nuevaLiga la nueva liga
     * @return id de la liga creada
     */
    public void nuevaLiga(Liga nuevaLiga){
        LigaDaoDb.nuevaLiga(nuevaLiga);
    }

    public static Liga getLiga(int idLiga) {
        return  dao.getLiga(idLiga);
    }


    public static Optional<Integer> getLigaEnCursoId() {
        return LigaDaoDb.getLigaEnCursoId();
    }

    public static boolean puedeIniciarLiga(int idLiga) {
        return !LigaDaoDb.existeLigaEnCursoExcluyendo(idLiga);
    }

    public static boolean iniciarLiga(int idLiga) {
        if (!puedeIniciarLiga(idLiga)) {
            return false;
        }
        return LigaDaoDb.actualizarEstadoLiga(idLiga, Liga.EN_CURSO);
    }

    public static boolean finalizarLiga(int idLiga) {
        return LigaDaoDb.actualizarEstadoLiga(idLiga, Liga.FINALIZADO);
    }

    public static void marcarLigaComoPendiente(int idLiga) {
        LigaDaoDb.actualizarEstadoLiga(idLiga, Liga.INCIAR);
    }

    public ArrayList<Liga> getAllLigas(){
        return (ArrayList<Liga>) ordenarLigas(dao.getAllLigas());
    }

    public List<Liga> ordenarLigas(List<Liga> liga){
        for (int i = 0; i < liga.size(); i++) {
            for (int j = i + 1; j < liga.size(); j++) {
                if(liga.get(i).getEstado() > liga.get(j).getEstado()){
                    Collections.swap(liga, i, j);
                }
            }
        }

        return liga;
    }

    public boolean crearJugadoresEnLiga(String idLiga, List<String> usuarios){
        //Crear alos jugadores
        if(LigaDaoDb.crearJugadores(idLiga, usuarios)){
            //Cambiar el estado de la liga
            LigaDaoDb.actualizarEstadoLiga(Integer.parseInt(idLiga), 0);
            return true;
        }
        return false;
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



    public void runLiga(int idliga) {
        //TODO: hacer update pasar liga en curso
        List<Jugador> jugadoresApuntados = LigaDaoDb.obtenerJugadoresLiga(idliga);
        //iniciarPartida(jugadoresApuntados)

    }

//    //region Pruebas
//    public static void main(String[] args) {
//        Liga liga = new Liga();
//        Usuario user1 = new Usuario();
//        Usuario user2 = new Usuario();
//        Usuario user3 = new Usuario();
//        Usuario user4 = new Usuario();
//        Usuario user5 = new Usuario();
//        Usuario user6 = new Usuario();
//        user1.setAlias("Paco");
//        user2.setAlias("Julian");
//        user3.setAlias("Urko");
//        user4.setAlias("Chiqui");
//        user5.setAlias("Andrés");
//        user6.setAlias("JJ");
//        System.out.println(user1.getAlias());
//        System.out.println(user2.getAlias());
//        System.out.println(user3.getAlias());
//        System.out.println(user4.getAlias());
//        System.out.println(user5.getAlias());
//        System.out.println(user6.getAlias());
//
//        System.out.println("-----------------------------");
//
//        Jugador jugador1 = new Jugador(user1);
//        Jugador jugador2 = new Jugador(user2);
//        Jugador jugador3 = new Jugador(user3);
//        Jugador jugador4 = new Jugador(user4);
//        Jugador jugador5 = new Jugador(user5);
//        Jugador jugador6 = new Jugador(user6);
//
//        liga.agregarJugador(jugador1);
//        liga.agregarJugador(jugador2);
//        liga.agregarJugador(jugador3);
//        liga.agregarJugador(jugador4);
//        liga.agregarJugador(jugador5);
//        liga.agregarJugador(jugador6);
//        System.out.println(liga.getJugadoresApuntados().size());
//
//        System.out.println(liga.getJugadoresApuntados().toString());
//        System.out.println("-----------------------------");
//
//        LigaLogicService logicaService = new LigaLogicService();
//
//        logicaService.calculoPartidas(liga);
//        System.out.println(liga.getNumPartidas());
//        int numPartidas = liga.getNumPartidas();
//        PartidaLogicService partidaService = new PartidaLogicService();
//        //inicio partida con el set que devuelve el liga get jugadores
//        System.out.println(liga.getJugadoresApuntados().toString());
//        System.out.println("-----------------------------");
//
//        partidaService.ordenarJugadores(liga.getJugadoresApuntados());
//        System.out.println(liga.getJugadoresApuntados().toString());
//
//
//    }
//    //endregion

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

    public void cambiarEstadoLiga(Liga liga){
        if(liga.getEstado() > 2){
            LigaDaoDb.updateEstadoLiga(liga.getIdLiga());
        }
        System.out.println("La liga excede");
    }

    public Collection<Usuario> listarUsuarios() {
        return productos.values();
    }

    public static int getNumMesa(Partida partida){
        return partida.getCantidadMesa();
    }

    public void eliminarLiga(String liga) {
        dao.eliminarLiga(liga);
    }

}
