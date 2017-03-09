package view;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import model.User.UserType;

public class UserSelectController {
	@FXML
	private RadioButton attendeeRButton;
	@FXML
	private RadioButton judgeRButton;
	@FXML
	private Button backButton;
	@FXML
	private Button nextButton;

	// Reference to the main application.
	private Main mainApp;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
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
	private void backButtonClicked() {
		if (mainApp != null) {
			mainApp.showLoginPage();
		}
	}

	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void nextButtonClicked() {
		if (mainApp != null) {
			if (attendeeRButton.isSelected()) {
				mainApp.showRegisterPage(UserType.ATTENDEE);
			} else if (judgeRButton.isSelected()) {
				mainApp.showRegisterPage(UserType.JUDGE);
			}
		}
	}
}
