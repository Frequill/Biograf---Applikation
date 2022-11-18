package basePackage.Dao;

import basePackage.dataBaseClasses.Upcomming_screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScreeningDao
{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 Takes four inputs from Frontend (Movie title, studio name, date and saloon), then uses these inputs as parameters
	 for calling the "add_screening" stored procedure in database which creates a new saloon based on the
	 administrators inputs.

	 * This method can fuck off!  //Julius           (But I fixed it!)
	 */

	// This method should be void BUT has been made String so that it can return a value for testing.
	// Remove when greenlit
	public String addScreenings(String title, String studio, String screening_date, String saloon) {
		
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String titleSpaceFixed = title.replace("WHITESPACEHEREX", " ");
		String studioSpaceFixed = studio.replace("WHITESPACEHEREX", " ");
		String screening_dateSpaceFixed = screening_date.replace("WHITESPACEHEREX", " ");
		String saloonSpaceFixed = saloon.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_screening");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("title", titleSpaceFixed);
		inParameters.put("studio", studioSpaceFixed);
		inParameters.put("screening_date", screening_dateSpaceFixed);
		inParameters.put("saloon", saloonSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		String testReturnable = String.valueOf(simpleJdbcCall.execute(in));
		return testReturnable;
	}


	/**
	 Sends a "SELECT * FROM upcomming_screenings (YES, it is misspelled)" statement to database and stores all
	 information returned in a HashMap which has the column names from the database-table as keys. All the info
	 is then returned into a list of upcoming screenings which is then returned to Frontend where it becomes a String.
	 */
	public List<Upcomming_screening> getAllScreenings() {
		String query = "SELECT * FROM upcomming_screenings";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<Upcomming_screening> screeningList = new ArrayList<>();

		for (Map<String, Object> row : rows) {
			Upcomming_screening upcomming_screening = new Upcomming_screening(Long.parseLong(row.get("screening_ID").toString()),
					(String) row.get("title"),
					(String) row.get("studio"),
					(String) row.get("screening_date"),
					(String) row.get("saloon"),
					(String) row.get("avalible_tickets").toString());
			screeningList.add(upcomming_screening);

		}
		return screeningList;
	}


	/**
	 Takes a single input from Frontend (movieID) ((which is a screening_ID in database)), then sends a
	 "DELETE FROM upcomming_screenings WHERE screening_ID = input" statement to database which allows the administrator
	 to easily delete the screening in question.
	 */
	public void deleteScreeningById(String movie_ID) {
		String query = "DELETE FROM upcomming_screenings WHERE screening_ID = ?";
		
		int result = jdbcTemplate.update(query, movie_ID);
		
		if (result > 0){
			System.out.println(result + "Screening deleted from database");
		}
	}


	/**
	 Takes 2 inputs from Frontend (ticket amount and screeningID). These inputs are sent here from Frontend when
	 a customer deletes a previously made ticket order. The database stored procedure "restore_tickets" is then
	 called with these inputs as parameters. The tickets that were purchased are then returned to upcoming screenings
	 so other users can purchase these tickets instead. (Smart feature!)
	 */
	// This method should be void BUT has been made String so that it can return a value for testing.
	// Remove when greenlit
	public String restoreTickets(String amount_of_tickets, String screeningID) {

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("restore_tickets");

		Map<String, String> inParameters = new HashMap<>();

		inParameters.put("amount_of_tickets", amount_of_tickets);
		inParameters.put("screeningID", screeningID);

		SqlParameterSource in = new MapSqlParameterSource(inParameters);

		String testReturnable = String.valueOf(simpleJdbcCall.execute(in));
		return testReturnable;
	}
	
	
}
