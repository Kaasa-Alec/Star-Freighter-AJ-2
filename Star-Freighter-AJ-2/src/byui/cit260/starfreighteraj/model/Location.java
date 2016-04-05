/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author JeffJones
 */
public class Location implements Serializable{
    
    //class instance variables
    private int row;
    private int column;
    private boolean visited;
    /* Do we need this?
    private int amountRemaining; */
    private Scene scene;
    private ArrayList<Actor> actors;
    public boolean getVisited;
    public boolean setVisited;

    public Location() {
        this.actors = new ArrayList<Actor>();
    }

    public Location(int row, int column, Scene scene, ArrayList<Actor> actors) {
        this.row = row;
        this.column = column;
        this.visited = false;
        this.scene = scene;
        this.actors = actors;
    }
    
    
    public double getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public double getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setExplored(boolean visited) {
        this.visited = visited;
    }

    /* public double getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(int amountRemaining) {
        this.amountRemaining = amountRemaining;
    } */
    
    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.row) ^ (Double.doubleToLongBits(this.row) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.column) ^ (Double.doubleToLongBits(this.column) >>> 32));
        hash = 71 * hash + (this.visited ? 1 : 0);
        /* hash = 71 * hash + (int) (Double.doubleToLongBits(this.amountRemaining) ^ (Double.doubleToLongBits(this.amountRemaining) >>> 32)); */
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
        final Location other = (Location) obj;
        if (Double.doubleToLongBits(this.row) != Double.doubleToLongBits(other.row)) {
            return false;
        }
        if (Double.doubleToLongBits(this.column) != Double.doubleToLongBits(other.column)) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        /* if (Double.doubleToLongBits(this.amountRemaining) != Double.doubleToLongBits(other.amountRemaining)) {
            return false;
        } */
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + '}';
    }

    
    
    
    public void setVisited(boolean newValue) {
        visited = newValue;
    }
    
    public void addActor(Actor actor) {
        if (actor == null || this.actors.contains(actor)) {
            return;
        }
            
        this.actors.add(actor);
    }

    public void removeActor(Actor actor) {
        if (actor == null) {
            return;
        }
        this.actors.remove(actor);
    }
}
