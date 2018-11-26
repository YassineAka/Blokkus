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
import g49382.blokus.model.Player;
import javafx.scene.paint.Color;


public class SquareHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        Rectangle square = (Rectangle) event.getSource();
        if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
            if (square.getFill() == Color.WHITE){
                square.setFill(Color.GRAY);
            }
        }else if (event.getEventType() == MouseEvent.MOUSE_EXITED ){ 
            square.setFill(Color.WHITE);
        }
    }
}
