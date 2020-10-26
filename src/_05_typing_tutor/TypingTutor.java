package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	char currentLetter;
	JLabel label;
	JFrame frame;
	JPanel panel;
	Color green;
	Color red;
	int charsTyped;
	
	Date timeAtStart;
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
		frame = new JFrame();
        panel = new JPanel();
        currentLetter = generateRandomLetter();
        label = new JLabel();
        label.setText(String.valueOf(currentLetter));
        label.setFont(label.getFont().deriveFont(28.0f));
        label.setHorizontalAlignment(JLabel.CENTER);
        
        frame.addKeyListener(this);
        panel.add(label);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        
        green = new Color(0,255,0);
        red = new Color(255, 0, 0);
        
        timeAtStart = new Date();
        charsTyped = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("you typed: " + e.getKeyChar());
		if(e.getKeyChar() == currentLetter) {
			System.out.println("Correct!");
			panel.setBackground(green);
		}
		else {
			panel.setBackground(red);
		}
		charsTyped++;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		label.setText(String.valueOf(currentLetter));
		if(charsTyped>=15) {
			showTypingSpeed(charsTyped);
			charsTyped = 0;
			timeAtStart = new Date();
		}
		
		
	}
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
	    Date timeAtEnd = new Date();
	    long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	    long gameInSeconds = (gameDuration / 1000) % 60;
	    double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	    int charactersPerMinute = (int) (charactersPerSecond * 60);
	    JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	}

}
