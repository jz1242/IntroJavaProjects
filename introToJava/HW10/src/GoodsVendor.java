/*
Jason Zhang 
jzhan127
600.107
Assignment 10
Task 1
*/
public class GoodsVendor extends Provider {
	
	/**
	 * Constructor passes variables to super class
	 * @param name
	 * @param provides
	 * @param past
	 */
	public GoodsVendor(String name, String provides, double past){
		super(name, provides, 0.0, past);			//passes variables to the super class
	}
	/**
	 * overrides tostring method
	 * 
	 * returns a string about the provider
	 */
	public String toString(){
								//creates a custom tostring for this provider
		return super.getName()+" ["+super.getWhat()+"]" +", sales:$"+String.format("%.2f",super.getTotalPreviousSales());
	
	}
		
}
