/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import byui.cit260.starfreighteraj.exceptions.MapControlException;
import byui.cit260.starfreighteraj.model.Actor;
import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.Map;
import byui.cit260.starfreighteraj.model.Scene;
import java.awt.Point;
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
    
    public static void moveActorToLocation (Actor actor, Point coordinates) 
                            throws MapControlException {
        
        Map map = StarFreighterAJ.getCurrentGame().getMap();
        int newRow = coordinates.x-1;
        int newColumn = coordinates.y-1;
        
        if (newRow < 0 || newRow >= map.getNoOfRows() ||
            newColumn < 0 || newColumn >= map.getNoOfColumns()) {
            throw new MapControlException("Can not move actor to location "
                                        + coordinates.x + ", " + coordinates.y
                                        + " because that location is outside "
                                        + " the bounds of the map.");
        }
        
    }

    public static void moveActorsToStartingLocation(Map map) 
                            throws MapControlException {
        
        Actor[] actors = Actor.values();
        
        for (Actor actor : actors) {
            Point coordinates = actor.getCoordinates();
            MapControl.moveActorToLocation(actor, coordinates);
            
            }
        
        
        
    }

    private static Scene[] createScenes() {
        Game game = StarFreighterAJ.getCurrentGame();
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene startingScene = new Scene();
        startingScene.setDescription(
                "\n*Starting Scene is shown*");
        startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.start.ordinal()] = startingScene;
        
        Scene shopScene = new Scene();
        startingScene.setDescription(
                "\n Pick up mission supplies here");
        startingScene.setMapSymbol(" SH ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.shop.ordinal()] = shopScene;
        
        Scene gardensScene = new Scene();
        startingScene.setDescription(
                "\nTerror mites have infested the hydproponic gardens, "
                        + "exterminate them to complete the Bug Killer Job");
        startingScene.setMapSymbol(" GD ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.gardens.ordinal()] = gardensScene;
        
        Scene upgradeScene = new Scene();
        startingScene.setDescription(
                "\nUpgrade the ship to get it ready for the voyage");
        startingScene.setMapSymbol(" UG ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.upgrade.ordinal()] = upgradeScene;
        
        Scene manufacturingScene = new Scene();
        startingScene.setDescription(
                "\nNeed ship supplies? "
                        + "pick some up in the Maufacturing Center");
        startingScene.setMapSymbol(" MC ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.manufacturing.ordinal()] = manufacturingScene;
        
        Scene medBayScene = new Scene();
        startingScene.setDescription(
                "\nComplete MedBay job here.");
        startingScene.setMapSymbol(" MB ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.medBay.ordinal()] = medBayScene;
        
        Scene tradeCenterScene = new Scene();
        startingScene.setDescription(
                "\nA smuggler is trying to offload contraband at the trade center"
                        + "stop him to complete the Smuggle Job");
        startingScene.setMapSymbol(" TC ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.trade_center.ordinal()] = tradeCenterScene;
        
        Scene reactorScene = new Scene();
        startingScene.setDescription(
                "\nThe Space Corsair is trying to sabotage the fusion reator so"
                        + "his crew can raid the space station, stop him to "
                        + "complete the Space Corsair Job!");
        startingScene.setMapSymbol(" RS ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.reactor.ordinal()] = reactorScene;
       
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
        start("Here is where your adventure Begins."),
        shop("Go here to pick up mission supplies."),
        gardens("There are terror mites infesting the hydroponic gardens."),
        upgrade("Go here to upgrade the ship."),
        manufacturing("Pick up ship supplies in the Manfacturing Center"),
        medBay("The MedBay job can be completed here."),
        trade_center("Stop the smugglers from selling their contraband!"),
        reactor("Defeat the Space Corsair to save the space station from invasion!"),
        finish("Launch Your Ship to travel to Omacron Persei-8.");
    private final String description;
        
        SceneType(String description){
            this.description = description;
        }
        
        public String getDescription(){
            return description;
        }
    }
    }