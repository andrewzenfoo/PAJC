package it.ing.unibs.pajc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblOut = new JLabel("");
		frame.getContentPane().add(lblOut, BorderLayout.NORTH);
		lblOut.setVisible(true);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		PanKeyPad panKeyPad = new PanKeyPad();
		panKeyPad.setBounds(45, 23, 161, 201);
		panel.add(panKeyPad);
		
		PanOperators panOperators = new PanOperators();
		panOperators.setBounds(229, 23, 54, 201);
		panel.add(panOperators);
		
		panKeyPad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblOut.setText(lblOut.getText()+e.getActionCommand());
			}
		});
		
		//evento che permette ai bottoni di scrivere sull lable
		ActionListener aclButton=new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source =e.getSource();
				if(source instanceof JButton)
					lblOut.setText(lblOut.getText().concat(((JButton) source).getText()));				
			}
		};	
	}

}
