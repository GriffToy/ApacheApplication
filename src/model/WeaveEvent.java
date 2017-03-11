package model;

import java.sql.Date;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


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
	private String criteriaAndJudges;
	private ObservableList<Category> eventCategories = FXCollections.observableArrayList();
	
	public WeaveEvent(String eventName, int eventID, String location,
			LocalDate dateAndTime, LocalDate cutOff){
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDetails = eventName;
		this.location = location;
		this.dateAndTime = dateAndTime;
		this.cutOff = cutOff;
		this.sponsors = "Nike";
		this.criteriaAndJudges = "Hans";
	}
	
	@Override
	public String toString(){
		return eventName;
	}
	
	public void addCategory(Category newCategory){
		this.eventCategories.add(newCategory);
	}
	
	public ObservableList<Category> getEventCategories(){
		return this.eventCategories;
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
		return criteriaAndJudges;
	}
	public void setCriteriaAndJudges(String criteriaAndJudges) {
		this.criteriaAndJudges = criteriaAndJudges;
	}
}
