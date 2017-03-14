package view;

import controller.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import model.WeaveEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;
import model.WeaveEvent;
import model.Category;

public class JudgeViewController {
	@FXML
	private ComboBox<WeaveEvent> eventComboBox;
	@FXML
	private ComboBox<Category> categoryComboBox;
	@FXML
	private Label entryNumberLabel;
	@FXML
	private Label contestantIDLabel;
	@FXML
	private Label entryInfoLabel;
	@FXML
	private Button logoutButton;
	@FXML
	private ScrollPane entryDisplayPane;
	
    // Reference to the main application.
    private Main mainApp;
	private ObservableList<WeaveEvent> weaveEventList;
	private WeaveEvent event;
	private Category category;
    
    /**
     * Is called by the main application to give a reference back to itself.
     * @author Griffin Toyoda
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        this.weaveEventList = mainApp.getWeaveEventList();
        eventComboBox.setItems(weaveEventList);
    	eventComboBox.valueProperty().addListener((obs, oldVal, newVal) -> selectEvent(newVal));
    	eventComboBox.setConverter(new StringConverter<WeaveEvent>() {
    	    @Override
    	    public String toString(WeaveEvent object) {
    	        return object.getEventName();
    	    }

    	    @Override
    	    public WeaveEvent fromString(String string) {
    	        return null;
    	    }
    	});
		eventComboBox.getSelectionModel().selectFirst();
		
		categoryComboBox.setItems(event.getEventCategories());
		categoryComboBox.valueProperty().addListener((obs, oldVal, newVal) -> selectCategory(newVal));
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
	
	private void selectCategory(Category newVal) {
		// TODO Auto-generated method stub
		this.category = newVal;
		updateList();
	}

	private void selectEvent(WeaveEvent newVal) {
		// TODO Auto-generated method stub
		this.event = newVal;
		updateList();
	}

	private void updateList() {
		// TODO Auto-generated method stub
		if (this.event != null && this.category != null){
			System.out.println("test");
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
	
	/**
	 * @author Griffin Toyoda
	 */
	/*
	@FXML
	private void okButtonClicked(){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText("This functionality has not been implemented yet");
		alert.setContentText("Okay button selected");
		alert.showAndWait();
	}
	*/
	@FXML
	private void test(){
		
	}
}
