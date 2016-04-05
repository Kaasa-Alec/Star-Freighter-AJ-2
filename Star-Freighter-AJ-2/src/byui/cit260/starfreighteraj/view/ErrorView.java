/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.view;

import java.io.PrintWriter;
import star.freighter.aj.StarFreighterAJ;

/**
 *
 * @author AlecSir
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = StarFreighterAJ.getOutFile();
    private static final PrintWriter logFile = StarFreighterAJ.getLogFile();
    
    public static void display(String className, String errorMessage) {
        errorFile.println(
                    "---------------------------------------------------------"
                  + "\n-- ERROR -- " + errorMessage
                  + "\n---------------------------------------------------------");
        
        // log error
        logFile.println(className + " - " + errorMessage);
    }
}