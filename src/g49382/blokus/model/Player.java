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

    public Player() {
        this.stock = new Deck();
        this.nbShape = stock.getNbShape();
    }
    
    
}
