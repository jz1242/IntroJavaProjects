/*
Jason Zhang 
jzhan127
600.107
Assignment 10
Task 1
*/
public class Performer extends Provider{
	private String schedule;
	/**
	 * Constructor passes variables to super class and sets the schedule as a private variable
	 * @param name
	 * @param provides
	 * @param fee
	 * @param sched
	 */
	public Performer(String name, String provides, double fee, String sched){
		super(name, provides, fee, 0.0);			//passes variables to the super class and initializes the variable schedule
		this.schedule=sched;
	}
	/**
	 * method that gives the schedule back
	 * @return the schedule
	 */
	public String getSched(){
		return schedule;					
	}	
	public String toString(){		//overrides tostring and gives custom tostring for this provider
		return String.format(super.getName()+" ["+super.getWhat()+"], "+"fee:$"+String.format("%.2f",super.getFee())+","+this.getSched());
	}
}
