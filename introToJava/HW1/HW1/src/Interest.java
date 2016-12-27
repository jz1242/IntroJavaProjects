/*
 Jason Zhang 
 jzhan127	
 600.107
 assignment 1
 task 2 
 
 */

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the amount of initial principal:  $");
		double initial = sc.nextDouble();														//takes in initial principle as double value
		System.out.println("Please enter the interest rate (e.g.  9% is entered as .09):");
		double rate = sc.nextDouble();													//takes in interest rate as a double value
				
		
		//calculates the amount earned after one year, five years, and twenty five years
		double oneYear = initial * Math.pow(1 + rate, 1);
		double fiveYears = initial * Math.pow(1 + rate, 5);
		double twentyfiveYears = initial * Math.pow(1 + rate, 25);

		//prints out the amount earned after 1,5,25 years
		System.out.println("The value of that initial deposit after 1 year is $ " + oneYear);
		System.out.println("The value of that initial deposit after 5 years is $ " + fiveYears);
		System.out.println("The value of that initial deposit after 25 years is $ " + twentyfiveYears);
	}
}
