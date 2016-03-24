/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.freighter.aj;

import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.InventoryItem;
import byui.cit260.starfreighteraj.model.Player;
import byui.cit260.starfreighteraj.model.ShipModel;
import byui.cit260.starfreighteraj.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JeffJones
 */
public class StarFreighterAJ {
    
    private static Game currentGame = null;
    private static Player player = null;
    private static ShipModel ship = null;
    private static InventoryItem crate = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;

    
    public static void main(String[] args) {
        
        try {
        
            // open character stream files for end user input and output
            StarFreighterAJ.inFile =
                    new BufferedReader(new InputStreamReader(System.in));
        
            StarFreighterAJ.outFile = new PrintWriter(System.out, true);
            
            // open log file
            String filePath = "log.txt";
            StarFreighterAJ.logFile = new PrintWriter(filePath);
        
            // create StartProgramView and start the program
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
            return;
            
        } catch (Throwable e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        }
        
        finally {
            try {
                if (StarFreighterAJ.inFile != null)
                    StarFreighterAJ.inFile.close();
                
                if (StarFreighterAJ.outFile != null)
                    StarFreighterAJ.outFile.close();
                
                if (StarFreighterAJ.logFile != null)
                    StarFreighterAJ.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
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

    public static ShipModel getShip() {
        return ship;
    }
    
    public static void setShip(ShipModel ship) {
        StarFreighterAJ.ship = ship;
    }

    public static InventoryItem getCrate() {
        return crate;
    }
    
    public static void setCrate(InventoryItem crate) {
        StarFreighterAJ.crate = crate;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        StarFreighterAJ.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        StarFreighterAJ.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        StarFreighterAJ.logFile = logFile;
    }

    
    
}