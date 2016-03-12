/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.control.ShopControl;
import byui.cit260.starfreighteraj.model.InventoryItem;
import java.util.Scanner;
import star.freighter.aj.StarFreighterAJ;

/**
 *
 * @author JeffJones
 */
public class GameMenuView extends View {
    
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
                System.out.println("\n*** Invalid selection *** Try again");
                valid = false; // HERE WAS THE PROBLEM, WATCH OUT IN FUTURE
                break;
        }
        
        return false;
    }
        
    private void displayInventoryView() {
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\nList of Inventory Items");
        System.out.println("Description" + "\t" +
                           "Required" + "\t" + 
                           "In Stock");
        
        // for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            // DISPLAY the description, the required amount and amount in stock
            System.out.println(inventoryItem.getDescription() + "\t    " +
                               inventoryItem.getRequiredAmount() + "\t    " +
                               inventoryItem.getQuantityInStock());
        }
    }
    
    private void displayMapView() {
        
    }

    private void displayVendorMenu() {
        VendorMenuView vendorMenuView = new VendorMenuView();
        vendorMenuView.display();
    }
    
    private void displayDesignCrateView() {
        DesignCrateView designCrateView = new DesignCrateView();
        designCrateView.display();
    }
  

  //ShopControl.createNewShop(StarFreighterAJ.getPlayer());  

}
