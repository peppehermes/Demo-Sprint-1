package gui;

import java.util.Date;

public class Ticket {
	private char label;
	private int number;
	private Date d;
	
	public Ticket() { }

	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return d;
	}

	public void setDate(Date d) {
		this.d = d;
	}

}
