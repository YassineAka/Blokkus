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
public enum Color {
    BLUE('b'),RED('r'),GREEN('g'),YELLOW('y');
    
    private char c;

    private Color(char c) {
        this.c = c;
    }

    public char getC() {
        return c;
    }
    
    
}
