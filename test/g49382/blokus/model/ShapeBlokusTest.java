/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;
import g49382.blokus.model.*;

import java.util.List;
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
public class ShapeBlokusTest {

    /**
     * Test of isInside method, of class ShapeBlokus.
     */
    @Test
    public void testIsInsideTrue() {
        Point p = new Point(1,0);
        ShapeBlokus instance = new ShapeBlokus(new Bloc(),new Bloc(1,0),new Bloc(2,0));
        boolean expResult = true;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsInsideFalse() {
        Point p = new Point(1,1);
        ShapeBlokus instance = new ShapeBlokus(new Bloc(),new Bloc(1,0),new Bloc(2,0));
        boolean expResult = false;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
    }
    
}
