/*
Jason Zhang 
jzhan127
600.107
Assignment 8
Task 2
*/
public class PackageList extends Object {
	private Package[] list;						//list
	private double TOTAL_ALLOWABLE_WEIGHT;			//max weight
	private int numPackages;				//counts number of packages
	private int numCounter;				//counter used to shift array
	public static final int START_SIZE = 5;			//unchangeable size

	/**
	 * Creates a new empty PackageList with capacity START_SIZE, which is 5
	 * @param allowable_weight the weight limit in pounds for this collection of packages
	 */
	public PackageList(double allowable_weight) {
		this.list = new Package[this.START_SIZE];						//set list ot size of 5
		this.TOTAL_ALLOWABLE_WEIGHT = allowable_weight;			//set the limint to allowablweight
		this.numPackages = 0;						//starts numPackages at 0
	}

	/**
	 * return the number of packages present in the list
	 * @return the number of packages in the list 
	 */
	public int getNumPackages() {
		return numPackages;		
	}

	/**
	 * Return the total weight, in pounds, of all packages present in the list
	 * @return the total packages weight in pounds
	 */
	public double getTotalWeight() {
		double total = 0;	
		for (int i = 0; i < this.list.length; i++) {//goes through entire array list and takes the weight of each package and sums them together
			if (list[i] != null)
				total += list[i].getWeight();//summing all weights
		}	
		return total;
	}

	/**
	 * get a string description about a specific package in the list. Package tracking IDs are matched ignoring case. 
	 * @param ID the tracking number for the package
	 * @return the information about the package, if it exists, or otherwise "***package
not found***".
	 */
	public String getPackageInfo(String ID) {
		String info = "";
		for (int i = 0; i < this.list.length; i++) {	//goes through entire array
			if (list[i] != null)						//checks for null object
				if (list[i].getTrackingID().equalsIgnoreCase(ID)) {	
					info += list[i].toString();							//finds the matching ID and gets its data
				}

		}
		if (info.equals("")) {
			return "***package not found***";				//there is no package that matches then this statement returns 
		}
		return info;
	}

	/**
	 * Add a new package to the list, if the new item does not have the same tracking ID as an existing
package (ignoring case), and if the new item won't put the list over its allowable weight. If more space
is needed in the list to make this addition, this method doubles the list's current capacity.
	 * @param trackingID the ID number of package
	 * @param length length of package in inches
	 * @param width width of package in inches
	 * @param height height of package in inches
	 * @param weight weight of package in pounds
	 * @return true if the item was added successfully, or, false if the new item could not
be added to the list
	 */
	public boolean addEntry(String trackingID, double length, double width, double height, double weight) {
		Package addpack = new Package(trackingID, length, width, height, weight);		//creates a package object to add
		for (int i = 0; i < this.list.length; i++) {
			if (list[i] != null) {
				if (list[i].getTrackingID().equalsIgnoreCase(trackingID)) {					//checks the list to see if there is an ID of a similar name in which case we will not be able to add
					return false;
				}
			}
			if (weight + getTotalWeight() > this.TOTAL_ALLOWABLE_WEIGHT) {			//checks if the total weight excceeds the max weight to which we cannot add more
				return false;
			}
			if(length<=0||width<=0||height<=0||weight<=0){		//checks if input is negative or 0
				return false;
			}
		}

		if (numCounter >= list.length - 1) {			//check if the array is at its max
			Package holder[] = new Package[list.length * 2];	//creates a new array of double length 
			for (int j = 0; j < this.list.length; j++) {
				holder[j] = list[j];						//puts all packages in list into the new array

			}
			numPackages++;
			holder[numCounter + 1] = addpack;			//adds the new object and increments the counter and package count
			numCounter++;
			this.list = holder;			//sets the list to the holder list 
			return true;

		}
		numCounter++;				//if the list is long enough, just add the object to the list and increment number of packages 
		numPackages++;
		list[numCounter] = addpack;	
		// numPackages++;
		 //System.out.println(numPackages);
		return true;

	}

	/**
	 * Given a trackingID, remove the entry in the list (if any) that matches. The trackingIDs do not need to
match with respect to case. The resulting list need not store its remaining entries in the same order as
prior to the removal of this package.
	 * @param trackingID unique ID number of package
	 * @return true if package removed, false otherwise
	 */
	public boolean removeEntry(String trackingID) {

		for (int i = 0; i < this.list.length; i++) {					// goes through the list 
			if (list[i] != null)
				if (list[i].getTrackingID().equalsIgnoreCase(trackingID)) {		//checks to see if the ID matches 
					Package holder[] = new Package[list.length];				//new arrary created
					for (int j = 0; j < holder.length; j++) {
						if (j == i) {
							holder[j] = list[j + 1];							//the new array skips over the element we want to remove and adds the rest of the elements to it
							j++;
						} else {
							holder[j] = list[j];
						}

					}
					list = holder;					//list now is set to holder
					numPackages--;				//decrement the number of packages
					// System.out.println(numPackages);
					return true;
				}
		}
		return false;
	}

	/**
	 * Return a String containing all the packages in the package list, on separate lines, with details for each
package presented exactly as indicated by the Package's toString() method. No particular ordering of
the packages is guaranteed. If the package list currently contains no items, the returned String is
"***no entries present***".
	 * @return a string description of the packages currently in list
	 */
	public String toString() {
		String total = "";
		for (int i = 0; i < this.list.length; i++) {			//returns a concatenation of the toString methods of all the packages in the list 
			if (list[i] != null)
				total += (list[i].toString() + "\n");
		}
		if (total.equals("")) {
			return "***no entries present***";			//if there are no packages this displays 
		}
		return total;
	}

	/**
	 * Return a String containing all the oversize packages in the package list, one per line, with details as
given by the Package's toString() method. No particular ordering of the packages is guaranteed. If the
package list currently contains no oversize items, the returned String is "***no oversize entries
present***"
	 * @return the list of packages that are classified as oversize
	 */
	public String getOversizePackageList() {
		String total = "";
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				if (list[i].isOversize()) {			//goes through the entire list and looks for if the isOversize returns true 
					total += list[i] + "\n";			//concatenates the toStrings of the oversize packages
				}
			}
		}
		if (total.equals("")) {
			return "***no oversize entries present***";			//returns if there are no packages that are oversize 
		}
		return total;

	}

}
