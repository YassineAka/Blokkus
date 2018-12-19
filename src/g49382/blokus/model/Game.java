/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package g49382.blokus.model;

import g49382.blokus.strategy.Context;
import g49382.blokus.strategy.NextPlayer;
import g49382.blokus.strategy.PlaceAShape;
import static java.lang.Math.cos;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author PaRaDoxe1070
 */
public class Game extends Observable {

    private List<Player> players;
    private List<Player> playersstoped;
    private boolean isOver;
    private Player currentPlayer;
    private GamePlate plate;
    private ShapeBlokus shapeChosen;
    private List<Observer> observers;
    private Context contextPlace;
    private Context contextPass;

    /**
     * Create a new game.
     */
    public Game() {
        this.players = new ArrayList<Player>(4);
        this.playersstoped = new ArrayList<Player>();
        this.players.add(new Player(Paint.BLUE));
        this.players.add(new Player(Paint.RED));
        this.players.add(new Player(Paint.GREEN));
        this.players.add(new Player(Paint.YELLOW));
        this.isOver = false;
        this.currentPlayer = this.players.get(0);
        this.plate = new GamePlate(20, 20);
        this.shapeChosen = null;
        this.observers = new ArrayList<>();
        this.contextPlace = new Context(new PlaceAShape());
        this.contextPass = new Context(new NextPlayer());

    }

    /**
     * Check if the attribute isOver is true that mean the game is over.
     *
     * @return true if the game is over
     */
    public boolean isOver() {
        if (players.isEmpty()) {
            this.isOver = true;

        }
        return isOver;
    }

    public void remainPlayers() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isStoped()) {
//                this.nextPlayer(players.get(i+1));
                playersstoped.add(players.get(i));
                players.remove(players.get(i));
            }
        }
    }


    public void nextPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        changed();
    }

    /**
     * Get the current player of this game.
     *
     * @return
     */
    public Player getCurrentPlayer() {
        return currentPlayer;

    }

    /**
     * Get the palte of this game.
     *
     * @return the plate
     */
    public GamePlate getPlate() {
        return plate;
    }

    /**
     * Get the shape chosen of this game.
     *
     * @return shapeChosen
     */
    public ShapeBlokus getShapeChosen() {
        return shapeChosen;
    }

    public void setShapeChosen(ShapeBlokus shapeChosen) {
        this.shapeChosen = shapeChosen;

    }

    public void resetGame() {
        this.players.clear();
        this.isOver = false;
        this.currentPlayer = null;
        this.plate = null;
        this.shapeChosen = null;
        this.observers = null;
    }

    /**
     * Get the players of this game.
     *
     * @return players
     */
    public List<Player> getPlayers() {
        return players;
    }

    public void changed() {
        setChanged();
        notifyObservers();
    }

    /**
     * Get the winner of the game. She check if it exist a player with no more
     * shapes.
     *
     * @return Player
     */
    public Player getWinner() {
        Player winner = new Player();
        int score;
        score = 0;
        for (Player p : this.playersstoped) {
            if (p.getScore() > score) {
                score = p.getScore();
                winner.setColor(p.getColor());
            }
        }
        return winner;

    }

    /**
     * She place the shape in the plate at the numShape position at the position
     * received in paramater.
     *
     * @param position of the shape chosen in the deck.
     * @param x.
     * @param y.
     */
    public void play(int numShape, int x, int y) {
        if (shapeChosen != null) {
            if (this.currentPlayer.getNbShape() == 22) {
                if ((this.plate.isBorder(shapeChosen, x, y))) {
                    for (Bloc b : shapeChosen.getShape()) {
                        b.getP().setX(b.getP().getX() + x);
                        b.getP().setY(b.getP().getY() + y);
                    }
                    this.plate.addShapeBorder(shapeChosen, x, y);
                    shapeChosen = this.currentPlayer.place(numShape);
                    this.currentPlayer.addScore(shapeChosen);
                    this.shapeChosen = null;
                    this.nextPlayer(this.passToNextPlayer());

                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                if ((this.plate.isPossible(shapeChosen, x, y))) {
                    this.plate.addShape(shapeChosen, x, y);
                    shapeChosen = this.currentPlayer.place(numShape);
                    this.shapeChosen = null;
                    this.nextPlayer(this.passToNextPlayer());
                } else {

                    throw new IllegalArgumentException();
                }

            }
        }
        changed();

    }

    /**
     * She passes a turn.
     */
    public Player passToNextPlayer() {
        int index = this.players.indexOf(this.currentPlayer);
        return this.players.get((index + 1) % this.players.size());

    }

    public void turn() {
        if (shapeChosen != null) {
            for (Bloc bloc : shapeChosen.getShape()) {
                bloc.getP().turn();
            }
        }
    }

    public void mirror() {
        if (shapeChosen != null) {
            for (Bloc bloc : shapeChosen.getShape()) {
                bloc.getP().mirror();
            }
        }
    }

    /**
     * She paint the plate of the game.
     *
     * @return a StringBuffer with the shapes placed on the plate.
     */
    public StringBuffer paint() {
        StringBuffer aff = new StringBuffer();
        for (int i = 0; i < this.plate.getHeight(); i++) {
            for (int j = 0; j <= this.plate.getWidth(); j++) {
                Point p = new Point(j, i);
                if (this.plate.getShapeAt(p) != null) {
                    ShapeBlokus s = this.plate.getShapeAt(p);
                    aff.append(s.getColor().getC() + " ");
                } else {
                    aff.append(". ");
                }
            }
            aff.append("\n");
        }
        return aff;
    }

    @Override
    public void notifyObservers() {
        try {
            for (Observer observer : this.observers) {
                observer.update(this, null);
            }
        } catch (ConcurrentModificationException e) {
        }
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        if (this.observers.contains(o)) {
            this.observers.remove(o);
        }
    }

    @Override
    public synchronized void addObserver(Observer o) {
        if (!this.observers.contains(o)) {
            this.observers.add(o);
        }
    }

    /**
     * She reset the game. You juste have to reslect a shape and choose a new
     * position in the plate an then the gameplate(the board) will reset.
     */
    public void newGame() {
        this.players = null;
        this.plate = null;
        this.playersstoped = null;
        this.players = new ArrayList<Player>(4);
        this.playersstoped = new ArrayList<>();
        this.players.add(new Player(Paint.BLUE));
        this.players.add(new Player(Paint.RED));
        this.players.add(new Player(Paint.GREEN));
        this.players.add(new Player(Paint.YELLOW));
        this.isOver = false;
        this.currentPlayer = null;
        this.plate = new GamePlate(20, 20);
        this.shapeChosen = null;
        this.nextPlayer(passToNextPlayer());
        changed();

    }

    public void playIA() {
        boolean ok = false;
        int cpt = 0;
        while (!ok && cpt < 10000) {
            try {
                cpt++;
                int x = ((int) (19 * Math.random()));
                int y = ((int) (19 * Math.random()));
                int p = ((int) (22 * Math.random()));
                this.shapeChosen = currentPlayer.getStock().getShapes().get(p - 1);

                if (this.currentPlayer.getNbShape() == 22) {
                    if ((this.plate.isBorder(shapeChosen, x, y))) {
                        for (Bloc b : shapeChosen.getShape()) {
                            b.getP().setX(b.getP().getX() + x);
                            b.getP().setY(b.getP().getY() + y);
                        }
                        this.plate.addShapeBorder(shapeChosen, x, y);
                        shapeChosen = this.currentPlayer.place(p);
                        this.currentPlayer.addScore(shapeChosen);
                        this.shapeChosen = null;
                        this.nextPlayer(this.passToNextPlayer());
                        ok = true;
                        changed();

                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    if ((this.plate.isPossible(shapeChosen, x, y))) {
                        this.plate.addShape(shapeChosen, x, y);
                        shapeChosen = this.currentPlayer.place(p);
                        this.currentPlayer.addScore(shapeChosen);
                        this.shapeChosen = null;
                        this.nextPlayer(this.passToNextPlayer());
                        ok = true;
                        changed();
                    } else {
                        throw new IllegalArgumentException();
                    }

                }
                notifyObservers();

            } catch (Exception e) {
                e.getMessage();
            }
        }
        if (cpt == 10000) {
            this.currentPlayer.Stop();
            this.nextPlayer(passToNextPlayer());

        }

    }

}
