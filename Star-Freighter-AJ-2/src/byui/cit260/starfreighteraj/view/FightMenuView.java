/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.FightTemplateControl;
import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.model.Enemy;

/**
 *
 * @author JeffJones
 */
public class FightMenuView extends View {
    
    private final String FightMENU = "\n"
            +"\n------------------------------"
            +"\n You encounter an enemy"
            +"\n------------------------------"
            +"\nB - Begin Fight"
            +"\nN - Negotiate for peace"
            +"\nR - RUN!"
            +"\n------------------------------";
    
    private final String PEACE = "\n"
            +"\n You attempt to convince {enemyname} that they will"
            +"\n be defeated by your superior. However"
            +"\n your attempts to intimidate {enemytype} were in vain.";
    
    private Enemy enemy = null;
    
    private String actionResult = "";
    private int fightProgress;
        
    /**
     * displays the menu to go into fight.
     */
    @Override
    public void display() {
        
        String enemyName = "Hive";
        String enemyType = "Terror Mites";
        enemy = GameControl.createEnemy(enemyName, enemyType);
        String fightMsg = FightTemplateControl.updateEnemyVars(FightMENU, enemy);
        char selection = ' ';
        String input;
        do {
            
            this.console.println(fightMsg);
            input = this.getInput().toUpperCase();
            
            this.doAction(input);
            if (!"".equals(actionResult)) {
                break;
            }
        } while (!"R".equals(input.toUpperCase()));
    }
    
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase();
        char choice = value.charAt(0);
        
        switch (choice){
            case 'B':
                actionResult = this.beginFight();
                break;
            case 'N':
                actionResult = this.negotiatePeace();
                break;    
            case 'R':
                return true;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    
    private String beginFight() {
        FightView fightView = new FightView();
        return fightView.displayFight(enemy);
    }

    private String negotiatePeace() {
        String peaceMsg = FightTemplateControl.updateEnemyVars(PEACE, enemy);
        this.console.println(peaceMsg);
        return this.beginFight();
    }
}
