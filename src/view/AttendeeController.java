package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.UserEntry;

public class AttendeeController {
	@FXML
	private ComboBox<UserEntry> selectEntryComboBox;
	@FXML
	private Label eventLabel;
	@FXML
	private Label categoryLabel;
	@FXML
	private Label fibersLabel;
	@FXML
	private Label selfDyedLabel;
	@FXML
	private Label handspunLabel;
	@FXML
	private Label otherDetailsLabel;
	@FXML
	private Button newEntryButton;
	@FXML
	private Button logoutButton;
	
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
    private void showUserEntry(UserEntry userEntry){
    	this.eventLabel.setText(userEntry.getWeaveEvent().toString());
    	this.categoryLabel.setText(userEntry.getCategory().toString());
    	this.fibersLabel.setText(userEntry.getFibersInWeave());
    	if(userEntry.isHandspunYarn()){
    		this.handspunLabel.setText("Yes");
    	}
    	else{
    		this.handspunLabel.setText("No");
    	}
    	if(userEntry.isSelfDyedYarn()){
    		this.selfDyedLabel.setText("Yes");
    	}
    	else{
    		this.selfDyedLabel.setText("No");
    	}
    	this.otherDetailsLabel.setText(userEntry.getOtherDetails());
    }
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void newEntryButtonClicked(){
		if(mainApp != null){
			mainApp.showEventPage();
			//mainApp.showEntryRegistrationPage();
		}
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
}
