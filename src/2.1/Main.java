import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Ifn.fbh;


import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Main {

	public static JFrame frmHexlator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmHexlator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Frame Init
		frmHexlator = new JFrame();
		frmHexlator.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/imgs/color_picker.png")));
		frmHexlator.setResizable(false);
		frmHexlator.setTitle("Hexlator");
		frmHexlator.setSize(520, 464);
		frmHexlator.setLocationRelativeTo(null);
		frmHexlator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmHexlator.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnFindColorBy = new JButton("Find Color by Hex Code");
		btnFindColorBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHexlator.getContentPane().remove(panel);
				frmHexlator.getContentPane().repaint();
				frmHexlator.getContentPane().revalidate();
				frmHexlator.getContentPane().add(new fbh(), BorderLayout.CENTER);
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel = new JLabel("HEXlator");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/imgs/color_picker.png")));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Euphemia", Font.BOLD, 39));
		
		JLabel lblMoreOptions = new JLabel("More Options...");
		lblMoreOptions.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMoreOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMoreOptions.setText("<html><U>More Options...</U></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMoreOptions.setText("More Options...");
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mo.main(null);
			}
		});
		lblMoreOptions.setForeground(Color.BLUE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(btnFindColorBy, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(421, Short.MAX_VALUE)
					.addComponent(lblMoreOptions, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(106)
					.addComponent(lblNewLabel)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnFindColorBy, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(120)
					.addComponent(lblNewLabel)
					.addGap(75)
					.addComponent(lblMoreOptions)
					.addGap(100))
		);
		panel.setLayout(gl_panel);
	}
}
