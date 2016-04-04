/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import byui.cit260.starfreighteraj.control.GameControl;
import byui.cit260.starfreighteraj.exceptions.GameControlException;
import byui.cit260.starfreighteraj.model.ShipModel;

/**
 *
 * @author AlecSir
 */
public class ShipNameView extends View {
    public ShipModel ship;
    
    public ShipNameView() {
        
            super("\n************************************************"
                + "\n*                                              *"
                + "\n* What an exciting day! It feels like you've   *"
                + "\n* been cramped up in that space station        *"
                + "\n* forever! Finally, the time has come to       *"
                + "\n* depart for Omacron Persei-8! But before you  *"
                + "\n* leave on your maiden voyage, don't you think *"
                + "\n* you should give the ship a name? At the very *"
                + "\n* least, it might help them identify your body *"
                + "\n* in case something goes wrong, so go ahead    *"
                + "\n* and give it a try! Grab that paintbrush and  *"
                + "\n* give the flagship of your future shipping    *"
                + "\n* fleet an awesome name!                       *"
                + "\n*                                              *"
                + "\n************************************************"
                + "\n                                                "
                + "\nPlease enter the name of your ship:");
    }
    
    @Override
    public boolean doAction(String value) {
        
        try {
            
            if (value.length() < 2) {
            ErrorView.display(this.getClass().getName(), "\nInvalid ship name: The name must be greater "
                    + "than one character in length");
            return false;
            }
            ship = GameControl.createShip(value);
        } catch (GameControlException e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
        
        this.displayNextView(ship);
    
        return true;
        
    }

    private void displayNextView(ShipModel ship) {
        
        if (ship.getName().toUpperCase().equals("ENTERPRISE")) {
            this.console.println(
                         "\n************************************************"
                       + "\n*                                              *"
                       + "\n* 'Enterprise,' huh? How original. Did you     *"
                       + "\n* think of that all on your own? I bet you're  *" 
                       + "\n* feelin' reeeeaaaally proud of yourself,      *"
                       + "\n* aren't you?                                  *"
                       + "\n*                                              *"
                       + "\n* Alright, whatever. In any case, the ship's   *"
                       + "\n* all done, and now all that remains is to     *"
                       + "\n* have one last look around the place and make *"
                       + "\n* sure that we have everything we need. We     *"
                       + "\n* wouldn't want to run out of air or food in   *"
                       + "\n* space. And we certainly wouldn't want to be  *"
                       + "\n* caught off-guard if pirates show up. Take    *"
                       + "\n* another look before we shove off and let's   *"
                       + "\n* get under way, captain!                      *"
                       + "\n*                                              *"
                       + "\n************************************************"
                       );
        }
        else {
            this.console.println(
                         "\n************************************************"
                       + "\n                                                "
                       + "\n Wow, '" + ship.getName() + "' is an awesome    "
                       + "\n name! People everywhere will empty their       "
                       + "\n wallets whenever they hear it! Now that        "
                       + "\n we are all done, all that remains is to        "
                       + "\n have one last look around the place and make   "
                       + "\n sure that we have everything we need. We       "
                       + "\n wouldn't want to run out of air or food in     "
                       + "\n space. And we certainly wouldn't want to be    "
                       + "\n caught off-guard if pirates show up. Take      "
                       + "\n another look before we shove off and let's get "
                       + "\n under way, captain!                            "
                       + "\n                                                "
                       + "\n************************************************"
                       );
        }
        
        return;
    }
}