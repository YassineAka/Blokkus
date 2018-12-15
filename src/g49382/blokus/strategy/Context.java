/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.strategy;
import g49382.blokus.model.Game;
import g49382.blokus.model.ShapeBlokus;

/**
 *
 * @author PaRaDoxe1070
 */
public class Context {
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public void executeStrategy(ShapeBlokus shape, int x, int y, Game game){
      strategy.doOperation(shape, x, y, game);
   }
}
