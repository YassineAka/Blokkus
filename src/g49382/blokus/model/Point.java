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
public class Point {
    private int x ;
    private int y ;    
    
    /**
     * Create a new point at the position received in parameter.
     * @param x
     * @param y
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Create a duplication of the point received in parameter .
     * @param p
     */
    public Point (Point p){
     this.x = p.getX();
     this.y = p.getY();
    }

    /**
     * Get the x of this point.
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y of this point.
     * @return y
     */
    public int getY() {
        return y;
    }
    public void turn(){
        int a;
        
        a = this.x;
        this.x = this.y;
        this.y = 0-a;
        
    }
    public void mirror(){
        this.x = -(this.x);
        this.y = (this.y);
    }

    /**
     * Set a new value to the x.
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set a new value to the y.
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * She move this point with the specifiek valu received in parameter.
     * @param x
     * @param y
     */
    public void move (int x, int y){
        this.x += x ;
        this.y += y ;
    }

    /**
     *
     * @param p
     * @return
     */
    public boolean equals(Point p) {
        return (p.getX()== this.x) && (p.getY() == this.y);
    }
    
    
    
}

