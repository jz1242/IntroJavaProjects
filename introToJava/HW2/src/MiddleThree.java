/*
 Jason Zhang 
 jzhan127
 600.107
 Assignment 2
 Task 1
 */
import java.util.*;

public class MiddleThree {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter an odd-length String with at least three characters:");		//prompts user for input
		String userInput = sc.nextLine();																//takes userinput as string
		int lengthInput = userInput.length();															//calculates the length of the input
		String middlethree = userInput.substring((lengthInput) / 2 - 1, (lengthInput / 2) + 2);			//extracting the middle three characters of the input and creating the middle three string

		System.out.println("That string has length " + lengthInput + ", and its middle three String is " + "\""
				+ middlethree + "\"");	
		System.getProperty("sun.arch.data.model") ;//prints out the length and middle three string

	}

}
