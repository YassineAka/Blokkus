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
    public boolean isInside(Point p){
        Bloc upperRight = new Bloc(this.getX()+ width, this.getY());
        Bloc downLeft = new Bloc(this.getX(), this.getY()+ height);
        return (this.getX() <= p.getX()) && (this.getY() <= p.getY()) && (downLeft.getY() > p.getY()) && (upperRight.getX() > p.getX());
    }

    
    
    
}
