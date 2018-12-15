/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.strategy;

import g49382.blokus.model.Game;
import g49382.blokus.model.ShapeBlokus;

/**
 *
 * @author PaRaDoxe1070
 */
public class PlaceAShape implements Strategy{

    @Override
    public void doOperation(ShapeBlokus shape, int x, int y, Game game) {
        game.play(shape.getNumShape(), x, y);
    }
    
}
