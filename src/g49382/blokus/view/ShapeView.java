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
public class ShapeView {
    private GridPane grid;

    public ShapeView(ShapeBlokus shape) {
        this.grid = new GridPane();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Point p = new Point(j, i);
                Rectangle square = new Rectangle(10, 10);
                if (shape.isInside(p)){
                    square.setFill(Color.valueOf(shape.getColor().getAscii()));
                    
                }
                else{
                    square.setFill(Color.WHITE);
                }
                grid.add(square, i, j);
            }
        }
    }

    public GridPane getGrid() {
        return grid;
    }
    
    
}
