/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Benoit
 */
public class PatchworkTest {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of class Patchwork, with a null array.
     */    
    @Test
    public void testNullArray() {
        System.out.println("testNullArray");
        int tab2d [][]=null;
        try{
            Patchwork p = new Patchwork(tab2d);
            fail("Une IllegalArgumentException aurait du être levée");
        } catch (IllegalArgumentException iae){
        }
    }
    /**
     * Test of class Patchwork, with a square array.
     */    
    @Test
    public void testSquareArray() {
        System.out.println("testSquareArray");
        int tab2d [][]= new int [5][5];
        try{
            Patchwork p = new Patchwork(tab2d);
            fail("Une IllegalArgumentException aurait du être levée");
        } catch (IllegalArgumentException iae){
        }
    }
    /**
     * Test of isInside method, of class Patchwork.
     */
    @Test
    public void testIsInside() {
        System.out.println("isInside");
        int x = 0;
        int y = 0;        
        int tab2d [][]= new int [5][6];
        Patchwork p = new Patchwork(tab2d);
        boolean expResult = true;
        boolean result = p.isInside(x, y);
        assertEquals(true, result);
        x = -1;
        y = -1;
        result = p.isInside(x, y);
        assertEquals(false, result);
    }

    /**
     * Test of compterTaches method, of class Patchwork.
     */
    @Test
    public void test1CompterTaches() {                
        int tab2d [][]={{0,0,0},
                        {0,0,0},
                        {0,0,0},
                        {0,0,0}};
        System.out.println("compterTaches 1");
        Patchwork p = new Patchwork(tab2d);
        int result = p.compterTaches();
        assertTrue(result == 1);
    }
    /**
     * Test of compterTaches method, of class Patchwork.
     */
    @Test
    public void test2CompterTaches() {                
        int tab2d [][]={{0,0,0},
                        {0,0,1},
                        {0,2,1},
                        {2,0,1}};
        System.out.println("compterTaches 2");
        Patchwork p = new Patchwork(tab2d);
        int result = p.compterTaches();
        assertTrue(result == 2);
    }
}
