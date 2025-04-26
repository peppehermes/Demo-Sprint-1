package gui;

import java.util.ArrayList;

public class Request {
	public ArrayList<Ticket> ticketList;
	Integer serviceTime; //minute
	Integer counterNumber;
	Integer totalServed;

	// Constructor
	
	public Request() { 
		this.ticketList = new ArrayList<Ticket>();
		this.totalServed = 1;
	};
	
	public Request(Integer s, Integer c) {
		this.ticketList = new ArrayList<Ticket>();
		this.serviceTime = s;
		this.counterNumber = c;
		this.totalServed = 1;
	}
	
	//Getters and Setters
	
	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public Integer getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Integer serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Integer getCounterNumber() {
		return counterNumber;
	}

	public void setCounterNumber(Integer counterNumber) {
		this.counterNumber = counterNumber;
	}
	
	public Integer getTotalServed() {
		return totalServed;
	}

	public void setTotalServed(Integer totalServed) {
		this.totalServed = totalServed;
	}
	
	// Reset methods
	
	public void resetTicketList() {
		this.ticketList = new ArrayList<Ticket>();
	}
	
	public void resetTotalServed() {
		this.totalServed = 1;
	}
	
}
