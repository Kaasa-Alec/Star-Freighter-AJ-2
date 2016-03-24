/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import star.freighter.aj.StarFreighterAJ;

/**
 *
 * @author AlecSir
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    protected final BufferedReader keyboard = StarFreighterAJ.getInFile();
    protected final PrintWriter console = StarFreighterAJ.getOutFile();
    
    public View() {
        
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
        
        boolean done = false;
        do {
            // prompt for and get value
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the view
            
            // do the requested action and display the next view
            done = this.doAction(value);
            
        } while (!done); // exit the view when done == true
        
    }
    
    @Override
    public String getInput() {
        
        
        boolean valid = false;
        String value = null;
        
        // while a valid name has not been retrieved
        while (!valid) {
            
            try {
                // prompt for the player's name
                this.console.println("\n" + this.displayMessage);
                
                // get the value entered from the keyboard
                value = keyboard.readLine();
                value = value.trim();
                
                if (value.length() < 1) { // blank value entered
                    ErrorView.display(this.getClass().getName(),
                                      "You must enter a value.");
                    continue;
                }
                
                break;
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return value; // return the name
    }
    
}
