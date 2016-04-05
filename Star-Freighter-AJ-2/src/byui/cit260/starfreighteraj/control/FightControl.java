/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import byui.cit260.starfreighteraj.model.Enemy;
import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.Player;
import java.util.Random;
import star.freighter.aj.StarFreighterAJ;

/**
 *
 * @author JeffJones
 */
public class FightControl {

    public static void updateHitPoints(String characterType, double damage) {
        Game game = StarFreighterAJ.getCurrentGame();
        if (characterType.equals("enemy")) {
            Enemy enemy = game.getEnemy();
            enemy.setHitPoints((int) (enemy.getHitPoints() + damage));
        } else if (characterType.equals("player")) {
            Player player = game.getPlayer();
            player.setHitPoints((int) (player.getHitPoints() + damage));
        }
    }

    public static boolean hasPlayerLost() {
        Game game = StarFreighterAJ.getCurrentGame();
        return game.getPlayer().getHitPoints() <= 0;
    }

    public static boolean hasPlayerWon() {
        Game game = StarFreighterAJ.getCurrentGame();
        return game.getEnemy().getHitPoints() <= 0;
    }
    
    private Enemy enemy;
    
    public Enemy createEnemy(String enemyName) {
        enemy = new Enemy();
        // set the enemy name
        return enemy;
    }
    
//    public String inflictDamage(Player player, damage) {    
//        calcPlayerAttack();
//    }
    
   /**
    * Returns a pseudo-random number between min and max, inclusive.
    * The difference between min and max can be at most
    * <code>Integer.MAX_VALUE - 1</code>.
    *
    * @param min Minimum value
    * @param max Maximum value.  Must be greater than min.
    * @return Integer between min and max, inclusive.
    * @see java.util.Random#nextInt
    */
   public static int randNumber(int min, int max) {

       Random rand = new Random();

       int randomNum = rand.nextInt((max - min) + 1) + min;

       return randomNum;
   }
   
   public static int computeAnswer(int numberOne, int numberTwo, int randomInt) {
       if (randomInt == 1) {
           return numberOne + numberTwo;
       } else if (randomInt == 2) {
           return numberOne - numberTwo;
       } else if (randomInt == 3) {
           return numberOne * numberTwo;
       }
       return numberOne + numberTwo;
   }
   
   public static int[] getFormula() {
       int numOne = randNumber(1, 15);
       int numTwo = randNumber(1, 15);
       int numThree = randNumber(1, 3);
       int result = computeAnswer(numOne, numTwo, numThree);
       int[] formulaValues =  new int[]{numOne, numTwo, numThree, result};
       return formulaValues;
   }
}
