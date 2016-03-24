/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import java.util.Scanner;

/**
 *
 * @author AlecSir
 */
public class JobBoardView extends View {
    
    public JobBoardView() {
        super("\n************************************************"
                           + "\n*----------------------------------------------*"
                           + "\n*|Guy at the Counter                          |*"
                           + "\n*----------------------------------------------*"
                           + "\n*                                              *"
                           + "\n* 'Oh, those? Those are board postings of jobs *"
                           + "\n* folks need done. A lot of them are transport *"
                           + "\n* so maybe you should consider signing up for  *"
                           + "\n* a few. I've got the money here, so let me    *"
                           + "\n* know which ones you'd like. But be careful   *"
                           + "\n* which you choose. Don't go spending the      *"
                           + "\n* money then changing your mind.'              *"
                           + "\n*                                              *"
                           + "\n************************************************"
                           + "\n                                                "
                           + "\n------------------------------------------------"
                           + "\n| Job Board                                    |"
                           + "\n------------------------------------------------"
                           + "\nA - Job A"
                           + "\nB - Job B"
                           + "\nC - Job C"
                           + "\nD - Job D"
                           + "\nE - Job E"
                           + "\nF - Job F"
                           + "\nQ - Back to Vendor"
                           + "\n------------------------------------------------");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean valid = true;
        switch (value) {
            case "A":
                this.displayJobA();
                break;
            case "B":
                this.displayJobB();
                break;
            case "C":
                this.displayJobC();
                break;
            case "D":
                this.displayJobD();
                break;
            case "E":
                this.displayJobE();
                break;
            case "F":
                this.displayJobF();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "You must enter a valid selection.");
                valid = false;
                break;
    }
        return false;
}

    private void displayJobA() {
        this.console.println("*** displayJobA function called ***");
    }

    private void displayJobB() {
        this.console.println("*** displayJobB function called ***");
    }

    private void displayJobC() {
        this.console.println("*** displayJobC function called ***");
    }

    private void displayJobD() {
        this.console.println("*** displayJobD function called ***");
    }

    private void displayJobE() {
        this.console.println("*** displayJobE function called ***");
    }

    private void displayJobF() {
        this.console.println("*** displayJobF function called ***");
    }
}