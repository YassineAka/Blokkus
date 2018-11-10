/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

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
public class GameTest {

    

    /**
     * Test of getWinner method, of class Game.
     */
    @Test
    public void testGetWinner() {
        Game game = new Game();
        Player expResult = game.getPlayers().get(0);
        expResult.setNbShape(0);
        Player result = game.getWinner();
        assertEquals(expResult, result);
    }


    /**
     * Test of nextPlayer method, of class Game.
     */
    @Test
    public void testNextPlayer() {
        Game game = new Game();
        Player expResult = game.getPlayers().get(3);
        game.nextPlayer();
        for (int i = 0; i < 3; i++) { 
            game.nextPlayer();
        }
        assertEquals(expResult, game.getPlayers().get(3));
        
    }

//    /**
//     * Test of paint method, of class Game.
//     */
//    @Test
//    public void testPaint() {
//        System.out.println("paint");
//        Game instance = new Game();
//        StringBuffer expResult = null;
//        StringBuffer result = instance.paint();
//        assertEquals(expResult, result);
//    }
//    /**
//     * Test of paint method, of class Game.
//     */
//    @Test
//    public void testPaint() {
//        Game game = new Game();
//        Game game2 = new Game();
//        game.play(18,4,3);
//        game.play(20,8,3);
//        game2.play(18,4,3);
//        game2.play(20,8,3);
////        System.out.println(game.getPlate().getShapePlaced());
////        System.out.println(game.paint());
//        
//        assertEquals(game.paint(), game2.paint());
//    }

    
    
}
