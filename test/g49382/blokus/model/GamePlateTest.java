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
public class GamePlateTest {
    
    /**
     * Test of addShape method, of class GamePlate.
     */
    @Test
    public void testAddShape() {
        ShapeBlokus shape = new ShapeBlokus(new Bloc(),new Bloc(), new Bloc());
        GamePlate instance = new GamePlate(0, 0);
        for (int i = 0; i < 3; i++) {
            instance.addShape(shape);
        }
        assertEquals(instance.getShapePlaced().size(), 3);
    }
    

    /**
     * Test of getShapeAt method, of class GamePlate.
     */
    @Test
    public void testGetShapeAtTrue() {
        GamePlate plate = new GamePlate(100, 100);
        Deck stock = new Deck();
        plate.getShapePlaced().add(stock.getShapes().get(4));//(0,0)/(0,1)/(0,2)
        Point p = new Point(0, 1);
        ShapeBlokus expResult = stock.getShapes().get(4);
        ShapeBlokus result = plate.getShapeAt(p);
        assertEquals(expResult, result);
    }
    /**
     * Test of getShapeAt method, of class GamePlate.
     */
    @Test
    public void testGetShapeAtFalse() {
        GamePlate plate = new GamePlate(100, 100);
        Deck stock = new Deck();
        plate.getShapePlaced().add(stock.getShapes().get(4));//(0,0)/(0,1)/(0,2)
        Point p = new Point(14, 1);
        ShapeBlokus expResult = null;
        ShapeBlokus result = plate.getShapeAt(p);
        assertEquals(expResult, result);
    }
    
}
