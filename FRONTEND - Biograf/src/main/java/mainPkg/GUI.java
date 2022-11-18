package mainPkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GUI extends Application {
    // The main stage which we place all scenes on
    private static Stage mainStage;


    // Contains the email-address of the currently selected user
    // used to keep track of who is logged-in in the "loggedInUser" scene
    // which is a subclass of GUI (Like all sceneControllers)
    private static String currentUser;

    public String getCurrentUser() {
        return currentUser;
    }
    
    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }


    // Every single method which name starts with "launch" is simply made to swap scenes in JAVAFX



    /**
     Takes the user to the "start screen", the first screen the user sees when starting the program.
     This is achieved through a scene change on the default stage.
     */

    public void launchStartScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("StartScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        mainStage.setTitle("startScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "admin screen", this is the scene which is only intended for use of an administrator/employer at the cinema.
     */

    public void launchAdminScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("AdminScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        mainStage.setTitle("AdminScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "staff screen", this scene is used to hire/fire and assign shifts to staff
     */
    public void launchStaffScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("StaffScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        mainStage.setTitle("StaffScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "addStaff screen", a subScene of "Staff screen" used to add new staff to the database
     */
    
    public void launchAddStaffScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("AddStaffScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
    
        mainStage.setTitle("AddStaff");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "addShift screen", a subScene of "Staff screen" used to add new shifts to the database
     */
    public void launchAddShiftScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("AddShiftScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        mainStage.setTitle("Shifts");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "launchMovie screen", this scene is used to add/remove upcoming movie screenings
     */
    public void launchMovieScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("AddMovies.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
    
        mainStage.setTitle("Movies");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "allScreenings screen", a subScene of "Movie screen" used to see all upcoming screenings
     and lets admin add new screenings to database
     */
    public void launchAllScreeningsScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("allMovieScreeningsScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        mainStage.setTitle("Screenings");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "Customer screen", this scene is used to let a customer either login to an existing account
     or add a brand-new account to the database that can later be logged back into.
     */
    public void launchCustomerScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("CustomerScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        mainStage.setTitle("Greetings");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "loggedInUser screen", a subScene of "Customer Screen", this is what a customer/user
     sees when they've completed a successful login attempt
     */
    public void launchLoggedInUser() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("LoggedInUserScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        mainStage.setTitle("Successfully logged in");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "launchBookTickets screen", a subScene of "loggedInUser Screen", this is what a logged in
     user sees when they want to book new movie tickets, see their orders OR cancel a previously made order
     */
    public void launchBookTicketsScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("BookTicketsScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        mainStage.setTitle("Book Tickets");
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    /**
     JavaFX default application start. We ignore the forced "primaryStage" and instead use an instance variable version
     of the basic FX-stage (called mainStage) so that it is more easily accessible.
     */

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("StartScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        mainStage = primaryStage;
        mainStage.setTitle("StartScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     The return of the old stupid MAIN method... I want to switch to Python :(
     */
    public static void main(String[] args) {
        launch(args);
    }
}
