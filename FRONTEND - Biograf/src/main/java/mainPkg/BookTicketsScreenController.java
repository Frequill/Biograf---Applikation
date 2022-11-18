package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.io.IOException;

public class BookTicketsScreenController extends GUI {

    @FXML
    private TextField amountOfTicketsTextField;

    @FXML
    private TextField movieIDTextField;

    @FXML
    private TextArea upcommingScreeningsTextArea;

    @FXML
    private Label bookingCompletedMessageLabel;


    public void initialize() {  // This function refreshes the field with all of the users bookings,
                                // the name "initialize" means that this is run by default when
                                // "Book tickets" scene is launched

        ConnectionManager connectionManager = new ConnectionManager();
        String allScreenings = connectionManager.sendRequest("getAllScreenings");

        String firstAllScreenings = allScreenings.replace("},", "}\n\n");
        String secondScreenings = firstAllScreenings.replace("[", " ");
        String thirdScreenings = secondScreenings.replace("]", "");
        String finalScreenings = thirdScreenings.replace("screening_date", "\nscreening_date");

        upcommingScreeningsTextArea.setFont(new Font("System", 12));
        upcommingScreeningsTextArea.setText(finalScreenings);
    }

    @FXML
    void bookTickets(ActionEvent event) {
        ConnectionManager connectionManager = new ConnectionManager();

        String user_ID = connectionManager.sendRequest("getUser_ID/?userEmailAddress=" + getCurrentUser());
        String finalUser_ID = String.valueOf(user_ID.charAt(29)); // Works
        String fullList = connectionManager.sendRequest("getMyBookings/?user_ID=" + finalUser_ID);
        String[] fullListSplitted = fullList.split(","); // Creating the first split-array

        connectionManager.sendRequest("bookTickets/?valuesAsCSV=" + "," + finalUser_ID + "," + amountOfTicketsTextField.getText() + "," + movieIDTextField.getText());

        String secondFullList = connectionManager.sendRequest("getMyBookings/?user_ID=" + finalUser_ID);
        String[] secondFullListSplitted = secondFullList.split(","); // creating the second split-array


        // The two "split-arrays" are compared to see weather the booking was added into database or not
        // If the movie is not added that's because a ROLLBACK has occurred and a rollback can ONLY auto-occur
        // because of an order exceeding the available stock in tickets for the screening in question.
        // As a result we can assume that IF-user had rollback occur THEN they tried to purchase too many tickets.
        // And IF a rollback did INDEED occur THEN the new array will not have grown larger that the older array
        // (Since no new information has been added) Logically, we can then understand that if both arrays are of
        // equal size, then nothing has been added because of a rollback caused because user wanted too many tickets.
        if (secondFullListSplitted.length > fullListSplitted.length){
            bookingCompletedMessageLabel.setText("Ditt köp lyckades!");
        } else if (secondFullListSplitted.length == fullListSplitted.length){
            bookingCompletedMessageLabel.setText("Ditt köp misslyckades på grund av platsbrist.");
        }
        initialize(); // Re-running "initialize" method to auto-update the list of users bookings!
    }


    @FXML
    void goToLoggedInUserScreen(ActionEvent event) throws IOException {
        launchLoggedInUser();
    }

}
