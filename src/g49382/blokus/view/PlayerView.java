/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.model.Player;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author PaRaDoxe1070
 */
public class PlayerView {
    private GridPane playerView;
    
    public PlayerView(Player player){
        int indice = 0;
        playerView = new GridPane();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                ShapeView shapeView = new ShapeView(player.getStock().getShapes().get(indice));
                playerView.add(shapeView.getGrid(), i, j);
                indice++;
            }
        }
        
    }

    public GridPane getPlayerView() {
        return playerView;
    }
    
}
