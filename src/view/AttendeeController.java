package view;

import java.util.Optional;

import controller.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import model.UserEntry;

public class AttendeeController {
	private static int maxTotalEntries = 3;
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
	private Button deleteEntryButton;
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
     * If the userEntry is null, all labels are set to "None". Otherwise, the labels on the attendee
     * home page are set to the relevant labels of the userEntry.
     * 
     * @author Griffin Toyoda
     * @param userEntry an entry to display
     */
    private void showUserEntry(UserEntry userEntry){
    	if(userEntry == null){
    		this.eventLabel.setText("None");
    		this.categoryLabel.setText("None");
	    	this.fibersLabel.setText("None");
    		this.handspunLabel.setText("None");
    		this.selfDyedLabel.setText("None");
	    	this.otherDetailsLabel.setText("None");
    	}
    	else{
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
    }
	
	/**
	 * Brings up the event selection page if the user is under the total entry limit.
	 * Pops up a warning box if they have reached the limit.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void newEntryButtonClicked(){
		if(mainApp != null){
			if(this.userEntryList.size() < maxTotalEntries){
				mainApp.showEventPage("AttendeePage");
			}
			else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("You have reached the entry limit of " + maxTotalEntries + " total entries.");
				alert.setContentText("Delete an entry before submitting another.");
				alert.showAndWait();
			}
		}
	}
	
	/**
	 * Deletes the currently selected entry if the user has an entry in their userEntry list.
	 * Confirms via a pop-up box if the user really wants to delete their entry.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void deleteEntryButtonClicked(){
		if(mainApp != null){
        	//Only show the dialog if there is an entry to delete
    		if(userEntryList.size() != 0){
    			// Warn the user that they are about to delete an entry.
    			Alert alert = new Alert(AlertType.CONFIRMATION);
    			alert.setTitle("Confirmation Dialog");
    			alert.setHeaderText("Are you sure you want to delete this entry?");
    			alert.setContentText("Entry details will be lost");

    			Optional<ButtonType> result = alert.showAndWait();
    			if (result.get() == ButtonType.OK){
    				// ... user chose OK
        			userEntryList.remove(selectEntryComboBox.getValue());
    			} 
    			else {
        	    // ... user chose CANCEL or closed the dialog
    			}
    		}
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
