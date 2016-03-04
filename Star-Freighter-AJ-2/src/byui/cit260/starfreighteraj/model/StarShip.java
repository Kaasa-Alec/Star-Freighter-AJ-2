/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.model;

import java.io.Serializable;

/**
 *
 * @author JeffJones
 */
public class StarShip implements Serializable{

    public StarShip() {
    }
    
    
    
    //class instance variables
    private double hull;
    private double sensors;
    private double cargoBays;
    private double weaponTurrets;
    private double shields;
    private double maxFuelCapacity;

    public double getHull() {
        return hull;
    }

    public void setHull(double hull) {
        this.hull = hull;
    }

    public double getSensors() {
        return sensors;
    }

    public void setSensors(double sensors) {
        this.sensors = sensors;
    }

    public double getCargoBays() {
        return cargoBays;
    }

    public void setCargoBays(double cargoBays) {
        this.cargoBays = cargoBays;
    }

    public double getWeaponTurrets() {
        return weaponTurrets;
    }

    public void setWeaponTurrets(double weaponTurrets) {
        this.weaponTurrets = weaponTurrets;
    }

    public double getShields() {
        return shields;
    }

    public void setShields(double shields) {
        this.shields = shields;
    }

    public double getMaxFuelCapacity() {
        return maxFuelCapacity;
    }

    public void setMaxFuelCapacity(double maxFuelCapacity) {
        this.maxFuelCapacity = maxFuelCapacity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.hull) ^ (Double.doubleToLongBits(this.hull) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.sensors) ^ (Double.doubleToLongBits(this.sensors) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.cargoBays) ^ (Double.doubleToLongBits(this.cargoBays) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.weaponTurrets) ^ (Double.doubleToLongBits(this.weaponTurrets) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.shields) ^ (Double.doubleToLongBits(this.shields) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.maxFuelCapacity) ^ (Double.doubleToLongBits(this.maxFuelCapacity) >>> 32));
        return hash;
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
        final StarShip other = (StarShip) obj;
        if (Double.doubleToLongBits(this.hull) != Double.doubleToLongBits(other.hull)) {
            return false;
        }
        if (Double.doubleToLongBits(this.sensors) != Double.doubleToLongBits(other.sensors)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cargoBays) != Double.doubleToLongBits(other.cargoBays)) {
            return false;
        }
        if (Double.doubleToLongBits(this.weaponTurrets) != Double.doubleToLongBits(other.weaponTurrets)) {
            return false;
        }
        if (Double.doubleToLongBits(this.shields) != Double.doubleToLongBits(other.shields)) {
            return false;
        }
        if (Double.doubleToLongBits(this.maxFuelCapacity) != Double.doubleToLongBits(other.maxFuelCapacity)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StarShip{" + "hull=" + hull + ", sensors=" + sensors + ", cargoBays=" + cargoBays + ", weaponTurrets=" + weaponTurrets + ", shields=" + shields + ", maxFuelCapacity=" + maxFuelCapacity + '}';
    }
    
    
    
    
}
