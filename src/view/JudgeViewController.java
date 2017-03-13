package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class JudgeViewController {
	@FXML
	private ComboBox eventComboBox;
	@FXML
	private ComboBox categoryComboBox;
	@FXML
	private Label entryNumberLabel;
	@FXML
	private Label contestantIDLabel;
	@FXML
	private Label entryInfoLabel;
	@FXML
	private Button logoutButton;
	@FXML
	private Button okButton;
	
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
	private void logoutButtonClicked(){
		if(mainApp != null){
			mainApp.showLoginPage();
		}
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void okButtonClicked(){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText("This functionality has not been implemented yet");
		alert.setContentText("Okay button selected");
		alert.showAndWait();
	}
}
