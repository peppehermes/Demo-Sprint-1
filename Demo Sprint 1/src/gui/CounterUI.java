package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import java.awt.TextArea;

public class CounterUI extends JDialog {

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			CounterUI dialog = new CounterUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	/**
	 * Create the dialog.
	 */
	public CounterUI() {
		setBounds(100, 100, 450, 300);
		{
			cnt3 = new JLabel("COUNTER 3");
			cnt3.setHorizontalAlignment(SwingConstants.CENTER);
			cnt3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		{
			cnt1 = new JLabel("COUNTER 1x");
			cnt1.setHorizontalAlignment(SwingConstants.CENTER);
			cnt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		{
			cnt2 = new JLabel("COUNTER 2");
			cnt2.setHorizontalAlignment(SwingConstants.CENTER);
			cnt2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		
		ticketCnt1 = new JTextField();
		ticketCnt1.setColumns(10);
		
		ticketCnt2 = new JTextField();
		ticketCnt2.setColumns(10);
		
		ticketCnt3 = new JTextField();
		ticketCnt3.setColumns(10);
		
		JButton nextTick1 = new JButton("Next");
		
		JButton nextTick2 = new JButton("Next");
		
		JButton nextTick3 = new JButton("Next");
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
