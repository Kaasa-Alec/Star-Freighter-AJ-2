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
 * @author AlecSir
 */
public class ShipModel implements Serializable{
    
    // class instance variables
    private String name;
    private String description;
    private double width;
    private double length;
    private double height;
    private double maxCapacity;

    public ShipModel() {
        this.description = "\nThis is the ship your dad left you when he died."
                         + "\nHe always dreamed that you'd one day follow in his"
                         + "\nfootsteps, and now that you've flunked out of the"
                         + "\nUniversity of Arboles Mentirosos, looks like "
                         + "\nyou've run out of options."
                         + "\n"
                         + "\nShe's old and rickety, but if you fix her up,"
                         + "\nyou might just be able to pay off those student"
                         + "\nloans and make a profit while you're at it.";
        this.width = 0;
        this.length = 0;
        this.height = 0;
        this.maxCapacity = 0;
        
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public String toString() {
        return "ShipModel{" + "name=" + name + '}';
    }

    
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        
        return true;
    }

}