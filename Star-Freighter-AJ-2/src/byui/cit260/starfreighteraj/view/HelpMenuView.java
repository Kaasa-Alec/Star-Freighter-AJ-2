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
public class HelpMenuView extends View {
    
    public HelpMenuView() {
              super("\n"
                  + "\n-------------------------------------------"
                  + "\n| Help Menu                               |"
                  + "\n-------------------------------------------"
                  + "\nG - Information about your goal"
                  + "\nM - How to get around"
                  + "\nH - Collecting resources"
                  + "\nD - Ship details"
                  + "\nR - Shop, upgrades and repairs"
                  + "\nQ - Back to Main Menu"
                  + "\n--------------------------------------------");
    }
    
    public boolean doAction(String value) {
        
        value = value.toUpperCase();
        boolean valid = true;
        switch (value) {
            case "G":
                this.displayInfoScreen();
                break;
            case "M":
                this.displayMoveScreen();
                break;
            case "H":
                this.displayCollectScreen();
                break;
            case "D":
                this.displayDetailScreen();
                break;
            case "R":
                this.displayUpgradeScreen();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                valid = false; // HERE WAS THE PROBLEM, WATCH OUT IN FUTURE
                break;
        }
        
        return false;
    }

    private void displayInfoScreen() {
        System.out.println("\n-------------------------------------------------"
                         + "\n| Information about your goal"
                         + "\n-------------------------------------------------"
                         + "\nOptimize your ship!  Among other things, you'll"
                         + "\nneed adequate power in your warp drive, enough "
                         + "\nspace in your cargo bay for the goods entrusted to"
                         + "\nyou by your employers, enough space for the "
                         + "\nsupplies needed to survive the journey! Listen to "
                         + "\nyour first officer's advice. Two heads are better "
                         + "\nthan one."
                         + "\n-------------------------------------------------");
    }

    private void displayMoveScreen() {
        System.out.println("\n-------------------------------------------------"
                         + "\n| How to get around"
                         + "\n-------------------------------------------------"
                         + "\nEvery place you go has a set of destinations, "
                         + "\njust like how you got to the advice in this Help Menu! "
                         + "\nFamiliarize yourself with the space station and select your "
                         + "\ndestination by entering in the letter command used to access "
                         + "\nit."
                         + "\n-------------------------------------------------");
    }

    private void displayCollectScreen() {
        System.out.println("\n-------------------------------------------------"
                         + "\n| Collecting resources"
                         + "\n-------------------------------------------------"
                         + "\nAll over the space station, people have things "
                         + "\nthey need transported to Omacron Persei-8. That's where "
                         + "\nyou're going! If they offer, consider accepting! "
                         + "\nThey'll pay the fee up front. Your first officer "
                         + "\nshould keep a list of goods you're bringing, so heed his "
                         + "\nwarning if you don't have enough space for more merchandise! "
                         + "\nBut be careful. If you don't take on enough jobs, you won't "
                         + "\nmake enough money to finance your business for a return "
                         + "\ntrip to Earth! Select a potential client by entering the"
                         + "\nletter command for them, then determine if you should accept"
                         + "\ntheir offer or not based on your first officer's advice, then"
                         + "\nselect the letter command for either Yes or No."
                         + "\n-------------------------------------------------");
    }

    private void displayDetailScreen() {
        System.out.println("\n-------------------------------------------------"
                         + "\n| Ship Details"
                         + "\n-------------------------------------------------"
                         + "\nThis displays the current stats of your ship, "
                         + "\nincluding how much of each item you have, such as oxygen, "
                         + "\nwarp cells, food, merchandise, etc. A 'yes' or 'no' by each "
                         + "\nitem will tell you if you have enough of it for the "
                         + "\nvoyage."
                         + "\n-------------------------------------------------");
    }

    private void displayUpgradeScreen() {
        System.out.println("\n-------------------------------------------------"
                         + "\n| Shop, upgrades, and repairs"
                         + "\n-------------------------------------------------"
                         + "\nYou buy a few of your items at the shop, namely"
                         + "\nthe functional parts of your ship essential to its operation."
                         + "\nYou'll need money to buy the food, oxygen, shielding, weapons,"
                         + "\nand pylons to replace the hull of your ship, as it's a bit of"
                         + "\na clunker that's been leaking atmosphere. You will choose the"
                         + "\nobjects to purchase at the shop by entering the letter"
                         + "\ncommand for them. But don't worry, because any components will"
                         + "\nbe automatically applied to your ship at no cost! Lucky, right?"
                         + "\n-------------------------------------------------");
    }

    private void displayMainMenuView() {
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
    }
}
