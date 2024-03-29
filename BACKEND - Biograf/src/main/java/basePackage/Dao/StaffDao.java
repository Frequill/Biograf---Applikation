package basePackage.Dao;

import basePackage.dataBaseClasses.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
@Repository
public class StaffDao extends JdbcDaoSupport {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize() {
        setJdbcTemplate(jdbcTemplate);
    }


    /**
     Takes 5 inputs from Frontend (name, salary, salt1, email and salt2), then replaces any "WHITESPACEHEREX" found
     in any of the Strings from Frontend with spaces (" "). These Strings are then used as parameters for a prepared-
     statement which inserts this new staff member into the database.
     */
    public void insertStaff(String name, String salary, String salt1, String email_address, String salt2) {
        // If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
        // This phrase is replaced back with a space here so that the String takes its original form with spaces included
        // (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
        String nameSpaceFixed = name.replace("WHITESPACEHEREX", " ");
        String salarySpaceFixed = salary.replace("WHITESPACEHEREX", " ");
        String salt1SpaceFixed = salt1.replace("WHITESPACEHEREX", " ");
        String email_addressSpaceFixed = email_address.replace("WHITESPACEHEREX", " ");
        String salt2SpaceFixed = salt2.replace("WHITESPACEHEREX", " ");
        
        String query = "INSERT INTO staff(name, salary, salt1, email_address, salt2) VALUES (?, ?, ?, ?, ? )";

        int result = jdbcTemplate.update(query, nameSpaceFixed, salarySpaceFixed, salt1SpaceFixed, email_addressSpaceFixed, salt2SpaceFixed);

        if (result > 0) {
            System.out.println(result + " staff added to database");
        }
    }


    /**
     Takes a single input from Frontend (staffID), then uses this String for a
     "SELECT * FROM staff WHERE staff_ID = input  statement. The resulting information is then placed in a
     Staff object which is returned to Frontend where it becomes a String.
     */
    public Staff getStaffById(String staff_id) {
        String query = "SELECT * FROM staff WHERE staff_ID = ?";

        Staff staff = jdbcTemplate.queryForObject(query, new RowMapper<Staff>() {
            @Override
            public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
                Staff staff = new Staff(rs.getInt("staff_ID"),
                        rs.getString("name"),
                        rs.getString("salary"),
                        rs.getString("salt1"),
                        rs.getString("email_address"),
                        rs.getString("salt2"));

                return staff;
            }
        }, staff_id);

        return staff;
    }


    /**
     Sends a "SELECT * FROM staff" statement to database, every single row from the "staff" table is then placed into
     a list of maps which has the column names as keys. Every single row is then placed into an ArrayList
     called "staffList" which is returned to Frontend where it becomes a String.
     */
    public List<Staff> getAllStaff() {
        String query = "SELECT * FROM staff";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        List<Staff> staffList = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            Staff staff = new Staff(Integer.parseInt(row.get("staff_ID").toString()),
                    (String) row.get("name"),
                    (String) row.get("salary"),
                    (String) row.get("salt1"),
                    (String) row.get("email_address"),
                    (String) row.get("salt2"));
            staffList.add(staff);
        }
        return staffList;
    }


    /**
     Takes a single input from Frontend (staffID), then uses this as the parameter for calling the stored procedure
     "delete_staff" from database. Said procedure then deletes the staff memeber in question based on the ID that
     was given.
     */
    // This method should be void BUT has been made String so that it can return a value for testing.
    // Remove when greenlit
    public String delete_staff(String s_ID){
        
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_staff");
        
        Integer s_IDToInt = Integer.parseInt(s_ID);
        
        String testReturnable = String.valueOf(simpleJdbcCall.execute(s_IDToInt));
        return testReturnable;
    }
}