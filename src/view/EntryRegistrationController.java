package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import model.Category;
import model.UserEntry;
import model.WeaveEvent;

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
        categoryComboBox.setItems(weaveEventSelected.getEventCategories());
        categoryComboBox.setConverter(new StringConverter<Category>() {
    	    @Override
    	    public String toString(Category object) {
    	        return object.getCategoryName();
    	    }

    	    @Override
    	    public Category fromString(String string) {
    	        return null;
    	    }
    	});
        categoryComboBox.getSelectionModel().selectFirst();
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
		if(isValidEntry()){
			if(mainApp != null){
				mainApp.showAttendeePage();
				UserEntry newEntry = new UserEntry(weaveEventSelected);
				newEntry.setFibersInWeave(fibersTextField.getText());
				newEntry.setSelfDyedYarn(selfDyedCheckBox.isSelected());
				newEntry.setHandspunYarn(handSpunCheckBox.isSelected());
				newEntry.setOtherDetails(otherDetailsTextArea.getText());
				newEntry.setCategory(categoryComboBox.getValue());
				mainApp.getCurrentUser().addUserEntry(newEntry);
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
