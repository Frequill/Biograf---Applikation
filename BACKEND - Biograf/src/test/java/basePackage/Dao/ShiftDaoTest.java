package basePackage.Dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import basePackage.dataBaseClasses.Saloon;
import basePackage.dataBaseClasses.Shift;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import javax.sql.DataSource;

class ShiftDaoTest
{
	
	@Mock
	JdbcTemplate jdbcTemplateMock;
	
	@Mock
	ShiftDao shiftDaoMock = new ShiftDao();
	
	@Mock
	List<Shift> shiftListMock = new ArrayList<>();
	
	@BeforeEach
	void setup(){
		MockitoAnnotations.openMocks(this); // Injecta mocken från denna klass
	}
	
	@Test
	void getAllShifts() {
		//Setup
		Mockito.when(shiftDaoMock.getAllShifts()).thenReturn(shiftListMock);
		
		//Action
		List<Shift> testList = shiftDaoMock.getAllShifts();
		
		//Result
		assertEquals(shiftListMock, testList);
	}
	
	@Test
	void addShift()
	{
		// Setup
		String works = "works"; // String I want returned from addSalon
		Mockito.when(shiftDaoMock.addShift("1", "2022-02-02 22:00", "2022-02-02 23:59" )).thenReturn(works);
		
		// Action
		String result = shiftDaoMock.addShift("1","2022-02-02 22:00", "2022-02-02 23:59");
		
		// Result
		assertEquals(works, result);
		System.out.println("Expected: " + works + "      Actual result: " + result);
	}
	
	@Test
	void delete_shift()
	{
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(shiftDaoMock.delete_shift("1")).thenReturn(works);
		
		// Action
		String fakeResult = shiftDaoMock.delete_shift("1");
		
		// Result
		assertEquals(works, fakeResult);
		System.out.println("Expected: " + works + "      Actual result: " + fakeResult);
	}
}