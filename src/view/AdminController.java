package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class AdminController {
	@FXML
	private RadioButton createEventRButton;
	@FXML
	private RadioButton editEventRButton;
	@FXML
	private RadioButton viewEventRButton;
	@FXML
	private RadioButton reportEventRButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button okayButton;
	
    // Reference to the main application.
    private Main mainApp;
    
    /**
     * Is called by the main application to give a reference back to itself.
     * @author Griffin Toyoda
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
	
	/**
	 * Logs the user out and displays the login page
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void logoutButtonClicked(){
		if(mainApp != null){
			mainApp.showLoginPage();
		}
	}
	
	/**
	 * Displays the screen that the user selected.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void okayButtonClicked(){
		if(mainApp != null){
			if(createEventRButton.isSelected()){
				mainApp.showCreateEventPage();
			}
			else if(editEventRButton.isSelected()){
				//mainApp.showEventPage("EditEvent");
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("This functionality has not been implemented yet");
				alert.setContentText("Edit event selected");
				alert.showAndWait();
			}
			else if(viewEventRButton.isSelected()){
				mainApp.showEventPage("ViewEvent");
			}
			else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("This functionality has not been implemented yet");
				alert.setContentText("Generate reports selected");
				alert.showAndWait();
			}
		}
	}
}
