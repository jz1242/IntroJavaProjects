import java.util.Scanner;
/*
Jason Zhang 
jzhan127
600.107
Assignment 6
Task 2
*/
public class FormatLong {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);    //initializes scanner
		System.out.println("Please enter an integer:");			//prompts the user to enter an integer
		long userInp=sc.nextLong();									//takes in the integer
		System.out.println("The formatted number is "+formatLong(userInp)+".");		//calls the formatlong function and prints out the formatted numbers
	}
	/**
	* Returns its long integer argument as a String with commas
	* inserted so that a comma is used after every third digit
	* from right to left. The returned String never begins with
	* a comma. If the argument is negative, the returned String
	* begins with a - symbol.
	*
	* @param n the long integer to be formatted
	* @return the number formatted with commas as appropriate
	*/

	public static String formatLong(long n){
		
		
		if(Math.abs(n)<=999){		//if the absolute value of n is less than 999 then it just returns the string
			return n+"";
			
			
		}
		String threenum;			//string variable meant to hold 3 numbers
		if(Math.abs(n)%1000<100){			//if last three numbers are less than 100 then an extra 0 is added to the string
			threenum="0"+Math.abs(n)%1000;
			if(Math.abs(n)%1000<10){		//if last three numbers are less than 10 then two extra 0s are added to the string
				threenum="00"+Math.abs(n)%1000;
				
			}
		}
		else{
			threenum=Math.abs(n)%1000+"";	//if the last three numbers are greater than 100, then there are no extra 0s added
		}
		return formatLong(n/1000)+","+threenum;  //recursive statement that eventually returns the formatted number
		
		
	}
}
