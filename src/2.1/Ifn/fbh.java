package Ifn;

import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JColorChooser;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;



import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class fbh extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public fbh() {
		
		JColorChooser colorChooser = new JColorChooser();
		JLabel lblIsNotA = new JLabel();
		lblIsNotA.setForeground(Color.RED);
		lblIsNotA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsNotA.setVisible(false);
		
		
		// The meat of the code:
		colorChooser.setEnabled(false);
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				try {
					int color = Integer.parseInt(textField.getText(),16);
					Color color1 = new Color(color);
					colorChooser.setColor(color1);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					lblIsNotA.setText("Invaild HEX Code!");
					lblIsNotA.setVisible(true);
					
					
					Timer timer = new Timer();
			        timer.schedule(new TimerTask() {

			            @Override
			            public void run() {
			            	
			            	lblIsNotA.setVisible(false);
			         
			            
			        }}, 2000);
			    
		}
			}
		});
		
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				try {
					int color = Integer.parseInt(textField.getText(),16);
					Color color1 = new Color(color);
					colorChooser.setColor(color1);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					lblIsNotA.setText("Invaild HEX Code!");
					lblIsNotA.setVisible(true);
					
					
					Timer timer = new Timer();
			        timer.schedule(new TimerTask() {

			            @Override
			            public void run() {
			            	
			            	lblIsNotA.setVisible(false);
			         
			            
			        }}, 2000);
			    
		}}});
		
		
		textField.setColumns(10);
		
		JLabel lblHex = new JLabel("HEX: #");
		// -------------
		
		// Group layout settings:
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(colorChooser, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 493, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblHex)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnOk)
									.addGap(146))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(176)
							.addComponent(lblIsNotA, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(colorChooser, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOk)
						.addComponent(lblHex))
					.addGap(43)
					.addComponent(lblIsNotA, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		// -------------

	}
}
