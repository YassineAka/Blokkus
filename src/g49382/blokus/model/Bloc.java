/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;


public class Bloc {
    private  int x;
    private int y;
    private final int height;
    private final int width;
   

    public Bloc() {
        this.x = 0;
        this.y = 0;
        this.height = 1;
        this.width = 1;
    }
    
    public Bloc(int x, int y) {
        this.x = x;
        this.y = y;
        this.height = 1;
        this.width = 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    

    @Override
    public String toString() {
        return "("+x+";"+y+")";
    }
    
    
    
}
