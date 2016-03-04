/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

/**
 *
 * @author AlecSir
 */
public class InventoryControl {
    
    public double calcVolumeOfCrate (double height, double width, double length) {
    
	if (height < 0) { // height is negative?
            return -1;
        }

	if (width < 0 || width > 8) { // width out of range?
            return -1;
        }

	if (length < 5 || length > 20) { // length out of range?
            return -1;
        }
                
	double volume = height * width * length;

	return volume;
    
    }
}
