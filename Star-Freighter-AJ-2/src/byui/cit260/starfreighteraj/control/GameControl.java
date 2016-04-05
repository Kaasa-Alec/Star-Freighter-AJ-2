/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import byui.cit260.starfreighteraj.exceptions.GameControlException;
import byui.cit260.starfreighteraj.exceptions.MapControlException;
import byui.cit260.starfreighteraj.model.Actor;
import byui.cit260.starfreighteraj.model.Enemy;
import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.InventoryItem;
import byui.cit260.starfreighteraj.model.Location;
import byui.cit260.starfreighteraj.model.Map;
import byui.cit260.starfreighteraj.model.Player;
import byui.cit260.starfreighteraj.model.ShipModel;
import star.freighter.aj.StarFreighterAJ;
import byui.cit260.starfreighteraj.model.ShipUpgrade;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author AlecSir
 */
public class GameControl {

    // Jeffrey's FightControl, currently hiding values

    public static Player createPlayer(String name) 
                                throws GameControlException {
        
        if (name == null) {
            throw new GameControlException("Error creating the player "
                                          + "Please try again.");
        }
        
        Player player = new Player();
        player.setName(name);
        
        StarFreighterAJ.setPlayer(player);
       
        return player;
    }

    public static void createNewGame(Player player) 
            throws MapControlException {
        
        Game game = new Game(); // create new game
        StarFreighterAJ.setCurrentGame(game); // save in StarFreighterAJ
        
        game.setPlayer(player); // save player in game
                
        // create the inventory list and save in the game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        ShipModel ship = new ShipModel(); // create new starship
        game.setStarShip(ship); // save starship in game 
        
        Map map = MapControl.createMap(); // create and initialize new map
        game.setMap(map); // save map in the game
        
        Actor[] actors = Actor.values();
        
        // move actors to starting position in the map
        MapControl.moveActorsToStartingLocation(map, actors);
    }
        

    public static ShipModel createShip(String name) throws GameControlException {
        
        if (name == null) {
            throw new GameControlException ("Error creating the ship "
                                          + "Please try again.");
        }
        
        ShipModel ship = new ShipModel();
        ship.setName(name);
        
        StarFreighterAJ.setShip(ship);
        
        return ship;
    }
    
    public static InventoryItem[] createInventoryList() {
        
        // created array(list) of inventory items
        InventoryItem[] inventory = 
            new InventoryItem[9];
        
        InventoryItem crate = new InventoryItem();
        crate.setDescription("Crates");
        crate.setQuantityInStock(0);
        crate.setRequiredAmount(10);
        inventory[Item.crate.ordinal()] = crate;
        
        InventoryItem pylon = new InventoryItem();
        pylon.setDescription("Pylon");
        pylon.setQuantityInStock(0);
        pylon.setRequiredAmount(5);
        inventory [Item.pylon.ordinal()] = pylon;
        
        InventoryItem warpCells = new InventoryItem();
        warpCells.setDescription("Warp Cells");
        warpCells.setQuantityInStock(0);
        warpCells.setRequiredAmount(5);
        inventory [Item.warpCells.ordinal()] = warpCells;
        
        InventoryItem shields = new InventoryItem();
        shields.setDescription("Shields");
        shields.setQuantityInStock(0);
        shields.setRequiredAmount(5);
        inventory [Item.shields.ordinal()] = shields;
        
        InventoryItem weapons = new InventoryItem();
        weapons.setDescription("Weapons");
        weapons.setQuantityInStock(0);
        weapons.setRequiredAmount(5);
        inventory [Item.weapons.ordinal()] = weapons;
        
        InventoryItem food = new InventoryItem();
        food.setDescription("Food");
        food.setQuantityInStock(0);
        food.setRequiredAmount(10);
        inventory [Item.food.ordinal()] = food;
        
        InventoryItem oxygen = new InventoryItem();
        oxygen.setDescription("Oxygen");
        oxygen.setQuantityInStock(0);
        oxygen.setRequiredAmount(10);
        inventory [Item.oxygen.ordinal()] = oxygen;
        
        InventoryItem product = new InventoryItem();
        product.setDescription("Product");
        product.setQuantityInStock(0);
        product.setRequiredAmount(20);
        inventory [Item.product.ordinal()] = product;
        
        InventoryItem credit = new InventoryItem();
        credit.setDescription("Credit");
        credit.setQuantityInStock(100);
        credit.setRequiredAmount(0);
        inventory [Item.credit.ordinal()] = credit;
        
        return inventory;
    }

    public static Enemy createEnemy(String enemyName, String enemyType) {
        if (enemyName == null) return null;
        
        Enemy enemy = new Enemy();
        return enemy;
    }

    

    public enum Item {
        crate,
        pylon,
        warpCells,
        shields,
        weapons,
        food,
        oxygen,
        product,
        credit;
    }
        
    public static InventoryItem[] getSortedInventoryList() {
        InventoryItem[] inventoryList = StarFreighterAJ.getCurrentGame().getInventory();
        
        InventoryItem[] sortedInventoryList = inventoryList.clone();
        
        InventoryItem tempInventoryItem;
        for (int i = 0; i < sortedInventoryList.length-1; i++) {
            for (int j = 0; j < sortedInventoryList.length-1-i; j++) {
                if (sortedInventoryList[j].getDescription().
                        compareToIgnoreCase(sortedInventoryList[j + 1].getDescription()) > 0) {
                    tempInventoryItem = sortedInventoryList[j];
                    sortedInventoryList[j] = sortedInventoryList[j+1];
                    sortedInventoryList[j+1] = tempInventoryItem;
                }
            }
        }
        
        return sortedInventoryList;
    }
    
    public static Location[][] getMapLocations() {
        return StarFreighterAJ.getCurrentGame().getMap().getLocations();
    }
    
    /* Dunno if we need this or not
    
    public static ShipUpgrade[] getSortedUpgradeList() {
        System.out.println("\n*** getSortedUpgradeList stub function called ***");
        return null;
    } */
    
    public static InventoryItem[] getInventory() {
        return StarFreighterAJ.getCurrentGame().getInventory();
    }
    
    public static void saveGame(Game game, String filePath) 
            throws GameControlException {
        
        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game); // write the game object out to file
        }
        catch(IOException e) {
            throw new GameControlException(e.getMessage());
        }
    }
    
    public static void getSavedGame(String filepath) 
                        throws GameControlException {
        Game game = null;

        try( FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream output = new ObjectInputStream(fips);
            
            game = (Game) output.readObject(); // read the game object from file
        }
        catch(FileNotFoundException fnfe) {
            throw new GameControlException(fnfe.getMessage());
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }

       // close the outuput file
       StarFreighterAJ.setCurrentGame(game); // save in CuriousWorkmanship
    }
    
    
    
}
