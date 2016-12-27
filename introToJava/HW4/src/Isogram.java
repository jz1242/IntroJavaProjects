/*
 Jason Zhang 
 jzhan127
 600.107
 Assignment 4
 Task 1
 */
import java.util.*;

public class Isogram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);										
		System.out.println("Please enter a word (no spaces or punctuation, please):"); //ask user for input
		String rawinput = sc.nextLine();							//takes userinput
		String inputlowercase = rawinput.toLowerCase();				//changes userinput into all lower case
		boolean repeats = false;
		for (int i = 0; i < inputlowercase.length(); i++) {				//for loop runs and compares every value of the user input
			for (int j = i + 1; j < inputlowercase.length(); j++) {
				if (inputlowercase.charAt(i) == inputlowercase.charAt(j)) {
					repeats = true;												//if any character in the string has a repeat, the boolean changes to true
				}					

			}

		}

		if (repeats == false) {														//if the repeats boolean is unchanged that means it is an isogram
			System.out.println("The word " + rawinput + " is an isogram.");

		} else {
			System.out.println("The word " + rawinput + " is NOT an isogram.");		//if the boolean is now true that means it is not an isogram
			
		}

	}

}
