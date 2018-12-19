/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.model.Game;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author g49382
 */
public class HistoricalView implements Observer{
    private Game game;
    private VBox historical;
    
    public HistoricalView(Observable game){
        this.game = (Game) game;
        ((Observable)game).addObserver(this);
        this.historical = new VBox(5);
        this.update(game, null);
    }

    public VBox getHistorical() {
        return historical;
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
        for (Text text : this.game.getHistorical()) {
            this.historical.getChildren().add(text);
            System.out.println("appelé pour historical");
        }
        
    }

    @Override
    public String toString() {
        return "HistoricalView{" + "historical=" + historical + '}';
    }
    
    
    
    
}
