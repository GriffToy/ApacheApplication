package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class EventController implements Initializable{
	@FXML
	private Button cancelButton;
	@FXML
	private Button OKButton;
	@FXML
	private ComboBox<String> eventsComboBox;
	@FXML
	private ObservableList<String> events = FXCollections.observableArrayList(
			"Yarnosphere", "Fiber Fair at Lambtown", "Stitches West", "Fiber Fest");

	/**
	 * @author Griff
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Populate combobox dropdown menu.
		eventsComboBox.getItems().setAll(events);
		eventsComboBox.getSelectionModel().selectFirst();
	}
	
	/**
	 * @author Griff
	 */
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
	
	/**
	 * @author Griff
	 */
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
