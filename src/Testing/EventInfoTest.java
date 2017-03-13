package Testing;

import java.sql.Date;
import model.EventInfo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Max Kulish
 */
public class EventInfoTest {
    /**
     * Test of toString method, of class EventInfo.
     */
	
	Date date = new Date(3/12/2017);
    Date cutDate = new Date(3/13/2017);
	
    @Test
    public void testToString() {
        System.out.println("toString");
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        String expResult = "test";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEventID method, of class EventInfo.
     */
    @Test
    public void testGetEventID() {
        System.out.println("getEventID");
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        int expResult = 0;
        int result = instance.getEventID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEventID method, of class EventInfo.
     */
    @Test
    public void testSetEventID() {
        System.out.println("setEventID");
        int eventID = 0;
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        instance.setEventID(eventID);
    }

    /**
     * Test of getEventName method, of class EventInfo.
     */
    @Test
    public void testGetEventName() {
        System.out.println("getEventName");
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        String expResult = "test";
        String result = instance.getEventName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEventName method, of class EventInfo.
     */
    @Test
    public void testSetEventName() {
        System.out.println("setEventName");
        String eventName = "";
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        instance.setEventName(eventName);
    }

    /**
     * Test of getEventDetails method, of class EventInfo.
     */
    @Test
    public void testGetEventDetails() {
        System.out.println("getEventDetails");
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        String expResult = "test";
        String result = instance.getEventDetails();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEventDetails method, of class EventInfo.
     */
    @Test
    public void testSetEventDetails() {
        System.out.println("setEventDetails");
        String eventDetails = "";
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        instance.setEventDetails(eventDetails);
    }

    /**
     * Test of getLocation method, of class EventInfo.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        String expResult = "here";
        String result = instance.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocation method, of class EventInfo.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        instance.setLocation(location);
    }

    /**
     * Test of getDateAndTime method, of class EventInfo.
     */
    @Test
    public void testGetDateAndTime() {
        System.out.println("getDateAndTime");
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        Date expResult = date;
        Date result = instance.getDateAndTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateAndTime method, of class EventInfo.
     */
    @Test
    public void testSetDateAndTime() {
        System.out.println("setDateAndTime");
        Date dateAndTime = null;
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        instance.setDateAndTime(dateAndTime);
    }

    /**
     * Test of getCutOffDate method, of class EventInfo.
     */
    @Test
    public void testGetCutOffDate() {
        System.out.println("getCutOffDate");
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        Date expResult = cutDate;
        Date result = instance.getCutOffDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCutOffDate method, of class EventInfo.
     */
    @Test
    public void testSetCutOffDate() {
        System.out.println("setCutOffDate");
        Date eventInfo = null;
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        instance.setCutOffDate(eventInfo);
    }

    /**
     * Test of getSponsors method, of class EventInfo.
     */
    @Test
    public void testGetSponsors() {
        System.out.println("getSponsors");
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        String expResult = "Nike";
        String result = instance.getSponsors();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSponsors method, of class EventInfo.
     */
    @Test
    public void testSetSponsors() {
        System.out.println("setSponsors");
        String sponsors = "";
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        instance.setSponsors(sponsors);
    }

    /**
     * Test of getCriteriaAndJudges method, of class EventInfo.
     */
    @Test
    public void testGetCriteriaAndJudges() {
        System.out.println("getCriteriaAndJudges");
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        String expResult = "Hans";
        String result = instance.getCriteriaAndJudges();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCriteriaAndJudges method, of class EventInfo.
     */
    @Test
    public void testSetCriteriaAndJudges() {
        System.out.println("setCriteriaAndJudges");
        String criteriaAndJudges = "";
        EventInfo instance = new EventInfo("test", 0, "here", date, cutDate);
        instance.setCriteriaAndJudges(criteriaAndJudges);
    }
    
}
