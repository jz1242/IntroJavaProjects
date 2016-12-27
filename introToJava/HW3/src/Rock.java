/*
 Jason Zhang 
 jzhan127
 600.107
 Assignment 3
 Task 2
 */
import java.util.*;

public class Rock {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();												 
		int randomNumber = rand.nextInt(3);					// random number generator from 0 to 3
		System.out.println("Welcome to Rock, Paper, Scissors!");				
		System.out.println("I've made my choice. What's yours? Enter R, P, or S:");	//prompts user to enter a character
		String userChoice = sc.next().toLowerCase();						//takes user input and puts it to lowercase

		String CompChoice;
		if (randomNumber == 0) {					// the random numbers generated are assigned a value (0=r, 1=p, 2=s)
			CompChoice = "r";
		} else if (randomNumber == 1) {
			CompChoice = "p";
		} else {
			CompChoice = "s";
		}
		if (!userChoice.equals("s") && !userChoice.equals("r") && !userChoice.equals("p")) {			//checks if user input is valid or not
			System.out.println("Sorry, that is not a valid choice.");
		} else {
			if (userChoice.equals(CompChoice)) {					//checks if the user and computer chose the same value
				if (userChoice.equals("r")) {										
					System.out.println("I chose Rock, and you chose Rock. We TIED!");	//print statement is used when the value is r
				} else if (userChoice.equals("p")) {
					System.out.println("I chose Paper, and you chose Paper. We TIED!");		//print statement is used when value is p
				} else {
					System.out.println("I chose Scissors, and you chose Scissors. We TIED!");	//print statement is used when value is s
				}

			} else {															//checks the rest of the possible cases in rock paper scissors
				if (userChoice.equals("p") && CompChoice.equals("r")) {				//checks if userinput is p and comp choice is r and prints the following statement
					System.out.println("I chose Rock, and you chose Paper.   You WIN!");			

				} else if (userChoice.equals("p") && CompChoice.equals("s")) {		//checks if userinput is p and comp choice is s and prints the following statement
					System.out.println("I chose Scissors, and you chose Paper.   You LOSE!");

				} else if (userChoice.equals("r") && CompChoice.equals("p")) {			//checks if userinput is r and comp choice is p and prints the following statement
					System.out.println("I chose Paper, and you chose Rock.   You Lose!");

				} else if (userChoice.equals("r") && CompChoice.equals("s")) {				//checks if userinput is r and comp choice is s and prints the following statement
					System.out.println("I chose Scissors, and you chose Rock.   You WIN!");

				} else if (userChoice.equals("s") && CompChoice.equals("r")) {				//checks if userinput is s and comp choice is r and prints the following statement
					System.out.println("I chose Rock, and you chose Scissors.   You LOSE!");

				} else {																	//this is the final possibility in the game for if the userinput is p and comp choice is s, it prints the following statement
					System.out.println("I chose Paper, and you chose Scissors.   You WIN!");

				}
			}
		}
	}
}
