import java.util.Scanner;
/*
Jason Zhang 
jzhan127
600.107
Assignment 6
Task 3
*/
public class CompressDuplicates {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);  //initializes scanner
		System.out.println("Please enter a line of input:");  //prompts user for input
		String inp=sc.nextLine();						//takes string user input
	
	System.out.println("The compressed line is "+compressDuplicates(inp)+".");		//calls the compressDuplicates function and prints out the compressed line
	
	}
	/**
	*this function will compress the string by replacing 
	*duplicate consecutive symbols in a line of text with 
	*the symbol and the number of times it appears in that location
	*
	* @param s the string from which duplicates are compressed
	* @return the compressed string
	*/
	public static String compressDuplicates(String s){
		String holder="";					//temporary string to hold
		int count=0;						//initialized counter

		
		if(count<s.length()){					
		count=countLetters(s,s.charAt(0),0);	//makes a call to countLetters function and gets the number of that specific letter in the string
		holder=s.substring(count);				//temporary string now holds the new string that is a substring that cuts out the counted letters
		return s.charAt(0)+""+count+compressDuplicates(holder); //recursive statement that is given the new string
		}
		return "";
		
	}
	/**
	*Returns the number of duplicate letters and returns the value when a different character is encountered
	*
	* @param a the string that is passed to the method that will be analyzed
	* @param b  the char that will be used to compare to all the characters in the string 'a'
	* @param counter this int that will be used to traverse the string
	* @return the integer that represents the number of duplicate letters
	*/
	public static int countLetters(String a,char b,int counter){
		if(counter<a.length()){										//when the counter is less than the length of string the statement executes
			if(a.charAt(counter)==b){
				return 1+countLetters(a,b,counter+1);				//when the charAt the counter of string a is equal to the char b then the recursive statement is executed and 1 is added
			}
		}
		return 0;													//when the counter is now = to the length of string 0 is added and then the function will return the number of duplicate letter
		
	}

}
