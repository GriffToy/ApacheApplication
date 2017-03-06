package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Category;

public class EntryRegistrationController {
	@FXML
	private ComboBox<Category> categoryComboBox;
	@FXML
	private TextField fibersTextField;
	@FXML
	private CheckBox selfDyedCheckBox;
	@FXML
	private CheckBox handSpunCheckBox;
	@FXML
	private TextArea otherDetailsTextArea;
	@FXML
	private Button anotherEntryButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button submitButton;
	
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
	private void anotherEntryButtonClicked(){
		System.out.println("This feature has not been implemented yet");
		// TODO Validate entry
		// TODO Save Entry details to a file
		if(mainApp != null){
			mainApp.showEntryRegistrationPage();
		}
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
	private void submitButtonClicked(){
		System.out.println("This feature has not been implemented yet");
		// TODO Validate entry
		if(mainApp != null){
			mainApp.showAttendeePage();
		}
	}
}
