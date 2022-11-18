package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CustomerScreenController extends GUI {
	
	@FXML
	private TextField existingUserLoginTextField;
	
	@FXML
	private PasswordField existingUserPWTextField;
	
	@FXML
	private TextField newUserCreditcardTextField;
	
	@FXML
	private TextField newUserEmailTextField;
	
	@FXML
	private TextField newUserNameTextField;
	
	@FXML
	private PasswordField newUserPWTextField;
	
	@FXML
	private Label existingUserConfirmedLabel1;
	
	@FXML
	private Label newUserConfirmedLabel;
	
	@FXML
	private Label logInErrorMsgLabel;
	
	@FXML
	void createNewUser(ActionEvent event) {
		String newUserNameInput = newUserNameTextField.getText().replace(" ", "WHITESPACEHEREX");
		String newUserEmailInput = newUserEmailTextField.getText().replace(" ", "WHITESPACEHEREX");
		String newUserCreditcardInput = newUserCreditcardTextField.getText().replace(" ", "WHITESPACEHEREX");
		String newUserPWInput = newUserPWTextField.getText().replace(" ", "WHITESPACEHEREX");

		ConnectionManager connectionManager = new ConnectionManager();
		String answer = connectionManager.sendRequest("compareCustomerEmail/?email=" + newUserEmailInput);
		System.out.println("This is in answer: " + answer);

		if (answer.equals("[]")){
			connectionManager.sendRequest("addCustomer/?valuesAsCSV=" + "," + newUserNameInput + "," + newUserEmailInput + "," + newUserCreditcardInput + "," + newUserPWInput);
			newUserConfirmedLabel.setText("Användaren har lagts till i systemet!");
		} else {
			newUserConfirmedLabel.setText("Den inmatade email-adressen finns redan i systemet...");
		}
	}

	
	@FXML
	void existingUserLogin(ActionEvent event) throws IOException {
		String existingUserEmailInput = existingUserLoginTextField.getText().replace(" ", "WHITESPACEHEREX");
		String existingUserPWInput = existingUserPWTextField.getText().replace(" ", "WHITESPACEHEREX");
		
		ConnectionManager connectionManager = new ConnectionManager();
		connectionManager.sendRequest("verify_customer/?valuesAsCSV=" + "," + existingUserEmailInput + "," + existingUserPWInput);
		
		String answer = connectionManager.sendRequest("getLastValidationNumber");

		String finalAnswer = String.valueOf(answer.charAt(14));
		
		System.out.println("THIS " + finalAnswer);
		
		if(finalAnswer.equals("2")){
			setCurrentUser(existingUserEmailInput);
			launchLoggedInUser();
		} else if (finalAnswer.equals("1")){
			logInErrorMsgLabel.setText("Felaktigt lösenord!");
		} else {
			logInErrorMsgLabel.setText("Användaren existerar inte!");
		}
	}
	
	@FXML
	void goToStartScreen(ActionEvent event) throws IOException {
		launchStartScene();
	}
}
