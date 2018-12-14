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
import java.util.Observable;
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
public class GamePlateView implements Observer {

    private GridPane grid;
    private SquareHandler handler;
    private Game game;
    private ShapeBlokus shapeToPlace;

    /**
     * Create a gridPane who represents the plate of the game.
     *
     * @param game
     */
    public GamePlateView(Observable game) {
        this.game = (Game) game;
        this.game.addObserver(this);
        this.grid = new GridPane();
        this.shapeToPlace = ((Game) game).getShapeChosen();
        this.handler = new SquareHandler((Game) game, this);
        this.update((Game) game, null);
        
        }

    

    /**
     * Get the gridPane.
     *
     * @return a gridPane
     */
    public GridPane getGrid() {
        return grid;
    }

    public ShapeBlokus getShapeToPlace() {
        return shapeToPlace;
    }
    

    @Override
    public void update(java.util.Observable o, Object arg) {
        for (int i = 0; i < game.getPlate().getHeight(); i++) {
            for (int j = 0; j < game.getPlate().getWidth(); j++) {
                Point p = new Point(j, i);
                Rectangle square = new Rectangle(30, 30);
                square.addEventHandler(EventType.ROOT, new EventHandler<Event>() {
                    @Override
                    public void handle(Event event) {
                        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                            System.out.println(GridPane.getColumnIndex(square));
                            System.out.println(GridPane.getRowIndex(square));
                        }
                    }
                });

                square.addEventHandler(MouseEvent.MOUSE_ENTERED, this.handler);
                square.addEventHandler(MouseEvent.MOUSE_EXITED, this.handler);
                square.addEventHandler(MouseEvent.MOUSE_PRESSED, this.handler);

                if (game.getPlate().getShapeAt(p) != null) {
                    ShapeBlokus s = game.getPlate().getShapeAt(p);
                    square.setFill(Color.valueOf(s.getColor().getAscii()));
                    square.setStroke(Color.BLACK);

                } else {
                    square.setFill(Color.WHITE);
                    square.setStroke(Color.BLACK);
                }
                grid.add(square, j, i);
            }
        }
    }

    public void update1() {
        this.grid.getChildren().clear();
        for (int i = 0; i < game.getPlate().getHeight(); i++) {
            for (int j = 0; j < game.getPlate().getWidth(); j++) {
                Point p = new Point(j, i);
                Rectangle square = new Rectangle(30, 30);
                

                square.addEventHandler(MouseEvent.MOUSE_ENTERED, this.handler);
                square.addEventHandler(MouseEvent.MOUSE_EXITED, this.handler);
                square.addEventHandler(MouseEvent.MOUSE_PRESSED, this.handler);

                if (game.getPlate().getShapeAt(p) != null) {
                    ShapeBlokus s = game.getPlate().getShapeAt(p);
                    square.setFill(Color.valueOf(s.getColor().getAscii()));
                    square.setStroke(Color.BLACK);

                } else {
                    square.setFill(Color.WHITE);
                    square.setStroke(Color.BLACK);
                }
                grid.add(square, j, i);
            }
        }
    }

}
