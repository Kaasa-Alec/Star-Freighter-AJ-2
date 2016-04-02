/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.model.Player;

/**
 *
 * @author JeffJones
 */
public class PlayerControl {
    
    private Player gamePlayer;
    
    public PlayerControl(Player player) {
        gamePlayer = player;
    }

    PlayerControl() {
    }
        
    public static double calcPlayerAttack(double attack, double eDefense,double timer, double allyBonus, double answerBonus ){
        
        if (attack < 0 || attack > 20) return -1;

        if (eDefense < 20 || eDefense>40) return -1;

        if (timer < 0 || timer >10) return -1;

        if (allyBonus <1 || allyBonus >2) return -1;

        if (answerBonus <1 || answerBonus >2) return -1;

        attack=attack-eDefense+timer*allyBonus*answerBonus;

        return attack;

    }
    public static int calcPlayerLevel(int attack, int defense, int difficulty, int level){
        
        if (attack < 0 || attack > 20) return -1;

        if (defense < 0 || defense > 20) return -1;

        if (difficulty < 0 || difficulty > 2) return -1;

         level=attack*defense/difficulty;
         
        return level;

    }

    public static double calcPlayerDefense(double defense, double eAttack, double timer, double allyBonus, double answerBonus ){

        if (defense < 20 || defense>20) return -1;

        if (eAttack < 0 || eAttack > 40) return -1;

        if (timer < 0 || timer >10) return -1;

        if (allyBonus <1 || allyBonus >2) return -1;

        if (answerBonus <1 || answerBonus >2) return -1;

        double hitDamage = (  defense - eAttack + timer * allyBonus * answerBonus );
         
        return hitDamage;

    }
}
