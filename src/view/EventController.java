package view;

import controller.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import model.WeaveEvent;

public class EventController {
	@FXML
	private Button leftButton;
	@FXML
	private Button rightButton;
	@FXML
	private ComboBox<WeaveEvent> eventsComboBox;
	@FXML
	private Label eventDetails;
	@FXML
	private Label eventLocation; // Does not work if name is "location"
	@FXML
	private Label dateAndTime;
	@FXML
	private Label cutOff;
	@FXML
	private Label sponsors;
	@FXML
	private Label judges;
	
	private ObservableList<WeaveEvent> weaveEventList;
	
    // Reference to the main application.
    private Main mainApp;
    private String action;
    
    /**
     * Is called by the main application to give a reference back to itself.
     * @author Griffin Toyoda
     * @param mainApp
     */
    public void setMainApp(Main mainApp, String action) {
        this.mainApp = mainApp;
        this.action = action;
		// Populate combobox dropdown menu.
        this.weaveEventList = mainApp.getWeaveEventList();
    	eventsComboBox.setItems(weaveEventList);
    	eventsComboBox.valueProperty().addListener((obs, oldVal, newVal) -> showEvent(newVal));
    	eventsComboBox.setConverter(new StringConverter<WeaveEvent>() {
    	    @Override
    	    public String toString(WeaveEvent object) {
    	        return object.getEventName();
    	    }

    	    @Override
    	    public WeaveEvent fromString(String string) {
    	        return null;
    	    }
    	});
		eventsComboBox.getSelectionModel().selectFirst();
		// Check if user has logged in yet
		if(this.action.equals("AttendeePage") || this.action.equals("EditEvent")){
			// Two buttons when going from attendee page to viewing events or from
			// admin page to edit event page.
			leftButton.setText("Back");
			leftButton.setVisible(true);
			rightButton.setText("Next");
		}
    }	
	
	/**
	 * @author Griffin Toyoda
	 */
	private void showEvent(WeaveEvent eventToShow){
		if(eventToShow != null){
			eventDetails.setText(eventToShow.getEventDetails());
			eventLocation.setText(eventToShow.getLocation());
			dateAndTime.setText(eventToShow.getDateAndTime().toString());	
			sponsors.setText(eventToShow.getSponsors());
			cutOff.setText(eventToShow.getCutOffDate().toString());
			judges.setText(eventToShow.getCriteriaAndJudges());
		}
		else{
			eventDetails.setText("None");
			eventLocation.setText("None");
			dateAndTime.setText("None");
			cutOff.setText("None");
			sponsors.setText("None");
			judges.setText("None");
		}
	}

	/**
	 * This button is set to not visible by default. It is only set to visible after the user has logged in
	 * (in the setMainApp() function). After logging in, this button's text will change to "Back", 
	 * which takes the user back to the attendee home page.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void leftButtonClicked(){
		if(mainApp != null){
			if(this.action.equals("AttendeePage")){
				// Called from the attendee home page.
				// Pass the weave event selected to the next page
				mainApp.showAttendeePage();
			}
			else if(this.action.equals("EditEvent")){
				// Called from admin page. User selected to edit an event.
				mainApp.showAdminPage();
			}
		}
	}
	
	/**
	 * The default text of this button is "Back". When the user is not logged in, the back button will take 
	 * them back to the login page. Only after the user logs in does the text change to "Next". When the 
	 * user is logged in, the "Next" button will take them to the entry registration page.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void rightButtonClicked(){
		if(mainApp != null){
			if(this.action.equals("AttendeePage")){
				// Called from the attendee home page.
				// Pass the weave event selected to the next page
				mainApp.showEntryRegistrationPage(eventsComboBox.getValue());
			}
			else if(this.action.equals("LoginPage")){
				// Called from the login page.
				mainApp.showLoginPage();
			}
			else if(this.action.equals("EditEvent")){
				// Called from admin page. User selected to edit an event.
			}
			else if(this.action.equals("ViewEvent")){
				// Called from admin page. User selected to view an event.
				mainApp.showAdminPage();
			}
		}
	}
}
