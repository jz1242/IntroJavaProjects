/*
Jason Zhang 
jzhan127
600.107
Assignment 7
Task 1
*/
public class PiggyBank extends Object {
	public static final int CENTS_PER_DIME = 10;				//unchangeable static variables showing all monetary equivalents of each coin
	public static final int CENTS_PER_NICKEL = 5;
	public static final int CENTS_PER_PENNY = 1;
	public static final int CENTS_PER_QUARTER = 25;
	private int dimes;					//private variables that show the number of dimes, nickels, pennies, and quarters in the bank
	private int nickels;
	private int pennies;
	private int quarters;

	/**
	 * Constuctor that sets all the private instance variables to 0
	 */
	public PiggyBank() {
		this.dimes = 0;				//sets all the private variables to 0
		this.nickels = 0;
		this.pennies = 0;
		this.quarters = 0;

	}

	/**
	 * Constructor that sets the private instance variables to the parameters that are passed to it
	 * @param quarters
	 * @param dimes
	 * @param nickels
	 * @param pennies
	 */
	public PiggyBank(int quarters, int dimes, int nickels, int pennies) {
		
		if(quarters<0){
			this.quarters=0;
		}
		else{
			this.quarters = quarters;
		}
		if(nickels<0){
			this.nickels=0;
		}
		else{
			this.nickels = nickels;
		}
		if(dimes<0){
			this.dimes=0;
		}
		else{
			this.dimes= dimes;
		}
		if(pennies<0){
			this.pennies=0;
		}
		else{
			this.pennies = pennies;
		}

	}

	/**
	 * a function that gives the numbers of quarters 
	 * @return number of quarters in the bank
	 */
	public int getQuarters() {
		return quarters;			//gives the number of quarters in the bank
	}

	/**
	 * a function that gives the number of dimes
	 * @return number of dimes in the bank
	 */
	public int getDimes() {
		return dimes;				//gives the number of dimes in the bank

	}

	/**
	* a function that gives the number of nickels
	 * @return number of nickels in the bank
	 */
	public int getNickels() {
		return nickels;				//gives the number of nickels in the bank
	}

	/**
	* a function that gives the number of pennies
	 * @return number of pennies in the bank
	 */
	public int getPennies() {
		return pennies;		//gives the number of pennies in the bank
	}

	/**
	 * this function adds the desired amount of quarters to the bank 
	 * @param howMany
	 */
	public void insertQuarters(int howMany) {
		if(howMany>0){
		this.quarters += howMany;	
		}//adds the appropriate number of quarters to the quarters variable
	}

	/**
	 * this function adds the desired amount of dimes to the bank
	 * @param howMany
	 */
	public void insertDimes(int howMany) {
		if(howMany>0){
		this.dimes += howMany;			
		}//adds the appropriate number of dimes to the dimes variable
	}

	/**
	 * this function adds the desired amount of nickels to the bank
	 * @param howMany
	 */
	public void insertNickels(int howMany) {
		if(howMany>0){
		this.nickels += howMany;				//adds the appropriate number of nickels to the nickels variable
		}
	}
	/**
	 * this function adds the desired amount of pennies to the bank
	 * @param howMany
	 */
	public void insertPennies(int howMany) {
		if(howMany>0)
		this.pennies += howMany;		//adds the appropriate number of pennies to the pennies variable
	}

	/**
	 * this function removes the appropriate amount of quarters from the bank and returns the value of quarters removed
	 * @param howMany
	 * @return the number of quarters that was removed
	 */
	public int removeQuarters(int howMany) {
		if (howMany >= this.quarters) {		//sees if the value that you want to withdraw is more than whats in the bank
			int holder = this.quarters;
			this.quarters = 0;				//removes all the quarters
			return holder;					//returns the value of the number of removed quarters
		}
		this.quarters -= howMany;			//subtracts the value you want to withdraw from the quarters in the bank
		return howMany;						//returns how many quarters removed
	}

	/**
	 * this function removes the appropriate amount of dimes from the bank and returns the value of dimes removed
	 * @param howMany
	 * @return the number of dimes that was removed
	 */
	public int removeDimes(int howMany) {
		if (howMany >= this.dimes) {	//checks if the amount desired is more than whats in the bank and removes as many dimes as possible
			int holder = this.dimes;
			this.dimes = 0;
			return holder;			//returns number removed
		}
		this.dimes -= howMany;		//subtracts the number of dimes from the desired value and returns the number removed
		return howMany;
	}

	/**
	 * this function removes the appropriate amount of nickels from the bank and returns the value of nickels removed
	 * @param howMany
	 * @return the number of nickels that was removed
	 */
	public int removeNickels(int howMany) {
		if (howMany >= this.nickels) {		//checks if the amount desired is more than whats in the bank and removes as many nickels as possible
			int holder = this.nickels;
			this.nickels = 0;
			return holder;			//return the number removed
		}
		this.nickels -= howMany; //removes the desired number of nickels from the bank and returns the number removed
		return howMany;
	}

	/**
	 * this function removes the appropriate amount of pennies from the bank and returns the value of pennies removed
	 * @param howMany
	 * @return the number of pennies that was removed
	 */
	public int removePennies(int howMany) {
		if (howMany >= this.pennies) {		//checks if the amount desired is more than whats in the bank and removes as many pennies as possible
			int holder = this.pennies;
			this.pennies = 0;
			return holder;			//returns the number removed
		}
		this.pennies -= howMany;		//removes the desired number of pennies from the bank and returns the number removed
		return howMany;
	}

	/**
	 * this function gives the total amount inside the bank
	 * @return total amount of money in the bank
	 */
	public int getTotal() {
		return (this.quarters * CENTS_PER_QUARTER )+ (this.dimes * CENTS_PER_DIME) + (this.nickels * CENTS_PER_NICKEL)
				+ (this.pennies*CENTS_PER_PENNY);																	//returns the total value in the bank by multiplying the number of a specific coin by its monetary value and summing them together
	}

	/**
	 * this function withdraws the desired amount of gives a boolean value to signify a successful or unsuccesful transfer
	 * @param totalWanted
	 * @return
	 */
	public boolean withdrawAmount(int totalWanted) {
		if (totalWanted > getTotal()) {		//checks if the amount you want to withdraw is more than whats in the bank
			return false;			//signifies an unsuccessful withdraw
		}
		this.quarters -= totalWanted / 25;				//starts withdrawal from the largest coin and moves down in order to pennies 
		this.dimes -= (totalWanted % 25) / 10;
		this.nickels -= ((totalWanted % 25) % 10) / 5;
		this.pennies -= ((totalWanted % 25) % 10) % 5;
		return true;				//signifies a successful withdraw
	}

	/**
	 * overrides the equals function, this function compares two piggybanks and see if their values are equivalent
	 * @param other
	 * @return a boolean that signifies if the piggy banks contain the same amount of quarters, dimes, etc.
	 */
	public boolean equals(Object other) {
	
		if ((((PiggyBank) other).getQuarters() == this.getQuarters()) && (((PiggyBank) other).getDimes() == this.getDimes())
				&& (((PiggyBank) other).getNickels() == this.getNickels()) && (((PiggyBank) other).getPennies() == this.getPennies())) {
			return true;
		}
		return false;
	}

	/**
	 * overrides the compareto function, this function compares the totals in each piggy bank and returns a negative value if the other bank has more, 0 if equal, and 1 if less
	 * @param other
	 * @return a integer value that signifies if the other bank has more, equal, or less in its bank
	 */
	public int compareTo(Object other) {
		if (((PiggyBank) other).getTotal() > this.getTotal()) {
			return -1;										// returns a negative number if there are more in the other bank
		}
		if (((PiggyBank) other).getTotal() == this.getTotal()) {
			return 0;								//returns 0 if both banks have equal amount
		}
		return 1;								//returns a positive number if there is less in the other bank
	}
	
	
	/**
	 * overrides the toString function, this function returns a string that contains text that shows how many quarters, dimes, etc are in the bank now
	 * @return a string that contains the number of quarters, dimes, nickels, pennies inside the bank 
	 */
	public String toString() {
		String print = "Bank Contains:\n";			//starts a string that will be added to with the following code
		if (getTotal() == 0) {
			return "Bank is empty";
		}
		if (this.quarters > 0) {				//if there are quarters then the following string will be added to print
			if (this.quarters == 1) {
				print += "1 quarter\n";
			} else {
				print += this.quarters + " quarters\n";
			}
		}
		if (this.dimes > 0) {				//if there are dimes then the following string will be added to print
			if (this.dimes == 1) {
				print += "1 dime\n";
			} else {
				print += this.dimes + " dimes\n";
			}
		}
		if (this.nickels > 0) {				//if there are nickels then the following string will be added to print
			if (this.nickels == 1) {
				print += "1 nickel\n";
			} else {
				print += this.nickels + " nickels\n";
			}
		}
		if (this.pennies > 0) {			//if there are pennies then the following string will be added to print
			if (this.pennies == 1) {
				print += "1 penny\n";
			} else {
				print += this.pennies + " pennies\n";
			}
		}
		return print;			//this returns the ending print string that will show how many of each coin there are 

	}

}
