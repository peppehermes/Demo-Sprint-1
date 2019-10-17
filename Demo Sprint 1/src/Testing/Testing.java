package Testing;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import Exception.LabelException;
import Functions.Functions;
import gui.Main;
import gui.Ticket;

public class Testing {
	
	private static Main m;
	
	
	@BeforeEach
	public void setUp() throws LabelException {
		m = new Main();

		//Empty the lists
		Functions.reset();
	}
	
	
	@AfterAll
	public static void tearDown() throws Exception {
		Functions.reset();
	}
	
	/*
	 * Test method for addTicketToList()
	 */
	@Test
	public void TestAddTicketToList() throws LabelException {
		Ticket t;
		
		t = Functions.addTicketToList('A');
		
		assertEquals(t.getLabel(), 'A');
		assertEquals(Integer.valueOf(t.getNumber()), Integer.valueOf(1));
		
		t = Functions.addTicketToList('P');
		
		assertEquals(t.getLabel(), 'P');
		assertEquals(Integer.valueOf(t.getNumber()), Integer.valueOf(1));
		
		// Second insert in Account, the number of the ticket should be 2
		t = Functions.addTicketToList('A');
		
		assertEquals(t.getLabel(), 'A');
		assertEquals(Integer.valueOf(t.getNumber()), Integer.valueOf(2));
		
		//Invalid label
		assertThrows(LabelException.class, () -> Functions.addTicketToList('1'));
		assertThrows(LabelException.class, () -> Functions.addTicketToList('n'));		
	}

}
