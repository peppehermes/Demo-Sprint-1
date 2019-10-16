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
  */
 public SwingProva() {
  initialize();
 }

 /**
  * Initialize the contents of the frame.
  */
 private void initialize() {
  frame = new JFrame();
  frame.setBounds(100, 100, 480, 360);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
  
  JTextArea txtrClickOnA = new JTextArea("Click on a button to receive a ticket!");
  txtrClickOnA.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
  
  JButton btnAccount = new JButton("Account");
  btnAccount.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
  btnAccount.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    
    
    Ticket t = new Ticket();
    t.setLabel('A');
    t.setDate(new Date());
    t.setNumber(AccountTicketList.size());
    
    AccountTicketList.add(t);
    txtrClickOnA.setText("Here's your ticket!");

    txtrClickOnA.append(t.getLabel() + Integer.toString(t.getNumber()) +"  "+ dateFormat.format(t.getDate()));
    
   }
  });
  
  JButton btnPackage = new JButton("Package");
  btnPackage.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
  btnPackage.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    
    
    Ticket t = new Ticket();
    t.setLabel('P');
    t.setDate(new Date());
    t.setNumber(PackageTicketList.size());
    
    PackageTicketList.add(t);
    txtrClickOnA.setText("Here's your ticket!");
    
    txtrClickOnA.append(t.getLabel() + Integer.toString(t.getNumber()) +"  "+ dateFormat.format(t.getDate()));
    
   }
  });
  GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
  groupLayout.setHorizontalGroup(
   groupLayout.createParallelGroup(Alignment.TRAILING)
    .addGroup(groupLayout.createSequentialGroup()
     .addContainerGap()
     .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      .addComponent(txtrClickOnA, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
      .addGroup(groupLayout.createSequentialGroup()
       .addComponent(btnAccount)
       .addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
       .addComponent(btnPackage)))
     .addContainerGap())
  );
  groupLayout.setVerticalGroup(
   groupLayout.createParallelGroup(Alignment.LEADING)
    .addGroup(groupLayout.createSequentialGroup()
     .addContainerGap()
     .addComponent(txtrClickOnA, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
     .addGap(35)
     .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
      .addComponent(btnAccount)
      .addComponent(btnPackage))
     .addContainerGap(35, Short.MAX_VALUE))
  );
  frame.getContentPane().setLayout(groupLayout);
 }
}