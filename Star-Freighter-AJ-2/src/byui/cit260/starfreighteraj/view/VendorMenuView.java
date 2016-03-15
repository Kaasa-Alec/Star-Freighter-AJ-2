/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.model.ShipUpgrade;
import java.util.Scanner;

/**
 *
 * @author AlecSir
 */
public class VendorMenuView extends View{

    public VendorMenuView() {
        super("\n************************************************"
              + "\n*----------------------------------------------*"
              + "\n*|Guy at the Counter                          |*"
              + "\n*----------------------------------------------*"
              + "\n*                                              *"
              + "\n* 'Welcome to the vendor! Here you will find   *"
              + "\n* all products necessary to keep your crew fed *"
              + "\n* and sustained during interstellar space      *"
              + "\n* travel. If you're looking for ship parts,    *"
              + "\n* those would be at the Maintenance Hangar.    *"
              + "\n* ...Oh, you're /that/ ship captain? Yeah, I   *"
              + "\n* got a look at your freighter. It's a bit of  *"
              + "\n* a wreck, isn't it? You'll definitely need    *"
              + "\n* some new oxygen cells and plenty of food.    *"
              + "\n* What can I get you?'                         *"
              + "\n*                                              *"
              + "\n************************************************"
              + "\n                                                "
              + "\n------------------------------------------------"
              + "\n| Vendor                                       |"
              + "\n------------------------------------------------"
              + "\nO - Oxygen"
              + "\nF - Food"
              + "\nJ - Job Board"
              + "\nS - Ship upgrades available"  
              + "\nQ - Leave Vendor"
              + "\n------------------------------------------------");
        
    }

    public boolean doAction(String value) {
        
        value = value.toUpperCase();
        
        switch (value) {
            case "O":
                this.buyOxygen();
                break;
            case "F":
                this.buyFood();
                break;
            case "J":
                this.displayJobsBoard();
                break;
            case "S":
                this.displayUpgradeView();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    
    }
    
    private void displayUpgradeView() {
        // get the sorted list of upgrade items for the current game
        ShipUpgrade[] upgrade = GameControl.getSortedUpgradeList();
        
        System.out.println("\nList Upgrade Items");
        System.out.println("Description" + "\t" +
                           "Available");
        
        // for each inventory item
        for (ShipUpgrade upgradeItem : upgrade) {
            // DISPLAY the description, the required amount and amount in stock
            System.out.println(upgradeItem.getDescription() + "\t    " +
                               upgradeItem.getUpgradeAvailable());
        }
    }

    private void buyOxygen() {
        System.out.println("*** buyOxygen function called ***");
    }

    private void buyFood() {
        System.out.println("*** buyFood function called ***");
    }

    private void displayJobsBoard() {
        JobBoardView jobBoardView = new JobBoardView();
        
        jobBoardView.display();
    }
}
