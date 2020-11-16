package _10_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PigLatinTranslator implements ActionListener {

	JFrame frame;
	JPanel panel;
	JTextField englishInput;
	JTextField pigInput;
	JButton translateButton;
	
	void run() {
		frame = new JFrame();
		panel = new JPanel();
		englishInput = new JTextField(20);
		pigInput = new JTextField(20);
		translateButton = new JButton("Translate");
		
		panel.add(englishInput);
		panel.add(translateButton);
		panel.add(pigInput);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		translateButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		pigInput.setText(new TheLeaguesPigLatinTranslator().translate(englishInput.getText()));
	}

}
