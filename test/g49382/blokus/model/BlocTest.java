/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;
import g49382.blokus.model.*;

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
public class BlocTest {
    
    
    

    /**
     * Test of isInside method, of class Bloc.
     */
    @Test
    public void testIsInsideTrue() {
        Point p = new Point(5,0);
        Bloc instance = new Bloc(5,0);
        boolean expResult = true;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsInsideFalse() {
        Point p = new Point(2,4);
        Bloc instance = new Bloc(14,20);
        boolean expResult = false;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
    }
    
}
