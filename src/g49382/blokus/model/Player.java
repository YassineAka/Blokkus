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
    private Color color;

    public Player(Color color) {
        this.stock = new Deck();
        this.nbShape = stock.getNbShape();
        this.color = color;
        for (Shape s : this.stock.getShapes()) {
            s.setColor(color);
        }
    }

    public Player() {
        this.stock = new Deck();
        this.nbShape = stock.getNbShape();
        this.color = null;
    }

    public Color getColor() {
        return color;
    }
    

    public Deck getStock() {
        return stock;
    }

    public int getNbShape() {
        return nbShape;
    }
    
    public Shape place(int numShape){
        Shape shapechosen = this.stock.getShapes().get(numShape-1);
        this.stock.getShapes().set(numShape-1, null);
        this.nbShape--;
        return shapechosen;
    }

    @Override
    public String toString() {
        return "Player " +color+ ": "+ nbShape +" shapes "+ "Stock: " +'{' +this.stock+ '}';
    }
    
    
}
