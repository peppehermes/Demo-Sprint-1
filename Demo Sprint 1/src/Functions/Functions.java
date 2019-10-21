package Functions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Exception.LabelException;
import Exception.TicketException;
import gui.DisplayUI;
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
	 
	 /*
	  * Method used to estimate the time to wait until your ticket will be called
	  */
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
	 
	 /*
	  * Method used to remove called ticket from the proper queue 
	  * and to print it into the Counter interface
	  */
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
	 
	 /*
	  * Method used when the Counter button is pressed 
	  * to call the next ticket and display it into the DisplayUI window
	  */
	 public static Ticket displayTicket(JTextField tc, char type) throws LabelException, TicketException {
		 
		 Ticket t = null ;
		  
		 //Account Counter
		 if (type == 'A') {
			 
			 if(Main.Account.getTicketList().isEmpty() == false) {
				 t = Main.Account.getTicketList().get(0);
				 DisplayUI.txtrClickOnA1.setText(null);   
				 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "A" + Integer.toString(t.getNumber())); 
				  }
				 Functions.removeTicket(tc,'A');
			 
		 }
		 //Package Counter
		 else if (type == 'P') {

			 if(Main.Package.getTicketList().isEmpty() == false) {
				 t = Main.Package.getTicketList().get(0);
				 DisplayUI.txtrClickOnA1.setText(null);   
				 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "P" + Integer.toString(t.getNumber())); 
				  }
			 Functions.removeTicket(tc,'P');
			 
		 }
		 //Counter that manages both queues
		 else if (type == 'B') {			 
			
			int sizeAccount=Main.Account.getTicketList().size();
			int sizePackage=Main.Package.getTicketList().size();
			
			if (sizeAccount > sizePackage) {  
				
				if (Main.Account.getTicketList().isEmpty() == false) {
				     t = Main.Account.getTicketList().get(0);
					 DisplayUI.txtrClickOnA1.setText(null);   
					 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "A" + Integer.toString(t.getNumber())); 
					  }
			   Functions.removeTicket(tc,'A');
				
			}
			else if (sizePackage > sizeAccount) {
				
				if(Main.Package.getTicketList().isEmpty() == false) {
				     t = Main.Package.getTicketList().get(0);
					 DisplayUI.txtrClickOnA1.setText(null);   
					 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "P" + Integer.toString(t.getNumber())); 
					  }
				 Functions.removeTicket(tc,'P');
			}
			else {
				
				Integer serviceAccount = Main.Account.getServiceTime();
				Integer servicePackage = Main.Package.getServiceTime();
				
				if (serviceAccount > servicePackage) {
					if (Main.Package.getTicketList().isEmpty() == false) {
						 t = Main.Package.getTicketList().get(0);
						 DisplayUI.txtrClickOnA1.setText(null);   
						 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "P" + Integer.toString(t.getNumber())); 
						  }
				   Functions.removeTicket(tc,'P');
				}
				else {
					if (Main.Account.getTicketList().isEmpty() == false) {
						 t = Main.Account.getTicketList().get(0);
						 DisplayUI.txtrClickOnA1.setText(null);   
						 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "A" + Integer.toString(t.getNumber())); 
						  }
				   Functions.removeTicket(tc,'A');
				}			
				
			}
			 
		 }
		 else 
			throw new LabelException();
		 
		 return t;
	 }	 
}
