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
import java.util.Scanner;



public class DesignCrateView extends View {
    private InventoryItem volume;

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
         
        System.out.print("Please enter crate length: "); 
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        
        try{
            int length = Integer.parseInt(input);
            
            if (length < 5 || length > 20) {
            System.out.println("\nInvalid crate length: The length cannot be less "
                    + "than 5 or greater than 20 feet long");
            }
        } catch (NumberFormatException nf) {
            System.out.println("\nYou must enter a valid number."
                    + " Try again.");
        }
        
        
        
        
        
        System.out.print("\nPlease enter crate height: ");
        keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        
        try {
            int height = Integer.parseInt(input);
            
            if (height < 2 || height > 10) {
            System.out.println("\nInvalid crate height: The height cannot be less "
                    + "than 2 or greater than 10 feet high");
            }
        } catch (NumberFormatException nf) {
            System.out.println("\nYou must enter a valid number."
                    + " Try again.");
        }
        
        
        
        
        
        System.out.print("\nPlease enter crate width: ");
        keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        
        try {
            int width = Integer.parseInt(input);
            
            if (width < 2 || width > 8) {
            System.out.println("\nInvalid crate width: The width cannot be less "
                    + "than 2 or greater than 8 feet wide");
            }  
        } catch (NumberFormatException nf) {
            System.out.println("\nYou must enter a valid number."
                    + " Try again.");
        }
        
        
        
        
        
        // THIS IS A PROBLEM, BUT I DON'T KNOW ENOUGH ABOUT TRY AND CATCH STATEMENTS
        // TO FIX IT, AND THE PDF EXAMPLE IS COMPLETELY USELESS.  PLEASE HELP.
        
        int volume = length * height * width;        
        
        System.out.println("Volume: " + volume);
        
        this.displayNextView(volume);
        
        return true;
    }

    private void displayNextView(int volume) {
        System.out.println("\n************************************************"
                         + "\n Nice job. Crates with " + volume + " cubic"
                         + "\n feet of space will do quite nicely.          "
                         + "\n************************************************"
                          );
        
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
    }
} 

   
    
