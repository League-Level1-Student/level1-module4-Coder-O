package _08_calculator;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField input1;
	JTextField input2;
	JButton addButton;
	JButton multButton;
	JButton subtractButton;
	JButton divideButton;
	JLabel output;
	JPanel orginization;
	
	
	public void run() {
		frame = new JFrame();
		input1 = new JTextField(10);
		input2 = new JTextField(10);
		addButton = new JButton();
		multButton = new JButton();
		subtractButton = new JButton();
		divideButton = new JButton();
		output = new JLabel();
		orginization = new JPanel(); 
		
//		Dimension d = new Dimension(200, 10);
		
		
		
		addButton.setText("Add");
		multButton.setText("Multiply");
		subtractButton.setText("Subtract");
		divideButton.setText("Divide");
		output.setText("0000");
		
		
		orginization.add(input1);
		orginization.add(input2);
		orginization.add(addButton);
		orginization.add(multButton);
		orginization.add(subtractButton);
		orginization.add(divideButton);
		orginization.add(output);
		frame.add(orginization);
		
		
		frame.setVisible(true);
		frame.pack();
		
		addButton.addActionListener(this);
		multButton.addActionListener(this);
		subtractButton.addActionListener(this);
		divideButton.addActionListener(this);
	}
	
	int add(int num1, int num2) {
		return num1 + num2;
	}
	int multiply(int num1, int num2) {
		return num1 * num2;
	}
	int subtract(int num1, int num2) {
		return num1 - num2;
	}
	int divide(int num1, int num2) {
		return num1 / num2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(addButton)) {
			output.setText(String.valueOf(add(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()))));
		} else if (e.getSource().equals(multButton)) {
			output.setText(String.valueOf(multiply(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()))));
		} else if (e.getSource().equals(subtractButton)) {
			output.setText(String.valueOf(subtract(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()))));
		} else {
			output.setText(String.valueOf(divide(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()))));
		}
	}
}
