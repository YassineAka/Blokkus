package g49382.blokus.model;

/**
 *
 * @author PaRaDoxe1070
 */
public class Bloc {

    private Point p;

    /**
     * Builds a new Bloc.
     */
    public Bloc() {
        this.p = new Point(0, 0);
    }

    /**
     * Builds a new Bloc a the position received in parameter.
     *
     * @param x
     * @param y
     */
    public Bloc(int x, int y) {
        this.p = new Point(x, y);
    }

    /**
     * Get the Position attribute of this object.
     *
     * @return
     */
    public Point getP() {
        return p;
    }

    /**
     * Set the Position attribute of this object a the position received in
     * parameter.
     *
     * @param p
     */
    public void setP(Point p) {
        this.p = p;
    }

    public boolean isCoin(Bloc bloc) {
        if ((((this.p.getX() + 1) == (bloc.getP().getX())) && (this.p.getY() + 1 == bloc.getP().getY()))
                || (((this.p.getX() - 1) == (bloc.getP().getX())) && (this.p.getY() - 1 == bloc.getP().getY()))
                || (((this.p.getX() + 1) == (bloc.getP().getX())) && (this.p.getY() - 1 == bloc.getP().getY()))
                || (((this.p.getX() - 1) == (bloc.getP().getX())) && (this.p.getY() + 1 == bloc.getP().getY()))) {
            return true;
        }
        return false;
    }
    public boolean atLeastOneArete(Bloc bloc) {
        if ((((this.p.getX() + 1) == (bloc.getP().getX())) && (this.p.getY() == bloc.getP().getY()))
                || (((this.p.getX() - 1) == (bloc.getP().getX())) && (this.p.getY() == bloc.getP().getY()))
                || (((this.p.getX()) == (bloc.getP().getX())) && (this.p.getY() - 1 == bloc.getP().getY()))
                || (((this.p.getX()) == (bloc.getP().getX())) && (this.p.getY() + 1 == bloc.getP().getY()))) {
            return true;
        }
        return false;
    }
    
    
    @Override
    public String toString() {
        return "(" + p.getX() + ";" + p.getY() + ")";
    }

    /**
     * Check if this object equals the point received in paramater.
     *
     * @param p
     * @return
     */
    public boolean isInside(Point p) {
        return (p.getX() == this.getP().getX()) && (p.getY() == this.getP().getY());
        //(this.getX() <= p.getX()) && (this.getY() <= p.getY()) && (downLeft.getY() > p.getY()) && (upperRight.getX() > p.getX());
    }

}
