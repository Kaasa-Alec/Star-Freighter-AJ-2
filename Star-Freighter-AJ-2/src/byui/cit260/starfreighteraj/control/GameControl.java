/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import byui.cit260.starfreighteraj.control.MapControl.SceneType;
import byui.cit260.starfreighteraj.exceptions.GameControlException;
import byui.cit260.starfreighteraj.exceptions.InventoryControlException;
import byui.cit260.starfreighteraj.exceptions.MapControlException;
import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.InventoryItem;
import byui.cit260.starfreighteraj.model.Location;
import byui.cit260.starfreighteraj.model.Map;
import byui.cit260.starfreighteraj.model.Player;
import byui.cit260.starfreighteraj.model.Scene;
import byui.cit260.starfreighteraj.model.ShipModel;
import star.freighter.aj.StarFreighterAJ;
import byui.cit260.starfreighteraj.model.ShipUpgrade;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author AlecSir
 */
public class GameControl {

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

    public static void createNewGame(Player player) throws MapControlException {
        Game game = new Game(); //create new game
        StarFreighterAJ.setCurrentGame(game); //save in StarFreighterAJ
        
        game.setPlayer(player); //save player in game
                
        //create the inventory list and save in the game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        ShipModel ship = new ShipModel(); //create new starship
        game.setStarShip(ship); //save starship in game 
        
        Map map = MapControl.createMap(); //create and initialize new map
        game.setMap(map); //save map in game
        
        //move actors to starting position in the map
        MapControl.moveActorsToStartingLocation(map);
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
    
    public static void createCrate(int crateVolume) throws InventoryControlException {
        
        if (crateVolume == -1) {
            throw new InventoryControlException ("Error creating the crate"
                    + "Please try again.");
        }
        
        InventoryItem crate = new InventoryItem();
        crate.setCrateVolume(crateVolume);
        
        StarFreighterAJ.setCrate(crate);
        
    }

    public static InventoryItem[] createInventoryList() {
        
        // created array(list) of inventory items
        InventoryItem[] inventory = 
                new InventoryItem[8];
        
        InventoryItem crate = new InventoryItem();
        crate.setDescription("Crates");
        crate.setQuantityInStock(0);
        crate.setRequiredAmount(0);
        inventory[Item.crate.ordinal()] = crate;
        
        InventoryItem pylon = new InventoryItem();
        pylon.setDescription("Pylon");
        pylon.setQuantityInStock(0);
        pylon.setRequiredAmount(0);
        inventory [Item.pylon.ordinal()] = pylon;
        
        InventoryItem warpCells = new InventoryItem();
        warpCells.setDescription("Warp Cells");
        warpCells.setQuantityInStock(0);
        warpCells.setRequiredAmount(0);
        inventory [Item.warpCells.ordinal()] = warpCells;
        
        InventoryItem shields = new InventoryItem();
        shields.setDescription("Shields");
        shields.setQuantityInStock(0);
        shields.setRequiredAmount(0);
        inventory [Item.shields.ordinal()] = shields;
        
        InventoryItem weapons = new InventoryItem();
        weapons.setDescription("Weapons");
        weapons.setQuantityInStock(0);
        weapons.setRequiredAmount(0);
        inventory [Item.weapons.ordinal()] = weapons;
        
        InventoryItem food = new InventoryItem();
        food.setDescription("Food");
        food.setQuantityInStock(0);
        food.setRequiredAmount(0);
        inventory [Item.food.ordinal()] = food;
        
        InventoryItem oxygen = new InventoryItem();
        oxygen.setDescription("Oxygen");
        oxygen.setQuantityInStock(0);
        oxygen.setRequiredAmount(0);
        inventory [Item.oxygen.ordinal()] = oxygen;
        
        InventoryItem product = new InventoryItem();
        product.setDescription("Product");
        product.setQuantityInStock(0);
        product.setRequiredAmount(0);
        inventory [Item.product.ordinal()] = product;
        
        return inventory;
    }

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        // start point
        locations[0][0].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.shop.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.gardens.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.upgrade.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.manufacturing.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.medBay.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.trade_center.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.reactor.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.finish.ordinal()]);
        
    }

    public enum Item {
        crate,
        pylon,
        warpCells,
        shields,
        weapons,
        food,
        oxygen,
        product;
    }
        
    public static InventoryItem[] getSortedInventoryList() {
        System.out.println("\n*** getSortedInventoryList stub function called ***");
        return null;
    }
    
    public static Location[][] getMapLocations() {
        System.out.println("\n*** getMapLocations stub function called *** ");
        return null;
    }
    
    public static ShipUpgrade[] getSortedUpgradeList() {
        System.out.println("\n*** getSortedUpgradeList stub function called ***");
        return null;
    }
    
    public static void saveGame(Game game, String filePath) 
            throws GameControlException {
        
        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game); // write the game object out to file
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }
    
    public static void getSavedGame(String filePath) 
            throws GameControlException {
        Game game = null;
        
        try (FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject(); // read the game object from file
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
        // close the output file
        StarFreighterAJ.setCurrentGame(game); // save in StarFreighterAJ
    }
    
    
}
