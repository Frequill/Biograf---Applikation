package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddMoviesController extends GUI {
	
	@FXML
	private TextField saloonTextField;
	
	@FXML
	private TextField screeningdateTextField;
	
	@FXML
	private TextField studioTextField;
	
	@FXML
	private TextField titleTextField;
	
	@FXML
	private Label movieAddedLabel;
	
	@FXML
	void confirmMovie(ActionEvent event) {
		// Replaces spaces with the phrase "WHITESPACEHEREX" to fix an annoying bug where program would refuse to take in spaces as a request-parameter...
		String moveTitle = titleTextField.getText().replace(" ", "WHITESPACEHEREX");
		String studio = studioTextField.getText().replace(" ", "WHITESPACEHEREX");
		String screeningdate = screeningdateTextField.getText().replace(" ", "WHITESPACEHEREX");
		String saloon = saloonTextField.getText().replace(" ", "WHITESPACEHEREX");
		
		ConnectionManager connectionManager = new ConnectionManager();
		connectionManager.sendRequest("addScreening/?valuesAsCSV=" + "," + moveTitle + "," + studio + ","+  screeningdate + "," + saloon);

		// String "checkMeForBadGrammar" is made so that all strings can be checked for bad inputs!
		String checkMeForBadGrammar = moveTitle + " " + studio + " " + screeningdate + " " + saloon;

		if (checkMeForBadGrammar.contains("Å") || checkMeForBadGrammar.contains("Ä") || checkMeForBadGrammar.contains("Ö")
		|| checkMeForBadGrammar.contains("å") || checkMeForBadGrammar.contains("ä") || checkMeForBadGrammar.contains("ö")){
			movieAddedLabel.setText("Inga svenska bokstäver tillåtna!"); // If input is allowed...
		} else {
			movieAddedLabel.setText("Filmen har lagts till i visningslistan"); // Else if input contains illegal chars...
		}
	}
	
	@FXML
	void goToAllScreeningsScene(ActionEvent event) throws IOException {
		launchAllScreeningsScene();
	}
	
	@FXML
	void goToAdminScreen(ActionEvent event) throws IOException {
		launchAdminScene();
	}
	
}