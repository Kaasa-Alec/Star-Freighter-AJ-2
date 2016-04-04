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
public class Player implements Serializable{

    // Jeffrey's FightView
    private static Player player;

    // class instance variables
    private String name;
    private int defenseStrategyLvl;
    private int attackStrategyLvl;
    private int hitPoints = 10;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
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
        return "Player{" + "name=" + name + '}';
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }
    private int maxHitPoints = 10;
    
    public int getDefenseStrategyLvl(){
        return defenseStrategyLvl;
    }
    public void setDefenseStrategyLvl(double defenseStrategyLvl){
        this.defenseStrategyLvl=(int) defenseStrategyLvl;
    }
    
    public int getAttackStrategyLvl(){
        return attackStrategyLvl;
    }
    public void setAttackStrategyLvl(double attackStrategyLvl){
        this.attackStrategyLvl=(int) attackStrategyLvl;
    }
    
    
    // Jeffrey's FightView
    public static Player getPlayer() {
        return player;
    }
}