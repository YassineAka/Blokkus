/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.handler;

import g49382.blokus.model.Bloc;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.VBox;
import g49382.blokus.model.Game;
import g49382.blokus.model.ShapeBlokus;
import g49382.blokus.model.Player;
import g49382.blokus.model.Point;
import g49382.blokus.view.GamePlateView;
import g49382.blokus.view.ShapeView;
import java.util.ConcurrentModificationException;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javax.swing.SwingUtilities;

public class SquareHandler implements EventHandler<MouseEvent> {

    public Game game;
    public GamePlateView plate;
    public ShapeHandler handler;

    public SquareHandler(Game game, GamePlateView plate) {
        this.game = game;
        this.plate = plate;
    }

    @Override
    public void handle(MouseEvent event) {
        Rectangle square = (Rectangle) event.getSource();
        if ((game.getShapeChosen() != null) && (event.getEventType() == MouseEvent.MOUSE_ENTERED)) {
            try {
                if (square.getFill() == Color.WHITE) {
                ShapeBlokus shape = game.getShapeChosen();
                for (Bloc bloc : shape.getShape()) {
                    double x = GridPane.getColumnIndex(square);
                    double y = GridPane.getRowIndex(square);
                    try {
                        getNextSquare((x + bloc.getP().getX()), (y + bloc.getP().getY())).setFill(Color.GRAY);
                    } catch (NullPointerException e) {
                    }
                }
            }
            } catch (ConcurrentModificationException e) {
                
            }
            

        }
        if (event.getButton() == MouseButton.SECONDARY) {
            game.turn();
        }

        if ((event.getEventType() == MouseEvent.MOUSE_EXITED) && (square.getFill() == Color.GRAY)) {
            try {
                plate.update(((Game)game),null);
                game.changed();
            } catch (ConcurrentModificationException e) {
            }
        }

        if ((event.getEventType() == MouseEvent.MOUSE_PRESSED) && (event.getButton() == MouseButton.PRIMARY)) {
            //Point posRectangle = new Point(GridPane.getColumnIndex((Rectangle) event.getSource()), GridPane.getRowIndex((Rectangle) event.getSource()));
            try {
                try {
                if ((game.getShapeChosen() != null) ) {
                    game.play(game.getShapeChosen().getNumShape(), GridPane.getColumnIndex((Rectangle) event.getSource()),
                            GridPane.getRowIndex((Rectangle) event.getSource()));
                    game.changed();

                    for (ShapeBlokus shapeBlokus : game.getPlate().getShapePlaced()) {
                        System.out.println(shapeBlokus);
                    }
                } else {
                    System.out.println("c'est null");
                }
            } catch (IllegalArgumentException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Rules 1: You have to place your first shape in a corner of the plate ! \nRules 2 : You have to place your shapes on a corner of an other of your shapes placed and never on a side !");
                alert.show();
            }
            } catch (ConcurrentModificationException e) {
            }
        }

    }

    public Rectangle getNextSquare(double x, double y) {
        Rectangle square = null;
        for (Node node : plate.getGrid().getChildren()) {
            if (GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x) {
                square = (Rectangle) node;
            }

        }
        return square;
    }


}
