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
    
    /**
     *
     */
    public ViewConsole() {
        game = new Game();
        sc = new Scanner(System.in);
    }

    /**
     * She out print the view a of the game.
     */
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
                    this.game.play(Integer.parseInt(tabS[1]), Integer.parseInt(tabS[2]),Integer.parseInt(tabS[3]));
                    System.out.println("you played");
                }
            }catch(NumberFormatException e ){
                // APA : Hein ? Comment est ce que tu différencie un int d'un double ?
                System.err.println("Warning ! the number of the request is badly written !");
            }
            
            
        }
    }

}
