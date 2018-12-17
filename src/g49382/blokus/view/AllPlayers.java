/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import javafx.scene.layout.VBox;
import g49382.blokus.model.Game;
import g49382.blokus.model.Paint;
import g49382.blokus.model.Player;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class AllPlayers implements Observer{
    private Observable game;
    
    private VBox allPlayers;

    /**
     * Create a Vbox with the informations of all players.
     * @param game
     */
    public AllPlayers(Observable game) {
        allPlayers = new VBox(4);
        this.game = game;
        this.game.addObserver(this);
        this.update(game, null);
        
    }

    /**
     * Get the vbox
     * @return a vbox
     */
    public VBox getAllPlayers() {
        return allPlayers;
    }

    @Override
    public void update(Observable o, Object arg) {    
        ((Game)game).remainPlayers();
        
        this.allPlayers.getChildren().clear();
        for (Player player : ((Game)game).getPlayers()) {
             if (player.equals(((Game)game).getCurrentPlayer())) {
                allPlayers.getChildren().add((new PlayerView(((Game)game),player,true)).getPlayerFullView());
                
                
            }else{
                 allPlayers.getChildren().add((new PlayerView(((Game)game),player)).getPlayerFullView());
                 
             }
             
             
             
        }
        if (((Game)game).isOver()) {
            Player winner = ((Game)game).getWinner();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("The winner is the player "+winner.getColor()+"\nCONGRATULATION !!!!! .");
            alert.setHeaderText("THE GAME IS OVER !");
            alert.show();
        }


    }
    
    
    
}
