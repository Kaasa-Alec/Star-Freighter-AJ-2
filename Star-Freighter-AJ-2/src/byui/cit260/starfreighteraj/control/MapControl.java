/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import byui.cit260.starfreighteraj.exceptions.MapControlException;
import byui.cit260.starfreighteraj.model.Actor;
import byui.cit260.starfreighteraj.model.Game;
import byui.cit260.starfreighteraj.model.Location;
import byui.cit260.starfreighteraj.model.Map;
import byui.cit260.starfreighteraj.model.Scene;
import java.awt.Point;
import star.freighter.aj.StarFreighterAJ;

/**
 *
 * @author AlecSir
 */
public class MapControl {

    public static Map createMap() throws MapControlException {
        // create the map
        Map map = new Map(20, 20);
        
        // create the scenes for the game
        Scene[] scenes = createScenes();
        
        // assign scenes to locations
        assignScenesToLocations(map, scenes);
        
        return map;
    }
    
    public static void moveActorToLocation (Game game, Actor actor, Point coordinates) 
                            throws MapControlException {
        
        Map map = game.getMap();
        
        Location location = game.getMap().getLocations()[coordinates.x][coordinates.y];
        
        if (coordinates.x < 0 || coordinates.x >= map.getNoOfRows() ||
            coordinates.y < 0 || coordinates.y >= map.getNoOfColumns()) {
            throw new MapControlException("Can not move actor to location "
                                        + coordinates.x + ", " + coordinates.y
                                        + " because that location is outside "
                                        + " the bounds of the map.");
        }
        
    }

    public static void moveActorsToStartingLocation(Map map, Actor[] actors) 
                            throws MapControlException {
        Game game = StarFreighterAJ.getCurrentGame();        
        for (Actor actor : actors) {
            Point coordinates = actor.getCoordinates();
            MapControl.moveActorToLocation(game, actor, coordinates);
            
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
        startingScene.setTravelTime(000);
        scenes[SceneType.start.ordinal()] = startingScene;
        
        Scene shopScene = new Scene();
        startingScene.setDescription(
                "\n Pick up mission supplies here");
        startingScene.setMapSymbol(" SH ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(100);
        scenes[SceneType.shop.ordinal()] = shopScene;
        
        Scene gardensScene = new Scene();
        startingScene.setDescription(
                "\nTerror mites have infested the hydproponic gardens, "
                        + "exterminate them to complete the Bug Killer Job");
        startingScene.setMapSymbol(" GD ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(200);
        scenes[SceneType.gardens.ordinal()] = gardensScene;
        
        Scene upgradeScene = new Scene();
        startingScene.setDescription(
                "\nUpgrade the ship to get it ready for the voyage");
        startingScene.setMapSymbol(" UG ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(300);
        scenes[SceneType.upgrade.ordinal()] = upgradeScene;
        
        Scene manufacturingScene = new Scene();
        startingScene.setDescription(
                "\nNeed ship supplies? "
                        + "pick some up in the Maufacturing Center");
        startingScene.setMapSymbol(" MC ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(400);
        scenes[SceneType.manufacturing.ordinal()] = manufacturingScene;
        
        Scene medBayScene = new Scene();
        startingScene.setDescription(
                "\nComplete MedBay job here.");
        startingScene.setMapSymbol(" MB ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(500);
        scenes[SceneType.medBay.ordinal()] = medBayScene;
        
        Scene tradeCenterScene = new Scene();
        startingScene.setDescription(
                "\nA smuggler is trying to offload contraband at the trade center"
                        + "stop him to complete the Smuggle Job");
        startingScene.setMapSymbol(" TC ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(600);
        scenes[SceneType.trade_center.ordinal()] = tradeCenterScene;
        
        Scene reactorScene = new Scene();
        startingScene.setDescription(
                "\nThe Space Corsair is trying to sabotage the fusion reator so"
                        + "his crew can raid the space station, stop him to "
                        + "complete the Space Corsair Job!");
        startingScene.setMapSymbol(" RS ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(700);
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
    
    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        // start point
        locations[0][1].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.shop.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.gardens.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.upgrade.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.manufacturing.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.medBay.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.trade_center.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.reactor.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.finish.ordinal()]);
        
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