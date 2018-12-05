/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import javafx.scene.layout.VBox;
import g49382.blokus.model.Game;
import g49382.blokus.model.Player;


public class AllPlayers {
    private VBox allPlayers;

    /**
     * Create a Vbox with the informations of all players.
     * @param game
     */
    public AllPlayers(Game game) {
        allPlayers = new VBox(4);
        for (Player player : game.getPlayers()) {
             allPlayers.getChildren().add((new PlayerView(player,game)).getPlayerFullView());
             
        }
        
    }

    /**
     * Get the vbox
     * @return a vbox
     */
    public VBox getAllPlayers() {
        return allPlayers;
    }
    
    
}
