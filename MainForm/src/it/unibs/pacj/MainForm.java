package it.unibs.pacj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSlider;
import java.awt.event.MouseMotionAdapter;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JComboBox;

public class MainForm {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
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
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(new BorderLayout(0, 0));
				
				
				JPanel panel = new JPanel();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				
				JLabel lblSlider = new JLabel("");
				lblSlider.setBounds(12, 152, 271, 90);
				panel.add(lblSlider);
		
				JButton btnOk = new JButton("Ok");
				btnOk.setBounds(134, 26, 83, 28);
				panel.add(btnOk);
				
				textField = new JTextField();
				textField.setBounds(17, 26, 105, 28);
				panel.add(textField);
				textField.setColumns(10);
				
				JSlider slider = new JSlider();
				slider.setBounds(17, 88, 200, 28);
				panel.add(slider);
				slider.setMinimum(14);
				
				JLabel lblLabel = new JLabel("");
				lblLabel.setBounds(235, 26, 116, 28);
				panel.add(lblLabel);
				
				GraphicsEnvironment graphEnviron = GraphicsEnvironment.getLocalGraphicsEnvironment();
				Font[] allFonts = graphEnviron.getAllFonts();
				
				JComboBox comboBox = new JComboBox(allFonts);
				comboBox.setBounds(22, 256, 205, 24);
				panel.add(comboBox);
				
				JPanel pnlLog = new JPanel();
				frame.getContentPane().add(pnlLog, BorderLayout.EAST);
				pnlLog.setLayout(new BorderLayout(0, 0));
				
				textLog = new JTextArea();
				textLog.setBounds(0, 0, 507, 93);
				//pnlLog.add(textLog);
				textLog.setEditable(false);
				
				JScrollPane scrollPane = new JScrollPane();
				pnlLog.add(scrollPane);
				scrollPane.setViewportView(textLog);
				
		
		btnOk.addActionListener(e -> {
			lblLabel.setText(textField.getText());
			updateLog(String.format("Text inserted: \"%s\"", textField.getText()));
		});
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblSlider.setText(""+slider.getValue());
				lblSlider.setFont(new Font("Dialog", Font.PLAIN, slider.getValue()));
				updateLog(String.format("Slider moved at %d", slider.getValue()));
			}
		});
			
	}
	
	public void updateLog(String message) {
		textLog.append(String.format("%4d - %s\n", textLog.getLineCount(), message));
		
	}
}
