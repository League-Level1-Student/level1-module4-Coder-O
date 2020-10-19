package _05_typing_tutor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	char currentLetter;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TypingTutor tutor = new TypingTutor();
		tutor.setup();
	}
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}
	
	void setup() {
		JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        currentLetter = generateRandomLetter();
        JLabel label = new JLabel();
        label.setText(String.valueOf(currentLetter));
        label.setFont(label.getFont().deriveFont(28.0f));
        label.setHorizontalAlignment(JLabel.CENTER);
        
        frame.addKeyListener(this);
        panel.add(label);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
