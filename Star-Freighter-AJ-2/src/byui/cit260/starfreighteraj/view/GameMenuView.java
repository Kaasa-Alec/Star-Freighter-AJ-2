/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.InventoryItem;
import byui.cit260.starfreighteraj.model.Location;
import byui.cit260.starfreighteraj.model.Map;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.sum;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
              + "\nR - TEST - PrintReport"
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
                
            case "R":
        {
            try {
                this.reportFilePath();
            } catch (IOException ex) {
                Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
                
            default:
                ErrorView.display(this.getClass().getName(), "You must enter a valid selection.");
                valid = false;
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
    
    private void reportFilePath() throws IOException {
	
        // a.  Prompt the user for a file path of where the report is to be printed.
	this.console.println("\n\nEnter the file path for where the report is to be printed.");
		
	// b.  Get the file path entered by the end user.
	String filePath = keyboard.readLine();

	/* c.  Call another View Layer function that actually prints the report.  Maybe do 
	quotation marks around filePath */
	this.printReport(filePath);
		
    }
        
    public void printReport(String filePath) throws IOException {
	
	FileWriter outFile = null; // define a variable for a file stream
		
	try {
            // create and open new file stream for the output file
            outFile = new FileWriter(filePath);
            
            Game game = StarFreighterAJ.getCurrentGame();
            InventoryItem[] inventory = game.getInventory();
			
            // The report must include a title and column headings
            outFile.write("\n         LIST OF INVENTORY ITEMS");
            outFile.write("\nDESCRIPTION \t");
            outFile.write("REQUIRED \t");
            outFile.write("IN STOCK \t\n");
        
            /* use a for statement to go through the list of items to be displayed, having
            at least two columns of data for each item in the list. */
            for (InventoryItem item : inventory) {
                outFile.write(item.getDescription() + "\t");
                outFile.write(item.getRequiredAmount() + "\t");
                outFile.write(item.getQuantityInStock() + "\t\n");
            } 
		} catch (IOException ex) {
			this.console.println("Error printing report to file");
		} finally {
			if (outFile != null) { // if the file was successfully created
				outFile.close(); // close the file stream
				
				/* Display a success message to the console if the report was printed
				successfully to the specified file path. */
				this.console.println("Success!");
			}
		}
	}
}