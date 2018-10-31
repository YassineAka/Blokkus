/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.view;

import g49382.blokus.model.Game;
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

    
    
    
    
    public void play(){
        System.out.println("Which shape do yo wanna place ?");
        int numShape = sc.nextInt();
        game.play(numShape);
        System.out.println(game.getCurrentPlayer().getStock()+" HIS DECK "+ game.getCurrentPlayer().getColor());
    }
    
    public static void main(String[] args) {
        ViewConsole view = new  ViewConsole();
        view.play();
        System.out.println(view.game.paint());
        view.play();
        System.out.println(view.game.paint());
        view.play();
        System.out.println(view.game.paint());
        view.play();
        System.out.println(view.game.paint());
        view.play();
        System.out.println(view.game.paint());
    }
}
