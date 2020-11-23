package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.*;

public class SlotMachine implements ActionListener {
	JFrame frame;
	JPanel panel;
	JLabel image1;
	JLabel image2;
	JLabel image3;
	JButton spinButton;
	int imageInt1;
	int imageInt2;
	int imageInt3;
	int wins = 0;
	JLabel winLabel;
	
	int spins = 0;
	
	Random ran = new Random();
	
	
	void run() {
		frame = new JFrame();
		panel = new JPanel();
		spinButton = new JButton("SPIN!");
		image1 = new JLabel();
		image2 = new JLabel();
		image3 = new JLabel();
		winLabel = new JLabel("Spins: " + spins + "\nWins: " + wins + "\nWin rate: N/A");
		
		panel.add(winLabel);
		panel.add(spinButton);
		panel.add(image1);
		panel.add(image2);
		panel.add(image3);
		spinButton.addActionListener(this);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	
	void spin() {
		panel.remove(image1);
		panel.remove(image2);
		panel.remove(image3);
		
		spins++;
		
		imageInt1 = ran.nextInt(3);
		String nextImageString;
		if (imageInt1 == 0) {
			nextImageString = "HylianShieldSlots.png";
		} else if (imageInt1 == 1) {
			nextImageString = "MasterSwordSlots.png";
		} else {
			nextImageString = "OcorinaOfTimeSlots.png";
		}
		image1 = createLabelImage(nextImageString);
		
		
		imageInt2 = ran.nextInt(3);
		
		if (imageInt2 == 0) {
			nextImageString = "HylianShieldSlots.png";
		} else if (imageInt2 == 1) {
			nextImageString = "MasterSwordSlots.png";
		} else {
			nextImageString = "OcorinaOfTimeSlots.png";
		}
		image2 = createLabelImage(nextImageString);
		
		
		imageInt3 = ran.nextInt(3);
		
		if (imageInt3 == 0) {
			nextImageString = "HylianShieldSlots.png";
		} else if (imageInt3 == 1) {
			nextImageString = "MasterSwordSlots.png";
		} else {
			nextImageString = "OcorinaOfTimeSlots.png";
		}
		image3 = createLabelImage(nextImageString);
		
		panel.add(image1);
		panel.add(image2);
		panel.add(image3);
		
		
		if (imageInt1 == imageInt2 && imageInt2 == imageInt3) {
			wins++;
			
			frame.pack();
			JOptionPane.showMessageDialog(null, "YOU WIN!!!\nTotal wins: " + wins);
			
		}
		if(wins>0) {
			winLabel.setText("Spins: " + spins + "\nWins: " + wins + "\nWin rate: " + (spins/wins));
		} else {
			winLabel.setText("Spins: " + spins + "\nWins: " + wins + "\nWin rate: N/A");
		}
		frame.pack();
	}
	
	private JLabel createLabelImage(String fileName){
        URL imageURL = getClass().getResource(fileName);
		if (imageURL == null){
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		
		JLabel imageLabel = new JLabel(icon);
		
		return imageLabel;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		spin();
	}
}
