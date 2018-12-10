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
import java.util.Observable;
import java.util.Observer;
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
public class PlayerView implements Observer{
    private GridPane playerView;
    private VBox playerFullView;
    private ShapeHandler handler;
    private Game game;
    private Player player;
    
    /**
     * Create a Vbox and a gridPane with the informations of one players.
     * @param player
     */
    public PlayerView(Player player, Game game){
        this.game = (Game) game;
        this.game.addObserver(this);
        
        this.player = player;
        update((Game) game, null);
        this.handler = new ShapeHandler((Game) game);
        this.handlerClick = new ClickHandler();
        this.playerView = new GridPane();
        this.playerFullView = new VBox();
        this.playerView.setHgap(2);
        this.playerView.setVgap(2);
        
        
    }

    /**
     * Get the VBox with informations.
     * @return
     */
    public VBox getPlayerFullView() {
        return this.playerFullView;
    }

    @Override
    public void update(Observable o, Object arg) {
        int indice = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                ShapeView shapeView = new ShapeView(player.getStock().getShapes().get(indice));
                shapeView.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
//                shapeView.getGrid().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
                playerView.add(shapeView, j, i);
                
                indice++;
            }
        }
        Text infoPlayer = new Text("Player "+this.player.getColor().getNumPlayer()+"        Score             14                 Ok");
        this.playerFullView.getChildren().add(infoPlayer);
        this.playerFullView.getChildren().add(this.playerView);
        this.playerFullView.setStyle("-fx-border-color: black");
        
        
    }
    
}
