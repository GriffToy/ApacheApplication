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
	private Button showEventsButton;
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
	 * 
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
	private void showEventsButtonClicked() {
		if (mainApp != null) {
			mainApp.showEventPage();
		}
	}

	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void loginButtonClicked() {
		System.out.println("The user's username is: " + userNameField.getText());
		System.out.println("The user's password is: " + passwordField.getText());
		if (mainApp != null) {
			if (validateUser(userNameField.getText(), passwordField.getText())) {
				// Go on to next screen
				System.out.println("Valid user");
				mainApp.setCurrentUser(mainApp.userNameUserMap.get(userNameField.getText()));
				// Check to see which type of user they are
				if (mainApp.getCurrentUser().getUserType() == UserType.ATTENDEE) {
					mainApp.showAttendeePage();
				} 
				else if (mainApp.getCurrentUser().getUserType() == UserType.JUDGE) {
					mainApp.showJudgeViewPage();
				} 
				else if (mainApp.getCurrentUser().getUserType() == UserType.ADMIN){
					mainApp.showAdminPage();
				}
				else{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Error!");
					alert.setContentText("You are not an Attendee, Judge, or Admin.");
					alert.showAndWait();
				}
			} else {
				// Alert the user that the username and password is incorrect
				invalidLoginLabel.setText("Invalid Username or Password");
			}
		}
	}

	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void registerButtonClicked() {
		if (mainApp != null) {
			mainApp.showUserSelectPage();
		}
	}

	/**
	 * @author Griffin Toyoda
	 * @param username
	 *            entered on login screen
	 * @param password
	 *            entered on login screen
	 * @return true if username and password is valid pair, false otherwise
	 */
	private boolean validateUser(String username, String password) {
		// Check if there is a user with given username.
		if (mainApp.userNameUserMap.containsKey(username)) {
			// Check if password of user matches given password.
			if (mainApp.userNameUserMap.get(username).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
