/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package g49382.blokus.viewConsole;

import g49382.blokus.model.*;
import java.util.Scanner;

/**
 *
 * @author PaRaDoxe1070
 */
public class ViewConsole {
    private Game game ;
    private Scanner sc ;
    
    public ViewConsole() {
        game = new Game();
        sc = new Scanner(System.in);
    }
    public void start(){
        while (!this.game.isOver()){
            System.out.println("What do you wanna do ?(show/stock/play)");
            String requete = sc.nextLine();
            String[] tabS = requete.split(" ", 4);
            try {
                if (tabS[0].equalsIgnoreCase("show")) {
                    System.out.println(this.game.paint());
                } else if (tabS[0].equalsIgnoreCase("stock")) {
                    System.out.println("Stock of player "+this.game.getCurrentPlayer().getColor()+" :"+ this.game.getCurrentPlayer().getStock());
                } else if(tabS[0].equalsIgnoreCase("play")) {
                    this.game.play(Integer.parseInt(tabS[1]), Double.parseDouble(tabS[2]),Double.parseDouble(tabS[3]));
                    System.out.println("you played");
                }
            }catch(NumberFormatException e){
                System.err.println("Warning ! the number of the shape is an int mais the positons are double !");
            }
            
            
        }
    }
//    public void play(){
//        System.out.println("Which shape do yo wanna place ?");
//        int numShape = sc.nextInt();
//        System.out.println("At which x ?:");
//        double x = sc.nextDouble();
//        System.out.println("At which y ?:");
//        double y = sc.nextDouble();
//        game.play(numShape,x,y);
//    }
}
