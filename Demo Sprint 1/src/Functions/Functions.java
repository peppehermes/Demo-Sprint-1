package Functions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Exception.LabelException;
import Exception.TicketException;
import gui.Main;
import gui.Ticket;

public class Functions {
	 /*
	  * Reset method used to made lists empty
	  */
	 public static void reset() {
		 Main.Account.resetTicketList();
		 Main.Account.resetTotalServed();;
		 Main.Package.resetTicketList();
		 Main.Package.resetTotalServed();;
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
		float waitingTime = estimateWaitingTime(t.getLabel());
		
		// Print the ticket
		textArea.append(t.getLabel() + Integer.toString(t.getNumber()) + "\n\n" + 
		dateFormat.format(t.getDate()) + "\n" + waitingTime + " minutes waiting time" );
		
	 }
	 
	 public static float estimateWaitingTime(char ticketType) throws LabelException {
		 float waitingTime = 0;
		 if(ticketType == 'A') {
			 int accountListSize = Main.Account.getTicketList().size() - 1;
			 if (accountListSize > 0) {
				 int accountServiceTime = Main.Account.getServiceTime();
				 int accountCounter = Main.Account.getCounterNumber();
				 waitingTime = (float) (accountListSize * accountServiceTime) / (float) accountCounter;
			 }
		 }
		 else if(ticketType == 'P') {
			 int packageListSize = Main.Package.getTicketList().size() - 1;
			 if (packageListSize > 0) {
				 int packageServiceTime = Main.Package.getServiceTime();
				 int packageCounter = Main.Package.getCounterNumber();
				 waitingTime = (float) (packageListSize * packageServiceTime) / (float) packageCounter;
			 }
		 }
		 else
			 throw new LabelException();
		 
		return waitingTime;
	 }
	 
	 public static Ticket removeTicket(JTextField ticketCnt12, char type)
			 throws LabelException, TicketException {
		Ticket t = new Ticket();
		
		if (type == 'A') {
		
			if (Main.Account.getTicketList().size() > 0) {	
				t = Main.Account.getTicketList().remove(0);
			    ticketCnt12.setText(t.getLabel() + Integer.toString(t.getNumber()));
			}
			else 
				throw new TicketException();
		}
		
		else if (type == 'P') {
			
			if (Main.Package.getTicketList().size() > 0) {	
				t = Main.Package.getTicketList().remove(0);
				ticketCnt12.setText(t.getLabel() + Integer.toString(t.getNumber()));
			}
			else 
				throw new TicketException();
		}
		
		else
			throw new LabelException();
		
		return t;
	}
}
