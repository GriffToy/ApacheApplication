package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegisterPageController {
	@FXML
	TextField firstName;
	@FXML
	TextField lastName;
	@FXML
	TextField phoneNumber;
	@FXML
	TextField emailAddress;
	@FXML
	ComboBox<String> category;
	@FXML
	ComboBox<String> action;
	@FXML
	Button cancelButton;
	@FXML
	Button submitButton;
	
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
    
    @FXML
    private void cancelButtonClicked(){
    	// Popup warning, go back to login page if user confirms they want to go back.
    	mainApp.showLoginPage();
    }
    
    @FXML
    private void submitButtonClicked(){
    	// Store data and go back to the login page.
    	mainApp.showLoginPage();
    }
}
