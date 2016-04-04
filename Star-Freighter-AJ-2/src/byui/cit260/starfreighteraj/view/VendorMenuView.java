/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.InventoryItem;
import byui.cit260.starfreighteraj.model.ShipUpgrade;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import star.freighter.aj.StarFreighterAJ;

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

    @Override
    public boolean doAction(String value) {
        
        try {
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
                    ErrorView.display(this.getClass().getName(), "You must enter a valid selection.");
                    break;
            }
            //moved "return false;" from here to line 80
        } catch (IOException ex) {
            Logger.getLogger(VendorMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private void displayUpgradeView() {
        // get the sorted list of upgrade items for the current game
        ShipUpgrade[] upgrade = GameControl.getSortedUpgradeList();
        
        this.console.println("\nList Upgrade Items");
        this.console.println("Description" + "\t" +
                           "Available" + "\t" +
                            "Type");
        
        // for each inventory item
        for (ShipUpgrade shipUpgrade : upgrade) {
            // DISPLAY the description, the required amount and amount in stock
            this.console.println(shipUpgrade.getDescription() + "\t    " +
                               shipUpgrade.getUpgradeAvailable() + "\t    " +
                               shipUpgrade.getUpgradeType());
        }
    }

    private boolean buyOxygen() throws IOException {
        Game game = StarFreighterAJ.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        
        // Declare price
        int price = 10;
        
        // Prompt user for amount desired
        this.console.println("\nPlease enter the amount you wish to purchase.");
        
        // Get amount desired by user
        String input  = keyboard.readLine();
        
        // Convert amount from string to int
        int amount = parseInt(input);
        
        // Get total by multiplying amount by price
        int total = amount * price;
        
        /* ONLY WAY IT CAN TELL WHAT "credit" IS. NO IDEA HOW TO MAKE IT READ THE
           ACTUAL "credit" ITEM IN THE INVENTORY AND ADD AND SUBTRACT FROM IT. */
        int credit = 100;
        
        // Check to see if total is greater than current funds, display error if so
        if (total > credit) {
            ErrorView.display(this.getClass().getName(), "\nYou don't have enough money.");
            return false;
        }
        
        // Add item to inventory and subtract credits from inventory
        credit -= total;
        
        // Output amount bought, total price, and remaining credits to the user
        this.console.println("\nYou bought " + amount + " orders of Oxygen for " + total + 
	" credits, leaving you with " + credit + " credits remaining.");
        
        // Return to the vendor menu
        return true;
        
    }

    private void buyFood() {
        this.console.println("*** buyFood function called ***");
    }

    private void displayJobsBoard() {
        JobBoardView jobBoardView = new JobBoardView();
        
        jobBoardView.display();
    }
}
