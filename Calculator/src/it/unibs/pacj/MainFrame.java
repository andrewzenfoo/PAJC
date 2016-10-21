package it.unibs.pacj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

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
		
		Calculator calculator = new Calculator();
		
		JPanel panelNumbers = new JPanel();
		frame.getContentPane().add(panelNumbers, BorderLayout.CENTER);
		panelNumbers.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btn_1 = new JButton("1");
		panelNumbers.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		panelNumbers.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		panelNumbers.add(btn_3);
		
		JButton btn_4 = new JButton("4");
		panelNumbers.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		panelNumbers.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		panelNumbers.add(btn_6);
		
		JButton btn_7 = new JButton("7");
		panelNumbers.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		panelNumbers.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		panelNumbers.add(btn_9);
		
		JButton btn_dot = new JButton(".");
		panelNumbers.add(btn_dot);
		
		JButton btn_0 = new JButton("0");
		panelNumbers.add(btn_0);
		
		JPanel panel = new JPanel();
		panelNumbers.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btn_ac = new JButton("AC");
		panel.add(btn_ac);
		
		JButton btn_del = new JButton("DEL");
		panel.add(btn_del);
		
		
		JPanel panelOperations = new JPanel();
		frame.getContentPane().add(panelOperations, BorderLayout.EAST);
		panelOperations.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btn_plus = new JButton("+");
		panelOperations.add(btn_plus);
		
		JButton btn_minus = new JButton("-");
		panelOperations.add(btn_minus);
		
		JButton btn_mul = new JButton("*");
		panelOperations.add(btn_mul);
		
		JButton btn_div = new JButton("/");
		panelOperations.add(btn_div);
		
		JButton btn_eq = new JButton("=");
		panelOperations.add(btn_eq);
		
		JLabel lblOut = new JLabel(" ");
		frame.getContentPane().add(lblOut, BorderLayout.NORTH);
		
		//Inserimento numeri
		
		btn_1.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_1.getText())));
		btn_2.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_2.getText())));
		btn_3.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_3.getText())));
		btn_4.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_4.getText())));
		btn_5.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_5.getText())));
		btn_6.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_6.getText())));
		btn_7.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_7.getText())));
		btn_8.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_8.getText())));
		btn_9.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_9.getText())));
		btn_0.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_0.getText())));
		btn_dot.addActionListener(
				e -> lblOut.setText(lblOut.getText().concat(btn_dot.getText())));
		
		//Cancellazione
		
		btn_ac.addActionListener(e -> lblOut.setText(" "));
		btn_del.addActionListener(e -> lblOut.setText(lblOut.getText().substring(0, lblOut.getText().length()-1)));
		
		//Operazioni
		
		btn_plus.addActionListener(
				e -> {
					calculator.setNum1(Double.parseDouble(lblOut.getText()));
					lblOut.setText(" ");
					calculator.setOperation(btn_plus.getText());
				});
		btn_minus.addActionListener(
				e -> {
					calculator.setNum1(Double.parseDouble(lblOut.getText()));
					lblOut.setText(" ");
					calculator.setOperation(btn_minus.getText());
				});
		btn_mul.addActionListener(
				e -> {
					calculator.setNum1(Double.parseDouble(lblOut.getText()));
					lblOut.setText(" ");
					calculator.setOperation(btn_mul.getText());
				}
				);
		btn_div.addActionListener(
				e -> {
					calculator.setNum1(Double.parseDouble(lblOut.getText()));
					lblOut.setText(" ");
					calculator.setOperation(btn_div.getText());
				});
		btn_eq.addActionListener(
				e -> {
					calculator.setNum2(Double.parseDouble(lblOut.getText()));
					lblOut.setText(String.valueOf(calculator.getResult()));
				});
		
		
		
	}
	
	
	
	

}
