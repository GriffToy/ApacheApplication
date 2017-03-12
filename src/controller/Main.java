package controller;
import java.sql.*;
import java.time.LocalDate;
import java.io.IOException;
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
import model.UserEntry;
import model.WeaveEvent;
import view.AdminController;
import view.AttendeeController;
import view.CreateEventController;
import view.EntryRegistrationController;
import view.EventController;
import view.JudgeViewController;
import view.LoginPageController;
import view.RegisterPageController;
import view.UserSelectController;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<WeaveEvent> weaveEventList = FXCollections.observableArrayList();
    private User currentUser; // Stores current user. Set to null each time the login page is shown
    public HashMap<String, User> userNameUserMap; // Maps usernames to users

	@Override
	public void start(Stage primaryStage) {
		// TODO load list of events and map of users
		loadData();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Apache Application");
		this.primaryStage.getIcons().add(new Image("file:resources/images/Icon.png"));
	    initRootLayout();
	    showLoginPage();
	}
	
	@Override
	public void stop(){
		saveData();
	}
    
    /**
     * Constructor for testing purposes
     */
    public Main(){        
    	// Add some sample data
    	//weaveEventList.add(new WeaveEvent("Yarnosphere", 1));
    	//weaveEventList.add(new WeaveEvent("Fiber Fair at Lambtown", 2));
    	//weaveEventList.add(new WeaveEvent("Stitches West", 3));
    	WeaveEvent fiberFest = new WeaveEvent("Fiber Fest", 4, "Tacoma" , LocalDate.now(), LocalDate.now());
    	fiberFest.setEventDetails("Be there or be square");
    	fiberFest.setSponsors("Redbull");
    	fiberFest.setCriteriaAndJudges("Tony Hawk");
    	fiberFest.addCategory(new Category());
    	fiberFest.addCategory(new Category(-2, "Another category"));
    	weaveEventList.add(fiberFest);
    	userNameUserMap = new HashMap<String, User>();
    	User admin = new User();
    	admin.setUsername("admin");
    	admin.setPassword("password");
    	admin.setUserType(UserType.ADMIN);
    	userNameUserMap.put(admin.getUsername(), admin);
    	User judge = new User();
    	judge.setUsername("judge");
    	judge.setPassword("password");
    	judge.setUserType(UserType.JUDGE);
    	userNameUserMap.put(judge.getUsername(), judge);
    	User attendee = new User();
    	attendee.setUsername("attendee");
    	attendee.setPassword("password");
    	attendee.setUserType(UserType.ATTENDEE);
    	userNameUserMap.put(attendee.getUsername(), attendee);
    	
    	UserEntry testEntry = new UserEntry(fiberFest);
    	admin.addUserEntry(testEntry);
    	attendee.addUserEntry(testEntry);
    }
    
    /**
     * Loads the eventList and userList from database. Called once at startup.
     */
    private void loadData(){
    	Connection conn = null;
    	conn = sqliteConnection.dbConnector();
    	
    	try{
    		String query = "select * from EventInfo";
    		PreparedStatement pst = conn.prepareStatement(query);
    		ResultSet result = pst.executeQuery();
    		
    		while(result.next()) {
    			String name = result.getString("eventName");
    			int id = result.getInt("eventID");
    			String loc = result.getString("eventLocation");
    			String str = result.getString("eventDate").replaceAll("\\s", "");
    			LocalDate date = LocalDate.parse(str);
    			String cutDate = result.getString("eventCutDate").replaceAll("\\s", "");
    			LocalDate cut = LocalDate.parse(cutDate);
    			WeaveEvent loadedEvent = new WeaveEvent(name, id, loc, date, cut);
    			
    			// Dummy categories
    			loadedEvent.addCategory(new Category(-1, "A catgeory"));
    			loadedEvent.addCategory(new Category(-1, "Another catgeory"));
    			weaveEventList.add(loadedEvent);
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
