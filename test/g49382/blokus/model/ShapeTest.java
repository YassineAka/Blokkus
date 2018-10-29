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
public class ShapeTest {
    
        /**
     * Test of the creation of a Shape
     */
    @Test
    public void testMain() {
        Shape carré = new Shape(new Bloc(),new Bloc(2,2),new Bloc(3,0));
        for (Bloc bloc : carré.getShape()) {
            System.out.println(bloc);
        }
        
    }
    
}
