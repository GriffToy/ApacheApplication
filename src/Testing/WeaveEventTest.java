package Testing;

import java.time.LocalDate;
import model.Category;
import model.WeaveEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Max Kulish
 */
public class WeaveEventTest {
    /**
     * Test of toString method, of class WeaveEvent.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        WeaveEvent instance = new WeaveEvent();
        String expResult = null;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class WeaveEvent.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category newCategory = null;
        WeaveEvent instance = new WeaveEvent();
        instance.addCategory(newCategory);
    }

    /**
     * Test of removeCategory method, of class WeaveEvent.
     */
    @Test
    public void testRemoveCategory() {
        System.out.println("removeCategory");
        String name = "";
        WeaveEvent instance = new WeaveEvent();
        boolean expResult = false;
        boolean result = instance.removeCategory(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEventCategories method, of class WeaveEvent.
     */
   /* @Test
    public void testGetEventCategories() {
        System.out.println("getEventCategories");
        WeaveEvent instance = new WeaveEvent();
        ObservableList<Category> expResult = null;
        ObservableList<Category> result = instance.getEventCategories();
        assertEquals(expResult, result);
    }*/
    //not sure how to test this

    /**
     * Test of getEventID method, of class WeaveEvent.
     */
    @Test
    public void testGetEventID() {
        System.out.println("getEventID");
        WeaveEvent instance = new WeaveEvent();
        int expResult = -1;
        int result = instance.getEventID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEventID method, of class WeaveEvent.
     */
    @Test
    public void testSetEventID() {
        System.out.println("setEventID");
        int eventID = 0;
        WeaveEvent instance = new WeaveEvent();
        instance.setEventID(eventID);
    }

    /**
     * Test of getEventName method, of class WeaveEvent.
     */
    @Test
    public void testGetEventName() {
        System.out.println("getEventName");
        WeaveEvent instance = new WeaveEvent();
        String expResult = null;
        String result = instance.getEventName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEventName method, of class WeaveEvent.
     */
    @Test
    public void testSetEventName() {
        System.out.println("setEventName");
        String eventName = "";
        WeaveEvent instance = new WeaveEvent();
        instance.setEventName(eventName);
    }

    /**
     * Test of getEventDetails method, of class WeaveEvent.
     */
    @Test
    public void testGetEventDetails() {
        System.out.println("getEventDetails");
        WeaveEvent instance = new WeaveEvent();
        String expResult = null;
        String result = instance.getEventDetails();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEventDetails method, of class WeaveEvent.
     */
    @Test
    public void testSetEventDetails() {
        System.out.println("setEventDetails");
        String eventDetails = "";
        WeaveEvent instance = new WeaveEvent();
        instance.setEventDetails(eventDetails);
    }

    /**
     * Test of getLocation method, of class WeaveEvent.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        WeaveEvent instance = new WeaveEvent();
        String expResult = null;
        String result = instance.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocation method, of class WeaveEvent.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        WeaveEvent instance = new WeaveEvent();
        instance.setLocation(location);
    }

    /**
     * Test of getDateAndTime method, of class WeaveEvent.
     */
    @Test
    public void testGetDateAndTime() {
        System.out.println("getDateAndTime");
        WeaveEvent instance = new WeaveEvent();
        LocalDate expResult = null;
        LocalDate result = instance.getDateAndTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateAndTime method, of class WeaveEvent.
     */
    @Test
    public void testSetDateAndTime() {
        System.out.println("setDateAndTime");
        LocalDate dateAndTime = null;
        WeaveEvent instance = new WeaveEvent();
        instance.setDateAndTime(dateAndTime);
    }

    /**
     * Test of getCutOffDate method, of class WeaveEvent.
     */
    @Test
    public void testGetCutOffDate() {
        System.out.println("getCutOffDate");
        WeaveEvent instance = new WeaveEvent();
        LocalDate expResult = null;
        LocalDate result = instance.getCutOffDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCutOffDate method, of class WeaveEvent.
     */
    @Test
    public void testSetCutOffDate() {
        System.out.println("setCutOffDate");
        LocalDate cutDate = null;
        WeaveEvent instance = new WeaveEvent();
        instance.setCutOffDate(cutDate);
    }

    /**
     * Test of getSponsors method, of class WeaveEvent.
     */
    @Test
    public void testGetSponsors() {
        System.out.println("getSponsors");
        WeaveEvent instance = new WeaveEvent();
        String expResult = null;
        String result = instance.getSponsors();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSponsors method, of class WeaveEvent.
     */
    @Test
    public void testSetSponsors() {
        System.out.println("setSponsors");
        String sponsors = "";
        WeaveEvent instance = new WeaveEvent();
        instance.setSponsors(sponsors);
    }

    /**
     * Test of getCriteriaAndJudges method, of class WeaveEvent.
     */
    @Test
    public void testGetCriteriaAndJudges() {
        System.out.println("getCriteriaAndJudges");
        WeaveEvent instance = new WeaveEvent();
        String expResult = null;
        String result = instance.getCriteriaAndJudges();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCriteriaAndJudges method, of class WeaveEvent.
     */
    @Test
    public void testSetCriteriaAndJudges() {
        System.out.println("setCriteriaAndJudges");
        String criteriaAndJudges = "";
        WeaveEvent instance = new WeaveEvent();
        instance.setCriteriaAndJudges(criteriaAndJudges);
    }
    
}
