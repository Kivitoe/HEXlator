import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shc.ide;
import shc.ohc;
import tm.tstart;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class mo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mo frame = new mo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mo.class.getResource("/imgs/color_picker.png")));
		setResizable(false);
		setTitle("Hexlator");
		setSize(441, 365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnTutorial = new JButton("Tutorial Mode");
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Main.frmHexlator.setVisible(false);
				
				tstart.main(null);
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JLabel lblMoreOptionsView = new JLabel("More Options View");
		lblMoreOptionsView.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMoreOptionsView.setIcon(new ImageIcon(mo.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		
		JButton btnSaveAHex = new JButton("Save a HEX Code");
		btnSaveAHex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ide.main(null);
			}
		});
		
		JButton btnOpenHexCode = new JButton("Open HEX Code");
		btnOpenHexCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ohc.main(null);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblMoreOptionsView)
							.addGap(109))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnOpenHexCode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
								.addComponent(btnSaveAHex, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
								.addComponent(btnTutorial, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblMoreOptionsView, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTutorial, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSaveAHex, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOpenHexCode, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(158, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
