/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javafx.beans.Observable;
import javafx.scene.shape.Shape;

/**
 *
 * @author PaRaDoxe1070
 */
public class GamePlate extends java.util.Observable {

    private List<ShapeBlokus> shapePlaced;
    private int height;
    private int width;

    /**
     * She Creates a new plate.
     *
     * @param heigth
     * @param width
     */
    public GamePlate(int heigth, int width) {
        super();
        shapePlaced = new LinkedList<>();
        this.height = heigth;
        this.width = width;
    }

    /**
     * Get the height of the plate.
     *
     * @return the height of the plate
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get the width of the plate.
     *
     * @return the width of the plate
     */
    public int getWidth() {
        return width;
    }

    /**
     * Check if it exists a shape a this position received in paramater.
     *
     * @return a List with all the shapes placed.
     */
    public List<ShapeBlokus> getShapePlaced() {
        return shapePlaced;
    }

    /**
     * She add the shape received in paramter in the plate.
     *
     * @param shape the place.
     */
    public void addShape(ShapeBlokus shape, int x, int y) {
        for (Bloc b : shape.getShape()) {
            b.getP().setX(b.getP().getX() + x);
            b.getP().setY(b.getP().getY() + y);
        }
        for (Bloc bloc : shape.getShape()) {
            if (!((bloc.getP().getX()) >= 0 && (bloc.getP().getY()) >= 0
                    && (bloc.getP().getX()) <= 19 && (bloc.getP().getY()) <= 19)) {
                for (Bloc b : shape.getShape()) {
                        b.getP().setX(b.getP().getX() - x);
                        b.getP().setY(b.getP().getY() - y);
                    }
                throw new IllegalArgumentException();
            }
        }
        for (ShapeBlokus shapeBlokus : shapePlaced) {
            for (Bloc bloc : shapeBlokus.getShape()) {
                if (shape.isInside(bloc.getP())) {
                    for (Bloc b : shape.getShape()) {
                        b.getP().setX(b.getP().getX() - x);
                        b.getP().setY(b.getP().getY() - y);
                    }
                    throw new IllegalArgumentException();
                }
            }

        }
        this.shapePlaced.add(shape);
    }

//    public boolean stayInPlate(ShapeBlokus shape, int x, int y) {
//        boolean isInPlate = true;
//        for (Bloc b : shape.getShape()) {
//            b.getP().setX(b.getP().getX() + x);
//            b.getP().setY(b.getP().getY() + y);
//        }
//        for (Bloc bloc : shape.getShape()) {
//            if (bloc.getP().getX() < 0 || bloc.getP().getY() < 0 || bloc.getP().getX() >= 20 || bloc.getP().getY() >= 20) {
//                for (Bloc b : shape.getShape()) {
//                    b.getP().setX(b.getP().getX() - x);
//                    b.getP().setY(b.getP().getY() - y);
//                }
//                isInPlate = false;
//            }
//        }
//
//        return isInPlate;
//    }

    public void addShapeBorder(ShapeBlokus shape,int x, int y) {
        for (Bloc bloc : shape.getShape()) {
            if (!((bloc.getP().getX()) >= 0 && (bloc.getP().getY()) >= 0
                    && (bloc.getP().getX()) <= 19 && (bloc.getP().getY()) <= 19)) {
                for (Bloc b : shape.getShape()) {
                        b.getP().setX(b.getP().getX() - x);
                        b.getP().setY(b.getP().getY() - y);
                    }
                throw new IllegalArgumentException();
            }
        }
        this.shapePlaced.add(shape);
    }

    /**
     * She check if the Point received in parameter is part of this shape.
     *
     * @param Point (his position).
     * @return
     */
    public ShapeBlokus getShapeAt(Point p) {
        for (ShapeBlokus shape : shapePlaced) {
            if (shape.isInside(p)) {
                return shape;
            }
        }
        return null;
    }

    public boolean isBorder(ShapeBlokus shape, int x, int y) {
        boolean isBorder = false;
        int i = 0;
        List<Bloc> blocs = new ArrayList<>();

        for (Bloc b : shape.getShape()) {
            blocs.add(new Bloc(b.getP().getX() + x, b.getP().getY() + y));
        }

        ShapeBlokus shapeChosen = new ShapeBlokus(blocs);

        while (!isBorder && i < shapeChosen.getShape().size()) {
            Bloc bloc = shapeChosen.getShape().get(i);
            if ((bloc.getP().getX() == 0 && bloc.getP().getY() == 0)
                    || (bloc.getP().getX() == 0 && bloc.getP().getY() == 19)
                    || (bloc.getP().getX() == 19 && bloc.getP().getY() == 0)
                    || (bloc.getP().getX() == 19 && bloc.getP().getY() == 19)) {
                isBorder = true;
            }
            i++;
        }
        return isBorder;
    }

    public boolean isCoin(ShapeBlokus shape, int x, int y) {
        boolean isCorner = false;
        List<Bloc> blocs = new ArrayList<>();

        for (Bloc b : shape.getShape()) {
            blocs.add(new Bloc(b.getP().getX() + x, b.getP().getY() + y));
        }

        ShapeBlokus shapeChosen = new ShapeBlokus(blocs);
        shapeChosen.setColor(shape.getColor());
        for (ShapeBlokus shapePlaced : this.shapePlaced) {
            for (Bloc bloc : shapePlaced.getShape()) {
                if ((shapePlaced.getColor()) == (shapeChosen.getColor())) {
                    for (Bloc blocShapeChosen : shapeChosen.getShape()) {
                        if (bloc.getP().getX() - 1 == blocShapeChosen.getP().getX() && bloc.getP().getY() - 1 == blocShapeChosen.getP().getY()
                                || bloc.getP().getX() + 1 == blocShapeChosen.getP().getX() && bloc.getP().getY() + 1 == blocShapeChosen.getP().getY()
                                || bloc.getP().getX() - 1 == blocShapeChosen.getP().getX() && bloc.getP().getY() + 1 == blocShapeChosen.getP().getY()
                                || bloc.getP().getX() + 1 == blocShapeChosen.getP().getX() && bloc.getP().getY() - 1 == blocShapeChosen.getP().getY()) {
                            isCorner = true;
                        }
                    }
                }
            }
        }
        return isCorner;
    }

    public boolean isBesind(ShapeBlokus shape, int x, int y) {
        boolean isBesind = false;
        List<Bloc> blocs = new ArrayList<>();

        for (Bloc b : shape.getShape()) {
            blocs.add(new Bloc(b.getP().getX() + x, b.getP().getY() + y));
        }
        ShapeBlokus shapeChosen = new ShapeBlokus(blocs);
        shapeChosen.setColor(shape.getColor());
        for (ShapeBlokus shapePlaced : this.shapePlaced) {
            for (Bloc bloc : shapePlaced.getShape()) {
                if ((shapePlaced.getColor()) == (shapeChosen.getColor())) {
                    for (Bloc blocShapeChosen : shapeChosen.getShape()) {
                        if (bloc.getP().getX() + 1 == blocShapeChosen.getP().getX() && bloc.getP().getY() == blocShapeChosen.getP().getY()
                                || bloc.getP().getX() == blocShapeChosen.getP().getX() && bloc.getP().getY() + 1 == blocShapeChosen.getP().getY()
                                || bloc.getP().getX() - 1 == blocShapeChosen.getP().getX() && bloc.getP().getY() == blocShapeChosen.getP().getY()
                                || bloc.getP().getX() == blocShapeChosen.getP().getX() && bloc.getP().getY() - 1 == blocShapeChosen.getP().getY()) {
                            isBesind = true;
                        }
                    }
                }
            }
        }
        return isBesind;
    }

    public boolean isPossible(ShapeBlokus shape, int x, int y) {
        return isCoin(shape, x, y) && !isBesind(shape, x, y);
    }

}
