/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import byui.cit260.starfreighteraj.model.Player;
import byui.cit260.starfreighteraj.model.ShipModel;
import star.freighter.aj.StarFreighterAJ;

/**
 *
 * @author AlecSir
 */
public class GameControl {

    public static Player createPlayer(String name) {
        
        if (name == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        StarFreighterAJ.setPlayer(player);
        
        return player;
    }

    public static void createNewGame(Player player) {
        System.out.println("*** createNewGame function called ***");
    }

    public static ShipModel createShip(String name) {
        
        if (name == null) {
            return null;
        }
        
        ShipModel ship = new ShipModel();
        ship.setName(name);
        
        StarFreighterAJ.setShip(ship);
        
        return ship;
    }
    
}