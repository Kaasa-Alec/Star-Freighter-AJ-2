/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.control.ShopControl;
import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.InventoryItem;
import byui.cit260.starfreighteraj.model.Location;
import byui.cit260.starfreighteraj.model.Map;
import static java.lang.Integer.sum;
import java.util.Collections;
import java.util.Scanner;
import star.freighter.aj.StarFreighterAJ;

/**
 *
 * @author JeffJones
 */
public class GameMenuView extends View {

    private Location location;
    private int noOfRows;
    private int noOfColumns;
    private int requiredAmount;
    
    
    public GameMenuView() {
        super("\n"
              + "\n-------------------------------------------"
              + "\n| Game Menu                               |"
              + "\n-------------------------------------------"
              + "\nI - Display Inventory (YOU HAVE TO CREATE THE INVENTORY BY STARTING A NEW GAME FIRST)"
              + "\nM - Display Map"
              + "\nV - Vendor menu"
              + "\nD - Design Crate" 
              + "\nQ - Back to Main Menu"
              + "\nT - TEST SortedInventoryList (YOU HAVE TO CREATE THE INVENTORY BY STARTING A NEW GAME FIRST)" 
              + "\n--------------------------------------------");
    }
        
    @Override
        public boolean doAction(String value) {
        
        value = value.toUpperCase();
        boolean valid = true;
        switch (value) {
            case "I":
                this.displayInventory();
                break;
            case "M":
                this.displayMap();
                break;
            case "V":
                this.displayVendorMenu();
                break;
            case "D":
                this.displayDesignCrateView();
                break;
            case "T":
                this.displaySortedInventoryList();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "You must enter a valid selection.");
                valid = false; // HERE WAS THE PROBLEM, WATCH OUT IN FUTURE
                break;
        }
        
        return false;
    }
        
    private void displayInventory() {
        try {
        
            StringBuilder line;
        
            Game game = StarFreighterAJ.getCurrentGame();
            InventoryItem[] inventory = game.getInventory();
        
            this.console.println("\n         LIST OF INVENTORY ITEMS");
            line = new StringBuilder("                                   ");
            line.insert(0, "DESCRIPTION");
            line.insert(20, "REQUIRED");
            line.insert(30, "IN STOCK");
            this.console.println(line.toString());
        
            for (InventoryItem item : inventory) {
                line = new StringBuilder("                                  ");
                line.insert(0, item.getDescription());
                line.insert(23, item.getRequiredAmount());
                line.insert(33, item.getQuantityInStock());
            
                // DISPLAY the line
                this.console.println(line.toString());
            } 
        } catch (Exception ex) {
                ErrorView.display("GameMenuView", ex.getMessage());
        }
    }
    
    private void displayMap() {
        
        // get the map locations from the current game
        Location[][] locations = GameControl.getMapLocations();
        //DISPLAY title
        this.console.println("\nView Map");
        //DISPLAY row of column numbers
        this.console.println("1" + "\t" + "2" + "\t" + "3" + "\t" + "4");
        
        //FOR every row in map
        for (int row = 0; row < noOfRows; row++) {
            //DISPLAY row divider
            this.console.println("\n**********************************************");
            //DISPLAY row number
            this.console.println(row);
            //FOR every column in row
            for (int column = 0; column < noOfColumns; column++) {
                //DISPLAY column divider
                this.console.println("\n | ");
                //location = locations[row][column]
                locations[0][0] = location;
                //IF location has been visited
                if (locations[row][column].getVisited && locations[row][column].getVisited == false){
                    // DISPLAY the map symbol for location
                    this.console.println(" ~~~~ ");
                //ENDIF
                }
                //ELSE
                else {
                    //DISPLAY " ?? "
                    this.console.println(" ?? ");
                    //ENDELSE
                        }
                //DISPLAY ending column divider
                this.console.println("\n | ");
            //ENDFOR
            }
            //DISPLAY ending row divider
            this.console.println("\n**********************************************");
        //END
        }
    }

    private void displayVendorMenu() {
        VendorMenuView vendorMenuView = new VendorMenuView();
        vendorMenuView.display();
    }
    
    private void displayDesignCrateView() {
        DesignCrateView designCrateView = new DesignCrateView();
        designCrateView.display();
    }

    private void displaySortedInventoryList() {
        try {
            
            StringBuilder line;
        
            Game game = StarFreighterAJ.getCurrentGame();
            InventoryItem[] inventory = game.getInventory();
        
            int sum = 0;
        
            this.console.println("\n         INVENTORY ITEM TOTALS");
            line = new StringBuilder("                                   ");
            line.insert(0, "DESCRIPTION");
            line.insert(20, "REQUIRED");
            line.insert(30, "IN STOCK");
            this.console.println(line.toString());
        
            for (InventoryItem item : inventory) {
                line = new StringBuilder("                                  ");
                line.insert(0, item.getDescription());
                line.insert(23, item.getRequiredAmount());
                line.insert(33, item.getQuantityInStock());
            
                // Get the required amount
                requiredAmount = item.getRequiredAmount();     
                // DISPLAY the line
                this.console.println(line.toString());
                sum += requiredAmount;
            }
        
            this.console.println("\nThe total required amount of items is " 
                    + sum + ".");
        } catch (Exception ex) {
                ErrorView.display("GameMenuView", ex.getMessage());
        }
    }
}