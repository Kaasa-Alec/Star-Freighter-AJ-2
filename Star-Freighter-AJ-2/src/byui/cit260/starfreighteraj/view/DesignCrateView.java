/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;


import byui.cit260.starfreighteraj.control.GameControl;
import static byui.cit260.starfreighteraj.control.GameControl.Item.crate;
import byui.cit260.starfreighteraj.control.InventoryControl;
import byui.cit260.starfreighteraj.exceptions.InventoryControlException;
import byui.cit260.starfreighteraj.model.InventoryItem;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DesignCrateView extends View {

    public DesignCrateView() {
        super("\n************************************************"
            + "\n* Alright, sir, we've got to design the crates *"
            + "\n* we'll be using to carry our goods, as well   *"
            + "\n* as our own resources. No need to worry about *"
            + "\n* the cost. The shipping company has already   *"
            + "\n* paid for the shipping crates, but it's up to *"
            + "\n* us to tell the staff how big we want them.   *"
            + "\n* Enter 'OK' to go on.                         *"
            + "\n************************************************");
    }
        
    @Override
    public boolean doAction(String value) {
         
        try {
            
            this.console.println("Please enter crate length: ");
            String input = keyboard.readLine();
            int length = Integer.parseInt(input);
            
            try {
                
                if (length < 5 || length > 20) {
                    ErrorView.display(this.getClass().getName(), "\nInvalid crate length: The length cannot be less "
                            + "than 5 or greater than 20 feet long.");
                }
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number."
                        + " Try again." + e.getMessage());
            }
            
            
            this.console.println("\nPlease enter crate height: ");
            input = keyboard.readLine();
            
            int height = Integer.parseInt(input);
            
            try {
                
                if (height < 2 || height > 10) {
                    ErrorView.display(this.getClass().getName(), "\nInvalid crate height: The height cannot be less "
                            + "than 2 or greater than 10 feet high");
                }
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number."
                        + " Try again." + e.getMessage());
            }
            
            
            
            
            
            
            this.console.println("\nPlease enter crate width: ");
            input = keyboard.readLine();
            
            int width = Integer.parseInt(input);
            
            try {
                
                if (width < 2 || width > 8) {
                    ErrorView.display(this.getClass().getName(), "\nInvalid crate width: The width cannot be less "
                            + "than 2 or greater than 8 feet wide");
                }
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number."
                        + " Try again." + e.getMessage());
            }
            
            
            
            
            
            
            int volume = (length * height * width);
            
            this.console.println("Volume: " + volume);
            
            this.displayNextView(volume);
            
        } catch (IOException ex) {
            Logger.getLogger(DesignCrateView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private void displayNextView(int volume) {
        this.console.println("\n************************************************"
                         + "\n Nice job. Crates with " + volume + " cubic"
                         + "\n feet of space will do quite nicely.          "
                         + "\n************************************************"
                          );
        
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
    }
} 

   
    
