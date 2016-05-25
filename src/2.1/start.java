import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

public class start extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public JLabel lblAKivitoeProject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			start dialog = new start();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public start() {
		setUndecorated(true);
		setSize(450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		
		JLabel lblNewLabel = new JLabel("HEXlator");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Euphemia", Font.BOLD, 61));
		lblNewLabel.setIcon(new ImageIcon(start.class.getResource("/imgs/color_picker.png")));
		
		lblAKivitoeProject = new JLabel("A Kivitoe Project");
		lblAKivitoeProject.setForeground(Color.WHITE);
		lblAKivitoeProject.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
							.addGap(7))
						.addComponent(lblAKivitoeProject, Alignment.TRAILING)))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(86, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(62)
					.addComponent(lblAKivitoeProject))
		);
		contentPanel.setLayout(gl_contentPanel);
		
		
		
		
		
		
		
		
		// Animate
		
		
		Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                lblAKivitoeProject.setForeground(Color.LIGHT_GRAY);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        lblAKivitoeProject.setForeground(Color.GRAY);
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {

                            @Override
                            public void run() {
                                lblAKivitoeProject.setForeground(Color.DARK_GRAY);
                                Timer timer = new Timer();
                                timer.schedule(new TimerTask() {

                                    @Override
                                    public void run() {
                                        setVisible(false);
                                        Main.main(null);
                                        
                                    }
                                }, 3000);
                            }
                        }, 30);
                    }
                }, 35);
            }
            
        }, 1000);
    
	}
}
