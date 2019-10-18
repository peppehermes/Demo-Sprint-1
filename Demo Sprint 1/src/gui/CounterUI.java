package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Exception.LabelException;
import Exception.TicketException;
import Functions.Functions;


public class CounterUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel cnt1;
	private JLabel cnt2;
	private JLabel cnt3;
	private JTextField ticketCnt1;
	private JTextField ticketCnt2;
	private JTextField ticketCnt3;
	public int sizeAccount=0;
	public int sizePackage=0;
	
	
	
	/**
		 * Create the dialog.
		 */
	public CounterUI()  {
		setBounds(1100, 330, 450, 300);
		{
			cnt3 = new JLabel("COUNTER 3");
			cnt3.setHorizontalAlignment(SwingConstants.CENTER);
			cnt3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		{
			cnt1 = new JLabel("COUNTER 1");
			cnt1.setHorizontalAlignment(SwingConstants.CENTER);
			cnt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		{
			cnt2 = new JLabel("COUNTER 2");
			cnt2.setHorizontalAlignment(SwingConstants.CENTER);
			cnt2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		
		ticketCnt1 = new JTextField();
		ticketCnt1.setEditable(false);
		ticketCnt1.setColumns(10);
		
		ticketCnt2 = new JTextField();
		ticketCnt2.setEditable(false);
		ticketCnt2.setColumns(10);
		
		ticketCnt3 = new JTextField();
		ticketCnt3.setEditable(false);
		ticketCnt3.setColumns(10);
		
		
		
		
		JButton nextTick1 = new JButton("Next");
		nextTick1.addMouseListener(new MouseAdapter() {
			   @Override
			   public void mouseClicked(MouseEvent e) {    
				   
				   try {
					  if(Main.Account.getTicketList().isEmpty() == false) {
				     Ticket t = Main.Account.getTicketList().get(0);
					 DisplayUI.txtrClickOnA1.setText(null);   
					 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "A" + Integer.toString(t.getNumber())); 
					  }
					 Functions.removeTicket(ticketCnt1,'A');
					 
					 
					} catch (LabelException e1) {						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TicketException e1) {
						ticketCnt1.setText("No Customer");
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}    
				 
			   }
			  });
		
		JButton nextTick2 = new JButton("Next");
		nextTick2.addMouseListener(new MouseAdapter() {
			   @Override
			   public void mouseClicked(MouseEvent e) {    
				   
				   try {
					   if(Main.Package.getTicketList().isEmpty() == false) {
						     Ticket t = Main.Package.getTicketList().get(0);
							 DisplayUI.txtrClickOnA1.setText(null);   
							 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "P" + Integer.toString(t.getNumber())); 
							  }
						 Functions.removeTicket(ticketCnt2,'P');
					} catch (LabelException e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TicketException e1) {
						ticketCnt2.setText("No Customer");
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}    
				 
			   }
			  });
		
		JButton nextTick3 = new JButton("Next");
		nextTick3.addMouseListener(new MouseAdapter() {
			   @Override
			   public void mouseClicked(MouseEvent e) { 
				 sizeAccount=Main.Account.getTicketList().size();
				 sizePackage=Main.Package.getTicketList().size();
				
				 if(sizeAccount> sizePackage) {  
				   try {
					   if(Main.Account.getTicketList().isEmpty() == false) {
						     Ticket t = Main.Account.getTicketList().get(0);
							 DisplayUI.txtrClickOnA1.setText(null);   
							 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "A" + Integer.toString(t.getNumber())); 
							  }
					   Functions.removeTicket(ticketCnt3,'A');
					} catch (LabelException e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TicketException e1) {
						ticketCnt3.setText("No Customer");
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}    
				}
				
				else if (sizePackage>sizeAccount) {
					 try {
						 if(Main.Package.getTicketList().isEmpty() == false) {
						     Ticket t = Main.Package.getTicketList().get(0);
							 DisplayUI.txtrClickOnA1.setText(null);   
							 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "P" + Integer.toString(t.getNumber())); 
							  }
						 Functions.removeTicket(ticketCnt3,'P');
						} catch (LabelException e1) {
							
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (TicketException e1) {
							ticketCnt3.setText("No Customer");
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}    
					
					}
				  else  {                 // Queues equal, i pick the one with lower Service time so P
					
					  try {
						  if(Main.Package.getTicketList().isEmpty() == false) {
							     Ticket t = Main.Package.getTicketList().get(0);
								 DisplayUI.txtrClickOnA1.setText(null);   
								 DisplayUI.txtrClickOnA1.setText("Calling Ticket! \n\n" + "P" + Integer.toString(t.getNumber())); 
								  }
						   Functions.removeTicket(ticketCnt3,'P');
						} catch (LabelException e1) {
							
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (TicketException e1) {
							ticketCnt3.setText("No Customer");
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}    
					
				}
				
			   }
			  });	
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(nextTick1)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(ticketCnt1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(cnt1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(nextTick2))
										.addComponent(ticketCnt2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
									.addGap(82))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(cnt2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(41)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ticketCnt3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(10)
										.addComponent(nextTick3))
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cnt3, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))))
							.addGap(19))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cnt1)
						.addComponent(cnt2)
						.addComponent(cnt3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ticketCnt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ticketCnt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ticketCnt3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nextTick1)
						.addComponent(nextTick3)
						.addComponent(nextTick2))
					.addGap(178))
		);
		getContentPane().setLayout(groupLayout);
	}
}