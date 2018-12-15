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

        }
        if (event.getButton() == MouseButton.SECONDARY) {
            game.turn();
        }

        if ((event.getEventType() == MouseEvent.MOUSE_EXITED) && (square.getFill() == Color.GRAY)) {
            plate.update1();
            game.changed();
        }

        if ((event.getEventType() == MouseEvent.MOUSE_PRESSED) && (event.getButton() == MouseButton.PRIMARY)) {
            try {
                game.play(game.getShapeChosen().getNumShape(), GridPane.getColumnIndex((Rectangle) event.getSource()),
                        GridPane.getRowIndex((Rectangle) event.getSource()));
                game.changed();

                for (ShapeBlokus shapeBlokus : game.getPlate().getShapePlaced()) {
                    System.out.println(shapeBlokus);
                }
            } catch (IllegalArgumentException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You have to place your first shape in a border !");
                alert.show();
            }
        }
        if (event.getEventType() == MouseEvent.MOUSE_EXITED && event.getSource() == ShapeView.class) {
            System.out.println("oueoueoue");
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
