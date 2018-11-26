/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package g49382.blokus.view;

import g49382.blokus.model.Paint;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import g49382.blokus.model.Game;
import g49382.blokus.model.Point;
import g49382.blokus.model.ShapeBlokus;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
/**
 *
 * @author PaRaDoxe1070
 */
public class ShapeView extends GridPane{
    private GridPane grid;
    private ShapeBlokus shapeChosen;
    
    /**
     * Create a Gridpane who represents a shape.
     * @param shape
     */
    public ShapeView(ShapeBlokus shape) {
        this.grid = new GridPane();
        this.shapeChosen = shape;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Point p = new Point(i, j);
                Rectangle square = new Rectangle(7.5, 7.5);
                if (shape != null && shape.isInside(p)){
                    square.setFill(Color.valueOf(shape.getColor().getAscii()));
                    square.setStroke(Color.BLACK);
                    
                }
                else{
                        square.setFill(Color.WHITE);
                        square.setStroke(Color.BLACK);
                        }
                grid.add(square, i, j);
            }
        }
    }

    public ShapeBlokus getShapeChosen() {
        return shapeChosen;
    }
    /**
     * Get a gridPane 5x5 for a shape.
     * @return a gridPane.
     */
    public GridPane getGrid() {
        return grid;
    }
    
    
}
