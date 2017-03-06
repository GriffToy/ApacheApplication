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
	private Button cancelButton;
	@FXML
	private Button OKButton;
	@FXML
	private ComboBox<WeaveEvent> eventsComboBox;
	@FXML
	private Label eventDetails;
	@FXML
	private Label eventLocation; // Does not work if name is "location"
	@FXML
	private Label dateAndTime;
	@FXML
	private Label eventInfo;
	@FXML
	private Label sponsors;
	@FXML
	private Label judges;
	
	private ObservableList<WeaveEvent> weaveEventList;
	
    // Reference to the main application.
    private Main mainApp;
    
    /**
     * Is called by the main application to give a reference back to itself.
     * @author Griffin Toyoda
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
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
    }	
	
	/**
	 * @author Griffin Toyoda
	 */
	private void showEvent(WeaveEvent eventToShow){
		if(eventToShow != null){
			eventDetails.setText(eventToShow.getEventDetails());
			eventLocation.setText(eventToShow.getLocation());
			dateAndTime.setText(eventToShow.getDateAndTime());
			eventInfo.setText(eventToShow.getEventInfo());
			sponsors.setText(eventToShow.getSponsors());
			judges.setText(eventToShow.getCriteriaAndJudges());
		}
		else{
			eventDetails.setText("None");
			eventLocation.setText("None");
			dateAndTime.setText("None");
			eventInfo.setText("None");
			sponsors.setText("None");
			judges.setText("None");
		}
	}

	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void cancelButtonClicked(){
		mainApp.showUserSelectPage();
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void okayButtonClicked(){
		mainApp.currentUser.setEventID(eventsComboBox.getValue().getEventID());
		mainApp.showLoginPage();
	}
}
