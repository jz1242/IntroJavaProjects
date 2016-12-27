/*
 Jason Zhang 
 jzhan127
 600.107
 Assignment 2
 Task 3
 */
import java.util.*;

public class MilitaryTime {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a time in 24-hour HH:MM format, e.g., 1:02 or 19:56");	//prompts user for a time
		String inputTime = sc.nextLine();														//takes input as string
		System.out.println("Next, enter a duration to add to that time, Use HH:MM format.");		//prompts user for a time to add
		System.out.println("For example, to add two hours and five minutes, type 2:05.");		
		String inputTimeAdd = sc.nextLine();													//takes input from user as a string

		int hours = Integer.parseInt(inputTime.substring(0, inputTime.indexOf(':')));		//finds the hours from the input time and parse it to an Int
		int minutes = Integer.parseInt(inputTime.substring(inputTime.indexOf(':') + 1));	//finds the minutes from the input time and parse it to an Int
		int hoursAdd = Integer.parseInt(inputTimeAdd.substring(0, inputTimeAdd.indexOf(':')));	//finds the hours to add from input and parse it to an int
		int minutesAdd = Integer.parseInt(inputTimeAdd.substring(inputTimeAdd.indexOf(':') + 1));	//finds the minutes to add from input and parse it to an int
		int totalminutes = (minutes + minutesAdd);											//calculate the total minutes
		int totalHours = (hours + hoursAdd + (totalminutes / 60)) % 24;					//calculates the hours in military time by using modulus operation
		int minutescorrection = totalminutes % 60;											//calculates the minutes in military time by using modulus operation

		System.out.printf("Okay, the time " + hoursAdd + " hours(s) and " + minutesAdd + " minute(s) past " + inputTime
				+ " will be %02d:%02d%n", totalHours, minutescorrection);				//prints the formatted output with the complete military time 

	}

}
