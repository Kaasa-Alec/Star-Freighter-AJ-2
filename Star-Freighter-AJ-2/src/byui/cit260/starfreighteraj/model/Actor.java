/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.model;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author JeffJones
 */
public enum Actor implements Serializable{
    
    Bill ("Vendor clerk, Guy at the counter."),
    Riley ("Ship mechanic."),
    Phillip ("First Officer of the ship, provides hints."),
    Dr_Hu ("Works at the MedBay."),
    Engineer_Bob ("Works at Manfacturing Center."),
    Spice_Smuggler ("Game enemy."),
    Space_Corsair ("Game enemy."),
    Terror_Mites("Game enemy.");

    private final String description;
    private final Point coordinates;

    Actor (String description) {
        this.description = description;
        coordinates = new Point(1,1);
    }
    
    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }   
}