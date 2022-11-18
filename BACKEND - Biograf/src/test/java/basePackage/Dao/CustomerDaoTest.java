package basePackage.Dao;

import basePackage.dataBaseClasses.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerDaoTest {


    @Mock
    JdbcTemplate jdbcTemplateMock;

    @Mock
    CustomerDao customerDaoMock;


    @Mock
    Customer customerMock = new Customer(04, "Janne", "janne@mail.se", "salt1", "5226641377985525", "salt2");

    @Mock
    List<Customer> customerListMock = new ArrayList<>();

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this); // Injecta mocken från denna klass
    }

    @Test
    void insertCustomer() {
        // Setup
        String query = "INSERT INTO customers(customer_name, customer_email, salt1, creditcard_number, salt2) VALUES (?, ?, ?, ?, ?)";
        Mockito.when(jdbcTemplateMock.update(query,"Janne", "janne@mail.se", "salt1", "5226641377985525", "salt2")).thenReturn(1);

        // Action
        int i = jdbcTemplateMock.update(query, "Janne", "janne@mail.se", "salt1", "5226641377985525", "salt2");

        // Result
        assertEquals(1, i);
        Mockito.verify(jdbcTemplateMock).update(query,"Janne", "janne@mail.se", "salt1", "5226641377985525", "salt2");

        System.out.println("Expected: " + 1 + "      Result: " + i); // Output
    }

    @Test
    void getCustomerById() {
        // Setup
        Mockito.when(customerDaoMock.getCustomerById(Mockito.anyString())).thenReturn(customerMock);

        // Action
        Customer e = customerDaoMock.getCustomerById("Banan");

        // Result
        assertEquals(customerMock, e);
        Mockito.verify(customerDaoMock).getCustomerById("Banan");

        System.out.println("Expected: " + customerMock + "      Result: " + e); // Output
    }

    @Test
    void getAllCustomers() {
        // Setup
        Mockito.when(customerDaoMock.getAllCustomers()).thenReturn(customerListMock);

        // Action
        List<Customer> testList = customerDaoMock.getAllCustomers();

        // Result
        assertEquals(customerListMock, testList);

        System.out.println("Expected: " + customerListMock + "      Now showing testList: --> " + testList + " <--  If testList showed \"customerListMock\" then test was successful!" + ""); // Output
    }


    // Test on stored procedure required small amount of modification to the actual "CustomerDao" class.
    // Can be removed later if/when test has been greenlit.
    @Test
    void addCustomer() {
        // Setup
        String works = "works"; // String I want returned from addCustomer
        Mockito.when(customerDaoMock.addCustomer("Arne", "arne@mail.se", "5887741233635224", "password")).thenReturn(works);

        // Action
        String result = customerDaoMock.addCustomer("Arne", "arne@mail.se", "5887741233635224", "password");

        // Result
        assertEquals(works, result);

        System.out.println("Expected: " + works + "      Actual result: " + result);
    }

    @Test
    void existingUserLogin() {
        // Setup
        String works = "works"; // String I want returned from existingUserLogin
        Mockito.when(customerDaoMock.existingUserLogin("julius@mail.se", "password")).thenReturn(works);

        // Action
        String result = customerDaoMock.existingUserLogin("julius@mail.se", "password");

        // Result
        assertEquals(works, result);

        System.out.println("Expected: " + works + "      Actual result: " + result);
    }

    @Test
    void getValidationNumber() {
        // Setup
        Mockito.when(customerDaoMock.getValidationNumber()).thenReturn("1");

        // Action
        String fakeValidationNumber = customerDaoMock.getValidationNumber();

        // Result
        assertEquals(customerDaoMock.getValidationNumber(), fakeValidationNumber);

        System.out.println("Expected: " + customerDaoMock.getValidationNumber() + "      actual result: " + fakeValidationNumber); // Output
    }

    @Test
    void getCustomerIDByEmail() {
        // Setup
        String works = "works"; // String I want returned from getCustomerIDByEmail
        Mockito.when(customerDaoMock.getCustomerIDByEmail("darth.vader@deathstar.emp")).thenReturn(works);

        // Action
        String fakeResult = customerDaoMock.getCustomerIDByEmail("darth.vader@deathstar.emp");

        // Result
        assertEquals(works, fakeResult);

        System.out.println("Expected: " + works + "      Actual result was: " + fakeResult);
    }

    @Test
    void getIndividualBookings() {
        // Setup
        String user_ID = "ABC";
        String right = "right";
        Mockito.when(customerDaoMock.getIndividualBookings(user_ID)).thenReturn(right);

        // Action
        String result = customerDaoMock.getIndividualBookings(user_ID);

        // Result
        assertEquals(right, result);

        System.out.println("Expected: " + right + "      Actual result: " + result);
    }

    @Test
    void bookTickets() {
        // Setup
        String works = "works"; // String I want returned from bookTickets
        Mockito.when(customerDaoMock.bookTickets("01", "666", "01")).thenReturn(works);

        // Action
        String fakeResult = customerDaoMock.bookTickets("01", "666", "01");

        // Result
        assertEquals(works, fakeResult);

        System.out.println("Expected: " + works + "      Actual result: " + fakeResult);
    }

    @Test
    void delete_order() {
        // Setup
        String works = "works"; // String I want returned from delete_order
        Mockito.when(customerDaoMock.delete_order("01")).thenReturn(works);

        // Action
        String fakeResult = customerDaoMock.delete_order("01");

        // Result
        assertEquals(works, fakeResult);

        System.out.println("Expected: " + works + "      Actual result: " + fakeResult);
    }
}