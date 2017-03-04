package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class UserSelectController {
	@FXML
	private RadioButton attendeeRButton;
	@FXML
	private RadioButton judgeRButton;
	@FXML
	private RadioButton adminRButton;
	@FXML
	private Button submitButton;
	 
	public enum UserType{
		NONE, ATTENDEE, JUDGE, ADMIN
	}
	// Maybe create a model class for this?
	private static UserType user = UserType.NONE;
	
    // Reference to the main application.
    private Main mainApp;
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
	
	/**
	 *@author Griffin Toyoda
	 */
	@FXML
	private void submitButtonClicked(){
		if(attendeeRButton.isSelected()){
			user = UserType.ATTENDEE;
			// Load event page
			mainApp.showEventPage();
		}
		else if(judgeRButton.isSelected()){
			user = UserType.JUDGE;
			// Load login page
			mainApp.showLoginPage();
		}
		else if(adminRButton.isSelected()){
			user = UserType.ADMIN;
			// Load login page
			mainApp.showLoginPage();
		}
	}
	
	/**
	 * @author Griffin Toyoda
	 * @return user type (NONE, ATTENDEE, JUDGE, or ADMIN)
	 */
	public static UserType getUser(){
		return user;
	}
}
