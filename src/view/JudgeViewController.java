package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Main;
import controller.sqliteConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.WeaveEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;
import model.WeaveEvent;
import model.Category;
import model.UserEntry;

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
	@FXML
	private TableView<Entry> entryTable;
	@FXML
	private TableColumn<Entry, String> nameCol;
	@FXML
	private TableColumn<Entry, String> dateCol;
	@FXML
	private TableColumn<Entry, String> detailsCol;
	
    // Reference to the main application.
    private Main mainApp;
	private ObservableList<WeaveEvent> weaveEventList;
	private WeaveEvent event;
	private Category category;
	private ObservableList<Entry> data = FXCollections.observableArrayList(new Entry("Jacob", "1/11/1111", "testing this"));
	
	public class Entry{
		public SimpleStringProperty Name;
		public SimpleStringProperty Date;
		public SimpleStringProperty Details;
		
		public Entry(String Name, String Date, String Details){
			this.Name = new SimpleStringProperty(Name);
			this.Date = new SimpleStringProperty(Date);
			this.Details = new SimpleStringProperty(Details);
		}
		
		public SimpleStringProperty nameProperty(){
			return this.Name;
		}
		
		public SimpleStringProperty dateProperty(){
			return this.Date;
		}
		
		public SimpleStringProperty detailsProperty(){
			return this.Details;
		}
	}
	
    /**
     * Is called by the main application to give a reference back to itself.
     * @author Griffin Toyoda
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        this.weaveEventList = mainApp.getWeaveEventList();
        
        entryTable.setEditable(true);
		nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
		detailsCol.setCellValueFactory(cellData -> cellData.getValue().detailsProperty());
		entryTable.setItems(data);
		
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
		if (this.event != null && this.category != null){
			
			
			data.clear();
			Connection conn = null;
			conn = sqliteConnection.dbConnector();
			String query = "SELECT * FROM Entry WHERE CategoryID == " + category.getCategoryID() + " AND EventID == " + event.getEventID();
			System.out.println(query);
			try {
				PreparedStatement pst = conn.prepareStatement(query.toString());
				ResultSet result = pst.executeQuery();
				
				while(result.next()){
					try{
						pst = conn.prepareStatement("SELECT * FROM User WHERE attendeeID == " + result.getString(2));
						ResultSet resultName = pst.executeQuery();
						String nName = resultName.getString(2) + ", " + resultName.getString(3);
						String nDate = result.getString(4);
						String nDetails = result.getString(8);
						data.add(new Entry(nName, nDate, nDetails));
					} catch (SQLException e){
						System.out.println("Connection Error" + e.getMessage());
					}
					
				}
				entryTable.setItems(data);
				for (Entry x : data){
					System.out.println(x.Name.get() + " " + x.Date.get() + " " + x.Details.get());
				}
			} catch (SQLException e) {
				System.out.println("Connection Error" + e.getMessage());
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
