/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.control.ShopControl;
import byui.cit260.starfreighteraj.model.InventoryItem;
import byui.cit260.starfreighteraj.model.Location;
import byui.cit260.starfreighteraj.model.Map;
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
    
    
    public GameMenuView() {
        super("\n"
              + "\n-------------------------------------------"
              + "\n| Game Menu                               |"
              + "\n-------------------------------------------"
              + "\nI - Inventory"
              + "\nL - Location chooser"
              + "\nV - Vendor menu"
              + "\nD - Design Crate" 
              + "\nQ - Back to Main Menu"
              + "\n--------------------------------------------");
    }
        
        public boolean doAction(String value) {
        
        value = value.toUpperCase();
        boolean valid = true;
        switch (value) {
            case "I":
                this.displayInventoryView();
                break;
            case "L":
                this.displayMapView();
                break;
            case "V":
                this.displayVendorMenu();
                break;
            case "D":
                this.displayDesignCrateView();
                break;    
            default:
                ErrorView.display(this.getClass().getName(), "You must enter a valid selection.");
                valid = false; // HERE WAS THE PROBLEM, WATCH OUT IN FUTURE
                break;
        }
        
        return false;
    }
        
    private void displayInventoryView() {
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        this.console.println("\nList of Inventory Items");
        this.console.println("Description" + "\t" +
                           "Required" + "\t" + 
                           "In Stock");
        
        // for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            // DISPLAY the description, the required amount and amount in stock
            this.console.println(inventoryItem.getDescription() + "\t    " +
                               inventoryItem.getRequiredAmount() + "\t    " +
                               inventoryItem.getQuantityInStock());
        }
    }
    
    private void displayMapView() {
        
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
}
