package Testing;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import Exception.LabelException;
import gui.SwingProva;
import gui.Ticket;

public class Testing {
	
	private static SwingProva sw;
	
	@BeforeEach
	public void setUp() throws LabelException {
		sw = new SwingProva();
		//Empty the lists
		sw.reset();
	}
	
	@AfterAll
	public static void tearDown() throws Exception {
		sw.reset();
	}
	
	/*
	 * Test method for addTicketToList()
	 */
	@Test
	public void TestAddTicketToList() throws LabelException {
		Ticket t;
		
		t = sw.addTicketToList('A');
		
		assertEquals(t.getLabel(), 'A');
		assertEquals(Integer.valueOf(t.getNumber()), Integer.valueOf(0));
		
		//Invalid label
		assertThrows(LabelException.class, () -> sw.addTicketToList('1'));
		assertThrows(LabelException.class, () -> sw.addTicketToList('n'));
		
	}

}
