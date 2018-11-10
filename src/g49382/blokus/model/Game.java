/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package g49382.blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PaRaDoxe1070
 */
public class Game {
    private List<Player> players;
    private boolean isOver;
    private Player currentPlayer;
    private GamePlate plate;
    private ShapeBlokus shapeChosen;
    private Point position;
    
    /**
     * Create a new game.
     */
    public Game() {
        this.players = new ArrayList<Player>(4);
        this.players.add(new Player(Paint.BLUE));
        this.players.add(new Player(Paint.RED));
        this.players.add(new Player(Paint.GREEN));
        this.players.add(new Player(Paint.YELLOW));
        this.isOver = false;
        this.currentPlayer = this.players.get(0);
        this.plate = new GamePlate(20, 20);
        this.shapeChosen = null;
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
    
    /**
     *Get the players of this game.
     * @return players
     */
    public List<Player> getPlayers() {
        return players;
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
        this.position = new Point(x, y);
        shapeChosen = this.currentPlayer.place(numShape);
        try {
            for (Bloc b : shapeChosen.getShape()) {
                b.getP().setX(b.getP().getX() + x );
                b.getP().setY(b.getP().getY() + y );
            }
        } 
        catch (NullPointerException e) {
            System.err.println("You already placed this shape ! ");
        }
        this.plate.addShape(shapeChosen);
        
        this.nextPlayer();
        
        
    }

    /**
     * She passes a turn.
     */
    public void nextPlayer(){
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
    
    
}
