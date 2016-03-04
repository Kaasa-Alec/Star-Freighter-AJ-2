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
public class ShipUpgradeControlTest {
    
    public ShipUpgradeControlTest() {
    }

    /**
     * Test of checkProducts method, of class ShipUpgradeControl.
     */
    @Test
    public void testCheckProducts() {
        
        System.out.println("checkProducts");
        
        /*************************
         * Test case #1
         ************************/
        System.out.println("\tTest case #1");
        
        // input value for test case 1
        double product = 21.0;
        
        boolean expResult = true; // expected output returned value

        // create instance of ShipUpgradeControl class
        ShipUpgradeControl instance = new ShipUpgradeControl();
        
        // call function to run test
        boolean result = instance.checkProducts(product);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        
        /*************************
         * Test case #2
         ************************/
        System.out.println("\tTest case #2");
        
        // input value for test case 2
        product = 29.0;
        
        expResult = true; // expected output returned value

        // call function to run test
        result = instance.checkProducts(product);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        
        /*************************
         * Test case #3
         ************************/
        System.out.println("\tTest case #3");
        
        // input value for test case 3
        product = 19.0;
        
        expResult = false; // expected output returned value

        // call function to run test
        result = instance.checkProducts(product);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        /*************************
         * Test case #4
         ************************/
        System.out.println("\tTest case #4");
        
        // input value for test case 4
        product = 31.0;
        
        expResult = false; // expected output returned value

        // call function to run test
        result = instance.checkProducts(product);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
         /*************************
         * Test case #5
         ************************/
        System.out.println("\tTest case #5");
        
        // input value for test case 5
        product = 20.0;
        
        expResult = true; // expected output returned value

        // call function to run test
        result = instance.checkProducts(product);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        /*************************
         * Test case #6
         ************************/
        System.out.println("\tTest case #6");
        
        // input value for test case 6
        product = 30.0;
        
        expResult = true; // expected output returned value

        // call function to run test
        result = instance.checkProducts(product);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
    }

    /**
     * Test of calcWarpDrive method, of class ShipUpgradeControl.
     */
    @Test
    public void testCalcWarpDrive() {
        
        System.out.println("calcWarpDrive");
        
        /*************************
         * Test case #1
         ************************/
        System.out.println("\tTest case #1");
        
        // input value for test case 1
        double warp = 25.0;
        
        boolean expResult = true; // expected output returned value
        
        // create instance of ShipUpgradeControl class
        ShipUpgradeControl instance = new ShipUpgradeControl();

        // call function to run test
        boolean result = instance.calcWarpDrive(warp);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        
        
        
        
        /*************************
         * Test case #2
         ************************/
        System.out.println("\tTest case #2");
        
        // input value for test case 2
        warp = 5.0;
        
        expResult = false; // expected output returned value
        
        // call function to run test
        result = instance.calcWarpDrive(warp);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        
        
        
        /*************************
         * Test case #3
         ************************/
        System.out.println("\tTest case #3");
        
        // input value for test case 3
        warp = 100.0;
        
        expResult = false; // expected output returned value
        
        // call function to run test
        result = instance.calcWarpDrive(warp);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        
        
        
        /*************************
         * Test case #4
         ************************/
        System.out.println("\tTest case #4");
        
        // input value for test case 4
        warp = -10.0;
        
        expResult = false; // expected output returned value
        
        // call function to run test
        result = instance.calcWarpDrive(warp);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        
        
        
        /*************************
         * Test case #5
         ************************/
        System.out.println("\tTest case #5");
        
        // input value for test case 5
        warp = 10.0;
        
        expResult = true; // expected output returned value
        
        // call function to run test
        result = instance.calcWarpDrive(warp);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        
        
        
        /*************************
         * Test case #6
         ************************/
        System.out.println("\tTest case #6");
        
        // input value for test case 6
        warp = 50.0;
        
        expResult = true; // expected output returned value
        
        // call function to run test
        result = instance.calcWarpDrive(warp);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result);
        
    }
    
}
