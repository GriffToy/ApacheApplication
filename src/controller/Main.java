package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.EventController;
import view.LoginPageController;
import view.RegisterPageController;
import view.UserSelectController;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

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
     */
    public void showLoginPage() {
        try {
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
