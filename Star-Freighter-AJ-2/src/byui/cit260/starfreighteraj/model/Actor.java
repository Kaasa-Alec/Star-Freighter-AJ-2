/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.model;

import byui.cit260.starfreighteraj.model.Location;
import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author JeffJones
 */
public enum Actor implements Serializable{
    
    Bill ("Vendor clerk, Guy at the counter."),
    Riley ("Ship mechanic."),
    Phillip ("First Officer of the ship, provides hints."),
    Place_Holder_One ("Random encounter on the station."),
    PlaceHolderTwo ("Provides job opportunity on the station."),
    Smuggler ("Game enemy."),
    Pirate ("Game enemy.");

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