package g49382.blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PaRaDoxe1070
 */
public class Deck {
    private List<Shape> shapes;
    private int nbShape;

    public Deck() {
        this.shapes = new ArrayList<Shape>();
        Shape [] allShapes ={new Shape(new Bloc()),//1
                             new Shape(new Bloc(),new Bloc(0,1)),//2
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2)),//3
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(1,1)),//4
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(0,3)),//5
                             new Shape(new Bloc(0,2),new Bloc(1,0),new Bloc(1,1),new Bloc(1,2)),//6
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(1,1),new Bloc(0,2)),//7
                             new Shape(new Bloc(),new Bloc(1,0),new Bloc(0,1),new Bloc(1,1)),//8
                             new Shape(new Bloc(),new Bloc(1,0),new Bloc(1,1),new Bloc(2,1)),//9
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(0,3),new Bloc(0,4)),//10
                             new Shape(new Bloc(0,3),new Bloc(1,0),new Bloc(1,1),new Bloc(1,2),new Bloc(1,3)),//11
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(-1,2),new Bloc(-1,3)),//12
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(-1,1),new Bloc(-1,2)),//13
                             new Shape(new Bloc(-1,0),new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(-1,2)),//14
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(1,1),new Bloc(0,2),new Bloc(0,3)),//15
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(-1,2),new Bloc(1,2)),//16
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(0,2),new Bloc(1,2),new Bloc(2,2)),//17
                             new Shape(new Bloc(),new Bloc(1,0),new Bloc(1,1),new Bloc(2,1),new Bloc(2,2)),//18
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(1,1),new Bloc(2,1),new Bloc(2,2)),//19
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(1,1),new Bloc(2,1),new Bloc(1,2)),//20
                             new Shape(new Bloc(),new Bloc(0,1),new Bloc(-1,1),new Bloc(1,1),new Bloc(0,2))//21
                            };
        for (Shape s : allShapes) {
            s.setNumShape(this.nbShape+1);
            this.shapes.add(s);
            this.nbShape++;
        }
    }

    public List<Shape> getShapes() {
        return shapes;
    }
    
    public int getNbShape() {
        return nbShape;
    }
    

    @Override
    public String toString() {
        return "{" + shapes + '}';
    }

    
}
