package Functions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;

import Exception.LabelException;
import gui.Main;
import gui.Ticket;

public class Functions {
	 /*
	  * Reset method used to made lists empty
	  */
	 public static void reset() {
		 Main.Account.resetTicketList();
		 Main.Package.resetTicketList();
	 }
	 
	 /*
	  * Method used to add the ticket to the proper list
	  */
	 public static Ticket addTicketToList(char type) throws LabelException {
		Ticket t = new Ticket();
		
		if (type == 'A') {
			t.setLabel('A');
			t.setDate(new Date());
			t.setNumber(Main.Account.getTotalServed());
			
			Main.Account.setTotalServed(Main.Account.getTotalServed() + 1);
			
			Main.Account.getTicketList().add(t);
		}
		else if (type == 'P') {
			t.setLabel('P');
			t.setDate(new Date());
			t.setNumber(Main.Package.getTotalServed());
			 
			Main.Package.setTotalServed(Main.Package.getTotalServed() + 1);
		    
			Main.Package.getTicketList().add(t);
		}
		else
			throw new LabelException();
		
		return t;	
	 }
	 
	 /*
	  * Method used to print the ticket on the requested textArea
	  */
	 public static void printTicket(JTextArea textArea, Ticket t) throws LabelException {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		
		textArea.setText("Here's your ticket!" + "\n\n");
		
		// Estimate waiting time for his type of request
		int waitingTime = estimateWaitingTime(t.getLabel());
		
		// Print the ticket
		textArea.append(t.getLabel() + Integer.toString(t.getNumber()) + "\n\n" + 
		dateFormat.format(t.getDate()) + "\n" + waitingTime + " minutes waiting time" );
		
	 }
	 
	 public static int estimateWaitingTime(char ticketType) throws LabelException {
		 int waitingTime = 0;
		 if(ticketType == 'A') {
			 int accountListSize = Main.Account.getTicketList().size();
			 if (accountListSize > 1) {
				 int accountServiceTime = Main.Account.getServiceTime();
				 int accountCounter = Main.Account.getCounterNumber();
				 waitingTime = (accountListSize * accountServiceTime) / accountCounter;
			 }
		 }
		 else if(ticketType == 'P') {
			 int packageListSize = Main.Package.getTicketList().size();
			 if (packageListSize > 1) {
				 int packageServiceTime = Main.Package.getServiceTime();
				 int packageCounter = Main.Package.getCounterNumber();
				 waitingTime = (packageListSize * packageServiceTime) / packageCounter;
			 }
		 }
		 else
			 throw new LabelException();
		 
		return waitingTime;
	 }
}
