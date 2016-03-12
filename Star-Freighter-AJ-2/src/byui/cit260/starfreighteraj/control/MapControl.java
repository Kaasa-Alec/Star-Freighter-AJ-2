/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.Map;
import byui.cit260.starfreighteraj.model.Scene;
import star.freighter.aj.StarFreighterAJ;

/**
 *
 * @author AlecSir
 */
public class MapControl {

    public static Map createMap() {
        // create the map
        Map map = new Map(20, 20);
        
        // create the scenes for the game
        Scene[] scenes = createScenes();
        
        // assign scenes to locations
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
    }

    static void moveActorsToStartingLocation(Map map) {
        
    }

    public static Scene[] createScenes() {
        Game game = StarFreighterAJ.getCurrentGame();
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene startingScene = new Scene();
        startingScene.setDescription(
                "\n*Starting Scene is shown*");
        startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.start.ordinal()] = startingScene;
        
        
        Scene finishScene = new Scene();
        finishScene.setDescription(
                  "\n*Finish Scene is shown*");
        finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        finishScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.finish.ordinal()] = finishScene;
        
        return scenes;
    }
    
    public enum SceneType {
        start,
        finish;
    }
}