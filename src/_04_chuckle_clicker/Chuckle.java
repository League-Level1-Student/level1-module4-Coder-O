package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chuckle implements ActionListener {
	JButton jokeButton;
	JButton punchlineButton;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chuckle chuckle = new Chuckle();
		chuckle.makeButtons();
	}
	void makeButtons() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		
		jokeButton = new JButton();
		punchlineButton = new JButton();
		
		panel.add(jokeButton);
		panel.add(punchlineButton);
		frame.add(panel);
		
		jokeButton.setText("Joke");
		punchlineButton.setText("Punchline");
		
		jokeButton.addActionListener(this);
		punchlineButton.addActionListener(this);
		
		frame.pack();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == jokeButton) {
			JOptionPane.showMessageDialog(null, "Why is the United States a communist country?");
		}
		else {
			JOptionPane.showMessageDialog(null, "It's acronym is US.");
		}
		
	}

}
