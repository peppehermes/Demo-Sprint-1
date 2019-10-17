package gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import Exception.LabelException;
import Functions.Functions;

public class ClientUI {

	JFrame frame;

	/**
	 * Create the dialog.
	 */
	public ClientUI() {
		frame = new JFrame();
		  frame.setBounds(100, 300, 480, 360);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  JTextArea txtrClickOnA = new JTextArea("Click on a button to receive a ticket!");
		  txtrClickOnA.setEditable(false);
		  txtrClickOnA.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		  
		  JButton btnAccount = new JButton("Account");
		  btnAccount.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		  btnAccount.addMouseListener(new MouseAdapter() {
		   @Override
		   public void mouseClicked(MouseEvent e) {    
			   Ticket t = new Ticket();
			try {
				t = Functions.addTicketToList('A');
			} catch (LabelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}    
			try {
				Functions.printTicket(txtrClickOnA, t);
			} catch (LabelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}    
		   }
		  });
		  
		  JButton btnPackage = new JButton("Package");
		  btnPackage.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		  btnPackage.addMouseListener(new MouseAdapter() {
		   @Override
		   public void mouseClicked(MouseEvent e) {
			   Ticket t = new Ticket();
			try {
				t = Functions.addTicketToList('P');
			} catch (LabelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	    
				try {
					Functions.printTicket(txtrClickOnA, t);
				} catch (LabelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   }
		  });
		  
		  JLabel label = new JLabel("");
		  label.setIcon(new ImageIcon("/home/andrea/DemoSprint1/Webp.net-resizeimage.jpg"));
		  
		  JLabel label_1 = new JLabel("");
		  label_1.setIcon(new ImageIcon(ClientUI.class.getResource("/gui/Webp.net-resizeimage.jpg")));
		  GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		  groupLayout.setHorizontalGroup(
		  	groupLayout.createParallelGroup(Alignment.TRAILING)
		  		.addGroup(groupLayout.createSequentialGroup()
		  			.addGap(202)
		  			.addComponent(label)
		  			.addContainerGap(262, Short.MAX_VALUE))
		  		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
		  			.addGap(44)
		  			.addComponent(txtrClickOnA, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
		  			.addGap(42))
		  		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
		  			.addGap(192)
		  			.addComponent(label_1)
		  			.addContainerGap(204, Short.MAX_VALUE))
		  		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
		  			.addContainerGap()
		  			.addComponent(btnAccount)
		  			.addPreferredGap(ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
		  			.addComponent(btnPackage)
		  			.addContainerGap())
		  );
		  groupLayout.setVerticalGroup(
		  	groupLayout.createParallelGroup(Alignment.LEADING)
		  		.addGroup(groupLayout.createSequentialGroup()
		  			.addContainerGap()
		  			.addComponent(txtrClickOnA, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
		  			.addPreferredGap(ComponentPlacement.RELATED)
		  			.addComponent(label)
		  			.addPreferredGap(ComponentPlacement.RELATED)
		  			.addComponent(label_1)
		  			.addGap(18)
		  			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		  				.addComponent(btnAccount)
		  				.addComponent(btnPackage))
		  			.addContainerGap(78, Short.MAX_VALUE))
		  );
		  frame.getContentPane().setLayout(groupLayout);
	}
}
