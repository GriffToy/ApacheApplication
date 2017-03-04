package view;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Populate combobox dropdown menu.
		eventsComboBox.getItems().setAll(events);
		eventsComboBox.getSelectionModel().selectFirst();
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void cancelButtonClicked(){
		mainApp.showUserSelectPage();
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void okayButtonClicked(){
		mainApp.showLoginPage();
	}
}
