/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.FightControl;
import byui.cit260.starfreighteraj.control.FightTemplateControl;
import byui.cit260.starfreighteraj.model.Enemy;
import byui.cit260.starfreighteraj.model.Player;

/**
 *
 * @author JeffJones
 */
public class FightView extends View {
    
    private final String FIGHTINTRO = "\n"
            +"\n------------------------------"
            +"\n You are faced with an {enemytype}"
            +"\n defeat them to complete the job."
            +"\n";

    private String ROUNDINTRO = "\n------------------------------"
            + "\nYou feel {mood}. You most likely {outcome} this fight."
            + "\n{playername} the {playerType}: {hitPoints}/{maxHitPoints} \t {enemyname} the {enemytype}: {enemyHitPoints}/{enemyMaxHitPoints}";
    
    private String CONTROLS = "Answer Equation to Continue; R - Run Away!";
    
    private final String PLAYERATTACK = "\nAn equation appears into view as you ready your attack."
            + "\nWhat is the answer to {firstNum} {operation} {secondNum} ? ";

    private final String PLAYERDEFENSE = "\nAn equation appears into view as you ready your defense."
            + "\nWhat is the answer to {firstNum} {operation} {secondNum} ? ";
    
    private String HITSUCCEEDS = "\n"
            +" You {action} at your opponent and your {weapon} hits "
            +"\n your enemy. Causing {severity} damage to the {enemytype} of {dmg} hit points.";
    
    private String HITFAILS = "\n"
            +" You {action} at the {enemytype} {enemydodge} and miss.";    
    
    private String ENEMYHITS = "\n"
            +" The {enemytype} fires at you and connects hits."
            +"\n You take on damage of {dmg} hit points.";
    
    private String ENEMYMISS = "\n"
            +" The {enemytype} fires at you and {dodge} ";
            
    private String ENEMYDEATH = " The shot has taken {enemyname} the {enemytype} life. His body falls lifeless "
            +"\n to the ground. You have won.";
    
    private String PLAYERDEATH = "\n"
            +" You can take no more damage. You feel a light fuzzy feeling."
            +"\n You see a light in the distance. You begin to drift towards the light.";
    
    private Enemy fightEnemy = null;
    private Player player = null;
    int[] formula = FightControl.getFormula();
    private String type = "attack";
    
    public String displayFight(Enemy enemy) {
        
        player = Player.getPlayer();
        fightEnemy = enemy;
        
        String roundIntro = FightTemplateControl.updatePlayerVars(ROUNDINTRO, player);
        roundIntro = FightTemplateControl.updateEnemyVars(roundIntro, fightEnemy);
        
        String roundMsg = "";
        String input;
        
        System.out.println(FightTemplateControl.updateEnemyVars(FIGHTINTRO, fightEnemy));        
        waitSeconds(2);
        
        char selection = ' ';
        do {
            
            formula = FightControl.getFormula();
            if (type.equals("attack")) {
                roundMsg = FightTemplateControl.replaceFormulaVars(PLAYERATTACK, formula);
            } else {
                roundMsg = FightTemplateControl.replaceFormulaVars(PLAYERDEFENSE, formula);
            }
            System.out.println(roundIntro);
            waitSeconds(2);
            System.out.println(roundMsg);
            waitSeconds(2);
            System.out.println(CONTROLS);
            
            input = this.getInput();
            selection = input.toUpperCase().charAt(0);
            System.out.println(selection);
            if (selection != 'E') {
                this.doAction(input);
            
                if (type.equals("attack")) {
                    type = "defense";
                } else {
                    type = "attack";
                }
                roundIntro = FightTemplateControl.updatePlayerVars(ROUNDINTRO, player);
                roundIntro = FightTemplateControl.updateEnemyVars(roundIntro, fightEnemy);
                // TODO: Exit out of here when hit points reach 0.
                if (FightControl.hasPlayerLost()) {
                // TODO: Take player back to Main Menu when they lose.
                    System.out.println(PLAYERDEATH);
                    return "PlayerDeath";
                } else if (FightControl.hasPlayerWon()) {
                    // TODO: Take player back to Game Menu when they win.
                    // TOOD: Reward player when they win.
                    String enemyDeath = FightTemplateControl.updateEnemyVars(ENEMYDEATH, fightEnemy);
                    System.out.println(enemyDeath);
                    return "PlayerVictory";
                }
            }
        } while (!"R".equals(input.toUpperCase()));
        
        return "QuitToMenu";
    }
    
    @Override
    public boolean doAction(String value) {
        double damage;
        boolean answerCorrect = false;
        String resultMsg;
        int playerAnswer = Integer.parseInt(value);
                
        if (playerAnswer == formula[3]) {
            System.out.println("\n Correct! " + formula[0] + " " + FightView.getOperation(formula[2]) + " " + formula[1] + " = " + playerAnswer);
            answerCorrect = true;
        } else {
            System.out.println("\n Wrong! " + formula[0] + " " + FightView.getOperation(formula[2]) + " " + formula[1] + " \u2260 " + playerAnswer);
        }
        waitSeconds(1);
        if (type.equals("attack")) {
            // TODO: Fix damage amount to be correct.
            // TODO: make the hit / miss based on a random number. Something like 5% chance of missing?
            // TODO: Implement timer for equations.
            if (answerCorrect) {
                damage = PlayerControl.calcPlayerAttack(player.getAttackStrategyLvl(), fightEnemy.getDefenseBonus(), 10, 0, 2);
                resultMsg = FightTemplateControl.updateFightVars(HITSUCCEEDS, damage);
                resultMsg = FightTemplateControl.updateEnemyVars(resultMsg, fightEnemy);
                FightControl.updateHitPoints("enemy", damage);
            } else {
                damage = PlayerControl.calcPlayerAttack(player.getAttackStrategyLvl(), fightEnemy.getDefenseBonus(), 10, 0, 0);
                resultMsg = FightTemplateControl.updateFightVars(HITFAILS, damage);
                resultMsg = FightTemplateControl.updateEnemyVars(resultMsg, fightEnemy);
            }
        } else {
            if (answerCorrect) {
                damage = PlayerControl.calcPlayerDefense(player.getDefenseStrategyLvl(), fightEnemy.getAttackBonus(), 10, 0, 0);
                resultMsg = FightTemplateControl.updateFightVars(ENEMYMISS, damage);
                resultMsg = FightTemplateControl.updateEnemyVars(resultMsg, fightEnemy);
            } else {
                damage = PlayerControl.calcPlayerDefense(player.getDefenseStrategyLvl(), fightEnemy.getAttackBonus(), 10, 0, 2);
                resultMsg = FightTemplateControl.updateFightVars(ENEMYHITS, damage);
                resultMsg = FightTemplateControl.updateEnemyVars(resultMsg, fightEnemy);
                FightControl.updateHitPoints("player", damage);
            }
        }
        System.out.println(resultMsg);
        waitSeconds(3);
        return false;
    }
    
   public static String getOperation(int randomInt) {
       if (randomInt == 1) {
           return "+";
       } else if (randomInt == 2) {
           return "-";
       } else if (randomInt == 3) {
           return "*";
       }
       return "+";
   }

    
}
