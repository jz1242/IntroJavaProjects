/*
Jason Zhang 
jzhan127
600.107
Assignment 10
Task 1
*/
public class Provider implements Provides{
	private String name;
	private String provide;
	private double appearance;
	private double past;
	
	/**
	 * Constructor passes variables and sets to the instance variables 
	 * @param name
	 * @param provide
	 * @param appearance
	 * @param past
	 */
	public Provider(String name, String provide, double appearance, double past){
		this.name=name;
		this.provide=provide;								//sets all instance variabls to these parameters
		this.appearance=appearance;
		this.past=past;
	}
	/**
	 * Returns the name of the provider.
	 *
	 * @return the provider name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Returns what type of goods/services are supplied by provider.
	 *
	 * @return the type of goods/services supplied
	 */
	public String getWhat(){
		return provide;			
	}

	/**
	 * Returns the appearance fee charged by the provider.
	 *
	 * @return the appearance fee amount (0.0 if no charge)
	 */
	public double getFee(){
		return appearance;
	}

 	/**
	 * Get the total sales by this provider during previous event.
	 *
	 * @return the total sales from previous event
	 */
	public double getTotalPreviousSales(){
		return past;
	}

	/**
	 * Checks if two providers are equal by checking if their 
     * names are equal (ignoring case).
	 *
	 * @param o
	 *            the object being compared
	 * @return true if the provider names match, false otherwise
	 */
	@Override
	public boolean equals(Object o){
		if(this.getName().equalsIgnoreCase(((Provider) o).getName())){			//compares two objects to see if theyre equal
			return true;
		}
		return false;
		
	}

	/**
	 * Creates a String representation of a provider.
     * Any double values appearing in the representation are formatted to two decimal places. 
     *
	 * @return the String representation of a transactor
	 */
	@Override
	public String toString(){	//toString method for all provider methods
		return String.format(this.getName()+" ["+this.getWhat()+"], "+"fee:$"+String.format("%.2f",this.getFee())+", sales:$"+String.format("%.2f",this.getTotalPreviousSales()));
	}
	@Override
	public int compareTo(Object o){				//compares two objects and their sale values
		Provider holder=(Provider)o;
		if(this.getTotalPreviousSales()>holder.getTotalPreviousSales()){
			return 1;
		}
		else if(this.getTotalPreviousSales()==holder.getTotalPreviousSales()){
			return 0;
		}
		return -1;
	}
}
