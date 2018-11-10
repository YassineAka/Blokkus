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

    /**
     * Color blue , she is the color of the first player.
     */
    BLUE(1,'b',"#0000FF"),

    /**
     * Color blue , she is the color of the second player.
     */
    RED(2,'r',"#FF0000"),

    /**
     * Color blue , she is the color of the third player.
     */
    GREEN(3,'g',"#00FF00"),

    /**
     * Color blue , she is the color of the fourth player.
     */
    YELLOW(4,'y',"#FFFF00");
    
    private int numPlayer;
    private final char c;
    private String ascii;
    

    private Paint(int numPlayer, char c, String ascii) {
        this.c = c;
        this.ascii = ascii;
        this.numPlayer = numPlayer;
    }

    /**
     * Get the character of the color.
     * @return a character of a color.
     */
    public char getC() {
        return c;
    }

    /**
     * Get the code ascii of this color.
     * @return a string who contains a ascii code.
     */
    public String getAscii() {
        return ascii;
    }

    /** 
     * Get the number of the player.
     * @return
     */
    public int getNumPlayer() {
        return numPlayer;
    }
    
    
    
    
}
