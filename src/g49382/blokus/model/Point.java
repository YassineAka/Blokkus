/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

public class Point {
    private double x ;
    private double y ;    
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Point (Point p){
     this.x = p.getX();
     this.y = p.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public void move (double x, double y){
        this.x += x ;
        this.y += y ;
    }
    public double ditanceTo (Point other){
        return Math.sqrt((Math.pow((other.x - this.x),2))+(Math.pow((other.y - this.y),2)));
    }

    

    public boolean equals(Point p) {
        return (p.getX()== this.x) && (p.getY() == this.y);
    }
    
    
    
}

