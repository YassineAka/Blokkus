/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.model.Paint;
import g49382.blokus.model.*;
import g49382.blokus.model.ShapeBlokus;
import java.util.ConcurrentModificationException;
import java.util.Observable;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author PaRaDoxe1070
 */
public class FXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Observable game = new Game();
        Menu iTems1 = new Menu("File");
        Menu iTems2 = new Menu("Edit");
        Menu iTems3 = new Menu("Help");
        MenuBar menu = new MenuBar(iTems1, iTems2, iTems3);
        iTems2.getItems().addAll(new MenuItem("historical"));
        iTems2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                BorderPane historicalWindow = new BorderPane();
                HistoricalView historicalView = new HistoricalView(game);
                game.addObserver(historicalView);
                VBox historical =  historicalView.getHistorical();
                historicalWindow.setCenter(historical);
                
                Scene secondScene = new Scene(historicalWindow, 500, 500);
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Historical of shapes places");
                newWindow.setScene(secondScene);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 100);

                newWindow.show();
            }

        });
        HBox option = new HBox();
        option.setSpacing(4);
        option.setAlignment(Pos.CENTER);

        //button new game
        Button newGame = new Button("New Game");
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Game) game).newGame();
            }
        });

        //button pass
        Button toPass = new Button("I skip");
        toPass.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ((Game)game).getHistorical().add(new Text(((Game)game).getCurrentPlayer() +" skip his turn"));
                    ((Game) game).nextPlayer(((Game) game).passToNextPlayer());
                    ((Game) game).changed();
                } catch (ConcurrentModificationException e) {
                }
            }
        });

        //button stop
        Button toStop = new Button("I stop");
        toStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ((Game) game).getCurrentPlayer().Stop();
                    ((Game)game).getHistorical().add(new Text(((Game)game).getCurrentPlayer() +" stop to play"));
                    ((Game) game).nextPlayer(((Game) game).passToNextPlayer());
                    ((Game) game).setShapeChosen(null);
                    ((Game) game).changed();
                } catch (ConcurrentModificationException e) {
                }

            }
        });

        //button turn
        Button toTurn = new Button("I turn");
        toTurn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (((Game) game).getShapeChosen() != null) {
                    ((Game) game).turn();
                }
            }
        });

        //button return
        Button toReturn = new Button("I return");
        toReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (((Game) game).getShapeChosen() != null) {
                    ((Game) game).mirror();
                }
            }
        });

        //button IA
        Button IA = new Button("IA");
        IA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Game) game).playIA();
            }
        });
        option.getChildren().addAll(newGame, toPass, toStop, toTurn, toReturn, IA);
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
