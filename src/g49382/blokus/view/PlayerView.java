/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.handler.ClickHandler;
import g49382.blokus.handler.ShapeHandler;
import g49382.blokus.handler.SquareHandler;
import g49382.blokus.model.Game;
import g49382.blokus.model.Player;
import javafx.scene.input.MouseEvent;
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
    private ShapeHandler handler;
    private ClickHandler handlerClick;
    private Game game;
    
    /**
     * Create a Vbox and a gridPane with the informations of one players.
     * @param player
     */
    public PlayerView(Player player, Game game){
        this.game = game;
        int indice = 0;
        this.handler = new ShapeHandler(game);
        this.handlerClick = new ClickHandler();
        this.playerView = new GridPane();
        this.playerFullView = new VBox();
        this.playerView.setHgap(2);
        this.playerView.setVgap(2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                ShapeView shapeView = new ShapeView(player.getStock().getShapes().get(indice));
                shapeView.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
//                shapeView.getGrid().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
                playerView.add(shapeView, j, i);
                
                indice++;
            }
        }
        Text infoPlayer = new Text("Player "+player.getColor().getNumPlayer()+"        Score             14                 Ok");
        this.playerFullView.getChildren().add(infoPlayer);
        this.playerFullView.getChildren().add(this.playerView);
        this.playerFullView.setStyle("-fx-border-color: black");
        
        
    }

    /**
     * Get the VBox with informations.
     * @return
     */
    public VBox getPlayerFullView() {
        return this.playerFullView;
    }
    
}
