package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.WeaveEvent;

public class EntryRegistrationController {
	@FXML
	private ComboBox<String> categoryComboBox;
	@FXML
	private TextField fibersTextField;
	@FXML
	private CheckBox selfDyedCheckBox;
	@FXML
	private CheckBox handSpunCheckBox;
	@FXML
	private TextArea otherDetailsTextArea;
	@FXML
	private Button cancelButton;
	@FXML
	private Button backButton;
	@FXML
	private Button submitButton;
	
    // Reference to the main application.
    private Main mainApp;
    private WeaveEvent weaveEventSelected;
    
    /**
     * Is called by the main application to give a reference back to itself.
     * @author Griffin Toyoda
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * Sets the event that the user selected.
     * @author Griffin Toyoda
     */
    public void setWeaveEvent(WeaveEvent weaveEventSelected){
    	this.weaveEventSelected = weaveEventSelected;
    }
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void cancelButtonClicked(){
		if(mainApp != null){
			mainApp.showAttendeePage();
		}
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void backButtonClicked(){
		if(mainApp != null){
			mainApp.showEventPage();
		}
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void submitButtonClicked(){
		System.out.println("This feature has not been implemented yet");
		if(isValidEntry()){
			if(mainApp != null){
				mainApp.showAttendeePage();
			}
		}
	}
	
	/**
	 * @author Griffin Toyoda
	 * @return true if all fields are filled out, false if fields are not
	 * filled out or if the user has already submitted an entry for the selected category
	 */
	private boolean isValidEntry(){
		// TODO Validate entry
		return true;
	}
}
