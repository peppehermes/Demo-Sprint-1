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
	
	// BeforeEach not working
	@BeforeEach
	public static void setUp() {
		Functions.reset();
		System.out.println("BeforeEach setUp() method called");
	}	
	
	// AfterAll not working
	@AfterAll
	public static void tearDown() {
		Functions.reset();
	}
	
	/*
	 * Test method for addTicketToList()
	 */
	@Test
	public void TestAddTicketToList() throws LabelException {
		Functions.reset();
		Ticket t;
		
		t = Functions.addTicketToList('A');
		
		assertEquals('A', t.getLabel());
		assertEquals(Integer.valueOf(1), Integer.valueOf(t.getNumber()));
		
		t = Functions.addTicketToList('P');
		
		assertEquals('P', t.getLabel());
		assertEquals(Integer.valueOf(1), Integer.valueOf(t.getNumber()));
		
		// Second insert in Account, the number of the ticket should be 2
		t = Functions.addTicketToList('A');
		
		assertEquals('A', t.getLabel());
		assertEquals(Integer.valueOf(2), Integer.valueOf(t.getNumber()));
		
		//Invalid label
		assertThrows(LabelException.class, () -> Functions.addTicketToList('1'));
		assertThrows(LabelException.class, () -> Functions.addTicketToList('n'));		
	}
	
	/*
	 * Test method for estimateWaitingTime()
	 */
	@Test
	public void TestEstimateWaitingTime() throws LabelException {
		Functions.reset();
		float w;
		
		w = Functions.estimateWaitingTime('A');
		
		// First time the list is empty, so w should be 0
		assertEquals(Double.valueOf(0.0), Double.valueOf(w));
		
		// After a ticket has been emitted, the waiting time should be
		// equal to the number of ticket before your ticket,
		// multiplied by the service time and divided by the 
		// number of counters that are actually handling that request
		Functions.addTicketToList('A');
		
		w = Functions.estimateWaitingTime('A');
		assertEquals(Double.valueOf(0.0), Double.valueOf(w));
		
		// After another ticket has been emitted for the same request,
		// the waiting time should be 2.5 minutes
		Functions.addTicketToList('A');
		
		w = Functions.estimateWaitingTime('A');
		assertEquals(Double.valueOf(2.5), Double.valueOf(w));
		
		//Invalid label
		assertThrows(LabelException.class, () -> Functions.estimateWaitingTime('1'));
		assertThrows(LabelException.class, () -> Functions.estimateWaitingTime('n'));
	}

}
