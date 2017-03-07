package model;


public class User {
	public enum UserType{
		NONE, ATTENDEE, JUDGE, ADMIN
	}
	private UserType userType;
	private int attendeeID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private long phoneNumber;
	private int eventID;
	
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
	
	@Override
	public String toString(){
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
	
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public int getAttendeeID() {
		return attendeeID;
	}
	public void setAttendeeID(int attendeeID) {
		this.attendeeID = attendeeID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
