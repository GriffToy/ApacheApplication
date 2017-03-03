package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EventController {
	@FXML
	Button cancelButton;
	@FXML
	Button OKButton;
	
	@FXML
	private void cancelButtonClicked(){
		Parent root;
		Stage stage = (Stage)cancelButton.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource("UserSelectPage.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void okayButtonClicked(){
		Parent root;
		Stage stage = (Stage)OKButton.getScene().getWindow();
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
