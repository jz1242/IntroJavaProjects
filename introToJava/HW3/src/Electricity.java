/*
 Jason Zhang 
 jzhan127
 600.107
 Assignment 3
 Task 1
 */
import java.util.*;

public class Electricity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please input last month's meter reading [0-99999]:");	//prompts user to enter last months reading
		int lastMonth = sc.nextInt();												//takes user input as an integer
		System.out.println("Please input this month's meter reading [0-99999]:");	//prompts user to enter this months reading
		int thisMonth = sc.nextInt();											//takes user input as an integer
		int thisMonthUnwrapped;														//declared variables that will be used in later code
		double pay;
		int difference;

		if (thisMonth < lastMonth) {				//checks if this months reading is less than last months
			thisMonthUnwrapped = thisMonth + 100000;	//this months value was wrapped after 99999, adding 100000 "unwraps" the value
			difference = thisMonthUnwrapped - lastMonth;	//calculates the difference between the readings
			if (difference < 1000) {					//checks for the case that the difference is less than 1000 and executes the following operation and the amount due is 7 cents per kilowatt 
				pay = difference * 0.07;
			} else if (difference >= 1000 && difference <= 2500) {	//checks for the case that the difference is between 1000 and 2500 and executes the following operation and the amount due is 5 cents per kilowatt with an additional 50 dollars
				pay = ((difference - 1000) * 0.05) + 70;
			} else {										//checks for the case that the difference is greater than 2500 and executes the following operation and the amount due is 3 cents per kilowatt over with an additional 145 dollars
				pay = ((difference - 2500) * 0.03) + 145;
			}

		} else {										//if this month is not less than last month, then this conditional will be executed
			difference = thisMonth - lastMonth;			//calculates the difference between the readings
			if (difference < 1000) {					//checks for the case that the difference is less than 1000 and executes the following operation and the amount due is 7 cents per kilowatt 
				pay = difference * 0.07;				
			} else if (difference >= 1000 && difference <= 2500) {     //checks for the case that the difference is between 1000 and 2500 and executes the following operation and the amount due is 5 cents per kilowatt with an additional 50 dollars
				pay = ((difference - 1000) * 0.05) + 70;
			} else {													//checks for the case that the difference is greater than 2500 and executes the following operation and the amount due is 3 cents per kilowatt over with an additional 145 dollars
				pay = ((difference - 2500) * 0.03) + 145;
			}
		}
		
		if (thisMonth > 99999 || lastMonth > 99999) {	//checks if the user has entered in a valid 5 digit input

			System.out.println("You have entered an invalid input value, so no bill will be produced.");
		} else {						
			System.out.printf("You used " + difference + " kilowatt-hour(s), and you owe $%.2f", pay, ".");		//prints out a formated string if the user inputs valid numbers
		}

	}

}
