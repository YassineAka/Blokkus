/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PaRaDoxe1070
 */
public class Shape {
    private List<Bloc> shape;
    private int nbBloc;

    public Shape(Bloc ...blocs) {
        this.shape = new LinkedList<Bloc>();
        for (Bloc bloc : blocs) {
            this.shape.add(bloc);
        }
        this.nbBloc = this.shape.size();
    }

    public List<Bloc> getShape() {
        return shape;
    }
    
//    public static void main(String[] args) {
//        Shape carré = new Shape(new Bloc(),new Bloc(2,2),new Bloc(3,0));
//        for (Bloc bloc : carré.shape) {
//            System.out.println(bloc);
//        }
//    }
    
}
