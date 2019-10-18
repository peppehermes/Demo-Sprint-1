package gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class DisplayUI {

	JFrame frame;

	/**
	 * Create the dialog.
	 */
	static JTextArea txtrClickOnA1 = new JTextArea("");
	
	public DisplayUI() {
		frame = new JFrame();
		  frame.setBounds(600, 300, 480, 360);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  
		  txtrClickOnA1.setEditable(false);
		  txtrClickOnA1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		  
		  JLabel lblSs = new JLabel("");
		  lblSs.setIcon(new ImageIcon(ClientUI.class.getResource("/gui/Webp.net-resizeimage.jpg")));
		  GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		  groupLayout.setHorizontalGroup(
		  	groupLayout.createParallelGroup(Alignment.LEADING)
		  		.addGroup(groupLayout.createSequentialGroup()
		  			.addGap(192)
		  			.addComponent(lblSs)
		  			.addContainerGap(204, Short.MAX_VALUE))
		  		.addGroup(groupLayout.createSequentialGroup()
		  			.addGap(113)
		  			.addComponent(txtrClickOnA1, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
		  			.addGap(121))
		  );
		  groupLayout.setVerticalGroup(
		  	groupLayout.createParallelGroup(Alignment.LEADING)
		  		.addGroup(groupLayout.createSequentialGroup()
		  			.addContainerGap()
		  			.addComponent(lblSs)
		  			.addGap(41)
		  			.addComponent(txtrClickOnA1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
		  			.addContainerGap(127, Short.MAX_VALUE))
		  );
		  frame.getContentPane().setLayout(groupLayout);
	}
	

}
