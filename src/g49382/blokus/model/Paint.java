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
    BLUE('b',"#0000FF"),RED('r',"#FF0000"),GREEN('g',"#00FF00"),YELLOW('y',"#FFFF00");
    
    private final char c;
    private String ascii;

    private Paint(char c, String ascii) {
        this.c = c;
        this.ascii = ascii;
    }

    public char getC() {
        return c;
    }

    public String getAscii() {
        return ascii;
    }
    
    
    
}
