/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.model.Paint;
import g49382.blokus.model.*;
import g49382.blokus.model.ShapeBlokus;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author PaRaDoxe1070
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Game game = new Game();
        game.play(10, 11, 11);
        game.play(17, 8, 6);
        game.play(5, 2, 2);
        game.play(21, 9, 16);
        Menu Items1 = new Menu("File");
        Menu Items2 = new Menu("Edit");
        Menu Items3 = new Menu("Help");
        MenuBar menu = new MenuBar(Items1, Items2, Items3);
        HBox option = new HBox();
        option.setSpacing(4);
        option.setAlignment(Pos.CENTER);
        Button newGame = new Button("New Game");
        Button toPass = new Button("I passe");
        Button toStop = new Button("I stop");
        Button toTurn = new Button("I turn");
        option.getChildren().addAll(newGame,toPass,toStop,toTurn);
        AllPlayers allPlayers = new AllPlayers(game);
        GamePlateView gamePlate = new GamePlateView(game);
        root.setTop(menu);
        root.setLeft(allPlayers.getAllPlayers());
        root.setRight(gamePlate.getGrid());
        root.setBottom(option);
        Scene scene = new Scene(root, 1000, 750);
        primaryStage.setTitle("Blokus !");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
