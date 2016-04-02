package byui.cit260.starfreighteraj.model;

import java.io.Serializable;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Enemy implements Serializable  {
    
    private Integer attackBonus = 1;
    private Integer defenseBonus = 1;
    private double hitPoints = 10;
    private String type = "Terror Mites";
    private double maxHitPoints = 10;
    private String name = "Hive";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }

    public double getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(double maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }
    
    public Integer getDefenseBonus() {
        return defenseBonus;
    }

    public void setDefenseBonus(Integer defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    public Enemy() {
    }

    @Override
    public String toString() {
        return "Enemy{" + "attackBonus=" + attackBonus + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.attackBonus);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Enemy other = (Enemy) obj;
        if (!Objects.equals(this.attackBonus, other.attackBonus)) {
            return false;
        }
        return true;
    }
    
    
    public Integer getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(Integer attackBonus) {
        this.attackBonus = attackBonus;
    }

    
}
