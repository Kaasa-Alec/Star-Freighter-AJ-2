/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author JeffJones
 */
public enum Actor implements Serializable{
    
    Bill ("Vendor clerk, Guy at the counter."),
    Riley ("Ship mechanic."),
    Phillip J Bender ("First Officer of the ship, provides hints."),
    Place Holder One ("Random encounter on the station."),
    Place Holder Two ("Provides job opportunity on the station."),
    Smuggler Three ("Game enemy."),
    Pirate Four ("Game enemy.");

    private final String description;
    private final Point coordinates;

    Actor (String description) {
        this.description = description;
        coordinates = new Point (1,1);
    }
    
    public String getDescription() {
        return description;
    }

    public double getCoordinates() {
        return coordinates;
    }

   

    

    @Override
    public String toString() {
        return "Character{" + "name=" + name + ", description=" + description + ", coordinates=" + coordinates + ", statistics=" + statistics + '}';
    }
    
    
    
    
    
}
