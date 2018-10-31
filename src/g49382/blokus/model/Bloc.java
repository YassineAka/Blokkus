/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;


public class Bloc {
    private Point p;
    private final int height;
    private final int width;
   

    public Bloc() {
        this.p = new Point(0, 0);
        this.height = 1;
        this.width = 1;
    }
    
    public Bloc(double x, double y) {
        this.p = new Point(x, y);
        this.height = 1;
        this.width = 1;
    }

    public double getX() {
        return p.getX();
    }

    public double getY() {
        return p.getY();
    }
    

    @Override
    public String toString() {
        return "("+p.getX()+";"+p.getY()+")";
    }
    public boolean isInside(Point p){
        Bloc upperRight = new Bloc(this.getX()+ width, this.getY());
        Bloc downLeft = new Bloc(this.getX(), this.getY()+ height);
        return (p.getX() == this.getX()) && (p.getY() == this.getY());
        //(this.getX() <= p.getX()) && (this.getY() <= p.getY()) && (downLeft.getY() > p.getY()) && (upperRight.getX() > p.getX());
    }

    
    
    
}
