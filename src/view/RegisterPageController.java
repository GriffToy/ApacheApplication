package view;

import java.util.Optional;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Dialog");
    	alert.setHeaderText("Are you sure you want to return to the login page?");
    	alert.setContentText("Registration details will be lost");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    	    // ... user chose OK
        	mainApp.showLoginPage();
    	} else {
    	    // ... user chose CANCEL or closed the dialog
    	}
    }
    
    @FXML
    private void submitButtonClicked(){
    	// Store data and go back to the login page.
    	mainApp.showLoginPage();
    }
}
