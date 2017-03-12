package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	public WeaveEvent(){
		this.eventID = -1;
		this.eventName = null;
		this.eventDetails = null;
		this.location = null;
		this.dateAndTime = null;
		this.cutOff = null;
		this.sponsors = null;
		this.criteriaAndJudges = null;
	}
	
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
	
	/**
	 * @author Griffin Toyoda
	 * @param name of category
	 * @return 
	 */
	public boolean removeCategory(String name){
		List<Object> toRemove = new ArrayList<Object>();
		for(Object a: eventCategories){
		    if(a.toString().equals(name)){
		        toRemove.add(a);
		    }
		}
		eventCategories.removeAll(toRemove);
		if(toRemove.size() > 0){
			return true;
		}
		return false;
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
