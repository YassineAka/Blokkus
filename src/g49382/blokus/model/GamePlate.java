/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PaRaDoxe1070
 */
public class GamePlate {
    private List<Shape> shapePlaced;
    private int height;
    private int width;
    
    public GamePlate(int heigth, int width){
        shapePlaced = new LinkedList<>();
        this.height = heigth;
        this. width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    

    public List<Shape> getShapePlaced() {
        return shapePlaced;
    }
    public void addShape(Shape shape){
        this.shapePlaced.add(shape);
    }
    public Shape getShapeAt(Point p){
        for (Shape shape : shapePlaced) {
            return shape.isInside(p);
        }
        return null;
    }
}
