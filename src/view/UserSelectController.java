package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

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
	
	/**
	 *@author Griffin Toyoda
	 */
	@FXML
	private void submitButtonClicked(){
		Parent root;
		Stage stage = (Stage)submitButton.getScene().getWindow();
		if(attendeeRButton.isSelected()){
			user = UserType.ATTENDEE;
			// Load event page
			try {
				root = FXMLLoader.load(getClass().getResource("EventPage.fxml"));
				stage.setScene(new Scene(root));
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(judgeRButton.isSelected()){
			user = UserType.JUDGE;
			// Load login page
			try {
				root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
				stage.setScene(new Scene(root));
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(adminRButton.isSelected()){
			user = UserType.ADMIN;
			// Load login page
			try {
				root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
				stage.setScene(new Scene(root));
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
