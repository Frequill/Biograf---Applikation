package basePackage.Dao;

import basePackage.dataBaseClasses.Saloon;
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
public class SaloonDao
{
	@Autowired
	JdbcTemplate jdbcTemplate;


	/**
	 Sends a "SELECT * FROM saloons" statement to database, then stores the information from the table inside
	 a list of maps. Every single saloon is later placed in a new list as saloon Objects which is then returned
	 to the Frontend where it is made into a String.
	 */
	public List<Saloon> getAllSaloons() {
		String query = "SELECT * FROM saloons";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<Saloon> saloonList = new ArrayList<>();
		
		for (Map<String, Object> row : rows) {
			Saloon saloon = new Saloon(Integer.parseInt(row.get("saloon_ID").toString()),
					(String) row.get("saloon_name"),
					(int) row.get("seats"));
			saloonList.add(saloon);
		}
		return saloonList;
	}


	/**
	 Takes to inputs from Frontend (saloon name, and seats). If the name contains a "WHITESPACEHEREX" from frontend
	 it is replaced with a space (" "). The name and the amount of seats are used as parameters to call the
	 "add_saloon" procedure from database which adds the newly created saloon into the system.
	 */
	// This method should be void BUT has been made String so that it can return a value for testing.
	// Remove when greenlit
	public String addSaloon(String saloon_name, String seats){
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String titleSpaceFixed = saloon_name.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_saloon");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("saloon_name", titleSpaceFixed);
		inParameters.put("seats", seats);
		
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		String testReturnable = String.valueOf(simpleJdbcCall.execute(in));
		return testReturnable;
	}


	/**
		Takes one single input from Frontend (saloonID), then uses said input as parameter in the "delete_saloon"
	 	stored procedure in database which simply removes a saloon from the system based on its ID.
	 */
	// This method should be void BUT has been made String so that it can return a value for testing.
	// Remove when greenlit
	public String delete_saloon(String saloonID){
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_saloon");
		
		Integer saloonIDToInt = Integer.parseInt(saloonID);
		
		String testReturnable = String.valueOf(simpleJdbcCall.execute(saloonIDToInt));
		return testReturnable;
	}
	
}
