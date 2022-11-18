package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StartScreenController extends GUI {

    // Controller class for the "Start Screen"
    
    @FXML
    private TextField passwordTextField;
    
    @FXML
    private PasswordField secretPasswordTextField;

    @FXML
    private Label connectionMessageLabel;



    /**
     I do not need to explain this, man...
     */
    @FXML
    void quitProgram(ActionEvent event) {
        System.exit(0);
    }

    /**
     Takes user to the administrator side of the application provided that they input the correct password
     (which is "ishockey")
     */
    @FXML
    void showAdminScene(ActionEvent event) {
        String passwordInput = secretPasswordTextField.getText();
        String password = "ishockey";
    
        if (passwordInput.equals(password)) {
            try {
                launchAdminScene();
            } catch (IOException e) {
                e.printStackTrace();
            } // Try-Catch required to use JAVAFX scene-switch
        }
    }

    /**
     Button takes user to customer screen when they press "Logga in" from main menu
     */
    @FXML
    void showCustomerScene(ActionEvent event) {
        try {launchCustomerScene();} catch (IOException e) {e.printStackTrace();}
    }

    /**
     A basic "Test connection" button that calls a simple method in backend to confirm that the connection functions
     */
    @FXML
    void testConnection(ActionEvent event) {
        ConnectionManager connectionManager = new ConnectionManager();
        String answer = connectionManager.sendRequest("hello/?name="+ "works!");
        connectionMessageLabel.setText(answer);
    }
}