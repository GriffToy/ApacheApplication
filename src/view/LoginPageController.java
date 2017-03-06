package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.User.UserType;

public class LoginPageController {
	@FXML
	private Button cancelButton;
	@FXML
	private Button loginButton;
	@FXML
	private Button registerButton;
	@FXML
	private TextField userNameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label invalidLoginLabel;
	
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
	private void cancelButtonClicked(){
		// Go back to the UserSelect page.
		mainApp.showUserSelectPage();
		// Or close the window.
		//Platform.exit();
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void loginButtonClicked(){
		System.out.println("The user's username is: " + userNameField.getText());
		System.out.println("The user's password is: " + passwordField.getText());
		if(validateUser(userNameField.getText(), passwordField.getText())){
			// Go on to next screen
			System.out.println("Valid user");
		}
		else{
			// Alert the user that the username and password is incorrect
			invalidLoginLabel.setText("Invalid Username or Password");
		}
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void registerButtonClicked(){
		if(mainApp.currentUser.getUserType() == UserType.ATTENDEE){
			mainApp.showRegisterPage();
		}
		else{
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("Only attendees are allowed to register!");
	    	alert.showAndWait();
		}
	}
	
	/**
	 * @author Griffin Toyoda
	 * @param username entered on login screen
	 * @param password entered on login screen
	 * @return true if username and password is valid pair, false otherwise
	 */
	private boolean validateUser(String username, String password){
		// Check if there is a user with given username.
		if(mainApp.userNameUserMap.containsKey(username)){
			// Check if password of user matches given password.
			if(mainApp.userNameUserMap.get(username).getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
}
