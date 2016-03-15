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
    private boolean upgradeAvailable;
    private String upgradeType;
    private ShipUpgrade obj;

    public ShipUpgrade() {
    }

    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setUpgradeAvailable(boolean b) {

    }

    public void setUpgradeType(String stronger_lasers) {

    }
    
     @Override
    public String toString() {
        return "Upgrade{" + "description=" + description + ", upgradeAvailable=" + upgradeAvailable + ", upgradeType=" + upgradeType + '}';
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
        final ShipUpgrade other = (ShipUpgrade) obj;
        if (this.upgradeAvailable != other.upgradeAvailable) {
            return false;
        }
        if (this.upgradeType != other.upgradeType) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }


    public String getDescription() {
        System.out.println("\n*** getDescription stub function called ***");
        return null;
        
    }
     
     public String getUpgradeAvailable() {
        System.out.println("\n*** getUpgradeAvailable stub function called ***");
        return null;
    }

    public String getUpgradeType() {
        System.out.println("\n*** getUpgradeType stub function called ***");
        return null;
    }
  }


