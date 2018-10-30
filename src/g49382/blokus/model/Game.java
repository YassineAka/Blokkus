/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PaRaDoxe1070
 */
public class Game {
    private List<Player> players;
    private boolean isOver;
    private Player currentPlayer;
    private GamePlate plate;
    private Shape shapeChosen;

    public Game() {
        this.players = new ArrayList(4);
        this.isOver = false;
        this.currentPlayer = this.players.get(0);
        this.plate = new GamePlate(100, 100);
        this.shapeChosen = null;
    }

    public List<Player> getPlayers() {
        return players;
    }
    
    public Player getWinner(){
        if (isGameOver()) {
            this.isOver = true;
            return this.currentPlayer;
        }
        return null;
    }
    
    public boolean isGameOver(){
        return this.currentPlayer.getStock().getShapes().isEmpty();
    }
    
    
    
    
     
    
    
}
