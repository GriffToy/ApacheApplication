package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class for registered user
 * 
 * Modified by Jorie Fernandez to validate parameters on setters.
 * @author Griffin Toyoda
 *
 */
public class User {
	
	/** Enum */
	public enum UserType{
		NONE, ATTENDEE, JUDGE, ADMIN
	}
	
	/** User type */
	private UserType userType;
	/** Attendee ID */
	private int attendeeID;
	/** user name */
	private String username;
	/** password */
	private String password;
	/** first name */
	private String firstName;
	/** Last name */
	private String lastName;
	/** email address */
	private String emailAddress;
	/** Phone number */
	private long phoneNumber;
	/** Event ID */
	private int eventID;
	/** User entry list */
	private ObservableList<UserEntry> userEntries = FXCollections.observableArrayList();

	/**
	 * Constructor
	 */
	public User(){
		this.userType = UserType.NONE;
		this.attendeeID = -1;
		this.username = null;
		this.password = null;
		this.firstName = null;
		this.lastName = null;
		this.emailAddress = null;
		this.phoneNumber = -1;
		this.eventID = -1;

	}
	
	/**
	 * Method to return string
	 * 
	 */
	@Override
	public String toString(){
		/** Create and append fields info. */
		StringBuilder returnString = new StringBuilder();
		returnString.append("User is: ");
		returnString.append(userType);
		returnString.append("\nID: ");
		returnString.append(attendeeID);
		returnString.append("\nusername: ");
		returnString.append(username);
		returnString.append("\npassword: ");
		returnString.append(password);
		returnString.append("\nfirstName: ");
		returnString.append(firstName);
		returnString.append("\nlastName: ");
		returnString.append(lastName);
		returnString.append("\nemailAddress: ");
		returnString.append(emailAddress);
		returnString.append("\nphoneNumber: ");
		returnString.append(phoneNumber);
		returnString.append("\neventID: ");
		returnString.append(eventID);
		returnString.append("\n");
		return returnString.toString();
	}
	
	/**
	 * Checks via a comparison of category names and event names. TODO create a better comparison method as an event can have
	 * multiple categories with the same name.
	 * Modified by Jorie Fernandez by checking if the parameters are null
	 * @author Griffin Toyoda
	 * @param targetEvent to check.
	 * @param targetCategory category to check.
	 * @return true if the user has submitted an entry in targetCategory,
	 * false otherwise.
	 */
	public boolean containsCategory(Category targetCategory, WeaveEvent targetEvent){
		/** Check if the objects are null */
		if(targetCategory.equals(null) && targetEvent.equals(null)){
			throw new  NullPointerException("Category and Weave Event are null");
		}
		/** Validate if the entry sie is 0 */
		if(userEntries.size() == 0){
			return false;
		}
		
		/** Iterate through the user entries */
		for(UserEntry a: userEntries){
		    if(a.getCategory().getCategoryName().equals(targetCategory.getCategoryName())
		    		&& a.getWeaveEvent().getEventName().equals(targetEvent.getEventName())){
		        return true;
		    }
		}
		return false;
	}
	
	/**
	 * Method to get list of user entries.
	 * @return list of entries
	 */
	public ObservableList<UserEntry> getUserEntries() {
		return userEntries;
	}

	/**
	 * Method to add user entry
	 * 
	 * @param user entry
	 */
	public void addUserEntry(UserEntry userEntry) {
		
	
		userEntries.add(userEntry);
	}
	
	/**
	 * Method to get event ID.
	 * @return event ID
	 */
	public int getEventID() {
		return eventID;
	}
	
	/**
	 * Method to set event ID.
	 * @param eventID
	 */
	public void setEventID(int eventID) {
		if(eventID < 0){
			throw new IllegalArgumentException("Event ID is negative!");
		}
		this.eventID = eventID;
	}
	public UserType getUserType() {
		return userType;
	}
	
	/**
	 * Method to set user type
	 * @param userType
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	/**
	 * Method to get attendee ID
	 * @return
	 */
	public int getAttendeeID() {
		return attendeeID;
	}
	
	/**
	 * Method to set attendeeID
	 * @param attendeeID
	 */
	public void setAttendeeID(int attendeeID) {
		if (attendeeID < 0){
			throw new IllegalArgumentException("Attendee ID is negative!");
		}
		this.attendeeID = attendeeID;
	}
	
	/**
	 * Method to get user name
	 * @return user name
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Method to set user name.
	 * @param username
	 */
	public void setUsername(String username) {
		if(username.equals(null)){
			throw new NullPointerException("Null user name");
		}
		this.username = username;
	}
	
	/**
	 * Method to get password.
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Method to set password.
	 * @param password
	 */
	public void setPassword(String password) {
		if(password.equals(null)){
			throw new NullPointerException();
		}
		this.password = password;
	}
	
	/**
	 * Method to get first name.
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Method to set first name.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		if(firstName.equals(null)){
			throw new NullPointerException();
		}
		this.firstName = firstName;
	}
	
	/**
	 * Method to get last name.
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Method to set last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		if(lastName.equals(null)){
			throw new NullPointerException();
		}
		this.lastName = lastName;
	}
	
	/**
	 * Method to get email address
	 * @return email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * Method to set email address
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		if(emailAddress.equals(null)){
			throw new NullPointerException();
		}
		this.emailAddress = emailAddress;
	}
	/**
	 * Method to get phone number
	 * @return phone number
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Method to set phone number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(long phoneNumber) {
	
		this.phoneNumber = phoneNumber;
	}
	
	
}
