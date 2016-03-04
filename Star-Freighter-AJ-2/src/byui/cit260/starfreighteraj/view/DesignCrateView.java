/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import java.util.Scanner;

/**
 *
 * @author JeffJones
 */
public class DesignCrateView {

    //code not finished, and in need of revision
    
    private final String promptMessage;
    
    public DesignCrateView() {
        this.promptMessage = "\nPlease enter crate volume measurements:";
        
    

    public void displayDesignCrateView() {
        
        boolean done = false; //set flag to not done
        do {
            //prompt for and get players name
            String crateVolume = this.getInput();
            if (crateVolume.toUpperCase().equals("Q")) // user wants to quit
                return; //exit the game
            
            // do the requested action and display the next view
            done = this.doAction(crateVolume);
        } while (!done);
        
     }
    
    private String getInput(){
        
        Scanner keyboard = new Scanner(System.in);
        String value = ""; 
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.crateVolume() < 160 && value.crateVolume() >= 161) {
                System.out.println("\nInvalid entry."); 
                return false;
                
            }
            
            break;
        }
        
        return value;
    }

    private boolean doAction(String crateVolume) {
        
    }
    
}
