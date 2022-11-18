package basePackage.Dao;

import basePackage.dataBaseClasses.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
@Repository
public class CustomerDao extends JdbcDaoSupport {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @PostConstruct
    private void initialize(){
        setJdbcTemplate(jdbcTemplate);
    }


    /**
     Takes a single input from Frontend (id), then sends a "SELECT * FROM customers WHERE customer_ID = input"
     statement to database. A customer object is then made which contains the info of the customer whos ID matches
     the ID that was sent from Frontend. This customer Obj is then returned to Frontend where it becomes a String.

     This way we can easily find a single customer from the administrators side of our frontend by just inputting
     a users ID.
     */
    public Customer getCustomerById(String id)
    {
        String query = "SELECT * FROM customers WHERE customer_ID = ?";
        
        Customer customer = jdbcTemplate.queryForObject(query, new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer cus = new Customer(rs.getInt("customer_ID"),
                    rs.getString("customer_name"),
                    rs.getString("customer_email"),
                    rs.getString("salt1"),
                    rs.getString("creditcard_number"),
                    rs.getString("salt2"));
                
                    return cus;
                }
        }, id);
        return customer;
    }


    /**
     Sends a "SELECT * FROM customers" statement to database and places all table information in a map that's ordered
     by column names. Each "customer" (every row in the 'customers' table) is then placed into an ArrayList which
     is returned to the frontend, so it can be displayed.
     */
    public List<Customer> getAllCustomers(){
        String query = "SELECT * FROM customers";
        
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        List<Customer> customerList = new ArrayList<>();
        
        for (Map<String, Object> row: rows){
            Customer customer = new Customer((long)row.get("customer_ID"),
                    (String)row.get("customer_name"),
                    (String)row.get("customer_email"),
                    (String)row.get("salt1"),
                    (String)row.get("creditcard_number"),
                    (String)row.get("salt2"));
            customerList.add(customer);
        }
        return customerList;
    }


    /**
     Takes in 4 strings (name, email, password, credit card nr and password), removes 'WHITESPACEHEREX' from each string
     and inserts spaces (" ") instead.

     The stored procedure "add_customer" is then executed with all four strings as parameters, adding the inputs
     as a brand-new customer profile in the database.
     */
    // This method should be void BUT has been made String so that it can return a value for testing.
    // Remove when greenlit
    public String addCustomer(String user_name, String user_email, String user_creditcard, String user_password) {
        // If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
        // This phrase is replaced back with a space here so that the String takes its original form with spaces included
        // (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
        String user_nameSpaceFixed = user_name.replace("WHITESPACEHEREX", " ");
        String user_emailSpaceFixed = user_email.replace("WHITESPACEHEREX", " ");
        String user_creditcardSpaceFixed = user_creditcard.replace("WHITESPACEHEREX", " ");
        String user_passwordSpaceFixed = user_password.replace("WHITESPACEHEREX", " ");

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_customer");

        Map<String, String> inParameters = new HashMap<>();

        inParameters.put("customer_name", user_nameSpaceFixed);
        inParameters.put("customer_email", user_emailSpaceFixed);
        inParameters.put("creditcard_number", user_creditcardSpaceFixed);
        inParameters.put("customer_password", user_passwordSpaceFixed);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        String testReturnable = String.valueOf(simpleJdbcCall.execute(in));
        return testReturnable;
    }


    /**
     Takes in 2 strings (email and password), removes 'WHITESPACEHEREX' from each string
     and inserts spaces (" ") instead.

     The stored procedure "verify_customer" is then executed with both strings as parameters, ensuring that the
     email + password combination fits an existing user in the database. If it does, the user may be logged in.
     */
    // This method should be void BUT has been made String so that it can return a value for testing.
    // Remove when greenlit
    public String existingUserLogin (String users_email, String users_password){
        String users_emailSpaceFixed = users_email.replace("WHITESPACEHEREX", " ");
        String users_passwordSpaceFixed = users_password.replace("WHITESPACEHEREX", " ");
    
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("verify_customer");
    
        Map<String, String> inParameters = new HashMap<>();
    
        inParameters.put("users_email", users_emailSpaceFixed);
        inParameters.put("users_password", users_passwordSpaceFixed);
    
        SqlParameterSource in = new MapSqlParameterSource(inParameters);
    
        String testReturnable = String.valueOf(simpleJdbcCall.execute(in));
        
        return testReturnable;
    }


    /**
     When a login attempt is being made by a user, database adds a 0, 1 or 2 to an otherwise empty table.
     The number represents matching inputs from user and saved customer information. As in, if the login-attempt results
     in a number 0, all information did not match anything in the database. If it's a 1 the email was correct but the
     password wasn't (feedback is returned to user in frontend), and if the number is 2 we know that both the email
     and passwords are correct, the user may then be logged in successfully!

     This method essentially just retrieves this number and sends it back to the frontend so that it can be verified.
     */
    public String getValidationNumber(){
        String query = "SELECT * FROM user_validation";
    
        String answer = String.valueOf(jdbcTemplate.queryForList(query));
        
        return answer;
    }


    /**
     Calls the database stored procedure "get_customerIDByEmail" using inputted email as parameter. This way, we can
     know which customer ID belongs to the user in question (since the same email-address can NOT be used in more than
     one account).
     */
    public String getCustomerIDByEmail(String email){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_customerIDByEmail");
        String answer = String.valueOf(simpleJdbcCall.execute(email));

        return answer;
    }


    /**
     A "SELECT * FROM transactions" statement is executed for the ID that was inputted. The result is then saved
     and returned. This way we can fetch all bookings for a single account without adding in any other users bookings.
     */
    public String getIndividualBookings(String user_ID){
        String query = "SELECT * FROM transactions WHERE customer_ID = " + user_ID;
    
        String answer = String.valueOf(jdbcTemplate.queryForList(query));
    
        return answer;
    }

    /**
     Takes three inputs from Frontend (userID, ticket(s) and movieID), places them in a HashMap with database column
     names as keys and executes a call for the stored procedure "book_tickets" which creates a transaction for the
     logged-in user in question and removes the amount of tickets they booked from the available tickets of
     that screening so no overbooking is ensured.
     */
    // This method should be void BUT has been made String so that it can return a value for testing.
    // Remove when greenlit
    public String bookTickets(String customer_ID, String amountOfDesiredTickets, String movie_ID) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("book_tickets");
        
        Map<String, String> inParameters = new HashMap<>();
        
        inParameters.put("customer_ID",customer_ID);
        inParameters.put("tickets", amountOfDesiredTickets);
        inParameters.put("movie_by_ID", movie_ID);
        
        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        
        String testReturnable = String.valueOf(simpleJdbcCall.execute(in));
        return testReturnable;
    }


    /**
     Takes in one input from Frontend (orderID), then executes a call for the stored procedure "delete_order"
     in database which removes the users order in question based on its ID.
     */
    // This method should be void BUT has been made String so that it can return a value for testing.
    // Remove when greenlit  ** TEST MUST BE FIXED FOR THIS METHOD** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public String delete_order(String orderID){
        
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_order");
        
        Integer orderIDToInt = Integer.parseInt(orderID);
        
        String testReturnable = String.valueOf(simpleJdbcCall.execute(orderIDToInt));
        System.out.println(testReturnable);
        return testReturnable;
    }


    /**
     Takes in one input from Frontend (email), replaces "WHITESPACEHEREX" with a space (" ")then executes a basic
     "SELECT * FROM customers WHERE customer_email = input". This way we can easily know if the inputted email
     is already in use in our system when user attempts to create a new account.
     */
    public String compareCustomerEmail(String email){
        String emailSpaceFix = email.replace("WHITESPACEHEREX", " ");

        String query = "SELECT * FROM customers WHERE customer_email = ?";
        String answer = String.valueOf(jdbcTemplate.queryForList(query, emailSpaceFix));

        return answer;
    }


}
