package g49382.blokus.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PaRaDoxe1070
 */
public class Deck {
    private List<Shape> shape;

    public Deck() {
        this.shape = new LinkedList<Shape>();
        Shape [] allShapes = {new Shape(new Bloc()),
                              new Shape(new Bloc(),new Bloc(0,1)),
                              new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2)),
                              new Shape(new Bloc(),new Bloc(0,1),new Bloc(1,1)),
                              new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(0,3)),
                              new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(-1,2)),
                              new Shape(new Bloc(),new Bloc(0,1),new Bloc(1,1),new Bloc(0,2)),
                              new Shape(new Bloc(),new Bloc(1,0),new Bloc(0,1),new Bloc(1,1)),
                              new Shape(new Bloc(),new Bloc(1,0),new Bloc(1,1),new Bloc(2,1)),
                              };
        
                                        
    }
    
    
}
