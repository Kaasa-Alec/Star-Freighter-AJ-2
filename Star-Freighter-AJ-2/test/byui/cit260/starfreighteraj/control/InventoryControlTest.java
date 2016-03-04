/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starfreighteraj.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AlecSir
 */
public class InventoryControlTest {
    
    public InventoryControlTest() {
    }

    /**
     * Test of calcVolumeOfCrate method, of class InventoryControl.
     */
    @Test
    public void testCalcVolumeOfCrate() {
        System.out.println("calcVolumeOfCrate");
        
        /***********************
         * Test case #1
         **********************/
        System.out.println("\tTest case #1");
        
        // input values for test case 1
        double height = 4.0;
        double width = 4.0;
        double length = 10.0;
        
        double expResult = 160.0; // expected output returned value
        
        // create instance of InventoryControl class
        InventoryControl instance = new InventoryControl();
        
        // call function to run test
        double result = instance.calcVolumeOfCrate(height, width, length);
    
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
       
        
        
        /***********************
         * Test case #2
         **********************/
        System.out.println("\tTest case #2");
        
        // input values for test case 2
        height = -1.0;
        width = 7.0;
        length = 19.0;
        
        expResult = -1.0; // expected output returned value
        
        // call function to run test
        result = instance.calcVolumeOfCrate(height, width, length);
    
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
      
        
        /***********************
         * Test case #3
         **********************/
        System.out.println("\tTest case #3");
        
        // input values for test case 3
        height = 7.0;
        width = -1.0;
        length = 19.0;
        
        expResult = -1.0; // expected output returned value
        
        // call function to run test
        result = instance.calcVolumeOfCrate(height, width, length);
    
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
    
        
        /***********************
         * Test case #4
         **********************/
        System.out.println("\tTest case #4");
        
        // input values for test case 4
        height = 7.0;
        width = 7.0;
        length = -1.0;
        
        expResult = -1.0; // expected output returned value
        
        // call function to run test
        result = instance.calcVolumeOfCrate(height, width, length);
    
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        

        
        /***********************
         * Test case #5
         **********************/
        System.out.println("\tTest case #5");
        
        // input values for test case 5
        height = 7.0;
        width = 7.0;
        length = 21.0;
        
        expResult = -1.0; // expected output returned value
        
        // call function to run test
        result = instance.calcVolumeOfCrate(height, width, length);
    
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        

        
        
        
        
        /***********************
         * Test case #6
         **********************/
        System.out.println("\tTest case #6");
        
        // input values for test case 6
        height = 0.0;
        width = 8.0;
        length = 20.0;
        
        expResult = 0.0; // expected output returned value
        
        // call function to run test
        result = instance.calcVolumeOfCrate(height, width, length);
    
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        

        
        
        
        
        /***********************
         * Test case #7
         **********************/
        System.out.println("\tTest case #7");
        
        // input values for test case 7
        height = 8.0;
        width = 0.0;
        length = 20.0;
        
        expResult = 0.0; // expected output returned value
        
        // call function to run test
        result = instance.calcVolumeOfCrate(height, width, length);
    
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
  
        
        
        
        
        /***********************
         * Test case #8
         **********************/
        System.out.println("\tTest case #8");
        
        // input values for test case 8
        height = 8.0;
        width = 8.0;
        length = 0.0;
        
        expResult = -1.0; // expected output returned value
        
        // call function to run test
        result = instance.calcVolumeOfCrate(height, width, length);
    
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);

        
        
        
        
        /***********************
         * Test case #9
         **********************/
        System.out.println("\tTest case #9");
        
        // input values for test case 9
        height = 8.0;
        width = 8.0;
        length = 20.0;
        
        expResult = 1280.0; // expected output returned value
        
        // call function to run test
        result = instance.calcVolumeOfCrate(height, width, length);
    
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        

    }
    
}
