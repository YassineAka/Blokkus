/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

import java.util.LinkedList;
import java.util.List;
import javafx.beans.Observable;

/**
 *
 * @author PaRaDoxe1070
 */
public class GamePlate extends java.util.Observable{
    private List<ShapeBlokus> shapePlaced;
    private int height;
    private int width;
    
    /**
     * She Creates a new plate.
     * @param heigth
     * @param width
     */
    public GamePlate(int heigth, int width){
        super();
        shapePlaced = new LinkedList<>();
        this.height = heigth;
        this. width = width;
    }

    /**
     * Get the height of the plate.
     * @return the height of the plate
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get the width of the plate.
     * @return the width of the plate
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Check if it exists a shape a this position received in paramater.
     * @return a List with all the shapes placed.
     */
    public List<ShapeBlokus> getShapePlaced() {
        return shapePlaced;
    }

    /**
     * She add the shape received in paramter in the plate.
     * @param shape the place.
     */
    public void addShape(ShapeBlokus shape){
        this.shapePlaced.add(shape);
    }

    /**
     * She check if the Point received in parameter is part of this shape.
     * @param  Point (his position).
     * @return
     */
    public ShapeBlokus getShapeAt(Point p){
        for (ShapeBlokus shape : shapePlaced) {
            if (shape.isInside(p)){
                return shape;
            }
        }
        return null;
    }
}
