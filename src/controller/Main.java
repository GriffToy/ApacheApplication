package controller;
import java.sql.*;
import java.time.LocalDate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Category;
import model.User;
import model.User.UserType;
import view.AdminController;
import view.AttendeeController;
import view.CreateEventController;
import view.EditEventController;
import view.EntryRegistrationController;
import view.EventController;
import view.JudgeViewController;
import view.LoginPageController;
import view.RegisterPageController;
import view.UserSelectController;
import model.UserEntry;
import model.WeaveEvent;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<WeaveEvent> weaveEventList = FXCollections.observableArrayList();
    private User currentUser; // Stores current user. Set to null each time the login page is shown
    public HashMap<String, User> userNameUserMap; // Maps usernames to users
    public HashMap<Integer,WeaveEvent> eventMap = new HashMap<Integer, WeaveEvent>();
	public HashMap<Integer,String> categoryMap = new HashMap<Integer, String>();
	public ArrayList<Integer> entryIdSet = new ArrayList<Integer>();
	public ArrayList<UserEntry> entrySet = new ArrayList<UserEntry>();

	@Override
	public void start(Stage primaryStage) {
		loadData();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Apache Application");
		this.primaryStage.getIcons().add(new Image("file:resources/images/Icon.png"));
	    initRootLayout();
	    showLoginPage();
	}
	
	/**
	 * Called when Platform.exit() or the main window is closed.
	 */
	@Override
	public void stop(){
		//saveData();
	}
    
    /**
     * Constructor for testing purposes
     */
    public Main(){        
    	userNameUserMap = new HashMap<String, User>();
    }
    
    /**
     * Loads the eventList and userList from database. Called once at startup.
     */
    private void loadData(){
    	Connection conn = null;
    	conn = sqliteConnection.dbConnector();
    	
    	try{
    		PreparedStatement pst;
    		ResultSet eventResult;
    		ResultSet userResult;
    		ResultSet entryResult;
    		ResultSet categoryResult;
    		
    		pst = conn.prepareStatement("select * from Event");
    		eventResult = pst.executeQuery();
    		
    		pst = conn.prepareStatement("select * from User");
    		userResult = pst.executeQuery();
    		
    		pst = conn.prepareStatement("select * from Entry");
    		entryResult = pst.executeQuery();
    		
    		pst = conn.prepareStatement("select * from Category");
    		categoryResult = pst.executeQuery();
    		
    		while(eventResult.next()) {
    			WeaveEvent nEvent = new WeaveEvent();
    			nEvent.setEventID(eventResult.getInt(1));
    			nEvent.setEventName(eventResult.getString(2));
    			nEvent.setLocation(eventResult.getString(3));
    			nEvent.setDateAndTime(LocalDate.parse(eventResult.getString(4)));
    			nEvent.setCutOffDate(LocalDate.parse(eventResult.getString(5)));
    			weaveEventList.add(nEvent);
    			eventMap.put(nEvent.getEventID(), nEvent);
    		}
    		
    		while(categoryResult.next()){
    			Category nCategory = new Category();
    			nCategory.setCategoryID(categoryResult.getInt(1));
    			nCategory.setCategoryName(categoryResult.getString(2));
    			for (WeaveEvent x : weaveEventList){
    				if(x.getEventID() == categoryResult.getInt(3)){
    					x.addCategory(nCategory);
    				}
    			}
    			categoryMap.put(categoryResult.getInt(1), categoryResult.getString(2));
    		}
    		
    		while(entryResult.next()){
				UserEntry nEntry = new UserEntry();
				nEntry.category.setCategoryID(entryResult.getInt(1));
				nEntry.category.setCategoryName(categoryMap.get(nEntry.category.getCategoryID()));					nEntry.setWeaveEvent(eventMap.get(entryResult.getInt(3)));
				nEntry.setFibersInWeave(entryResult.getString(5));
				nEntry.setSelfDyedYarn(entryResult.getBoolean(6));
				nEntry.setHandspunYarn(entryResult.getBoolean(7));
				nEntry.setOtherDetails(entryResult.getString(8));
				entryIdSet.add(entryResult.getInt(2));
				entrySet.add(nEntry);
				
    		}
    		
    		while(userResult.next()){
    			User nUser = new User();
    			nUser.setAttendeeID(userResult.getInt("attendeeID"));
    			nUser.setLastName(userResult.getString("attendeeLastName"));
    			nUser.setFirstName(userResult.getString("attendeeFirstName"));
    			nUser.setUsername(userResult.getString("attendeeUserName"));
    			nUser.setPassword(userResult.getString("attendeePW"));
    			nUser.setEmailAddress(userResult.getString("attendeeEmail"));
    			nUser.setPhoneNumber(userResult.getLong("attendeePhone"));
    			String userType = userResult.getString("attendeeType");
    			if(userType.equals("admin")) nUser.setUserType(UserType.ADMIN);
    			else if(userType.equals("judge")) nUser.setUserType(UserType.JUDGE);
    			else if(userType.equals("attendee")) nUser.setUserType(UserType.ATTENDEE);
    			else nUser.setUserType(UserType.NONE);
    			for(int x : entryIdSet){
    				if(x == nUser.getAttendeeID()){
    					nUser.addUserEntry(entrySet.get(entryIdSet.indexOf(x)));
    				}
    			}
    			userNameUserMap.put(nUser.getUsername(), nUser);	
    		}
    		
    		
    		
    		
    		pst.close();
    	}catch (Exception e){
    		System.out.println("Error connection!" + e.getMessage());
    	}
    }
    
    /**
     * Saves the weaveEventList and userNameUserMap to database. Called when application is closed.
     */
    private void saveData(){
    	// TODO complete function
    }
    
    /**
     * Returns the data as an observable list of WeaveEvents. 
     * @author Griffin Toyoda
     * @return
     */
    public ObservableList<WeaveEvent> getWeaveEventList() {
        return weaveEventList;
    }
    
    public User getCurrentUser(){
    	return currentUser;
    }
    
    public void setCurrentUser(User currentUser){
    	this.currentUser = currentUser;
    }

    /**
     * Initializes the root layout with the menu bar.
     * @author Griffin Toyoda
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the User Select page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showUserSelectPage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/UserSelectPage.fxml"));
            AnchorPane userSelectPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(userSelectPage);

            // Give the controller access to the main app.
            UserSelectController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    /**
     * Shows the Login page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showLoginPage() {
        try {
        	currentUser = null;
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/LoginPage.fxml"));
            AnchorPane loginPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(loginPage);

            // Give the controller access to the main app.
            LoginPageController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the Event page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showEventPage(String action) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/EventPage.fxml"));
            AnchorPane eventPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(eventPage);

            // Give the controller access to the main app.
            EventController controller = loader.getController();
            controller.setMainApp(this, action);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the Register page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showRegisterPage(UserType attendeeType) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/RegisterPage.fxml"));
            AnchorPane registerPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(registerPage);

            // Give the controller access to the main app.
            RegisterPageController controller = loader.getController();
            controller.setMainApp(this);
            controller.setAttendeeType(attendeeType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the Register page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showEntryRegistrationPage(WeaveEvent eventSelected) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/EntryRegistrationPage.fxml"));
            AnchorPane EntryRegistrationPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(EntryRegistrationPage);

            // Give the controller access to the main app.
            EntryRegistrationController controller = loader.getController();
            controller.setWeaveEvent(eventSelected);
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the Register page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showAttendeePage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/AttendeePage.fxml"));
            AnchorPane attendeePage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(attendeePage);

            // Give the controller access to the main app.
            AttendeeController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the JudgeView page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showJudgeViewPage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/JudgeViewPage.fxml"));
            AnchorPane judgeViewPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(judgeViewPage);

            // Give the controller access to the main app.
            JudgeViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the Admin page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showAdminPage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/AdminPage.fxml"));
            AnchorPane adminPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(adminPage);

            // Give the controller access to the main app.
            AdminController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the CreateEvent page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showCreateEventPage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/CreateEventPage.fxml"));
            AnchorPane createEventPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(createEventPage);

            // Give the controller access to the main app.
            CreateEventController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the EditEvent page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showEditEventPage(WeaveEvent selectedWeaveEvent) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/EditEventPage.fxml"));
            AnchorPane editEventPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(editEventPage);

            // Give the controller access to the main app.
            EditEventController controller = loader.getController();
            controller.setMainApp(this);
            controller.setEventToEdit(selectedWeaveEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
