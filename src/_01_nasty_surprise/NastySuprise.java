package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySuprise implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JButton trickButton;
	JButton treatButton;
	
	void run() {
		frame = new JFrame();
		panel = new JPanel();
		trickButton = new JButton();
		treatButton = new JButton();
		
		trickButton.setText("Trick");
		treatButton.setText("Treat");
		
		frame.add(panel);
		panel.add(treatButton);
		panel.add(trickButton);
		frame.pack();
		frame.setVisible(true);
		
		trickButton.addActionListener(this);
		treatButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(trickButton)) {
			showPictureFromTheInternet("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*");
		} else {
			showPictureFromTheInternet("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/09e054e3-f3ac-4da9-8968-274a1e23aebf/d53twaq-4abc0030-f9f0-4da1-8ed5-582f4fdc3b9c.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvMDllMDU0ZTMtZjNhYy00ZGE5LTg5NjgtMjc0YTFlMjNhZWJmXC9kNTN0d2FxLTRhYmMwMDMwLWY5ZjAtNGRhMS04ZWQ1LTU4MmY0ZmRjM2I5Yy5qcGcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.rn5TEYSj8Kf2jgwJen4Fd-BsbvFOxBT6nSqT-H6ly0M");
		}
		
	}
	
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame2 = new JFrame();
	        frame2.add(imageLabel);
	        frame2.setVisible(true);
	        frame2.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}
//	public static void main(String[] args) {
//		NastySuprise suprise = new NastySuprise();
//		suprise.run();
//	}
}
