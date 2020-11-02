package _07_fortune_teller;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.util.Random;

import javax.swing.JOptionPane;

public class Magic8Ball {

	// 1. Make a main method that includes all the steps below….
	public static void main(String[] args) {
		int randomNum = new Random().nextInt(4);
		System.out.println(randomNum);
		JOptionPane.showMessageDialog(null, "The fourtuneteller delegated your question to the 8 ball.");
		String response;
		if (randomNum==0) {
			response = "Yes";
		} else if (randomNum==1) {
			response = "No.";
		} else if (randomNum==2) {
			response = "Maybey you should ask Google?";
		} else {
			response = "Your question was so thought-provoking that the 8-ball decied to quit it's job to persue the awnser. Come back in´®ETYEÁÍU†®ÏCI®Î¨†´ years.\n(The fourtuneteller sighs and grabs a new 8-ball, as if this is an often ocurance)";
		}
		JOptionPane.showMessageDialog(null, response);
	}
	// 2. Make a variable that will hold a random number and put a random number into this variable using "new Random().nextInt(4)"

	// 3. Print out this variable

	// 4. Get the user to enter a question for the 8 ball

	// 5. If the random number is 0

	// -- tell the user "Yes"

	// 6. If the random number is 1

	// -- tell the user "No"

	// 7. If the random number is 2

	// -- tell the user "Maybe you should ask Google?"

	// 8. If the random number is 3

	// -- write your own answer

}
