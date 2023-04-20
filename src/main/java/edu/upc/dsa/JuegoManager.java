package edu.upc.dsa;

import edu.upc.dsa.models.Objecto;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface JuegoManager {

    public void createJuego(Integer N, Integer P);

    public Usuario addUsuario(String id, String nombre, String apellido);

    public Objecto addOjectoEnTienda(String id, String desc, Integer precio);

    public void buyObjecto(String idObj,String idUsuario);

    public void initiatePartida(String idUsuario);

    public String getEstadoJuego();

    public void updateVida(String idUsuario,Integer cantidadVida);

    public Integer getVidaUsuario(String idUsuario);

    public Integer getVidaEquipo(Integer numeroEquipo);

    public void endJuego();



    public int sizeUsarios();

    public int sizeTienda();

}
