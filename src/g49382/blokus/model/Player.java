/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

/**
 *
 * @author PaRaDoxe1070
 */
public class Player {
    private Deck stock;
    private int nbShape;
    private Paint color;
    private boolean stoped;

    /**
     * Create a new Player with the color eceived in parameter.
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
    }

    /**
     * Create a new Player
     */
    public Player() {
        this.stock = new Deck();
        this.nbShape = stock.getNbShape();
        this.color = null;
    }

    /**
     * Get the color of this player.
     * @return a Color.
     */
    public Paint getColor() {
        return color;
    }
    
    /**
     * Get the stock of this player.
     * @return a Stock
     */
    public Deck getStock() {
        return stock;
    }

    /**
     * Get the number of shapes in the stock of this player.
     * @return number of shapes remaining
     */
    public int getNbShape() {
        return nbShape;
    }
    
    /**
     * Set the number of shapes in the stock of this player to number received in parameter.
     */
    public void setNbShape(int nbShape) {
        this.nbShape = nbShape;
    }
    
    
    /**
     * She choose the shape to place in the plate.
     * @param  shape to place
     * @return the shape to place
     */
    public ShapeBlokus place(int numShape){
        ShapeBlokus shapechosen = this.stock.getShapes().get(numShape-1);
        this.stock.getShapes().set(numShape-1, null);
        this.nbShape--;
        return shapechosen;
    }

    @Override
    public String toString() {
        return "Player " +color+ ": "+ nbShape +" shapes "+ "Stock: " +'{' + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Player  && ((Player)obj).getColor() == this.color) {
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
        
    
        
        
        
    
    
    
}
