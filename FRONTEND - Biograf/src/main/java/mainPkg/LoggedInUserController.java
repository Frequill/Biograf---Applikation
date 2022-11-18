package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoggedInUserController extends GUI {
	
	@FXML
	private Label userGreetingLabel;
	
	@FXML
	private TextArea showMyBookings;
	
	@FXML
	private TextField order_IDDeleteTextField;
	
	@FXML
	private Label deleteMsgLabel;
	
	public void initialize() {
		userGreetingLabel.setText("Current profile: " + getCurrentUser());
	}
	
	@FXML
	void goToCustomerScreen(ActionEvent event) throws IOException {
		launchCustomerScene();
	}
	
	@FXML
	void deleteUserBooking(ActionEvent event) {
		String order_IDDelete = order_IDDeleteTextField.getText();
		ConnectionManager connectionManager = new ConnectionManager();
		String result = connectionManager.sendDeleteRequest("deleteOrderByID?orderID=" + order_IDDelete);

		String[] splitResult = result.split("],");

		String removedEquals = splitResult[0].replace("=", " ");
		String[] splitResultIndexZeroSplit = removedEquals.split(" ");
		String finalTickets = splitResultIndexZeroSplit[5].replace("}", ""); // THIS IS HOW MANY TICKETS YOU HAD

		String removedEquals2 = splitResult[1].replace("=", " ");
		String[] splitResultIndexOneSplit = removedEquals2.split(" ");
		String finalScreeningID = splitResultIndexOneSplit[6].replace("}", ""); // THIS IS THE SCREENING_ID YOU HAD

		connectionManager.sendDeleteRequest("restoreTickets?valuesAsCSV=" + "," + finalTickets + "," + finalScreeningID); // Worked!
		
		showMyBookings.setText("Visningen med Order_ID: " + order_IDDelete + " är inte längre bokad!\n" + finalTickets + " biljetter är returnerade!");
	}
	
	@FXML
	void goToBookTicketScreen(ActionEvent event) throws IOException {
		launchBookTicketsScene();
	}
	
	@FXML
	void showUsersBookings(ActionEvent event) {
		ConnectionManager connectionManager = new ConnectionManager();
		
		String user_ID = connectionManager.sendRequest("getUser_ID/?userEmailAddress=" + getCurrentUser());
		String finalUser_ID = String.valueOf(user_ID.charAt(29));
		
		String fullList = connectionManager.sendRequest("getMyBookings/?user_ID=" + finalUser_ID);
		
		String finalFullList = fullList.replace("}" , "\n\n");
		System.out.println(finalFullList);

		if (finalFullList.equals("[]")){
			String emptyResult = finalFullList.replace("[]", "You have no current bookings...");
			showMyBookings.setText(emptyResult);
		} else{
			showMyBookings.setText(finalFullList);
		}
	}
}
