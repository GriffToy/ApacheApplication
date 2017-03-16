package view;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;

import controller.Main;
import controller.sqliteConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import model.Category;
import model.UserEntry;
import model.WeaveEvent;

/**
 * Controller for the entryRegistrationPage
 * 
 * @author Griffin Toyoda
 *
 */
public class EntryRegistrationController {
	private static int minFibersTextFieldLength = 1;
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
	@FXML
	private Label warningLabel;

	// Reference to the main application.
	private Main mainApp;
	private WeaveEvent weaveEventSelected;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
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
	 * 
	 * @author Griffin Toyoda
	 */
	public void setWeaveEvent(WeaveEvent weaveEventSelected) {
		this.weaveEventSelected = weaveEventSelected;
	}

	/**
	 * Shows the attendee page.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void cancelButtonClicked() {
		if (mainApp != null) {
			mainApp.showAttendeePage();
		}
	}

	/**
	 * Shows the event page.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void backButtonClicked() {
		if (mainApp != null) {
			mainApp.showEventPage("AttendeePage");
		}
	}

	/**
	 * Gets the entry information from the text fields, creates a new entry with those values, 
	 * and adds the entry to the user's list of entries.
	 * 
	 * @author Griffin Toyoda
	 */
	@FXML
	private void submitButtonClicked() {
		if (isValidEntry()) {
			if (mainApp != null) {
				mainApp.showAttendeePage();
				UserEntry newEntry = new UserEntry(weaveEventSelected);
				newEntry.setFibersInWeave(fibersTextField.getText());
				newEntry.setSelfDyedYarn(selfDyedCheckBox.isSelected());
				newEntry.setHandspunYarn(handSpunCheckBox.isSelected());
				newEntry.setOtherDetails(otherDetailsTextArea.getText());
				newEntry.setCategory(categoryComboBox.getValue());
				mainApp.getCurrentUser().addUserEntry(newEntry);
				Connection conn = null;
				conn = sqliteConnection.dbConnector();
				
				try{
					Statement statement = conn.createStatement();
					String query = ("INSERT INTO Entry VALUES("
									+ newEntry.getCategory().getCategoryID() + ", "
									+ mainApp.getCurrentUser().getAttendeeID() + ", "
									+ weaveEventSelected.getEventID() + ", '"
									+ LocalDate.now().toString() + "', '"
									+ newEntry.getFibersInWeave() + "', "
									+ (newEntry.isSelfDyedYarn() ? 1 : 0) + ", "
									+ (newEntry.isHandspunYarn() ? 1 : 0) + ", '"
									+ newEntry.getOtherDetails() + "')");
					System.out.println(query);
					statement.executeUpdate(query);
				} catch (Exception e){
					System.out.println("Error connection!" + e.getMessage());
				}
				
			}
		}
	}

	/**
	 * @author Griffin Toyoda
	 * @return true if all fields are filled out, false if fields are not filled
	 *         out or if the user has already submitted an entry for the
	 *         selected category
	 */
	private boolean isValidEntry() {
		if(mainApp.getCurrentUser().containsCategory(categoryComboBox.getValue(), weaveEventSelected)){
			warningLabel.setText("Already submitted an entry for this category. Choose another.");
			return false;
		}
		else if(fibersTextField.getText().length() < minFibersTextFieldLength){
			warningLabel.setText("Please enter the fibers used in weave.");
			return false;
		}
		return true;
	}
}
