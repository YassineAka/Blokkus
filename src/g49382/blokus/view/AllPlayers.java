/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import javafx.scene.layout.VBox;
import g49382.blokus.model.Game;
import g49382.blokus.model.Player;

/**
 *
 * @author PaRaDoxe1070
 */
public class AllPlayers {
    private VBox allPlayers;
    private Game game;

    public AllPlayers() {
        this.game = new Game();
        allPlayers = new VBox();
        for (Player player : this.game.getPlayers()) {
             allPlayers.getChildren().add((new PlayerView(player)).getPlayerView());
        }
    }

    public VBox getAllPlayers() {
        return allPlayers;
    }
    
    
}
