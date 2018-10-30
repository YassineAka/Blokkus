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
    private char color;

    public Player(Color color) {
        this.stock = new Deck();
        this.nbShape = stock.getNbShape();
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
        return shapechosen;
    }
    
    
}
