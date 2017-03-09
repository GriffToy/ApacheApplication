package model;

import java.sql.Date;
import java.time.LocalDate;


/**
 * Model class for an event.
 * @author Griffin Toyoda
 *
 */
public class WeaveEvent {
	private int eventID;
	private String eventName;
	private String eventDetails;
	private String location;
	private LocalDate dateAndTime; // TODO change to LocalDateTime variable
	private LocalDate cutOff;
	private String sponsors;
	private String eventJudges;
	


	public WeaveEvent(String eventName, int eventID, String location,
			LocalDate dateAndTime, LocalDate cutOff, String sponsors, String judges, String criteria ){
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDetails = criteria;
		this.location = location;
		this.dateAndTime = dateAndTime;
		this.cutOff = cutOff;
		this.sponsors = sponsors;
		this.eventJudges = judges;
	}
	
	@Override
	public String toString(){
		return eventName;
	}
	
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDetails() {
		return eventDetails;
	}
	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(LocalDate dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public LocalDate getCutOffDate() {
		return cutOff;
	}
	public void setCutOffDate(LocalDate cutDate) {
		this.cutOff = cutDate;
	}
	public String getSponsors() {
		return sponsors;
	}
	public void setSponsors(String sponsors) {
		this.sponsors = sponsors;
	}
	public String getCriteriaAndJudges() {
		return eventJudges;
	}
	public void setCriteriaAndJudges(String criteriaAndJudges) {
		this.eventJudges = criteriaAndJudges;
	}
	
	/*
	 * Below is class that follows the format of the address book example. I don't think
	 * it is needed, but am leaving it in case
	private IntegerProperty eventID;
	private StringProperty eventName;
	private StringProperty eventDetails;
	private StringProperty location;
	private StringProperty dateAndTime;
	private StringProperty eventInfo;
	private StringProperty sponsors;
	private StringProperty criteriaAndJudges;
	
	public WeaveEvent(String eventName, int eventID){
		this.eventID = new SimpleIntegerProperty(eventID);
		this.eventName = new SimpleStringProperty(eventName);
		this.eventDetails = new SimpleStringProperty(eventName);
		this.location = new SimpleStringProperty("Narnia");
		this.dateAndTime = new SimpleStringProperty("3/14/2017");
		this.eventInfo = new SimpleStringProperty("Boring");
		this.sponsors = new SimpleStringProperty("Nike");
		this.criteriaAndJudges = new SimpleStringProperty("Hans");
	}
	
	@Override
	public String toString(){
		return eventName.get();
	}

	public int getEventID() {
		return eventID.get();
	}

	public void setEventID(int eventID) {
		this.eventID.set(eventID);
	}

	public String getEventName() {
		return eventName.get();
	}

	public void setEventName(String eventName) {
		this.eventName.set(eventName);
	}

	public String getEventDetails() {
		return eventDetails.get();
	}

	public void setEventDetails(String eventDetails) {
		this.eventDetails.set(eventDetails);
	}

	public String getLocation() {
		return location.get();
	}

	public void setLocation(String location) {
		this.location.set(location);
	}

	public String getDateAndTime() {
		return dateAndTime.get();
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime.set(dateAndTime);
	}

	public String getEventInfo() {
		return eventInfo.get();
	}

	public void setEventInfo(String eventInfo) {
		this.eventInfo.set(eventInfo);
	}

	public String getSponsors() {
		return sponsors.get();
	}

	public void setSponsors(String sponsors) {
		this.sponsors.set(sponsors);
	}

	public String getCriteriaAndJudges() {
		return criteriaAndJudges.get();
	}

	public void setCriteriaAndJudges(String criteriaAndJudges) {
		this.criteriaAndJudges.set(criteriaAndJudges);
	}*/
}
