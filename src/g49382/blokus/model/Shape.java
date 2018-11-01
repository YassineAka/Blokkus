/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PaRaDoxe1070
 */
public class Shape {
    private List<Bloc> shape;
    private int nbBloc;
    private int numShape;
    private char charColor;
    private Color color = null;

    public Shape(Bloc ...blocs) {
        this.shape = new LinkedList<Bloc>();
        for (Bloc bloc : blocs) {
            this.shape.add(bloc);
        }
        this.nbBloc = this.shape.size();
    }
    public Color getColor() {
        return this.color ;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public char getCharColor() {
        return charColor;
    }

    public void setCharColor(char charColor) {
        this.charColor = charColor;
    }
    
    

    public List<Bloc> getShape() {
        return shape;
    }

    public void setNumShape(int numShape) {
        this.numShape = numShape;
    }
    public Boolean isInside(Point p){
        for (Bloc b : shape) {
            if (b.isInside(p)) {
                return true;
            }
        }
        return false;
    }
    
    
    
//    public static void main(String[] args) {
//        Shape carré = new Shape(new Bloc(),new Bloc(2,2),new Bloc(3,0));
//        for (Bloc bloc : carré.shape) {
//            System.out.println(bloc);
//        }
//    }

    @Override
    public String toString() {
        return "Shape n°"+ numShape+"{" + shape + '(' +this.color+ ") }";
    }

    
    
    
    
}
