/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.handler.SquareHandler;
import g49382.blokus.model.Game;
import g49382.blokus.model.Point;
import g49382.blokus.model.ShapeBlokus;
import java.util.Observer;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author PaRaDoxe1070
 */
public class GamePlateView implements Observer{
    private GridPane grid;
    private SquareHandler handler;
    private Game game;

    /**
     * Create a gridPane who represents the plate of the game.
     * @param game
     */
    public GamePlateView(Game game) {
        this.game = game;
        this.grid = new GridPane();
        this.handler = new SquareHandler();
        this.update(null, null);
        
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
        for (int i = 0; i < game.getPlate().getHeight(); i++) {
            for (int j = 0; j < game.getPlate().getWidth(); j++) {
                Point p = new Point(j, i);
                Rectangle square = new Rectangle(30, 30);
                square.addEventHandler(MouseEvent.MOUSE_ENTERED, this.handler);
                square.addEventHandler(MouseEvent.MOUSE_EXITED, this.handler);
                
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
    
    
    
}
