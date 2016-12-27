/*
 Jason Zhang 
 jzhan127
 600.107
 Assignment 4
 Task 3
 */
import java.util.*;

public class Divisors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Given a specific range of positive integers to search, this program will\n determine a value in the range which has the highest number of divisors.\nYou get to select the range.");//introduces the program
		int firstval = 0;		//initializes the following integers to 0
		int secondval = 0;
		int winner = 0;
		int numdivisorwinner = 0;
		int numdivisorcounter = 0;
		boolean accepted = false;   //boolean variable used to continue the loop below
		while (accepted == false) {// while the boolean accepted = false the loop runs
			System.out.println("Please specify the range by entering two positive integers: ");  //prompts user for input
			firstval = sc.nextInt();			//first user input
			secondval = sc.nextInt();				//second user input
			if (firstval > 0 && secondval > 0) {	//if the values are valid numbers then the boolean variable is changed to true and the loop is stopped
				accepted = true;
			}
		}
		System.out.println("Okay, checking values between " + firstval + " and " + secondval + "...");		//prints out the message
		if (firstval > secondval) {											//if the first value entered is larger than the second value entered then the following statement runs
			for (int i = firstval; i >= secondval; i--) {		//using the first input as the starting point, the for loop decrements until it gets to the second input 
				for (int j = 1; j <= firstval; j++) {
					if (i % j == 0) {							//using the % operation, every value is tested from 1 to the largest value inputed by the user
						numdivisorcounter++;					//for every number that does not have a remainder after division, the numdivisorcounter variable is incremented to keep track of the number of divisors
					}
				}
				if (numdivisorcounter > numdivisorwinner) {		
					numdivisorwinner = numdivisorcounter;			//numdivisorcounter is greater than the value in the numdivisorwinner, which contains the number of divisors for the number with the greatest number of divisors at the moment, then numdivisorwinner is set to numdivisorcounter and the number with the most divisors is changed
					winner = i;

				}
				numdivisorcounter = 0;					//numdivisorcounter is reset to 0
			}

		} else {							//this case occurs when the first value is less than the second value or if they are equal 

			for (int i = firstval; i <= secondval; i++) { //using the first value as the starting point and incrementing to the second value
				for (int j = 1; j <= secondval; j++) {  
					if (i % j == 0) {					//using the % operation, every value is tested from 1 to the largest value inputed by the user
						numdivisorcounter++;			//for every number that does not have a remainder after division, the numdivisorcounter variable is incremented to keep track of the number of divisors	
						
					}
				}
				if (numdivisorcounter > numdivisorwinner) {	
					numdivisorwinner = numdivisorcounter;		//numdivisorcounter is greater than the value in the numdivisorwinner, which contains the number of divisors for the number with the greatest number of divisors at the moment, then numdivisorwinner is set to numdivisorcounter and the number with the most divisors is changed
					winner = i;

				}
				numdivisorcounter = 0;				//numdivisorcounter is reset to 0
			}
		}

		System.out.println("The winning number is " + winner + " with " + numdivisorwinner + " divisors."); //prints out the value of the number that has the greatest number of divisors
	}
}
