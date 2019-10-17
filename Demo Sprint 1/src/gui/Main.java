package gui;

import java.awt.EventQueue;

import Exception.LabelException;

public class Main {
	
	public static Request Account = new Request(5, 2);
	public static Request Package = new Request(3, 2);
	
	/**
	  * Launch the application.
	  */
	 public static void main(String[] args) throws LabelException {
	  EventQueue.invokeLater(new Runnable() {
	   		  
	   public void run() {
	   
	    try {
	     //Create a new window
	     ClientUI window = new ClientUI();
	     window.frame.setVisible(true);
	     
	     CounterUI newWindow = new CounterUI();
	     newWindow.setVisible(true);
	     
	    } catch (Exception e) {
	     e.printStackTrace();
	    }
	   }
	  });
	 }
}
