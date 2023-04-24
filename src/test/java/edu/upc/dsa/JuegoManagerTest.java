package edu.upc.dsa;

import edu.upc.dsa.models.Objecto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JuegoManagerTest {

    JuegoManager jm;
    @Before
    public void setUp() throws Exception {
        this.jm = JuegoManagerImpl.getInstance();

    }

    @After
    public void tearDown() {
    }
    @Test
    public void testAddObjecto() {
        jm.addOjectoEnTienda("pocima","una pócima de vida que incrementa la vida en 10 puntos y que tiene un coste de 15 dsaCoins",15);
    }

    @Test
    public void testAddUsuario() {
        jm.addUsuario("123","Clement","Gouilloud");
    }

    @Test
    public void testBuyObjecto() {
        jm.addUsuario("personne","Clem","Gouil");
        jm.addOjectoEnTienda("object","a object",10);
        jm.buyObjecto("object","personne");
    }

    @Test
    public void testCreateJuego() {
        jm.createJuego(2,2);
        Assert.assertEquals( jm.getEstadoJuego(),"INICIADO_EN_PREPARACIÓN");
        jm.addUsuario("personne","Clem","Gouil");
        jm.initiatePartida("personne");
    }



}
