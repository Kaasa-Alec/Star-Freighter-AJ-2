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
public class ShipUpgrade implements Serializable{
    
    private String description;
    private double travelTime;
    private boolean blocked;
    private boolean upgradeAvailable;
    private String upgradeType;

    public ShipUpgrade() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean b) {
        
    }

    public void setUpgradeAvailable(boolean b) {

    }

    public void setUpgradeType(String stronger_lasers) {

    }
  }


