package view;

import controller.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
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
    
	private ObservableList<UserEntry> userEntryList;
    
    /**
     * Is called by the main application to give a reference back to itself.
     * @author Griffin Toyoda
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        this.userEntryList = mainApp.getCurrentUser().getUserEntries();
        selectEntryComboBox.setItems(userEntryList);
        selectEntryComboBox.valueProperty().addListener((obs, oldVal, newVal) -> showUserEntry(newVal));
        selectEntryComboBox.setConverter(new StringConverter<UserEntry>() {
    	    @Override
    	    public String toString(UserEntry object) {
    	    	return object.toString();
    	    }

    	    @Override
    	    public UserEntry fromString(String string) {
    	        return null;
    	    }
    	});
        selectEntryComboBox.getSelectionModel().selectFirst();
    }
    
    /*private void printEntries(){
        		userEntryList.forEach((entry) -> { 
        		    System.out.println(entry.getWeaveEvent());
        		    System.out.println(entry.getCategory());
        		    System.out.println(entry.getFibersInWeave());
        		    System.out.println(entry.getOtherDetails());
        		    System.out.println(entry.isHandspunYarn());
        		    System.out.println(entry.isSelfDyedYarn());
        		});
    }*/
    
    /**
     * @author Griffin Toyoda
     */
    private void showUserEntry(UserEntry userEntry){
    	if(userEntry.getWeaveEvent() != null){
    		this.eventLabel.setText(userEntry.getWeaveEvent().toString());
    	}
    	else{
    		this.eventLabel.setText("No event");
    	}
    	if(userEntry.getCategory() != null){
    		this.categoryLabel.setText(userEntry.getCategory().toString());
    	}
    	else{
    		this.categoryLabel.setText("No category");
    	}
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
