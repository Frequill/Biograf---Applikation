package basePackage.Dao;

import basePackage.dataBaseClasses.Upcomming_screening;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningDaoTest {

    @Mock
    ScreeningDao screeningDaoMock;

    @Mock
    Upcomming_screening upcomming_screeningMock;

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this); // Injecta mocken från denna klass
    }

    @Test
    void restoreTickets() {
        // Setup
        String works = "works"; // String I want returned from delete_order
        Mockito.when(screeningDaoMock.restoreTickets("1", "1")).thenReturn(works);

        // Action
        String fakeResult = screeningDaoMock.restoreTickets("1", "1");

        // Result
        assertEquals(works, fakeResult);

        System.out.println("Expected: " + works + "      Actual result: " + fakeResult);
    }

    @Test
    void addScreenings() {
        // Setup
        String works = "works"; // String I want returned from addSalon
        Mockito.when(screeningDaoMock.addScreenings("Movie", "Studio", "date", "Saloon")).thenReturn(works);

        // Action
        String result = screeningDaoMock.addScreenings("Movie", "Studio", "date", "Saloon");

        // Result
        assertEquals(works, result);
        System.out.println("Expected: " + works + "      Actual result: " + result);
    }

    @Test
    void getAllScreenings() {
        //Setup
        List<Upcomming_screening> works = new ArrayList<>();
        works.add(upcomming_screeningMock);
        Mockito.when(screeningDaoMock.getAllScreenings()).thenReturn(works);

        //Action
        List<Upcomming_screening> resultList = screeningDaoMock.getAllScreenings();

        //Result
        assertEquals(works, resultList);
    }

    @Test
    void deleteScreeningById() {
        // Setup
        String query = "DELETE FROM upcomming_screenings WHERE screening_ID = ?";
        Mockito.when(jdbcTemplateMock.update(query, 01)).thenReturn(1);

        // Action
        int i = jdbcTemplateMock.update(query, 01);

        // Result
        assertEquals(1, i);
        Mockito.verify(jdbcTemplateMock).update(query, 01);

        System.out.println("Expected: " + 1 + "      Result: " + i); // Output
    }
}