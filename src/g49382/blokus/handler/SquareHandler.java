/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.handler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.VBox;
import g49382.blokus.model.Game;
import g49382.blokus.model.ShapeBlokus;
import g49382.blokus.model.Player;
import g49382.blokus.view.ShapeView;
import javafx.event.EventType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SquareHandler implements EventHandler<MouseEvent> {

    public Game game;
    public ShapeHandler handler;

    public SquareHandler(Game game) {
        this.game = game;
    }
    
    

    @Override
    public void handle(MouseEvent event) {
        Rectangle square = (Rectangle) event.getSource();
        if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
            if (square.getFill() == Color.WHITE) {
                square.setFill(Color.GRAY);
            }
        }
        if (event.getEventType() == MouseEvent.MOUSE_EXITED && square.getFill() == Color.GRAY) {
            square.setFill(Color.WHITE);
        }
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            if (!(game.getShapeChosen() == null)) {
                //game.notifyObservers();
            System.out.println(GridPane.getColumnIndex(square));
            game.play(game.getShapeChosen().getNumShape(), GridPane.getColumnIndex((Rectangle) event.getSource()),
                    GridPane.getRowIndex((Rectangle) event.getSource()));
            game.changed();
            
            }
            for (ShapeBlokus shapeBlokus : game.getPlate().getShapePlaced()) {
                System.out.println(shapeBlokus);
            }
        }
        if (event.getEventType() == MouseEvent.MOUSE_EXITED && event.getSource() == ShapeView.class) {
            System.out.println("oueoueoue");
        }

    }
}
