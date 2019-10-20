package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import Exception.LabelException;
import Exception.TicketException;
import Functions.Functions;
import gui.Main;
import gui.Request;
import gui.Ticket;

class Test {

	@BeforeEach
	void setUp() throws Exception {
		Functions.reset();
		System.out.println("BeforeEach setUp() method called");
	}

	@AfterAll
	static void tearDown() throws Exception {
		Functions.reset();
		System.out.println("AfterAll tearDown() method called");
	}
	
	
	/*
	 * Test methods for Ticket class
	 */
	@org.junit.jupiter.api.Test
	public void TestTicketMethods() throws LabelException{
		
		//Create Ticket and insert into List
		Ticket t;
		
		t = Functions.addTicketToList('A');
		
		//Test getters
		assertEquals('A', t.getLabel());
		assertEquals(Integer.valueOf(1), Integer.valueOf(t.getNumber()));
		
		//Test setters
		t.setLabel('B');
		assertEquals('B', t.getLabel());
		
		t.setNumber(7);
		assertEquals(Integer.valueOf(7), Integer.valueOf(t.getNumber()));
		
		Date d = new Date();
		t.setDate(d);
		assertEquals(d, t.getDate());		
	}
		
	

	/*
	 * Test method for addTicketToList()
	 */
	@org.junit.jupiter.api.Test
	public void TestAddTicketToList() throws LabelException {
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
	 * Test method for removeTicket()
	 */
	@org.junit.jupiter.api.Test
	public void TestRemoveTicket() throws LabelException, TicketException {
		Ticket t;
		
		t = Functions.addTicketToList('A');
		
		assertEquals('A', t.getLabel());
		assertEquals(Integer.valueOf(1), Integer.valueOf(t.getNumber()));
		
		// Second insert in Account, the number of the ticket should be 2
		t = Functions.addTicketToList('A');
		
		JTextField txtField = new JTextField();
		
		// Removing Ticket #1 from the list A
		t = Functions.removeTicket(txtField, 'A');
		
		assertEquals('A', t.getLabel());
		assertEquals(Integer.valueOf(1), Integer.valueOf(t.getNumber()));
		
		// Removing Ticket #2 from the list A
		t = Functions.removeTicket(txtField, 'A');
				
		assertEquals('A', t.getLabel());
		assertEquals(Integer.valueOf(2), Integer.valueOf(t.getNumber()));
		
		//Trying to remove a Ticket from an Empty list
		//will generate a TicketException
		assertThrows(TicketException.class, () -> Functions.removeTicket(txtField, 'A'));
		assertThrows(TicketException.class, () -> Functions.removeTicket(txtField, 'P'));
		
		//Trying to remove a Ticket from a non-existent List
		//will generate a LabelException
		assertThrows(LabelException.class, () -> Functions.removeTicket(txtField, '2'));
		assertThrows(LabelException.class, () -> Functions.removeTicket(txtField, 'x'));
		
	}
	
	/*
	 * Test method for estimateWaitingTime()
	 */
	@org.junit.jupiter.api.Test
	public void TestEstimateWaitingTime() throws LabelException {
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
	

	/*
	 * Test methods for Request class
	 */
	@org.junit.jupiter.api.Test
	public void TestRequestMethods() throws LabelException{

		Request r = new Request(7, 4);
		
		//Test Getters
		assertEquals(Integer.valueOf(7), Integer.valueOf(r.getServiceTime()));
		assertEquals(Integer.valueOf(4), Integer.valueOf(r.getCounterNumber()));
		assertEquals(Integer.valueOf(1), Integer.valueOf(r.getTotalServed()));
		
		//Test setters
		r.setServiceTime(22);
		assertEquals(Integer.valueOf(22), Integer.valueOf(r.getServiceTime()));
		
		r.setCounterNumber(15);
		assertEquals(Integer.valueOf(15), Integer.valueOf(r.getCounterNumber()));
		
		r.setTotalServed(11);
		assertEquals(Integer.valueOf(11), Integer.valueOf(r.getTotalServed()));
		
		//Test change in TotalServed when adding a Ticket
		assertEquals(Integer.valueOf(1), Integer.valueOf(Main.Account.getTotalServed()));
		Functions.addTicketToList('A');
		assertEquals(Integer.valueOf(2), Integer.valueOf(Main.Account.getTotalServed()));
		
	}
	
	
	/*
	 * Test method for displayTicket()
	 */
	@org.junit.jupiter.api.Test
	public void TestDisplayTicket() throws LabelException, TicketException{
		
		JTextField txtField = new JTextField();
		Ticket tA;
		Ticket tP;
		Ticket tChosen;
		
		tA = Functions.addTicketToList('A');
		tP = Functions.addTicketToList('P');
		
		//Now, since the Account request type
		//has a longer estimated waiting time
		//The next Ticket called should be
		//from the Account list
		tChosen = Functions.displayTicket(txtField, 'B');
		
		assertEquals(tP.getLabel(), tChosen.getLabel());
		assertEquals(tP.getNumber(), tChosen.getNumber());
		
		//Since only the Account list is not empty
		//the next ticket called will be from that list
		tChosen = Functions.displayTicket(txtField, 'B');
		
		assertEquals(tA.getLabel(), tChosen.getLabel());
		assertEquals(tA.getNumber(), tChosen.getNumber());
		
		//Testing call from a specific list
		tA = Functions.addTicketToList('A');
		tP = Functions.addTicketToList('P');
		
		tChosen = Functions.displayTicket(txtField, 'A');
		assertEquals(tA.getLabel(), tChosen.getLabel());
		assertEquals(tA.getNumber(), tChosen.getNumber());
		
		tChosen = Functions.displayTicket(txtField, 'P');
		assertEquals(tP.getLabel(), tChosen.getLabel());
		assertEquals(tP.getNumber(), tChosen.getNumber());
		
		//Giving an invalid label as Input
		//will generate a LabelException
		assertThrows(LabelException.class, () -> Functions.displayTicket(txtField, 'G'));
		assertThrows(LabelException.class, () -> Functions.displayTicket(txtField, '2'));
		
		
		
	}
	
	
	
}
