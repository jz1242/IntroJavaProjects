/*
 Jason Zhang 
 jzhan127
 600.107 
 Assignment 1
 Task 1
 
 */

import java.util.Scanner;

public class MagicNumber {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Please enter the first place team's city and name:");
		String teamName = sc.nextLine();											//takes in the team name as a string
		
		System.out.print("Please enter their number of WINS so far:");
		int wins = sc.nextInt();													//takes in wins as an integer

		System.out.print("Please enter the number of LOSSES so far for the second place team:");
		int losses = sc.nextInt();													//takes in losses as an integer
				
		System.out.print("Please enter the total number of games per team:");
		int total = sc.nextInt();												//takes in total games as an integer
		
		int magicNum = total - wins - losses + 1;									//calculates the magic number as an integer	

		System.out.println("\nThe " + teamName + " have a magic number of " + magicNum);			//prints out the magic number
			
	}

}
