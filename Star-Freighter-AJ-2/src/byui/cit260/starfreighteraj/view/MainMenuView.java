/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.exceptions.MapControlException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import star.freighter.aj.StarFreighterAJ;



/**
 *
 * @author JeffJones
 */
public class MainMenuView extends View {
    
    public MainMenuView() {

        super("\n"
            + "\n-------------------------------------------"
            + "\n| Main Menu                               |"
            + "\n-------------------------------------------"
            + "\nN - Start new game"
            + "\nL - Load and start saved game"
            + "\nG - Game menu"
            + "\nH - Get help on how to play the game"
            + "\nS - Save game"
            + "\nQ - Quit game"
            + "\nT - TEST - ShipNameView"
            + "\nZ - TEST - DesignCrateView"   
            + "\n--------------------------------------------");
    }
    
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase();
        
        switch (value) {
            case "N":
        {
            try {
                this.startNewGame();
            } catch (MapControlException me) {
               System.out.println(me.getMessage());
            }
        }
                break;
            case "L":
                this.startExistingGame();
                break;
            case "G":
                this.displayGameMenu();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "S":
                this.saveGame();
                break;
// There was no Q - "Quit game" set up in your MainMenuView so it was passing to the default, which is why
// it was returning to the HelpMenuView.  This also will allow the game to break from this menu.
            case "Q":
                break; //I dunno if this was the real problem, because there's 
                // the bit above in the displayMainMenu function, but maybe we should include it to be safe from now on.
            case "T": //TEMPORARY FOR TESTING
                this.displayShipNameView();
                break;
            case "Z":
                this.displayDesignCrateView();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void startNewGame() throws MapControlException {
        GameControl.createNewGame(StarFreighterAJ.getPlayer());
        
    }

    private void startExistingGame() {
        System.out.println("*** startExistingGame function called ***");

    }
    
    private void displayGameMenu() {
        GameMenuView gameMenuView = new GameMenuView();
        
        gameMenuView.display();
        
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        
        helpMenuView.display();
    }
    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }

    //TEMPORARY FOR TESTING
    private void displayShipNameView() {
        ShipNameView shipNameView = new ShipNameView();
        
        shipNameView.display();
    }

    private void displayDesignCrateView() {
        DesignCrateView designCrateView = new DesignCrateView();
        
        designCrateView.display();
    }

}
