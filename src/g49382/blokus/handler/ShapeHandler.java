/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.handler;

import g49382.blokus.model.Game;
import g49382.blokus.model.ShapeBlokus;
import g49382.blokus.view.ShapeView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author g49382
 */
public class ShapeHandler implements EventHandler<MouseEvent>{
    private Game game;
    
    public ShapeHandler(Game game) {
    this.game = game;
    }
    @Override
    public void handle(MouseEvent event) {
//        ShapeView grid = (ShapeView) event.getSource();
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED && event.getSource() instanceof ShapeView ) {
            game.setShapeChosen(((ShapeView)event.getSource()).getShapeChosen());
            System.out.println(game.getShapeChosen());
        }
        
    }
    
}
