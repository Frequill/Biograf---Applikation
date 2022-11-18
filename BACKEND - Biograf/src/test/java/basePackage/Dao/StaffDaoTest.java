package basePackage.Dao;

import basePackage.dataBaseClasses.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StaffDaoTest {

    @Mock
    StaffDao staffDaoMock;

    @Mock
    List<Staff> staffListMock = new ArrayList<>();

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @Mock
    Staff staffMock;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this); // Injecta mocken från denna klass
    }

    @Test
    void insertStaff() {
        // Setup
        String query = "INSERT INTO staff(name, salary, salt1, email_address, salt2) VALUES (?, ?, ?, ?, ? )";
        Mockito.when(jdbcTemplateMock.update(query, "Jan", "100", "Salt1", "jan@mail.se", "Salt2")).thenReturn(1);

        // Action
        int i = jdbcTemplateMock.update(query,"Jan", "100", "Salt1", "jan@mail.se", "Salt2");

        // Result
        assertEquals(1, i);
        Mockito.verify(jdbcTemplateMock).update(query, "Jan", "100", "Salt1", "jan@mail.se", "Salt2");

        System.out.println("Expected: " + 1 + "      Result: " + i); // Output
    }

    @Test
    void getStaffById() {
        //Setup
        Mockito.when(staffDaoMock.getStaffById("01")).thenReturn(staffMock);

        //Action
        Staff fakeStaff = staffDaoMock.getStaffById("01");

        //Result
        assertEquals(staffMock, fakeStaff);

        System.out.println("Expected: " + staffMock + "      Result: " + fakeStaff);
    }

    @Test
    void getAllStaff() {
        //Setup
        List<Staff> staffList = new ArrayList<>();
        staffList.add(staffMock);
        Mockito.when(staffDaoMock.getAllStaff()).thenReturn(staffList);

        //Action
        List testList = staffDaoMock.getAllStaff();

        //Result
        assertEquals(staffList, testList);

        System.out.println("Expected: " + staffList + "      Result: " + testList);
    }

    @Test
    void delete_staff() {
        //Setup
        String works = "works";
        Mockito.when(staffDaoMock.delete_staff("01")).thenReturn(works);

        //Action
        String test = staffDaoMock.delete_staff("01");

        //Result
        assertEquals(works, test);

        System.out.println("Expected: " + works + "      Result: " + test);
    }
}