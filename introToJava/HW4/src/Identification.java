/*
 Jason Zhang 
 jzhan127
 600.107
 Assignment 4
 Task 2
 */
import java.util.*;

public class Identification {
	public static void main(String[] args) {

		final String TARGET_PIN = "1234";						//an unchangable final string
		Scanner sc = new Scanner(System.in);
		boolean correct = false;								//boolean variable initialized to false
		int counter = 0;										//integer variable initialized to 0
		while (correct == false && counter < 3) {				//the while loop will continue as long as the boolean and the integer variables are false and less than 3 respectively 
			System.out.println("Please enter your PIN number: ");  //prompts user for an input
			String input = sc.nextLine();
			if (input.equals(TARGET_PIN)) {							//compares the input to the TARGET_PIN
				System.out.println("You are successfully logged in.");
				correct = true;													//if they equal, then the boolean is set to true and the loop exits with a successful login
			}
			counter++;

		}
		if (correct == false) {													//if after 3 tries the boolean variable is still false then the following failed login statement will print 
			System.out.println("You made 3 unsuccessful login attempts. Your account is locked.");
			System.out.println("Please contact the bank");
		}

	}

}
