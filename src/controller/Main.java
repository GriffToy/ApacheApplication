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
import model.User;
import model.WeaveEvent;
import view.AttendeeController;
import view.EntryRegistrationController;
import view.EventController;
import view.LoginPageController;
import view.RegisterPageController;
import view.UserSelectController;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<WeaveEvent> weaveEventList = FXCollections.observableArrayList();
    public User currentUser; // Testing purposes. I don't know where to create a user within the program.
    public HashMap<String, User> userNameUserMap;
    
    /**
     * Constructor for testing purposes
     */
    public Main(){        
    	// Add some sample data
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
    		
    			weaveEventList.add(new WeaveEvent(name, id, loc, date, cut));
    		}
    		
    		pst.close();
    	}catch (Exception e){
    		System.out.println("Error connection!" + e.getMessage());
    	}
    	
    
    
    	userNameUserMap = new HashMap<String, User>();
    	User admin = new User();
    	admin.setUsername("admin");
    	admin.setPassword("password");
    	userNameUserMap.put(admin.getUsername(), admin);
    }
    
    /**
     * Returns the data as an observable list of WeaveEvents. 
     * @author Griffin Toyoda
     * @return
     */
    public ObservableList<WeaveEvent> getWeaveEventList() {
        return weaveEventList;
    }

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Apache Application");
		this.primaryStage.getIcons().add(new Image("file:resources/images/Icon.png"));
	    initRootLayout();
	    showUserSelectPage();
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
        	currentUser = new User();
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
        	System.out.println("User is of type: " + currentUser.getUserType());
        	System.out.println("User is attending event: " + currentUser.getEventID());
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
    public void showEventPage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/EventPage.fxml"));
            AnchorPane eventPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(eventPage);

            // Give the controller access to the main app.
            EventController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the Register page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showRegisterPage() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the Register page inside the root layout.
     * @author Griffin Toyoda
     */
    public void showEntryRegistrationPage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/EntryRegistrationPage.fxml"));
            AnchorPane EntryRegistrationPage = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(EntryRegistrationPage);

            // Give the controller access to the main app.
            EntryRegistrationController controller = loader.getController();
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
