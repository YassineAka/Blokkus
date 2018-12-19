/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PaRaDoxe1070
 */
public class Player {

    private Deck stock;
    private int nbShape;
    private Paint color;
    private boolean stoped;
    private int score;

    /**
     * Create a new Player with the color eceived in parameter.
     *
     * @param color
     */
    public Player(Paint color) {
        this.stock = new Deck();
        this.nbShape = stock.getNbShape();
        this.color = color;
        this.stoped = false;
        for (ShapeBlokus s : this.stock.getShapes()) {
            s.setColor(color);
        }
        this.score = 0;
    }

    /**
     * Create a new Player
     */
    public Player() {
        this.stock = new Deck();
        this.nbShape = stock.getNbShape();
        this.color = null;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    /**
     * Get the color of this player.
     *
     * @return a Color.
     */
    public Paint getColor() {
        return color;
    }

    /**
     * Get the stock of this player.
     *
     * @return a Stock
     */
    public Deck getStock() {
        return stock;
    }

    /**
     * Get the number of shapes in the stock of this player.
     *
     * @return number of shapes remaining
     */
    public int getNbShape() {
        return nbShape;
    }

    /**
     * Set the number of shapes in the stock of this player to number received
     * in parameter.
     */
    public void setNbShape(int nbShape) {
        this.nbShape = nbShape;
    }

    public void addScore(ShapeBlokus shape) {
        this.score += shape.getShape().size();
    }

    /**
     * She choose the shape to place in the plate.
     *
     * @param shape to place
     * @return the shape to place
     */
    public ShapeBlokus place(int numShape) {
        ShapeBlokus shapechosen = this.stock.getShapes().get(numShape - 1);
        this.stock.getShapes().set(numShape - 1, null);
        this.nbShape--;
        return shapechosen;
    }

    public ShapeBlokus placeIa(int numShape) {
        ShapeBlokus shapechosen = this.stock.getShapes().get(numShape - 1);
//        this.stock.getShapes().set(numShape-1, null);
//        this.nbShape--;
        return shapechosen;
    }

    @Override
    public String toString() {
        return "The player " + color + ".";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Player && ((Player) obj).getColor() == this.color) {
            return true;
        }
        return false;
    }

    public boolean isStoped() {
        return stoped;
    }

    public void Stop() {
        this.stoped = true;
    }

    public int shapesRemaining() {
        int shaperemaining = 0;
        for (ShapeBlokus shape : stock.getShapes()) {
            if (shape != null) {
                shaperemaining++;
            }
        }
        return shaperemaining;
    }

}
