/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package g49382.blokus.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author PaRaDoxe1070
 */
public class Game extends Observable{
    private List<Player> players;
    private boolean isOver;
    private Player currentPlayer;
    private GamePlate plate;
    private ShapeBlokus shapeChosen;
    private List<Observer> observers;
    
    
    /**
     * Create a new game.
     */
    public Game()  {
        this.players = new ArrayList<Player>(4);
        this.players.add(new Player(Paint.BLUE));
        this.players.add(new Player(Paint.RED));
        this.players.add(new Player(Paint.GREEN));
        this.players.add(new Player(Paint.YELLOW));
        this.isOver = false;
        this.currentPlayer = this.players.get(0);
        this.plate = new GamePlate(20, 20);
        this.shapeChosen = null;
        this.observers = new ArrayList<>();
        
    }
    
    /**
     * Check if the attribute isOver is true that mean the game is over.
     * @return true if the game is over
     */
    public boolean isOver() {
        return isOver;
    }
    
    /**
     * Get the current player of this game.
     * @return
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
        
    }
    
    /**
     * Get the palte of this game.
     * @return the plate
     */
    public GamePlate getPlate() {
        return plate;
    }
    
    /**
     * Get the shape chosen of this game.
     * @return shapeChosen
     */
    public ShapeBlokus getShapeChosen() {
        return shapeChosen;
    }

    public void setShapeChosen(ShapeBlokus shapeChosen) {
        this.shapeChosen = shapeChosen;
        changed();
    }
    
    
    /**
     *Get the players of this game.
     * @return players
     */
    public List<Player> getPlayers() {
        return players;
    }
    
    public void changed(){
        setChanged();
        notifyObservers();
    }
    
    /**
     * Get the winner of the game. She check if it exist a player with no more shapes.
     * @return Player
     */
    public Player getWinner(){
        for (Player player : players) {
            if (player.getNbShape() == 0) {
                this.isOver=true;
                return player;
            }
        }
        return null;
        
    }
    
    /**
     * She place the shape in the plate at the numShape position at the position received in paramater.
     * @param position of the shape chosen in the deck.
     * @param x.
     * @param y.
     */
    public void play(int numShape, double x,double y){
        shapeChosen = this.currentPlayer.place(numShape);
        if (shapeChosen != null ) {
            for (Bloc b : shapeChosen.getShape()) {
            b.getP().setX(b.getP().getX() + x );
            b.getP().setY(b.getP().getY() + y );
            }
            this.plate.addShape(shapeChosen);
            this.nextPlayer();
        }else{
            System.out.println(" You already placed this shape");
        }
        this.shapeChosen = null;
        changed();
        
    }

    /**
     * She passes a turn.
     */
    public void nextPlayer(){
        // APA : Un numéro est un modulo aurait été plus élégant
        switch (this.currentPlayer.getColor()) {
            case BLUE: this.currentPlayer = this.players.get(1);
            break;
            case RED: this.currentPlayer = this.players.get(2);
            break;
            case GREEN: this.currentPlayer = this.players.get(3);
            break;
            default:
                this.currentPlayer = this.players.get(0);
        }
        changed();
    }

    /**
     * She paint the plate of the game.
     * @return a StringBuffer with the shapes placed on the plate.
     */
    public StringBuffer paint() {
        StringBuffer aff = new StringBuffer();
        for(int i=0 ; i<this.plate.getHeight(); i++){
            for(int j=0 ; j<=this.plate.getWidth(); j++){
                Point p = new Point(j, i);
                if(this.plate.getShapeAt(p)!= null){
                    ShapeBlokus s = this.plate.getShapeAt(p);
                    aff.append(s.getColor().getC()+" ");
                }else{
                    aff.append(". ");
                }
            }
            aff.append("\n");
        }
        return aff ;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this, null);
        }
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        if (this.observers.contains(o)) {
            this.observers.remove(o);
        }
    }

    @Override
    public synchronized void addObserver(Observer o) {
        if (!this.observers.contains(o)) {
            this.observers.add(o);
        }
    }
    
    
}
