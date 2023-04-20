package edu.upc.dsa;

import edu.upc.dsa.models.Objecto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TracksManagerTest {

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
        Assert.assertEquals(1, jm.sizeTienda());
    }

    @Test
    public void testAddUsuario() {
        jm.addUsuario("123","Clement","Gouilloud");
        Assert.assertEquals(1, jm.sizeUsarios());
    }




}
