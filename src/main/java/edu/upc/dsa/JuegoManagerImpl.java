package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Objecto;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

public class JuegoManagerImpl implements JuegoManager {

    private static JuegoManager instance;
    protected List<Usuario> usuarios;
    protected List<Objecto> tienda;
    protected Juego juego;
    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);

    public static JuegoManager getInstance() {
        if (instance==null) instance = new JuegoManagerImpl();
        return instance;
    }
    private JuegoManagerImpl() {
        this.usuarios = new LinkedList<>();
        this.tienda = new LinkedList<>();
        this.juego = new Juego();
    }

    @Override
    public void createJuego(Integer N, Integer P) {
        if (juego.getEstado().equals("NO_INICIADO") | juego.getEstado().equals("FINALIZADO")){
            this.juego = new Juego(N,P);
            logger.info("Creation of the Game");
        } else{
            logger.info("The game is already running");
        }
    }

    @Override
    public Usuario addUsuario(String id, String nombre, String apellido) {
        Usuario u = new Usuario(id,nombre,apellido);
        logger.info("new usuario " + u);
        this.usuarios.add (u);
        logger.info("new user added to the sytem");
        return u;
    }

    @Override
    public Objecto addOjectoEnTienda(String id, String desc, Integer precio) {
        Objecto o = new Objecto(id,desc,precio);
        logger.info("new object " + o);
        this.tienda.add (o);
        logger.info("new object added to the tienda");
        return o;
    }

    @Override
    public void buyObjecto(String idObj, String idUsuario) {
        Usuario u = this.getUsuario(idUsuario);
        Objecto o = this.getObjecto(idObj);
        if (u.getSolda() >= o.getPrecio()){
            u.addObjecto(o);
            logger.info(u + "buy" + o + "in the shop");
        } else {
            logger.info("Usuario can not buy this objectos.It is too expensive, come back later !");
        }
    }

    @Override
    public void initiatePartida(String idUsuario) {

    }

    @Override
    public String getEstadoJuego() {
        return this.juego.getEstado();
    }

    @Override
    public void updateVida(String idUsuario, Integer cantidadVida) {
        if (this.juego.getEstado().equals("INICIADO_EN_FUNCIONAMIENTO")) {
            Usuario u = this.getUsuario(idUsuario);
            Integer vidaActual = u.getCantidadDeVida();
            u.setCantidadDeVida(vidaActual - cantidadVida);
            logger.info("Vida Update" + u);

            if (u.getCantidadDeVida() <= 0) {
                logger.info("The usuario :" + u + " is dead");
            }
        }else {
            logger.info("the juego is not working !!!");
        }
    }

    @Override
    public Integer getVidaUsuario(String idUsuario) {
        Usuario u = this.getUsuario(idUsuario);
        if (u.IsEnUnaPartida()){
            return u.getCantidadDeVida();
        }
        return null;
    }

    @Override
    public Integer getVidaEquipo(Integer numeroEquipo) {
        return null;
    }

    @Override
    public void endJuego() {
        juego.setEstado("FINALIZADO");
    }

    @Override
    public int sizeUsarios() {
        return this.usuarios.size();
    }

    @Override
    public int sizeTienda() {
        return this.tienda.size();
    }

    public Objecto getObjecto(String id) {
        logger.info("getObjecto("+id+")");

        for (Objecto t: this.tienda) {
            if (t.getId().equals(id)) {
                logger.info("getObjecto("+id+"): "+t);
                return t;
            }
        }
        logger.warn("not found " + id);
        return null;
    }

    public Usuario getUsuario(String id) {
        logger.info("getUsuario("+id+")");

        for (Usuario t: this.usuarios) {
            if (t.getId().equals(id)) {
                logger.info("getUsuario("+id+"): "+t);
                return t;
            }
        }
        logger.warn("not found " + id);
        return null;
    }
}