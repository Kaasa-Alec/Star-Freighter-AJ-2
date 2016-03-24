package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.exceptions.GameControlException;
import byui.cit260.starfreighteraj.model.Player;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JeffJones
 */
public class StartProgramView extends View {
    private Player Player;
    
    public StartProgramView() {
        
            super("\n************************************************"
                + "\n*                                              *"
                + "\n* This is the game of Star Freighter           *"
                + "\n* In this game you will build a star freighter *"
                + "\n* to travel through space to deliver the goods *"
                + "\n* entrusted to you by Space Amazon.com         *"
                + "\n*                                              *"
                + "\n* You and your crew will need to first plan    *"
                + "\n* for your trip determining and estimating     *"
                + "\n* the amount of resources needed for the trip. *"
                + "\n* Then you will have to go out and collect the *"
                + "\n* components for your ship and install them.   *"
                + "\n* Be careful and heed the advice of your first *"
                + "\n* officer.  If you have too much or too little *"
                + "\n* of any one resource...well...let's just say  *"
                + "\n* it won't end well for you.                   *"
                + "\n*                                              *"
                + "\n* Good luck and shop smart.                    *"
                + "\n*                                              *"
                + "\n************************************************"
                + "\n                                                "
                + "\nPlease enter your name:");
    }

    @Override
    public boolean doAction(String value) {
        
        if (value.length() < 2) {
            ErrorView.display(this.getClass().getName(), "\nInvalid players name:"
                    + "The name must be greater than one character in length");
        return false;
        }
        
        Player player = null;
        try {
            player = GameControl.createPlayer(value);
        } catch (GameControlException me) {
            this.console.println(me.getMessage());
        }
        
        
        
        this.displayNextView(player);
    
        return true;
        
    }

    private void displayNextView(Player player) {
        this.console.println("\n==========================================="
                          + "\n Welcome to the game " + player.getName()
                          + "\n We hope you have a lot of fun!"
                          + "\n==========================================="
                          );
        
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
    }

}