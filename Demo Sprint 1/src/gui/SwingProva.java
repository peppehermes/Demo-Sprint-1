package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class SwingProva {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingProva window = new SwingProva();
					window.frame.setVisible(true);
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
		
		JButton btnAccount = new JButton("Account");
		
		JButton btnPackage = new JButton("Package");
		
		JTextArea textArea = new JTextArea("Click on a button to receive a ticket!");
		textArea.setFont(new Font("Chiller", Font.PLAIN, 20));
		textArea.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAccount)
							.addPreferredGap(ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
							.addComponent(btnPackage)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPackage, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addComponent(btnAccount, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
