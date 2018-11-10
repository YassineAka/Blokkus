/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PaRaDoxe1070
 */
public class PlayerTest {
    

    /**
     * Test of place method, of class Player.
     */
    @Test
    public void testPlace() {
        int numShape = 21;
        Player player = new Player();
        ShapeBlokus expResult = player.getStock().getShapes().get(20);
        ShapeBlokus result = player.place(numShape);
        assertEquals(expResult, result);
    }
    @Test
    public void testPlace2() {
        int numShape = 21;
        Player player = new Player();
        ShapeBlokus expResult = null;
        player.place(numShape);
        assertEquals(expResult, player.getStock().getShapes().get(20));
    }
    
}
