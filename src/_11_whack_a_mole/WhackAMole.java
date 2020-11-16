package _11_whack_a_mole;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

public class WhackAMole implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton[][] buttons;
	int rows = 3;
	int colums = 8;
	Random ran;
	JButton mole;
	int molesHit = 0;
	int molesMissed = 0;
	Date startTime = new Date();
	
	void run() {
		frame = new JFrame("Whack a button for fame and glory.");
		panel = new JPanel();
		frame.add(panel);
		
		ran = new Random();
		
		buttons = new JButton[rows][colums];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				panel.add(buttons[i][j]);
			}
		}
		
		
		
		
		
		
		drawButtons(ran.nextInt(rows), ran.nextInt(colums));
	}
	
	void drawButtons(int randomIntCol, int randomIntRow) {
		
		
		
		mole = buttons[randomIntCol][randomIntRow];
		mole.setText("mole!");
		
		frame.setSize(rows*100, colums*40);;
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(mole)) {
			playSound("1-59 Horse Race Goal.wav");
			molesHit++;
		} else {
			molesMissed++;
			if(molesMissed == 1) {
				speak("Missed!");
			} else if(molesMissed == 2) {
				speak("Missed again!");
			} else if(molesMissed == 3) {
				speak("Failed a third time!");
			} else if(molesMissed == 4) {
				speak("One more innocent button smashed, and it's game over for you!");
			} else if(molesMissed == 5) {
				speak("Game over! You lost!");
				
				if(molesHit>1) {
					speak("You hit "+ molesHit+ " moles!");
					
				} else if(molesHit == 1) {
					speak("You hit one mole!");
					
				} else {
					speak("You didn't even hit a single one!? Are you trying to fail?!");
				}
			}
			
		}
		frame.dispose();
		if(molesHit<10 && molesMissed < 5) {
			run();
		} else if (molesMissed < 5) {
			endGame(startTime, molesHit);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
	
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	}
	private void playSound(String fileName) { 
	    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	    sound.play();
	}
}

