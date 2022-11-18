package mainPkg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;

public class StaffScreenController extends GUI{
    
    @FXML
    private TextField IdInputField;
    
    @FXML
    private TextField deleteField;

    @FXML
    private TextArea staffInfoTextField;


    /**
     Takes user to "Add-shift screen"
     */
    @FXML
    void addShift(ActionEvent event) {
        try{launchAddShiftScene();} catch (IOException e) {e.printStackTrace();}
    }

    /**
     Takes user to "Add-staff screen"
     */
    @FXML
    void addStaff(ActionEvent event) throws IOException {
        launchAddStaffScene();
    }

    @FXML
    void deleteStaffById(ActionEvent event) {
        String usersId = deleteField.getText();
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.sendDeleteRequest("deleteStaffById?s_ID="+ usersId);
    }
  
    @FXML
    void getAllStaff(ActionEvent event) {
        ConnectionManager connectionManager = new ConnectionManager();
        String answers = connectionManager.sendRequest("getAllStaff");

        String firstAnswers = answers.replace("},", "}\n\n");
        String secondAnswers = firstAnswers.replace("[", " ");
        String thirdAnswers = secondAnswers.replace("]", "");
        String finalScreenings = thirdAnswers.replace("saloon", "\nsaloon");

        staffInfoTextField.setText(finalScreenings);
    }
    
    @FXML
    void getStaffById(ActionEvent event) {
        String usersId = IdInputField.getText();
        ConnectionManager connectionManager = new ConnectionManager();
        String answer = connectionManager.sendRequest("getStaffByID/?staff_ID="+ usersId);

        staffInfoTextField.setText(answer);
    }
    
    @FXML
    void goToAdminScreen(ActionEvent event) {
        try {launchAdminScene();} catch (IOException e) {e.printStackTrace();}
    }
    
}
