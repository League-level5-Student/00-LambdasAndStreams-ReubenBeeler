package _00_JButtons_with_Lambdas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LambdaButtons {
	private JFrame window = new JFrame();
	private JButton addNumbers = new JButton("ADD 2 NUMBERS");
	private JButton randNumber = new JButton("RANDOM NUMBER");
	private JButton tellAJoke = new JButton("TELL A JOKE");
	
	public LambdaButtons() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());
		window.add(addNumbers);
		window.add(randNumber);
		window.add(tellAJoke);
		
		//1. Call the addActionListener methods for each button. Use lambdas
		//   to define the functionality of the buttons.
		addNumbers.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (addNumbers.getText().equals("ADD 2 NUMBERS")) {
					for (boolean redo = true; redo;) {
						Integer a = null, b = null;
						for (boolean num = false; !num;) {
							try {
								a = Integer.parseInt(JOptionPane.showInputDialog("Enter number 1: "));
								num = true;
							} catch (NumberFormatException NFE) {}
						}
						for (boolean num = false; !num;) {
							try {
								b = Integer.parseInt(JOptionPane.showInputDialog("Enter number 2: "));
								num = true;
							} catch (NumberFormatException NFE) {}
						}
						if (a != null && b != null) {
							addNumbers.setText(String.valueOf((long)(int) a + (long)(int) b));
							redo = false;
						}
					}
				} else {
					addNumbers.setText("ADD 2 NUMBERS");
				}
			}
		});
		
		randNumber.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (randNumber.getText().equals("RANDOM NUMBER")) {
					randNumber.setText(String.valueOf((int)(Math.random() * Integer.MAX_VALUE)));
				} else {
					randNumber.setText("RANDOM NUMBER");
				}
			}
		});
		
		tellAJoke.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(window, "Is your refridgerator running?... Well you better catch it before it gets too far!");
			}
		});
		
		window.setVisible(true);
		window.pack();
	}
	
	public static void main(String[] args) {
		new LambdaButtons();
	}
}
