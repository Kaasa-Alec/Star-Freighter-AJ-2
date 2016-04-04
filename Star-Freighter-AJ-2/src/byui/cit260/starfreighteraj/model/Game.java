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
public class Game implements Serializable  {
    
    //class instance variable
    private double totalTime;
    private ShipModel starship;
    private InventoryItem[] inventory;
    private Player player;
    private String [] actors;
    private Map map;
    private Point[] actorsLocation = new Point[Actor.values().length];
    private Enemy enemy;

    public Game() {
        this.totalTime = 0;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    
    // Jeffrey's actorReport in the GameMenuView
    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public Point[] getActorsLocation() {
        return actorsLocation;
    }

    public void setActorsLocation(Point[] actorsLocation) {
        this.actorsLocation = actorsLocation;
    }
    
    public ShipModel getStarShip() {
        return starship;
    }

    public void setStarShip(ShipModel starship) {
        this.starship = starship;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + '}';
    }    

    public Enemy getEnemy() {
        return enemy;
    }
    
}