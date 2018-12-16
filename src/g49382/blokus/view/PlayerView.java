/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.handler.ShapeHandler;
import g49382.blokus.handler.SquareHandler;
import g49382.blokus.model.Game;
import g49382.blokus.model.Player;
import g49382.blokus.model.ShapeBlokus;
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
public class PlayerView implements Observer {

    private GridPane playerView;
    private VBox playerFullView;
    private ShapeHandler handler;
    private Game game;
    private Player player;

    /**
     * Create a Vbox and a gridPane with the informations of one players.
     *
     * @param player
     */
    public PlayerView(Observable game,Player player) {
        this.game = (Game) game;
        this.game.addObserver(this);
        this.player = player;
        this.playerView = new GridPane();
        this.playerFullView = new VBox();
        this.playerView.setHgap(2);
        this.playerView.setVgap(2);
        this.handler = new ShapeHandler((Game) game);
        update((Game) game, null);

    }
    public PlayerView(Observable game,Player player, boolean bool) {
        this.game = (Game) game;
        this.game.addObserver(this);
        this.player = player;
        this.playerView = new GridPane();
        this.playerFullView = new VBox();
        this.playerView.setHgap(2);
        this.playerView.setVgap(2);
        this.handler = new ShapeHandler((Game) game);
        update1();

    }

    /**
     * Get the VBox with informations.
     *
     * @return
     */
    public VBox getPlayerFullView() {
        return this.playerFullView;
    }

    public void update(Observable o, Object arg) {
        
        int indice = 0;
        this.playerView.getChildren().clear(); //= new GridPane();
        this.playerFullView.getChildren().clear();// = new VBox();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                ShapeBlokus shape = player.getStock().getShapes().get(indice);
                ShapeView shapeView = new ShapeView(shape);
                if (game.getCurrentPlayer().equals(player)) {
                    shapeView.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
                }
                playerView.add(shapeView, j, i);
                indice++;
            }
        }
        Text infoPlayer = new Text("Player " + this.player.getColor().getNumPlayer() + "      Score :     "+this.player.getScore());
        this.playerFullView.getChildren().add(infoPlayer);
        this.playerFullView.getChildren().add(this.playerView);
        this.playerFullView.setStyle("-fx-border-color: black");

    }
    public void update1() {
        int indice = 0;
        this.playerView.getChildren().clear(); //= new GridPane();
        this.playerFullView.getChildren().clear();// = new VBox();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                ShapeBlokus shape = player.getStock().getShapes().get(indice);
                if (player.getColor() == this.game.getCurrentPlayer().getColor()) {
                    ShapeView shapeView = new ShapeView(shape, true);
                    if (game.getCurrentPlayer().equals(player)) {
                        shapeView.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
                        playerView.add(shapeView, j, i);
                        indice++;
                    }
                
                }

            }
        }
        Text infoPlayer = new Text("Player " + this.player.getColor().getNumPlayer() + "     Score :     "+this.player.getScore());
        this.playerFullView.getChildren().add(infoPlayer);
        if (player.isStoped()) {
            this.playerFullView.setStyle("-fx-border-color: red");
        } else {
            this.playerFullView.setStyle("-fx-border-color: black");
        }
        this.playerFullView.getChildren().add(this.playerView);

    }

}
