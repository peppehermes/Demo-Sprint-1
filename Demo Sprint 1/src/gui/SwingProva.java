package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import Exception.LabelException;

import javax.swing.ImageIcon;

public class SwingProva {
 
 public static ArrayList<Ticket> AccountTicketList;
 public static ArrayList<Ticket> PackageTicketList;

 private JFrame frame;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     //Create a new window
     SwingProva window = new SwingProva();
     window.frame.setVisible(true);
     
     CounterUI newWindow = new CounterUI();
     newWindow.setVisible(true);
     
     AccountTicketList = new ArrayList<Ticket>();
     PackageTicketList = new ArrayList<Ticket>();
     
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the application.
 * @throws LabelException 
  */
 public SwingProva() throws LabelException {
  initialize();
 }
 
 /*
  * Reset method used to made lists empty
  */
 public void reset() {
	 AccountTicketList = new ArrayList<Ticket>();
     PackageTicketList = new ArrayList<Ticket>();
 }
 
 /*
  * Method used to add the ticket to the proper list
  */
 public Ticket addTicketToList(char type) throws LabelException {
	Ticket t = new Ticket();
	
	if (type == 'A') {
		t.setLabel('A');
		t.setDate(new Date());
		t.setNumber(AccountTicketList.size());
		
		AccountTicketList.add(t);
	}
	else if (type == 'P') {
		 t.setLabel('P');
		 t.setDate(new Date());
		 t.setNumber(PackageTicketList.size());
	    
		 PackageTicketList.add(t);
	}
	else
		throw new LabelException();
	
	return t;	
 }
 
 /*
  * Method used to print the ticket on the requested textArea
  */
 public void printTicket(JTextArea textArea, Ticket t) {
	DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
	textArea.setText("Here's your ticket!" + "\n\n");
	textArea.append(t.getLabel() + Integer.toString(t.getNumber()) + "\n\n" + dateFormat.format(t.getDate()) );
 }

 /**
  * Initialize the contents of the frame.
  */
 private void initialize() throws LabelException {
  frame = new JFrame();
  frame.setBounds(100, 100, 480, 360);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  JTextArea txtrClickOnA = new JTextArea("Click on a button to receive a ticket!");
  txtrClickOnA.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
  
  JButton btnAccount = new JButton("Account");
  btnAccount.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
  btnAccount.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {    
	   Ticket t = new Ticket();
	try {
		t = addTicketToList('A');
	} catch (LabelException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}    
	   printTicket(txtrClickOnA, t);    
   }
  });
  
  JButton btnPackage = new JButton("Package");
  btnPackage.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
  btnPackage.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
	   Ticket t = new Ticket();
	try {
		t = addTicketToList('P');
	} catch (LabelException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	    
	   printTicket(txtrClickOnA, t);
   }
  });
  
  JLabel label = new JLabel("");
  label.setIcon(new ImageIcon(SwingProva.class.getResource("/gui/Webp.net-resizeimage.jpg")));
  GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
  groupLayout.setHorizontalGroup(
  	groupLayout.createParallelGroup(Alignment.TRAILING)
  		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
  			.addGap(44)
  			.addComponent(txtrClickOnA, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
  			.addGap(42))
  		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
  			.addGap(202)
  			.addComponent(label)
  			.addContainerGap(210, Short.MAX_VALUE))
  		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
  			.addContainerGap()
  			.addComponent(btnAccount)
  			.addPreferredGap(ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
  			.addComponent(btnPackage)
  			.addContainerGap())
  );
  groupLayout.setVerticalGroup(
  	groupLayout.createParallelGroup(Alignment.LEADING)
  		.addGroup(groupLayout.createSequentialGroup()
  			.addContainerGap()
  			.addComponent(txtrClickOnA, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
  			.addPreferredGap(ComponentPlacement.RELATED)
  			.addComponent(label)
  			.addGap(41)
  			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
  				.addComponent(btnAccount)
  				.addComponent(btnPackage))
  			.addContainerGap(62, Short.MAX_VALUE))
  );
  frame.getContentPane().setLayout(groupLayout);
 }
}