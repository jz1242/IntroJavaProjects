/*
Jason Zhang 
jzhan127
600.107
Assignment 8
Task 1
*/
public class Package extends Object {
	private double height;
	private double length;
	
	public static final int LINEAR_INCHES_LIMIT = 60;
	private String trackingID;
	private double weight;
	private double width;

	/**
	 * creates a new package item with the given data
	 * @param trackingID String identifier for package
	 * @param length the length of the package in inches
	 * @param width the width of the package in inches
	 * @param height the height of the package in inches
	 * @param weight the weight of the package in pounds
	 */
	public Package(String trackingID, double length, double width, double height, double weight) {
		this.trackingID = trackingID;											//sets the variables at the top to the variables passed to the constructor
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}

	/**
	 * gets the tracking ID for this package
	 * @return tracking ID string
	 */
	public String getTrackingID() {
		return this.trackingID;									
	}
	/**
	 * gets the weight of this package
	 * @return weight in pounds
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * Gets the "linear inch" measurement of this package. This is defined as the sum of length, width, and
height of the package, all given in inches.
	 * @return linear inch measurement of the package
	 */
	private double getLinearInches() {
		return this.length + this.width + this.height;			//returns the sum of the length width and height
	}

	/**
	 * Determine if the given package is classified as 
	 *"oversize", mening that its linear inch measurement is greater than the LINEAR_INCHES_LIMIT
	 * @return true if oversize, and false otherwise
	 */
	public boolean isOversize() {
		if (getLinearInches() > this.LINEAR_INCHES_LIMIT) {
			return true;												//checks if a package is greater than the LINEAR_INCHES_LIMIT, in which case it is oversize 
		}
		return false;
	}

	/** 
	 * Return a two-line string representation of this package, in the form matching examples given in the assignment description. Note that the second line is indented by two space, and ,if the package is classified as oversize, ends with the notation OVERSIZE
	 * @return a two-line string description of the package
	 */
	public String toString() {
		String total = "Package tracking ID: " + this.trackingID + "\n length: " + this.length + " width: " + this.width
				+ " height: " + this.height + " weight: " + this.weight;															//returns a string that contains all the measurments of the package 
		if (isOversize()) {
			total += " OVERSIZE";										//adds the oversize if isOversize returns true
			return total;
		}
		return total;
	}

}
