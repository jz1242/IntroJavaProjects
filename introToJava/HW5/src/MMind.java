/*
 Jason Zhang 
 jzhan127
 600.107
 Assignment 5
 Task 2
 */
import java.util.*;
public class MMind {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);	
		System.out.println("I'm thinking of a 4 digit number. Each digit is between 1 and 9.\nTry to guess my number, and I'll say R for each digit you get right,\nand W for each correct digit you get in the wrong place. If you don't\nuse any of the correct digits in your guess, I'll say none");
		//String randnum=genTargetWithNoZeroes();				//call to function to get a randomnumber to start the game
		String randnum="7578";
		//System.out.println(randnum);					
		Boolean correct=false;							//boolean variable to control the following while loop
		int counter=1;					//counter to count the tries
		while(correct!=true){				//while the guess is wrong, this loop will run 
			System.out.println("Your guess:");					
			String guess=sc.nextLine();
			if(guess.equals(randnum)){		//accesses this statement if the guessed number is correct 
				if(counter==1){
				System.out.println("You got it right in "+counter+" guess!");			//prints the statement and number of guesses 
				}
				else{
				System.out.println("You got it right in "+counter+" guesses!");//prints the statement and number of guesses 
				}
				correct=true;
			}
			else{
			String clue=getClue(randnum,guess);		//if the guessed value is incorrect it will call to the getclue function 
			System.out.println(clue);				//prints out the clue
			
			}
			counter++;							//increments the counter 
		}
		
	}
	public static String genTargetWithNoZeroes(){			//function generates a random 4 digit number and returns it as a string 
		Random rand=new Random();	
		int first=rand.nextInt(9)+1;						//gets 4 random numbers 
		int second=rand.nextInt(9)+1;
		int third=rand.nextInt(9)+1;
		int fourth=rand.nextInt(9)+1;
		String number=""+first+second+third+fourth;				//returns a concatenation of those 4 numbers 
		return number;
		
	}
	public static String getClue(String target, String guess){				//gives the user a clue 
		String R="";												//string of rights
		String W="";													//string of digits in wrong place
		
		String modifiedtarget=target;					
		String modifiedguess=guess;
		for(int i=0;i<4;i++){								//compares every value from the guess to the target string 
			for(int j=0;j<4;j++){
				if(guess.charAt(i)==target.charAt(j)){
					if(i==j){										//if we get a match in the same position then and R is added to the String R
						R+="R ";			
						modifiedtarget=modifiedtarget.substring(0,i)+"0"+modifiedtarget.substring(i+1);				//the modified target string will change the value to a 0 and the modified guess string will change the value to Q for later use 
						modifiedguess=modifiedguess.substring(0,i)+"Q"+modifiedguess.substring(i+1);
						//System.out.println(modifiedtarget);
					//System.out.println(modifiedguess);
					}
					
				}
			}
			
		}
		//System.out.println(modifiedtarget);
		for(int i=0;i<4;i++){						//compares every value of the modified strings to see if there are potential matches, the modified strings are used in order to get the accurate count of Ws and not recount the Rs 
			for(int j=0;j<4;j++){					
				if(modifiedguess.charAt(i)==modifiedtarget.charAt(j)){
					W+="W ";														//adds a W to W if there is a match 
					modifiedtarget=modifiedtarget.substring(0,j)+"0"+modifiedtarget.substring(j+1);			//changes the modified strings by changing the matching value to 0 and Q respectively on targets and guesses to stop repeat counts 
					modifiedguess=modifiedguess.substring(0,i)+"Q"+modifiedguess.substring(i+1);
					//System.out.println(modifiedtarget);
					//System.out.println(modifiedguess);
				}
			}
			
		}
		String tot=R+W;		//concatentates the Rs and Ws 
		if(tot.equals("")){				//if there are no Rs or Ws then the function will return no clue 
			return "none";
		}
		else{
			return tot;					//otherwise it will return the clue 
		}
		
	}

}
