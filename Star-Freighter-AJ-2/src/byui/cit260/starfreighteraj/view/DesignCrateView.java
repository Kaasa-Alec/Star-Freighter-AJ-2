/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;


import byui.cit260.starfreighteraj.control.GameControl;
import static byui.cit260.starfreighteraj.control.GameControl.Item.crate;
import java.util.Scanner;



public class DesignCrateView extends View {

    
    public DesignCrateView() {
        super("\nPlease enter crate volume measurements:");
    }
        
    @Override
    public boolean doAction(String value) {
        
        if (value.length() < 3 ) {
            System.out.println("\nInvalid value:"
                    + "Volume must be more than two characters");
        return false;
        }
        this.displayNextCrateView(crate);
        
        return true;
    }

    private void displayNextCrateView(GameControl.Item item) {
        System.out.println("*** displayNextCrateView function called ***");
    }
} 

   
    
