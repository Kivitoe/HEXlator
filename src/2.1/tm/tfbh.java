package tm;

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

public class tfbh extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public tfbh() {
		
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
		JLabel lblYouMustClick = new JLabel("You must click this before \"Next\".");
		
		JLabel lblNowTryEntering = new JLabel("Now, try entering the HEX code, #679F09 (Without the \"#\"). When done,\r\n click \"Next\".");
		lblNowTryEntering.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblYouMustClick.setVisible(false);
				lblNowTryEntering.setText("Finally in this tutorial, try finding the RBG properties of the color.");
				btnNext.setVisible(false);
			}
		});
		
		
		// -------------
		
		// Group layout settings:
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(lblHex)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOk)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblYouMustClick)
					.addContainerGap(39, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNowTryEntering, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(13))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(colorChooser, GroupLayout.PREFERRED_SIZE, 492, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(112)
					.addComponent(lblIsNotA, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(241, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(447, Short.MAX_VALUE)
					.addComponent(btnNext)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(colorChooser, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHex)
						.addComponent(btnOk)
						.addComponent(lblYouMustClick))
					.addGap(38)
					.addComponent(lblIsNotA, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNowTryEntering)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(btnNext)
					.addContainerGap())
		);
		setLayout(groupLayout);
		// -------------

	}
}
