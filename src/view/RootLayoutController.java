package view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;

/**
 * Controller for the rootLayout
 * 
 * @author Griffin Toyoda
 *
 */
public class RootLayoutController {
	@FXML
	private MenuItem delete;
	@FXML
	private MenuItem about;
	
	private static String aboutUs = "We are Team Apache:\n Brandon Gibbons --Gibbo\n Jorie Fernandez --J \n Griffin Toyoda --Griff\n "
			+ "Zeeshan Aziz Karim --**Needs nickname**\n Max Kullish --**Needs Nickname**";
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void onAboutClick(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About Team Apache");
		alert.setHeaderText(null);
		alert.setContentText(aboutUs);
		alert.showAndWait();
	}
	
	/**
	 * @author Griffin Toyoda
	 */
	@FXML
	private void close(){
		Platform.exit();
	}
}
