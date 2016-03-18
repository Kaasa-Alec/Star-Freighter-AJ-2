/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.freighter.aj;

import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.Player;
import byui.cit260.starfreighteraj.model.ShipModel;
import byui.cit260.starfreighteraj.view.StartProgramView;

/**
 *
 * @author JeffJones
 */
public class StarFreighterAJ {
    
    private static Game currentGame = null;
    private static Player player = null;
    private static ShipModel ship = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StartProgramView startProgramView = new StartProgramView();
        try{
        startProgramView.display();
        } catch (Throwable te) {
        System.out.println(te.getMessage());
        te.printStackTrace();
        startProgramView.display();
        
        }
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        StarFreighterAJ.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        StarFreighterAJ.player = player;
    }

    public static void setShip(ShipModel ship) {
        StarFreighterAJ.ship = ship;
    }
    
    
    
        
        
         
    }

 