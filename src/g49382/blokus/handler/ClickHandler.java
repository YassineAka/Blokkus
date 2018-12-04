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

/**
 *
 * @author g49382
 */
public class ClickHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        System.out.println("EVENT APA");
        if (event.getEventType() == event.MOUSE_PRESSED ) {
           // event.getSource()
        }

    }

}
