/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

/**
 *
 * @author JeffJones
 */
public class ShipUpgradeControl {

    /**
     *
     * @param product
     * @return
     */
    public boolean checkProducts(double product){
        
        if (product >= 20 && product <= 30) {
            return true;
        }
        else {
            return false;
        }
    }

  
    public boolean calcWarpDrive(double warp){

        if (warp >= 10 && warp <= 50){
            return true;
        }
        else {
            return false;
        }    
    }
}