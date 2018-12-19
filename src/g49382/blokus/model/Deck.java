package g49382.blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PaRaDoxe1070
 */
public class Deck {
    private List<ShapeBlokus> shapes;
    private int nbShape;

    /**
     * Create a new deck.
     */
    public Deck() {
        this.shapes = new ArrayList<ShapeBlokus>();
        ShapeBlokus [] allShapes ={new ShapeBlokus(Arrays.asList(new Bloc())),//1
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1))),//2
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(0,2))),//3
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(1,1))),//4
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(0,3))),//5
                             new ShapeBlokus(Arrays.asList(new Bloc(0,2),new Bloc(1,0),new Bloc(1,1),new Bloc(1,2))),//6
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(1,1),new Bloc(0,2))),//7
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(1,0),new Bloc(0,1),new Bloc(1,1))),//8
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(1,0),new Bloc(1,1),new Bloc(2,1))),//9
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(0,3),new Bloc(0,4))),//10
                             new ShapeBlokus(Arrays.asList(new Bloc(0,3),new Bloc(1,0),new Bloc(1,1),new Bloc(1,2),new Bloc(1,3))),//11
                             new ShapeBlokus(Arrays.asList(new Bloc(0,2),new Bloc(0,3),new Bloc(1,0),new Bloc(1,1),new Bloc(1,2))),//12
                             new ShapeBlokus(Arrays.asList(new Bloc(0,1),new Bloc(0,2),new Bloc(1,0),new Bloc(1,1),new Bloc(1,2))),//13
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(1,0),new Bloc(1,1),new Bloc(0,2),new Bloc(1,2))),//14
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(1,1),new Bloc(0,2),new Bloc(0,3))),//15
                             new ShapeBlokus(Arrays.asList(new Bloc(0,2),new Bloc(1,0),new Bloc(1,1),new Bloc(1,2),new Bloc(2,2))),//16
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(1,2),new Bloc(2,2))),//17
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(1,0),new Bloc(1,1),new Bloc(2,1),new Bloc(2,2))),//18
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(1,1),new Bloc(2,1),new Bloc(2,2))),//19
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(1,1),new Bloc(2,1),new Bloc(1,2))),//20
                             new ShapeBlokus(Arrays.asList(new Bloc(1,0),new Bloc(0,1),new Bloc(1,1),new Bloc(1,2),new Bloc(2,1))),//21
                             new ShapeBlokus(Arrays.asList(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(1,0),new Bloc(1,1),new Bloc(1,2)))//22
                            };
        for (ShapeBlokus s : allShapes) {
            s.setNumShape(this.nbShape+1);
            this.shapes.add(s);
            this.nbShape++;
        }
    }

    /**
     * Get the shapes attribute of this object.s
     * @return this.shapes
     */
    public List<ShapeBlokus> getShapes() {
        return shapes;
    }
    
    /**
     * Get the number of shapes attribute of this object.
     * @return this.nbShape
     */
    public int getNbShape() {
        return nbShape;
    }
    

    @Override
    public String toString() {
        return "{" + shapes + '}';
    }

    
}
