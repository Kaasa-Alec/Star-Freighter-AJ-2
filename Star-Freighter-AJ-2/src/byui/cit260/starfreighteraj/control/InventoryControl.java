/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import byui.cit260.starfreighteraj.exceptions.InventoryControlException;
import byui.cit260.starfreighteraj.model.InventoryItem;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author AlecSir
 */
public class InventoryControl implements Serializable{
    
    public static int calcVolumeOfCrate (String value) 
            throws InventoryControlException {
        
        System.out.print("Please enter crate length: "); 
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        int length = Integer.parseInt(input);
        
        if (length < 5 || length > 20) {
            System.out.println("\nInvalid crate length: The length cannot be less "
                    + "than 5 or greater than 20 feet long");
        }
        
        System.out.print("\nPlease enter crate height: ");
        keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        int height = Integer.parseInt(input);
        
        if (height < 2 || height > 10) {
            System.out.println("\nInvalid crate height: The height cannot be less "
                    + "than 2 or greater than 10 feet high");
        }
        
        System.out.print("\nPlease enter crate width: ");
        keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        int width = Integer.parseInt(input);
        
        if (width < 2 || width > 8) {
            System.out.println("\nInvalid crate width: The width cannot be less "
                    + "than 2 or greater than 8 feet wide");
        }
 
        int volume = length * height * width;
        
        return volume;
    }
        
}
