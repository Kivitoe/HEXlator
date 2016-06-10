package shc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Toolkit;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.border.BevelBorder;
import javax.swing.JColorChooser;

public class ohc {

	private JFrame frame;
	private JTextField textField;
	private JColorChooser colorChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ohc window = new ohc();
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
	public ohc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ohc.class.getResource("/imgs/color_picker.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 680, 448);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblHexCode = new JLabel("HEX Code:");
		
		colorChooser = new JColorChooser();
		colorChooser.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(4)
					.addComponent(lblHexCode)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(colorChooser, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(colorChooser, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHexCode)))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		final JFileChooser fc = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("HEXlator Code File (.hexlator)","hexlator");
		
	        int returnVal = fc.showOpenDialog(null);

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            //This is where a real application would open the file.
	            Path fil = file.toPath();
	            String fi = file.toString();
	            
	            Charset charset = Charset.forName("US-ASCII");
	            try (BufferedReader reader = Files.newBufferedReader(fil, charset)) {
	                String line = null;
	                while ((line = reader.readLine()) != null) {
	                    textField.setText(line);
	                }
	                frame.setTitle(fi);
	                
	                int color = Integer.parseInt(textField.getText(),16); //decode hex string
	                colorChooser.setColor(color);
	            } catch (IOException x) {
	                
	            }
	            
	            
	        } else {
	            
	        }
	}
}
