package model;

import java.sql.Date;

/**
 * Model class for an event.
 * 
 * Modified by Jorie Fernandez - added additional parameters in the constructor
 * @author Griffin Toyoda
 *
 */
public class EventInfo {
	/** Event ID */
	private int eventID;
	/** Event Name */
	private String eventName;
	/** Event details */
	private String eventDetails;
	/** Event location */
	private String location;
	/** Event date */
	private Date dateAndTime; 
	/** Event registration cutoff */
	private Date cutOff;
	/** Event sponsors */
	private String sponsors;
	/** Event judges */
	private String criteriaAndJudges;
	
	/**
	 * Constructor
	 * @param eventName, event name
	 * @param eventID, event ID
	 * @param loc, location
	 * @param date, date of event
	 * @param cutDate, cut off date
	 */
	public EventInfo(String eventName, int eventID, String loc,
			Date date, Date cutDate ){
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDetails = eventName;
		this.location = loc;
		this.dateAndTime = date;
		this.cutOff = cutDate;
		this.sponsors = "Nike";
		this.criteriaAndJudges = "Hans";
	}
	
	/**
	 * Return event string
	 * 
	 * @return event name
	 */
	@Override
	public String toString(){
		return eventName;
	}
	
	/**
	 * Method to get event ID
	 * @return event ID
	 */
	public int getEventID() {
		return eventID;
	}
	
	/**
	 * Method to set event ID
	 * @param eventID
	 */
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	
	/**
	 * Method to get event name.
	 * @return event name
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * Method to set event name
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * Method to get event details
	 * @return event details
	 */
	public String getEventDetails() {
		return eventDetails;
	}
	/**
	 * Method to set event details
	 * @param eventDetails
	 */
	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
	}
	
	/**
	 * Method to get Location.
	 * @return location of event
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Method to set event location.
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Method to get event date.
	 * @return event date
	 */
	public Date getDateAndTime() {
		return dateAndTime;
	}
	
	/**
	 * Method to set date and time
	 * @param dateAndTime
	 */
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	/**
	 * Method to get cutOffDate
	 * @return cutoff date
	 */
	public Date getCutOffDate() {
		return cutOff;
	}
	
	/**
	 * Method to set cut off date
	 * @param eventInfo
	 */
	public void setCutOffDate(Date eventInfo) {
		this.cutOff = eventInfo;
	}
	
	/**
	 * Method to get Sponsors
	 * @return sponsors
	 */
	public String getSponsors() {
		return sponsors;
	}
	
	/**
	 * Method to set sponsors.
	 * @param sponsors
	 */
	public void setSponsors(String sponsors) {
		this.sponsors = sponsors;
	}
	
	/**
	 * Method to get judge and criteria
	 * @return judge and criteria
	 */
	public String getCriteriaAndJudges() {
		return criteriaAndJudges;
	}
	/**
	 * Method to set criteria and judge.
	 * @param criteriaAndJudges
	 */
	public void setCriteriaAndJudges(String criteriaAndJudges) {
		this.criteriaAndJudges = criteriaAndJudges;
	}
	
}
