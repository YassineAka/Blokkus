/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.model.Player;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author PaRaDoxe1070
 */
public class PlayerView {
    private GridPane playerView;
    private VBox playerFullView;
    
    public PlayerView(Player player){
        int indice = 0;
        this.playerView = new GridPane();
        this.playerFullView = new VBox();
        this.playerView.setHgap(2);
        this.playerView.setVgap(2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                ShapeView shapeView = new ShapeView(player.getStock().getShapes().get(indice));
                playerView.add(shapeView.getGrid(), j, i);
                
                indice++;
            }
        }
        Text infoPlayer = new Text("Player "+player.getColor().getNumPlayer()+"        Score             14                 Ok");
        this.playerFullView.getChildren().add(infoPlayer);
        this.playerFullView.getChildren().add(this.playerView);
        this.playerFullView.setStyle("-fx-border-color: black");
        
        
    }

    public VBox getPlayerFullView() {
        return this.playerFullView;
    }
    
}
