/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

/**
 *
 * @author PaRaDoxe1070
 */
public enum Paint {
    BLUE(1,'b',"#0000FF"),RED(2,'r',"#FF0000"),GREEN(3,'g',"#00FF00"),YELLOW(4,'y',"#FFFF00");
    
    private int numPlayer;
    private final char c;
    private String ascii;
    

    private Paint(int numPlayer, char c, String ascii) {
        this.c = c;
        this.ascii = ascii;
        this.numPlayer = numPlayer;
    }

    public char getC() {
        return c;
    }

    public String getAscii() {
        return ascii;
    }

    public int getNumPlayer() {
        return numPlayer;
    }
    
    
    
    
}
