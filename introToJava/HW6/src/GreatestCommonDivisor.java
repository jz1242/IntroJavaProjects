import java.util.Scanner;
/*
Jason Zhang 
jzhan127
600.107
Assignment 6
Task 1
*/
public class GreatestCommonDivisor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //initialized scanner
		System.out.println("Please enter two integers:");	//prompts user for two integer inputs
		int userInp = sc.nextInt();							//takes first user input
		int userInpTwo = sc.nextInt();						//takes second user input
		System.out.println("Their greatest common divisor is " + gcd(userInp, userInpTwo)+".");  //calls the gcd function and prints out the greatest common divisor 

	}

	/**
	 * Determines the greatest common divisor of arguments a and b using a
	 * recursive implementation of the Euclidean algorithm.
	 *
	 * @param a    the first number
	 * @param b    the second number
	 * @return the gcd of a and b
	 */

	public static int gcd(int a, int b) {
		int greater;		
		int less;
		

		if (a > b) {			//if a is greater than b, a is stored in greater, b is stored in less
			greater = a;
			less = b;
		} else {					//if b is greater than a, b is stored in greater, a is stored in less
			greater = b;
			less = a;
		}
		if (less == 0) {			//returns greater if there is no more remainder
			return greater;
		}

		return gcd(less, greater % less);  //recursively calls the gcd function.

	}
}
