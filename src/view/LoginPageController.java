package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import controller.Main;
import controller.sqliteConnection;
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
	
	private String userType;

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
	 * Displays the loginPage.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void showEventsButtonClicked() {
		if (mainApp != null) {
			mainApp.showEventPage("LoginPage");
		}
	}

	/**
	 * Validates that the username and password match a user and displays the attendee, judge, or admin
	 * home page, depending on the type of user.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void loginButtonClicked() {
		System.out.println("The user's username is: " + userNameField.getText());
		System.out.println("The user's password is: " + passwordField.getText());
		if (mainApp != null) {
			if (validateUser()) {
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
	 * Displays the userSelectPage.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void registerButtonClicked() {
		if (mainApp != null) {
			mainApp.showUserSelectPage();
		}
	}

	/**
	 * 
	 * Validates if the user has an existing account
	 * @author Jorie Fernandez
	 * @param username
	 *            entered on login screen
	 * @param password
	 *            entered on login screen
	 * @return true if username and password is valid pair, false otherwise
	 */
	private boolean validateUser() {
		// Check if there is a user with given username.
		Connection conn = null;
    	conn = sqliteConnection.dbConnector();
    	
    	String query = "select * from Attendee where attendeeUserName = ? "
    				+ "and attendeePW = ?";
    	try{
    			
    		PreparedStatement pst = conn.prepareStatement(query);
    		pst.setString(1, userNameField.getText().replaceAll("\\s", ""));
    		pst.setString(2, passwordField.getText().replaceAll("\\s", ""));
    		ResultSet result = pst.executeQuery();
    		
    		if(!result.next()){
    			JOptionPane.showMessageDialog(null, "Invalid user! Please click Register to create an account",
    					"Error", JOptionPane.ERROR_MESSAGE);
    			return false;
    		} else {
    			userType = result.getString("attendeeType");
    		}
    		
    		pst.close();
    	}catch (Exception e){
    		JOptionPane.showMessageDialog(null, "Error Connection!" + e.getMessage(), "Database Error",
					JOptionPane.ERROR_MESSAGE);
    		
    	}
    	return true;
	}
}
