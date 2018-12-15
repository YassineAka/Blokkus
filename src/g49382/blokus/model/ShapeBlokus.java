/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author PaRaDoxe1070
 */
public class ShapeBlokus {
    private List<Bloc> shape;
    private int numShape;
    private char charColor;
    private Paint color = null;

    /**
     *
     * @param blocs
     */
    public ShapeBlokus(Bloc ...blocs) {
        this.shape = new LinkedList<Bloc>();
        for (Bloc bloc : blocs) {
            this.shape.add(bloc);
        }
    }

    /**
     * Get the color of this player.
     * @return a Color.
     */
    public Paint getColor() {
        return this.color ;
    }

    public int getNumShape() {
        return numShape;
    }
    

    /**
     * Set a new color to this shape.
     * @return a Color.
     */
    public void setColor(Paint color) {
        this.color = color;
    }

    /**
     * Get the charColor of this player.
     * @return a charColor.
     */
    public char getCharColor() {
        return charColor;
    }

    /**
     * Set a new charColor to this shape.
     * @return a charColor.
     */
    public void setCharColor(char charColor) {
        this.charColor = charColor;
    }
    
    /**
     * Return a List with all the block of this shape.
     * @return a List o blocks
     */
    public List<Bloc> getShape() {
        return shape;
    }

    public void setShape(List<Bloc> shape) {
        this.shape = shape;
    }
    

    /**
     * Set a new number of Shape.
     * @param numShape
     */
    public void setNumShape(int numShape) {
        this.numShape = numShape;
    }

    /**
     * Check if the point received in parameter is part of this shape.
     * @param p
     * @return
     */
    public Boolean isInside(Point p){
        for (Bloc b : shape) {
            if (b.isInside(p)) {
                return true;
            }
        }
        return false;
    }
    public Boolean placedWell(Bloc bloc){
        for (Bloc b : shape) {
            if (b.atLeastOneArete(bloc)) {
                return false;
            }else if(!b.isCoin(bloc)){
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString() {
        return "Shape n°"+ numShape+"{" + shape ;
    } 

    
    
    
    
}
