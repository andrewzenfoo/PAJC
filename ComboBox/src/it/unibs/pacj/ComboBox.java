package it.unibs.pacj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;

public class ComboBox {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBox window = new ComboBox();
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
	public ComboBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		JPanel panC = new JPanel();
		frame.getContentPane().add(panC, BorderLayout.CENTER);
		panC.setLayout(new BorderLayout(0, 0));
		
		JLabel lblOut = new JLabel("Prova");
		lblOut.setHorizontalAlignment(SwingConstants.CENTER);
		panC.add(lblOut);
		
		JPanel panE = new JPanel();
		frame.getContentPane().add(panE, BorderLayout.EAST);
		panE.setLayout(new BorderLayout(0, 0));
		
		JComboBox cbColor = new JComboBox();
		cbColor.setModel(new DefaultComboBoxModel(new String[] {"Red", "Green", "Blue"}));
		panE.add(cbColor, BorderLayout.NORTH);
		
		JPanel panW = new JPanel();
		frame.getContentPane().add(panW, BorderLayout.WEST);
		panW.setLayout(new BorderLayout(0, 0));
		
	
		//String[] fontNames = Arrays.copyOf(allFonts.getFontName, allFonts.length);
		
		JComboBox cbFont = new JComboBox();
		panW.add(cbFont, BorderLayout.NORTH);
		
		JPanel panS = new JPanel();
		frame.getContentPane().add(panS, BorderLayout.SOUTH);
		panS.setLayout(new BorderLayout(0, 0));
		
		JSlider slider = new JSlider();
		slider.setValue(10);
		panS.add(slider, BorderLayout.CENTER);
		

		
		
	}

}
