package view;

import java.util.Optional;

import javax.swing.event.ChangeListener;

import controller.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.User;
import model.WeaveEvent;

public class RegisterPageController {
	private static int minUsernameLength = 1;
	private static int minPasswordLength = 1;
	private static int minFirstNameLength = 1;
	private static int minLastNameLength = 1;
	private static int minEmailLength = 1;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField emailAddress;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button saveExitButton;

    @FXML
    private Button saveContinueButton;

    @FXML
    private ComboBox<WeaveEvent> eventToAttend;

    @FXML
    private Button backButton;

    @FXML
    private TextField passwordField;

    @FXML
    private Label warningText;
	
    // Reference to the main application.
    private Main mainApp;
    
    private ObservableList<WeaveEvent> weaveEventList;
    
    private WeaveEvent eventSelected;
    /**
     * Is called by the main application to give a reference back to itself.
     * @author Griffin Toyoda
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        
        this.weaveEventList = mainApp.getWeaveEventList();
    	eventToAttend.setItems(weaveEventList);
    	eventToAttend.valueProperty().addListener((obs, oldVal, newVal) -> showEvent(newVal));
    	eventToAttend.setConverter(new StringConverter<WeaveEvent>() {
    	    @Override
    	    public String toString(WeaveEvent object) {
    	        return object.getEventName();
    	    }

        @Override
    	    public WeaveEvent fromString(String string) {
            return null;
    	    }
    	});
    	
    
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
    private void saveExitButtonClicked(){
    	// Verify filed are setup
    	if(verifyFields()){
    		getInputValues();
	    	
	    	mainApp.showLoginPage();
    	}
    }
    
    /**
     * @author Jorie Fernandez
     */
    @FXML
    private void getInputValues(){
    	// Verify filed are setup
    	
	    	// Store data and go back to the login page.
    		User newUser = new User();
    		
    		
    		
    		newUser.setUserType(mainApp.attendeeType);
    		newUser.setAttendeeID(-1);
    		newUser.setUsername(userNameField.getText());
    		newUser.setPassword(passwordField.getText());
	    	// TODO Encrypt password. http://blog.jerryorr.com/2012/05/secure-password-storage-lots-of-donts.html
    		newUser.setFirstName(firstName.getText());
    		newUser.setLastName(lastName.getText());
    		//TODO needs to check if this fields are not null
    		newUser.setPhoneNumber(Long.parseLong(phoneNumber.getText()));
    		newUser.setEmailAddress(emailAddress.getText());
	    	mainApp.userNameUserMap.put(userNameField.getText(), newUser);
	    	newUser.setEventID(eventSelected.getEventID());
	    	
	    	System.out.println(newUser);
	    	// TODO Append user to list of users file.
	    	

    }
    
  
    
    /**
     * @author Griffin Toyoda
     */
    @FXML
    private void saveContinueButtonClicked(){
    	// Verify filed are setup
    	if(verifyFields()){
	    	getInputValues();
	    	
	       mainApp.showEntryRegistrationPage(eventSelected);
    	}
    }
    
    /**
	 * @author Griffin Toyoda
	 */
	private void showEvent(WeaveEvent eventToShow){
		if(eventToShow != null){
			eventSelected = (WeaveEvent) eventToAttend.getSelectionModel().getSelectedItem();
			System.out.println("Event " + eventSelected.getEventName());
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
