/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import byui.cit260.starfreighteraj.model.Enemy;
import byui.cit260.starfreighteraj.model.Player;
import byui.cit260.starfreighteraj.view.FightView;

/**
 *
 * @author JeffJones
 */
public class FightTemplateControl {
    
     public static String updateEnemyVars(String msg, Enemy enemy) {
        String message = msg.replace("{enemy}", enemy.getName());
        message = message.replace("{enemyname}", enemy.getName());
        message = message.replace("{enemytype}", enemy.getType());
        message = message.replace("{enemyHitPoints}", String.valueOf(enemy.getHitPoints()));
        message = message.replace("{enemyMaxHitPoints}", String.valueOf(enemy.getMaxHitPoints()));
        return message;
    }

    public static String replaceFormulaVars(String msg, int[] formula) {
        String message = msg.replace("{firstNum}", Integer.toString(formula[0]));
        message = message.replace("{secondNum}", Integer.toString(formula[1]));
        message = message.replace("{operation}", FightView.getOperation(formula[2]));
        return message;
    }
    
    public static String updateFightVars(String msg, double damage) {
        String message = msg.replace("{action}", "fire");
        message = message.replace("{weapon}", "plasma pistol");
        message = message.replace("{enemydodge}", "his personal shield deflects "
                                    + "the blast");
        message = message.replace("{dodge}", " your personal shield deflects"
                                        + "the blast");
        
        message = message.replace("{dmg}", String.valueOf(damage));
        
        if (damage <= 5) {
            message = message.replace("{severity}", "minor");
        } else if (damage <= 10) {
            message = message.replace("{severity}", "major");
        } else if (damage <= 20) {
            message = message.replace("{severity}", "critical");
        }
        
        return message;
    }

    public static String updatePlayerVars(String msg, Player player) {
        String message = "";
        double playerHitPoints = player.getHitPoints();
        message = msg.replace("{playername}", player.getName());
        if (playerHitPoints >= 7) {
            message = message.replace("{mood}", "ready");
            message = message.replace("{outcome}", "win");
        } else if (playerHitPoints >= 5) {
            message = message.replace("{mood}", "hungry");
            message = message.replace("{outcome}", "tie");
        } else if (playerHitPoints >= 2) {
            message = message.replace("{mood}", "fatigued");
            message = message.replace("{outcome}", "lose");
        }
        message = message.replace("{hitPoints}", String.valueOf(playerHitPoints));
        message = message.replace("{maxHitPoints}", String.valueOf(player.getMaxHitPoints()));
        return message;
    }

    

   

    
}
    

