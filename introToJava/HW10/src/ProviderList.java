/*
Jason Zhang 
jzhan127
600.107
Assignment 10
Task 1
*/
import java.util.Scanner;

public class ProviderList implements ProviderCatalog {
	public static final int START_SIZE = 5;
	private Provider[] list;

	/**
	 * constructor that initializes the array.
	 */
	public ProviderList() {

		this.list = new Provider[START_SIZE];	//initalizes array

	}

/**
 * method counter the number of providers
 * @return the integer value of providers
 */
	public int countProviders() {
		int providers = 0;								//counts the number of providers by traversing entire array
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				providers++;

			}
		}
		return providers;

	}
	/**
	 * Adds a new Provider, as long as no other Provider in the catalog has the
	 * same name (ignoring case).
	 *
	 * @param p
	 *            the new Provider to add
	 * @return true if the Provider was added, false otherwise
	 */

	public boolean add(Provider p) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {														//finds if the item is null or not and then sees if there is something else in the array with the same name

				if (list[i].getName().equalsIgnoreCase(p.getName())) {
					return false;
				}
			}
		}
		int numProv = countProviders();									//gets the number of providers
		if (numProv == list.length) {
			Provider[] holder = new Provider[list.length * 2];			//if the list is not long enough, double it
			for (int i = 0; i < list.length; i++) {
				holder[i] = list[i];

			}
			holder[list.length] = p;							//sets the new array as our list
			list = holder;
			return true;
		}
		list[numProv] = p;
		return true;

	}

	/**
	 * Removes all Providers from the list whose total sales in the previous
	 * event is less than the amount of the parameter, and returns the number of
	 * Providers that were removed from the list. This can never cause the
	 * removal of a Performer, since Performers always have zero sales.
	 *
	 * @param minSales
	 *            the minimum threshold for sales in the previous event
	 * @return the number of Providers removed
	 */
	public int remove(double minSales) {
		int removed = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof GoodsVendor || list[i] instanceof FoodVendor
					|| list[i] instanceof ActivitySupplier) {										//checks if the item is not an instance of performer
				if (list[i].getTotalPreviousSales() < minSales) {        //compares the previous sales to the threshold sale and removes based on if it is less
					list[i] = null;
					removed++;										//counts removed items
				}

			}
		}
		Provider[] holder = new Provider[list.length];				
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				holder[i] = list[i];							//create new array with the leftover elements and set it to the list
			}
		}
		return removed;										//returns the number removed
	}

	/**
	 * Sorts the Providers by sales during the previous event (descending
	 * order).
	 */
	public void sort() {
		for (int k = 0; k < (list.length ^ 2); k++) {						//classic bubble sort algorithm that runs through the entire list n^2 with n being number of elements
			for (int i = 0; i < list.length; i++) {
				for (int j = i + 1; j < list.length; j++) {
					if (list[i] == null || list[j] == null) {				//checks for null case
						if (list[i] == null && list[j] != null) {			
							Provider holder = list[i];					
							list[i] = list[j];
							list[j] = holder;
						}

					} else {
						if (list[i].getTotalPreviousSales() < list[j].getTotalPreviousSales()) {//compares the values the sales of both providers and sees which one is the larger of the two
							Provider holder = list[i];
							list[i] = list[j];			//swaps the two providers in the list
							list[j] = holder;

						}
					}

				}

			}
		}
	}

	/**
	 * Outputs to the screen all the Providers in the list.
	 */
	public void display() {										
		if (countProviders() == 0) {								//checks for any providers
			System.out.println("There are no providers");
		} else {													
			for (int i = 0; i < list.length; i++) {								//goes through entire array and calls the toString method of all providers
				if (list[i] != null) {
					System.out.println(list[i].toString());
				}
			}
		}
	}

	/**
	 * Indicates that a given FoodVendor's license to serve is confirmed. The
	 * method first supplies a list of existing food vendors, with indices, then
	 * asks the user for the index of the FoodVendor to confirm. If the user
	 * enters an index which does not represent a FoodVendor, no status is
	 * changed.
	 *
	 * @param kb
	 *            a Scanner which can collect keyboard input, needed because the
	 *            current method will collect user input
	 */
	public void confirmLicenseToServeFood(Scanner kb) {
		boolean foodvend = false;
		for (int i = 0; i < list.length; i++) {							
			if (list[i] instanceof FoodVendor) {						//goes through the entire array and checks for foodvendors
				foodvend = true;
				System.out.println(i + ") " + list[i].toString());		//print all tostring methods of foodvendors
			}
		}
		if (foodvend == false) {
			System.out.println("There are currently no food vendors in the list.");
		} else {
			System.out.println("Enter index");	
			int value = kb.nextInt();	
			if(list[value] instanceof FoodVendor){
			FoodVendor hold = new FoodVendor(list[value].getName(), list[value].getWhat(),
					list[value].getTotalPreviousSales(), true);      //goes to the desired index and changes its license to true
			list[value] = hold;
			}
			else{
				System.out.println("Not a food vendor here");
			}
		}
	}

	/**
	 * Displays the Providers in the list grouped by type (performers, activity
	 * suppliers, (non-food) goods vendors, food vendors).
	 */
	public void displayGroups() {
		boolean countperf = false;
		boolean countact = false;
		boolean countgood = false;
		boolean countfood = false;
		System.out.println("-- Groups --");
		System.out.println("Performers:");											//lists all performers
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof Performer) {														
				System.out.println(list[i].toString());									//uses toString of all performer providers in array
				countperf = true;
			}
		}
		if (countperf == false) {
			System.out.println("There are no providers for this group");			//checks to see if there are any performers
		}
		System.out.println("\nActivity Suppliers:");					//lists all activity suppliers
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof ActivitySupplier) {
				System.out.println(list[i].toString());					//toString method from all activity suppliers
				countact = true;
			}
		}
		if (countact == false) {//checks for this type of provider
			System.out.println("There are no providers for this group");
		}
		System.out.println("\nGoods Vendors:");								//lists all goods vendors
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof GoodsVendor&&!(list[i] instanceof FoodVendor)) {
				System.out.println(list[i].toString());					//uses tostring of goods vendors providers
				countgood = true;
			}
		}
		if (countgood == false) {
			System.out.println("There are no providers for this group");
		}
		System.out.println("\nFood Vendors:");							//lists all food vendors
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof FoodVendor) {
				System.out.println(list[i].toString());							//uses to string for all the food vendors
				countfood = true;
			}
		}
		if (countfood == false) {
			System.out.println("There are no providers for this group");				//checks for this type of provider
		}
		System.out.println();
	}

	/**
	 * Returns the Performer or ActivitySupplier with the greatest appearance
	 * fee. If there is a tie, returns just one such provider. If there are no
	 * Performers or ActivitySuppliers in the list, returns null.
	 *
	 * @return the Performer or ActivitySupplier with the greatest appearance
	 *         fee, or null if no Performers or ActivitySuppliers in list
	 */
	public Provider getPerfOrActSuplLargestFee() {
		boolean hasperfact = false;				//checks if there is performer or activity supplier
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof Performer || list[i] instanceof ActivitySupplier) {
				hasperfact = true;					//sets variable to true 
			}
		}
		if (hasperfact == false) {		//checks for the null case
			return null;
		}
		Provider largest = list[0];								//goes through the entire array to find the largest value
		for (int i = 1; i < list.length; i++) {
			if (list[i].getFee() > largest.getFee()) {
				largest = list[i];
			}
		}
		return largest;						//returns the provider with the largest fee.

	}

}
