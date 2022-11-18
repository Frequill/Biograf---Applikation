package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddStaffScreenController extends GUI {
	
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField salaryTextField;
	
	@FXML
	private TextField salt1TextField;
	
	@FXML
	private TextField email_addressTextField;
	
	@FXML
	private TextField salt2TextField;
	
	@FXML
	void confirmInput(ActionEvent event) {
		String nameInput = nameTextField.getText();
		String salaryInput = salaryTextField.getText();
		String salt1Input = salt1TextField.getText();
		String email_addressInput = email_addressTextField.getText();
		String salt2Input = salt2TextField.getText();

		String finalNameInput = nameInput.replace(" ", "WHITESPACEHEREX");
		String finalSalaryInput = salaryInput.replace(" ", "WHITESPACEHEREX");
		String finalSalt1Input = salt1Input.replace(" ", "WHITESPACEHEREX");
		String finalEmail_addressInput = email_addressInput.replace(" ", "WHITESPACEHEREX");
		String finalSalt2Input = salt2Input.replace(" ", "WHITESPACEHEREX");

		System.out.println("All the shit from FRONTEND: " + finalNameInput + finalSalaryInput + finalSalt1Input + finalEmail_addressInput + finalSalt2Input);
		ConnectionManager connectionManager = new ConnectionManager();
		connectionManager.sendRequest("addStaff/?valuesAsCSV=" + "," + finalNameInput + "," + finalSalaryInput + ","+  finalSalt1Input + "," + finalEmail_addressInput + "," + finalSalt2Input);
	}
	
	@FXML
	void goToStaffScreen(ActionEvent event)
	{try{launchStaffScene();} catch (IOException e) {e.printStackTrace();}}
}
