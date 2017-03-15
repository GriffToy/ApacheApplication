package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import javax.swing.JOptionPane;

import controller.Main;
import controller.sqliteConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import model.User;
import model.UserEntry;
import model.User.UserType;

public class AttendeeController {
	private static int maxTotalEntries = 3;
	@FXML
	private ComboBox<String> selectEntryComboBox;
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
	
	private Connection conn = sqliteConnection.dbConnector();
	
    // Reference to the main application.
    private Main mainApp;
    
	private ObservableList userEntryList = FXCollections.observableArrayList();
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * Modified by Jorie Fernandez - to get value from database
     * @author Griffin Toyoda
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
  
        refreshTable();
        selectEntryComboBox.setOnAction(e ->{
        	displayEntry((String)selectEntryComboBox.getSelectionModel().getSelectedItem());
        });
        selectEntryComboBox.valueProperty().addListener((obs, oldVal, newVal) -> displayEntry(newVal));
      /*
        selectEntryComboBox.setConverter(new StringConverter<String>() {
    	    @Override
    	    public String toString(UserEntry object) {
    	    	return object.toString();
    	    }

    	    @Override
    	    public UserEntry fromString(String string) {
    	        return null;
    	    }
    	});
    	*/
        selectEntryComboBox.getSelectionModel().selectFirst();
    }
    
    private void refreshTable(){
    	 userEntryList.clear();
    	 fillEntryComboBox();
         selectEntryComboBox.setItems(userEntryList);
    }
    private void displayEntry(String entry){
    	
    	
    	String query = "select * from Registration where regName = ? and regAttendeeID = ?";
    	try{
    			
    		PreparedStatement pst = conn.prepareStatement(query);
    	//	pst.setString(1, (String)selectEntryComboBox.getSelectionModel().getSelectedItem());
    		pst.setString(1, entry);
    		pst.setInt(2, mainApp.getCurrentUser().getAttendeeID());
    		ResultSet result = pst.executeQuery();
    		
    
    		while(result.next()){
    			
    			this.eventLabel.setText(Integer.toString(result.getInt("regEventID")));
        		this.categoryLabel.setText(Integer.toString(result.getInt("regCategoryID")));
    	    	this.fibersLabel.setText(result.getString("regFibers"));
        		this.handspunLabel.setText(Boolean.toString(result.getBoolean("regYarn")));
        		this.selfDyedLabel.setText(Boolean.toString(result.getBoolean("regDye")));
    	    	this.otherDetailsLabel.setText(result.getString("regDetails"));
    		}
    		
    		pst.close();
    	}catch (Exception e){
    		JOptionPane.showMessageDialog(null, "No registration record!" + e.getMessage(), "Database Error",
					JOptionPane.ERROR_MESSAGE);
    		
    	}
    }
    
    private void fillEntryComboBox(){
    	
    	String query = "select * from Registration where regAttendeeID = ? ";
    	try{
    			
    		PreparedStatement pst = conn.prepareStatement(query);
    		pst.setInt(1, mainApp.getCurrentUser().getAttendeeID());
    		ResultSet result = pst.executeQuery();
    		
    		while(result.next()){
    		    
    			userEntryList.add(result.getString("regName"));
    			this.eventLabel.setText(Integer.toString(result.getInt("regEventID")));
        		this.categoryLabel.setText(Integer.toString(result.getInt("regCategoryID")));
    	    	this.fibersLabel.setText(result.getString("regFibers"));
        		this.handspunLabel.setText(Boolean.toString(result.getBoolean("regYarn")));
        		this.selfDyedLabel.setText(Boolean.toString(result.getBoolean("regDye")));
    	    	this.otherDetailsLabel.setText(result.getString("regDetails"));
    		}
    		
    		pst.close();
    	}catch (Exception e){
    		JOptionPane.showMessageDialog(null, "No registration record!" + e.getMessage(), "Database Error",
					JOptionPane.ERROR_MESSAGE);
    		
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
    				
    				
        			//userEntryList.remove(selectEntryComboBox.getValue());
    				deleteTable(selectEntryComboBox.getValue());
    				refreshTable();
    			} 
    			else {
        	    // ... user chose CANCEL or closed the dialog
    			}
    		}
		}
	}
	
	private void deleteTable(String val){
		
    	String query = "delete from Registration where regAttendeeID = ? and regName = ?";
    	try{
    			
    		PreparedStatement pst = conn.prepareStatement(query);
    		pst.setInt(1, mainApp.getCurrentUser().getAttendeeID());
    		pst.setString(2, val );
    		pst.executeUpdate();
    		
    		
    		pst.close();
    	}catch (Exception e){
    		JOptionPane.showMessageDialog(null, "No registration record!" + e.getMessage(), "Database Error",
					JOptionPane.ERROR_MESSAGE);
    		
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
