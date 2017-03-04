package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
		System.out.println("Login button. This feature has not been implemented yet...");
		System.out.println("The user's username is: " + userNameField.getText());
		System.out.println("The user's password is: " + passwordField.getText());
		if(validateUser(userNameField.getText(), passwordField.getText())){
			// Go on to next screen
		}
		else{
			// Alert the user that the username and password is incorrect
		}
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void registerButtonClicked(){
		mainApp.showRegisterPage();
	}
	
	/**
	 * @author Griffin Toyoda
	 * @param username entered on login screen
	 * @param password entered on login screen
	 * @return true if username and password is valid pair, false otherwise
	 */
	private boolean validateUser(String username, String password){
		return true;
	}
}
