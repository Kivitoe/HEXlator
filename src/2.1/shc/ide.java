package shc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

public class ide {

	private JFrame frmHexlator;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ide window = new ide();
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
	public ide() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHexlator = new JFrame();
		frmHexlator.setResizable(false);
		frmHexlator.setIconImage(Toolkit.getDefaultToolkit().getImage(ide.class.getResource("/imgs/color_picker.png")));
		frmHexlator.setTitle("HEXlator");
		frmHexlator.setBounds(100, 100, 179, 67);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		final JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		FileFilter filter = new FileNameExtensionFilter("HEXlator Code File (.hexlator)","hexlator");
		fc.addChoosableFileFilter(filter);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str = textField.getText();
				
				if (e.getSource() == btnSave) {
			        int returnVal = fc.showSaveDialog(null);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            //This is where a real application would open the file.
			            
			            String fil = file.toString();
			            byte data[] = str.getBytes();
			            Path p = Paths.get(fil);

			            try (OutputStream out = new BufferedOutputStream(
			              Files.newOutputStream(p))) {
			              out.write(data, 0, data.length);
			            } catch (IOException x) {
			              System.err.println(x);
			            }
			            frmHexlator.setVisible(false);
			            
			        } else {
			            
			        }}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmHexlator.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSave)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		frmHexlator.getContentPane().setLayout(groupLayout);
	}
}
