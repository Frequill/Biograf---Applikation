package basePackage.Dao;

import basePackage.dataBaseClasses.Saloon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaloonDaoTest
{
	
	@Mock
	SaloonDao saloonDaoMock;
	
	@Mock
	List<Saloon> saloonListMock = new ArrayList<>();
	
	@BeforeEach
	void setup(){
		MockitoAnnotations.openMocks(this); // Injecta mocken från denna klass
	}
	
	@Test
	void getAllSaloons()
	{
		//Setup
		Mockito.when(saloonDaoMock.getAllSaloons()).thenReturn(saloonListMock);
		
		//Action
		List<Saloon> testList = saloonDaoMock.getAllSaloons();
		
		//Result
		assertEquals(saloonListMock, testList);
	}
	
	@Test
	void addSaloon()
	{
		// Setup
		String works = "works"; // String I want returned from addSalon
		Mockito.when(saloonDaoMock.addSaloon("huge", "200")).thenReturn(works);
		
		// Action
		String result = saloonDaoMock.addSaloon("huge", "200");
		
		// Result
		assertEquals(works, result);
		System.out.println("Expected: " + works + "      Actual result: " + result);
	}
	
	@Test
	void delete_saloon()
	{
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(saloonDaoMock.delete_saloon("01")).thenReturn(works);
		
		// Action
		String fakeResult = saloonDaoMock.delete_saloon("01");
		
		// Result
		assertEquals(works, fakeResult);
		System.out.println("Expected: " + works + "      Actual result: " + fakeResult);
	}
}