package Testing;

import model.Category;
import model.UserEntry;
import model.WeaveEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Max Kulish
 */

public class UserEntryTest {
	
	WeaveEvent wv = new WeaveEvent();
    /**
     * Test of toString method, of class UserEntry.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserEntry instance = new UserEntry(wv);
        String expResult = "null: A test category";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeaveEvent method, of class UserEntry.
     */
    @Test
    public void testGetWeaveEvent() {
        System.out.println("getWeaveEvent");
        UserEntry instance = new UserEntry(wv);
        WeaveEvent expResult = wv;
        WeaveEvent result = instance.getWeaveEvent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeaveEvent method, of class UserEntry.
     */
    @Test
    public void testSetWeaveEvent() {
        System.out.println("setWeaveEvent");
        WeaveEvent weaveEvent = null;
        UserEntry instance = new UserEntry(wv);
        instance.setWeaveEvent(weaveEvent);
    }

    /**
     * Test of getCategory method, of class UserEntry.
     */
    /*@Test
    public void testGetCategory() {
        System.out.println("getCategory");
        UserEntry instance = new UserEntry(wv);
        Category expResult = null;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }*/
    //not sure how to test this

    /**
     * Test of setCategory method, of class UserEntry.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        Category category = null;
        UserEntry instance = new UserEntry(wv);
        instance.setCategory(category);
    }

    /**
     * Test of getFibersInWeave method, of class UserEntry.
     */
    @Test
    public void testGetFibersInWeave() {
        System.out.println("getFibersInWeave");
        UserEntry instance = new UserEntry(wv);
        String expResult = "Testing 1";
        String result = instance.getFibersInWeave();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFibersInWeave method, of class UserEntry.
     */
    @Test
    public void testSetFibersInWeave() {
        System.out.println("setFibersInWeave");
        String fibersInWeave = "";
        UserEntry instance = new UserEntry(wv);
        instance.setFibersInWeave(fibersInWeave);
    }

    /**
     * Test of isSelfDyedYarn method, of class UserEntry.
     */
    @Test
    public void testIsSelfDyedYarn() {
        System.out.println("isSelfDyedYarn");
        UserEntry instance = new UserEntry(wv);
        boolean expResult = false;
        boolean result = instance.isSelfDyedYarn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelfDyedYarn method, of class UserEntry.
     */
    @Test
    public void testSetSelfDyedYarn() {
        System.out.println("setSelfDyedYarn");
        boolean selfDyedYarn = false;
        UserEntry instance = new UserEntry(wv);
        instance.setSelfDyedYarn(selfDyedYarn);
    }

    /**
     * Test of isHandspunYarn method, of class UserEntry.
     */
    @Test
    public void testIsHandspunYarn() {
        System.out.println("isHandspunYarn");
        UserEntry instance = new UserEntry(wv);
        boolean expResult = false;
        boolean result = instance.isHandspunYarn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHandspunYarn method, of class UserEntry.
     */
    @Test
    public void testSetHandspunYarn() {
        System.out.println("setHandspunYarn");
        boolean handspunYarn = false;
        UserEntry instance = new UserEntry(wv);
        instance.setHandspunYarn(handspunYarn);
    }

    /**
     * Test of getOtherDetails method, of class UserEntry.
     */
    @Test
    public void testGetOtherDetails() {
        System.out.println("getOtherDetails");
        UserEntry instance = new UserEntry(wv);
        String expResult = "Testing 123 Testing 123 Testing 123 Testing 123 Testing 123 Testing 123 Testing 123 Testing 123";
        String result = instance.getOtherDetails();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOtherDetails method, of class UserEntry.
     */
    @Test
    public void testSetOtherDetails() {
        System.out.println("setOtherDetails");
        String otherDetails = "";
        UserEntry instance = new UserEntry(wv);
        instance.setOtherDetails(otherDetails);
    }
    
}
