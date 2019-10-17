package Testing;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import gui.SwingProva;
import gui.Ticket;

public class Testing {
	
	private static SwingProva sw;
	
	@BeforeEach
	public void setUp() {
		sw = new SwingProva();
		//Empty the databases
		//sw.reset();
	}
	
	@AfterAll
	public static void tearDown() throws Exception {
		//sw.reset();
	}
	
	/*
	 * Test method for addTicketToList()
	 */
	@Test
	public void TestAddTicketToList() {
		Ticket t;
		
		t = sw.addTicketToList('A');
		
		assertEquals(t.getLabel(), 'A');
		assertEquals(Integer.valueOf(t.getNumber()), Integer.valueOf(0));
		
	}

}
