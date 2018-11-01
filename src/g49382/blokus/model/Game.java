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
    private Shape shapeChosen;
    private Point position;

    public Game() {
        this.players = new ArrayList<Player>(4);
        this.players.add(new Player(Color.BLUE));
        this.players.add(new Player(Color.RED));
        this.players.add(new Player(Color.GREEN));
        this.players.add(new Player(Color.YELLOW));
        this.isOver = false;
        this.currentPlayer = this.players.get(0);
        this.plate = new GamePlate(70, 60);
        this.shapeChosen = null;
    }

    public boolean isIsOver() {
        return isOver;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GamePlate getPlate() {
        return plate;
    }

    public Shape getShapeChosen() {
        return shapeChosen;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public Player getWinner(){
        if (isGameOver()) {
            this.isOver = true;
            return this.currentPlayer;
        }
        return null;
    }
    
    public boolean isGameOver(){
        return this.currentPlayer.getStock().getShapes().isEmpty();
    }
    
    public void play(int numShape, double x,double y){
        this.position = new Point(x, y);
        shapeChosen = this.currentPlayer.place(numShape);
        for (Bloc b : shapeChosen.getShape()) {
            b.getP().setX(b.getP().getX() + x );
            b.getP().setY(b.getP().getY() + y );
        }
        this.plate.addShape(shapeChosen);
        
        this.nextPlayer();
        
        
    }
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
    public StringBuffer paint() {
        StringBuffer aff = new StringBuffer();
        for(int i=0 ; i<this.plate.getHeight(); i++){
            for(int j=0 ; j<=this.plate.getWidth(); j++){
                Point p = new Point(j, i);
                if(this.plate.getShapeAt(p)!= null){
                    Shape s = this.plate.getShapeAt(p);
                    aff.append(s.getColor().getC()+" ");
                }else{
                    aff.append(". ");
                }
            }
            aff.append("\n");
        }
        return aff ;
    }
//    public String paint() {
//        String aff= ""; 
//        for(int i=1 ; i<this.plate.getHeight(); i++){
//            for(int j=1 ; j<=this.plate.getWidth(); j++){
//                Point p = new Point(j, i);
//                if(this.plate.getShapeAt(p)!=null){
//                    aff = aff+ this.plate.getShapeAt(p).getColor().getC()+" ";
//                }else{
//                    aff = aff +". ";
//                }
//            }
//            aff= aff+ "\n";
//        }
//        return aff ;
//    }

    
    public static void main(String[] args) {
        Game game = new Game();
        game.play(18,4,3);
        game.play(20,8,3);
        game.play(2,16,5);
        game.play(13,18,15);
        game.play(6,7,7);
        game.play(9,5,19);
        System.out.println(game.getPlate().getShapePlaced() +"AND" );
        System.out.println(game.paint());
    }
    


    
    
     
    
    
}
