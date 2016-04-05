/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.model;

import byui.cit260.starfreighteraj.view.ErrorView;
import java.io.Serializable;

/**
 *
 * @author JeffJones
 */
public class Map implements Serializable{
    
    //class instance variables
    private Location[][] locations;
    private int noOfRows;
    private int noOfColumns;

    public Map() {
    }
    
    public Map(int noOfRows, int noOfColumns) {
        
        if (noOfRows < 1 || noOfColumns < 1) {
            ErrorView.display(this.getClass().getName(), "The numbers of rows and columns have to be greater than zero");
            return;
        }
        
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        
        // create a 2-D array for the Location objects
        this.locations = new Location[noOfRows][noOfColumns];
        
        for (int row = 0; row < noOfRows; row++) {
            
            for (int column = 0; column < noOfColumns; column++) {

                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
            
                locations[row][column] = location;
            }
        }
    }
    
    public Location[][] getLocations() {
        return locations;
    }
    
    public void setLocations(Location [][] locations) {
        this.locations = locations;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }
    
    @Override
    public String toString() {
        return "Map{" + "noOfRows=" + noOfRows + ", noOfColumns=" + noOfColumns + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.noOfRows ^ (this.noOfRows >>> 31));
        hash = 29 * hash + (int) (this.noOfColumns ^ (this.noOfColumns >>> 31));
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
        final Map other = (Map) obj;
        if (this.noOfRows != other.noOfRows) {
            return false;
        }
        if (this.noOfColumns != other.noOfColumns) {
            return false;
        }
        return true;
    }
}