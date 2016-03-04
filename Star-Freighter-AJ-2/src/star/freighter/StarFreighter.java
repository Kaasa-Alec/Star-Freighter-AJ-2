/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.freighter;

import byui.cit260.starfreighteraj.model.Player;
import byui.cit260.starfreighteraj.model.RegularScene;
import byui.cit260.starfreighteraj.model.Shop;
import byui.cit260.starfreighteraj.model.ShipUpgrade;
import byui.cit260.starfreighteraj.model.Inventory;
import byui.cit260.starfreighteraj.model.Resource;

/**
 *
 * @author AlecSir
 */
public class StarFreighter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Player playerOne = new Player();
        
        playerOne.setName("Fred Flintstone");
        playerOne.setTotalMoneyEarned(700.00);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        
        RegularScene regularSceneOne = new RegularScene();
       
        regularSceneOne.setDescription("Bridge");
        regularSceneOne.setTravelTime(24.00);
        regularSceneOne.setBlocked(true);
        regularSceneOne.setSymbol('A');
        
        String regularSceneInfo = regularSceneOne.toString();
        System.out.println(regularSceneInfo);
        
        
        Shop shopOne = new Shop();
        
        shopOne.setDescription("Armory");
        shopOne.setTravelTime(72.00);
        shopOne.setBlocked(false);
        shopOne.setSymbol('S');
        
        String shopInfo = shopOne.toString();
        System.out.println(shopInfo);
        
        
        ShipUpgrade shipUpgradeOne = new ShipUpgrade();
        
        shipUpgradeOne.setDescription("Guns");
        shipUpgradeOne.setTravelTime(1.00);
        shipUpgradeOne.setBlocked(false);
        shipUpgradeOne.setUpgradeAvailable(true);
        shipUpgradeOne.setUpgradeType("Stronger lasers");
        
        String shipUpgradeInfo = shipUpgradeOne.toString();
        System.out.println(shipUpgradeInfo);
        
        
        Inventory inventoryOne = new Inventory();
        
        inventoryOne.setInventoryType("Weapon");
        inventoryOne.setQuantityInStock(65);
        inventoryOne.setRequiredAmount(1);
        
        String inventoryInfo = inventoryOne.toString();
        System.out.println(inventoryInfo);
        
        
        Resource resourceOne = new Resource();
        
        resourceOne.setResourceType("Food");
        resourceOne.setQuantityInStock(3);
        resourceOne.setRequiredAmount(2);
        
        String resourceInfo = resourceOne.toString();
        System.out.println(resourceInfo);



        
    }
    
}