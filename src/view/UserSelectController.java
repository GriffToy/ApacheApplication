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
	
	@FXML
	private void submitButtonClicked(){
		Parent root;
		Stage stage = (Stage)submitButton.getScene().getWindow();
		System.out.print("The user selected: ");
		if(attendeeRButton.isSelected()){
			System.out.println("Attendee");
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
			System.out.println("Judge");
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
			System.out.println("Admin");
			try {
				root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
				stage.setScene(new Scene(root));
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("This button should lead to the login page");
	}
}
