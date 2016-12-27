/*
Jason Zhang 
jzhan127
600.107
Assignment 10
Task 1
*/
public class FoodVendor extends GoodsVendor {
	private boolean canSell;
	/**
	 * Constructor passes variables to super class and sets private variable to value
	 * @param name
	 * @param provides
	 * @param sale
	 * @param canSell
	 */
	public FoodVendor(String name, String provides, double sale, boolean canSell){
		super(name, provides,sale);			//passes variables to super class and initializes canSell 
		this.canSell=canSell;
	}
	/**
	 * method overrides tostring method
	 * returns a string that prints out the data for this provider
	 */
	public String toString(){						//prints a custom toString for this type of provider
		return super.getName()+" ["+super.getWhat()+"]"+", sales:$"+String.format("%.2f",super.getTotalPreviousSales())+", license: "+this.canSell;
	}
}
