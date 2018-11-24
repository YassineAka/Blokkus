/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.model.Game;
import g49382.blokus.model.Point;
import g49382.blokus.model.ShapeBlokus;
import java.util.Observer;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author PaRaDoxe1070
 */
public class GamePlateView implements Observer{
    private GridPane grid;

    /**
     * Create a gridPane who represents the plate of the game.
     * @param game
     */
    public GamePlateView(Game game) {
        this.grid = new GridPane();
        for (int i = 0; i < game.getPlate().getHeight(); i++) {
            for (int j = 0; j < game.getPlate().getWidth(); j++) {
                Point p = new Point(j, i);
                Rectangle square = new Rectangle(30, 30);
                if (game.getPlate().getShapeAt(p)!= null){
                    ShapeBlokus s = game.getPlate().getShapeAt(p);
                    square.setFill(Color.valueOf(s.getColor().getAscii()));
                    square.setStroke(Color.BLACK);
                    
                }
                else{
                    square.setFill(Color.WHITE);
                    square.setStroke(Color.BLACK);
                }
                grid.add(square, j, i);
            }
        }
    }

    /**
     * Get the gridPane.
     * @return a gridPane
     */
    public GridPane getGrid() {
        return grid;
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        
    }
    
    
    
}
