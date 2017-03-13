package Testing;

import javafx.collections.ObservableList;
import model.Category;
import model.User;
import model.User.UserType;
import model.UserEntry;
import model.WeaveEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max Kulish
 */
public class UserTest {
    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User();
        String expResult = "User is: NONE\nID: -1\nusername: null\npassword: null\nfirstName: null\nlastName: null\nemailAddress: null\nphoneNumber: -1\neventID: -1\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of containsCategory method, of class User.
     */
    @Test
    public void testContainsCategory() {
        System.out.println("containsCategory");
        Category targetCategory = null;
        WeaveEvent targetEvent = null;
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.containsCategory(targetCategory, targetEvent);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserEntries method, of class User.
     */
/*    @Test
    public void testGetUserEntries() {
        System.out.println("getUserEntries");
        User instance = new User();
        ObservableList<UserEntry> expResult = null;
        ObservableList<UserEntry> result = instance.getUserEntries();
        assertEquals(expResult, result);
    }*/
    //not sure how to test this
    
    /**
     * Test of addUserEntry method, of class User.
     */
    @Test
    public void testAddUserEntry() {
        System.out.println("addUserEntry");
        UserEntry userEntry = null;
        User instance = new User();
        instance.addUserEntry(userEntry);
    }

    /**
     * Test of getEventID method, of class User.
     */
    @Test
    public void testGetEventID() {
        System.out.println("getEventID");
        User instance = new User();
        int expResult = -1;
        int result = instance.getEventID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEventID method, of class User.
     */
    @Test
    public void testSetEventID() {
        System.out.println("setEventID");
        int eventID = 0;
        User instance = new User();
        instance.setEventID(eventID);
    }

    /**
     * Test of getUserType method, of class User.
     */
    @Test
    public void testGetUserType() {
        System.out.println("getUserType");
        User instance = new User();
        User.UserType expResult = UserType.NONE;
        User.UserType result = instance.getUserType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserType method, of class User.
     */
    @Test
    public void testSetUserType() {
        System.out.println("setUserType");
        User.UserType userType = null;
        User instance = new User();
        instance.setUserType(userType);
    }

    /**
     * Test of getAttendeeID method, of class User.
     */
    @Test
    public void testGetAttendeeID() {
        System.out.println("getAttendeeID");
        User instance = new User();
        int expResult = -1;
        int result = instance.getAttendeeID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAttendeeID method, of class User.
     */
    @Test
    public void testSetAttendeeID() {
        System.out.println("setAttendeeID");
        int attendeeID = 0;
        User instance = new User();
        instance.setAttendeeID(attendeeID);
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User();
        String expResult = null;
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        User instance = new User();
        instance.setUsername(username);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        String expResult = null;
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User();
        instance.setPassword(password);
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User();
        String expResult = null;
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        User instance = new User();
        instance.setFirstName(firstName);
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User instance = new User();
        String expResult = null;
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class User.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        User instance = new User();
        instance.setLastName(lastName);
    }

    /**
     * Test of getEmailAddress method, of class User.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        User instance = new User();
        String expResult = null;
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmailAddress method, of class User.
     */
    @Test
    public void testSetEmailAddress() {
        System.out.println("setEmailAddress");
        String emailAddress = "";
        User instance = new User();
        instance.setEmailAddress(emailAddress);
    }

    /**
     * Test of getPhoneNumber method, of class User.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        User instance = new User();
        long expResult = -1;
        long result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhoneNumber method, of class User.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        long phoneNumber = 0L;
        User instance = new User();
        instance.setPhoneNumber(phoneNumber);
    }
    
}
