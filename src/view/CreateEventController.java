package view;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import model.Category;
import model.WeaveEvent;

public class CreateEventController {
	private static int minEventNameLength = 1;
	private static int minlocationLength = 1;
	private static int minSponsorLength = 0;
	private static int minCategoryLength = 1;
	@FXML
	private TextField eventNameTextField;
	@FXML
	private DatePicker eventDateDatePicker;
	@FXML
	private TextField locationTextField;
	@FXML
	private TextField sponsorTextField;
	@FXML
	private ListView<Category> categoryListView;
	@FXML
	private Button addCategoryButton;
	@FXML
	private Button removeCategoryButton;
	@FXML
	private TextArea otherDetailsTextArea;
	@FXML
	private Button cancelButton;
	@FXML
	private Button saveEventButton;
	@FXML
	private Label warningLabel;
	
	// Reference to the main application.
	private Main mainApp;
	private WeaveEvent newWeaveEvent;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * Also create a new WeaveEvent instance.
	 * 
	 * @author Griffin Toyoda
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
		newWeaveEvent = new WeaveEvent();
		categoryListView.setItems(newWeaveEvent.getEventCategories());
	}
	
	/**
	 * Brings up a new dialog window which prompts the user to enter a category name.
	 * The category name is used to create a new category and is added to the current event.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void addCategoryButtonClicked(){
		// TODO Verify the category name does not already exist.
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Add a category");
		dialog.setContentText("Please enter category name:");

		// Get the response
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			if(result.get().length() > minCategoryLength){
				// Create a new event with the ID number equal to the number of categories and name equal to user input.
				Category newCategory = new Category(newWeaveEvent.getEventCategories().size(), result.get());
				newWeaveEvent.addCategory(newCategory);
			}
			else{
				warningLabel.setText("Category length has to be greater than " + minCategoryLength);
			}
		}
		else{
			// User clicked cancel
			warningLabel.setText(" ");
		}
	}
	
	/**
	 * Brings up a new dialog window which prompts the user to enter a category name.
	 * If the category matches a current category, that category is removed.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void removeCategoryButtonClicked(){
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Remove a category");
		dialog.setContentText("Please enter category name to remove:");

		// Get the response
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			if(result.get().length() > minCategoryLength){
				// Remove the category
				if(!newWeaveEvent.removeCategory(result.get())){
					warningLabel.setText("Category not found");
				}
			}
			else{
				warningLabel.setText("Category length has to be greater than " + minCategoryLength);
			}
		}
		else{
			// User clicked cancel
			warningLabel.setText(" ");
		}
	}
	
	/**
	 * Brings the user back to the admin home page.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void cancelButtonClicked(){
		if(mainApp != null){
        	// Popup warning: go back to admin home page if user confirms they want to go back.
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Are you sure you want to return to the admin home page?");
        	alert.setContentText("Event details will be lost");

        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == ButtonType.OK){
        	    // ... user chose OK
    			mainApp.showAdminPage();
        	} else {
        	    // ... user chose CANCEL or closed the dialog
        	}
		}
	}
	
	/**
	 * Checks if the event has all the required fields and sets the current event properties
	 * to those fields.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void saveEventButtonClicked(){
		if(mainApp != null){
			if(isValidEntry()){
				newWeaveEvent.setEventID(mainApp.getWeaveEventList().size());
				newWeaveEvent.setEventName(eventNameTextField.getText());
				newWeaveEvent.setDateAndTime(eventDateDatePicker.getValue());
				newWeaveEvent.setCutOffDate(eventDateDatePicker.getValue().minus(2, ChronoUnit.WEEKS));
				newWeaveEvent.setLocation(locationTextField.getText());
				newWeaveEvent.setSponsors(sponsorTextField.getText());
				newWeaveEvent.setEventDetails(otherDetailsTextArea.getText());
				mainApp.getWeaveEventList().add(newWeaveEvent);
				mainApp.showAdminPage();
			}
		}
	}
	
	/**
	 * Checks if the eventName, location, and sponsor fields meet the minimum length requirements.
	 * Checks if the user has picked a date.
	 * 
	 * @author Griffin Toyoda
	 * @return false if a required field is not filled out, true otherwise.
	 */
	private boolean isValidEntry(){
		if(eventNameTextField.getText().length() < minEventNameLength){
			warningLabel.setText("Please enter an event name");
			return false;
		}
		else if(eventDateDatePicker.getValue() == null){
			warningLabel.setText("Please pick a date for the event");
			return false;
		}
		else if(locationTextField.getText().length() < minlocationLength){
			warningLabel.setText("Please enter a location");
			return false;
		}
		else if(sponsorTextField.getText().length() < minSponsorLength){
			warningLabel.setText("Please enter a sponsor name");
			return false;
		}
		return true;
	}
}
