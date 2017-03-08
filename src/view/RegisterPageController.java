package view;

import java.util.Optional;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterPageController {
	private static int minUsernameLength = 1;
	private static int minPasswordLength = 1;
	private static int minFirstNameLength = 1;
	private static int minLastNameLength = 1;
	private static int minEmailLength = 1;
	@FXML
	private TextField userNameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField phoneNumber;
	@FXML
	private TextField emailAddress;
	@FXML
	private ComboBox<String> category;
	@FXML
	private ComboBox<String> action;
	@FXML
	private Button backButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button submitButton;
	@FXML
	private Label warningText;
	
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
     * @author Griffin Toyoda
     */
    @FXML
    private void backButtonClicked(){
    	if(mainApp != null){
        	// Popup warning, go back to login page if user confirms they want to go back.
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Are you sure you want to go back a page?");
        	alert.setContentText("Registration details will be lost");

        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == ButtonType.OK){
        	    // ... user chose OK
        		mainApp.showUserSelectPage();
        	} else {
        	    // ... user chose CANCEL or closed the dialog
        	}
    	}
    }
    
    /**
     * @author Griffin Toyoda
     */
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
    
    /**
     * @author Griffin Toyoda
     */
    @FXML
    private void submitButtonClicked(){
    	// Verify filed are setup
    	if(verifyFields()){
	    	// Store data and go back to the login page.
	    	mainApp.currentUser.setAttendeeID(-1);
	    	mainApp.currentUser.setUsername(userNameField.getText());
	    	mainApp.currentUser.setPassword(passwordField.getText());
	    	// TODO Encrypt password. http://blog.jerryorr.com/2012/05/secure-password-storage-lots-of-donts.html
	    	mainApp.currentUser.setFirstName(firstName.getText());
	    	mainApp.currentUser.setLastName(lastName.getText());
	    	mainApp.currentUser.setPhoneNumber(Long.parseLong(phoneNumber.getText()));
	    	mainApp.currentUser.setEmailAddress(emailAddress.getText());
	    	mainApp.userNameUserMap.put(userNameField.getText(), mainApp.currentUser);
	    	System.out.println(mainApp.currentUser);
	    	// TODO Append user to list of users file.
	    	mainApp.showLoginPage();
    	}
    }
    
    /**
     * Sets the warning text to the field that is incorrect.
     * @author Griffin Toyoda
     * @return True if fields in the registration page are valid, false otherwise.
     */
    private boolean verifyFields(){
    	boolean phoneNumberIsInt = false;
    	try{
    		Long.parseLong(phoneNumber.getText());
    		phoneNumberIsInt = true;
    	}
    	catch (NumberFormatException e){
    	}
    	if(userNameField.getText().length() < minUsernameLength){
    		warningText.setText("Username has to be longer than " + minUsernameLength + " characters.");
    		return false;
    	}
    	if(mainApp.userNameUserMap.containsKey(userNameField.getText())){
    		warningText.setText("Username already in use. Please choose another.");
    		return false;
    	}
    	else if(passwordField.getText().length() < minPasswordLength){
    		warningText.setText("Password has to be longer than " + minPasswordLength + " characters.");
    		return false;
    	}
    	else if(firstName.getText().length() < minFirstNameLength){
    		warningText.setText("Please enter your first name.");
    		return false;
    	}
    	else if(lastName.getText().length() < minLastNameLength){
    		warningText.setText("Please enter your last name.");
    		return false;
    	}
    	else if(phoneNumber.getText().length() != 10){
    		warningText.setText("Please enter a 10 digit phone number in the form of: 0123456789.");
    		return false;
    	}
    	else if(!phoneNumberIsInt){
    		warningText.setText("Phone number is not a number.");
    		return false;
    	}
    	else if(emailAddress.getText().length() < minEmailLength){
    		warningText.setText("Please enter your email address.");
    		return false;
    	}
    	else if(!emailAddress.getText().contains("@")){
    		warningText.setText("Please enter a valid email address.");
    		return false;
    	}
    	return true;
    }
}
