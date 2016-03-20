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
public class InventoryItem implements Serializable{

    private String inventory;
    private int quantityInStock;
    private int requiredAmount;
    private int crateVolume;

    public InventoryItem() {
    }
    
    public String getInventoryType() {
        return inventory;
    }

    public void setInventoryType(String inventory) {
        this.inventory = inventory;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }
    
    public int getCrateVolume(){
        return crateVolume;
    }
    
    public void setCrateVolume(int crateVolume){
        this.crateVolume = crateVolume;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.inventory);
        hash = 31 * hash + this.quantityInStock;
        hash = 31 * hash + this.requiredAmount;
        return hash;
    }

    @Override
    public String toString() {
        return "Inventory{" + "inventoryItem=" + inventory + ", quantityInStock=" + quantityInStock + ", requiredAmount=" + requiredAmount + '}';
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
        final InventoryItem other = (InventoryItem) obj;
        if (this.quantityInStock != other.quantityInStock) {
            return false;
        }
        if (this.requiredAmount != other.requiredAmount) {
            return false;
        }
        if (!Objects.equals(this.inventory, other.inventory)) {
            return false;
        }
        return true;
    }

    public void setDescription(String crates) {
    }

    public String getDescription() {
        System.out.println("\n*** getDescription stub function called ***");
        return null;
    }
}
