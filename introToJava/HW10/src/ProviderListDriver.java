/*
Jason Zhang 
jzhan127
600.107
Assignment 10
Task 1
*/

import java.util.Scanner;
public class ProviderListDriver {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String a="a";
		String b=a.substring(1);
		System.out.println(b);
		boolean done=false;  //boolean to keep going with the app
		ProviderList list=new ProviderList();  //initialize the list
		while(done!=true){
			System.out.println("0) Quit\n1) Add new performer\n2) Add new activity supplier\n3) Add new goods vendor\n4) Add new food vendor\n5) Print all the providers\n6) Display providers in groups\n7) Sort all proviers sorted by total sales at previous event (decending)\n8) Remove all non-Performers below a total sales threshold\n9) Record that a food vendor's license to serve has been confirmed\n10) Get performer or activity supplier with largest appearance fee");
			System.out.println("Choice -->");
			int choice=sc.nextInt();
			String trash=sc.nextLine();
			if(choice==0){
				done=true;							//0 allowsthe user to quit the app
				System.out.println("Goodbye!");
			}
			else if(choice==1){									//allows user to enter a performer into the list
				System.out.println("Enter name for performer ->");
				String name=sc.nextLine();
				System.out.println("Enter what type ->");
				String type=sc.nextLine();
				System.out.println("Enter schedule of performance ->");
				String sched=sc.nextLine();
				System.out.println("Enter appearance fee ->");
				double fee=sc.nextDouble();
				Performer toAdd=new Performer(name,type,fee,sched);				//initializing performer
				if(list.add(toAdd)){
					System.out.println("Performer "+name+" successfully added.");		//msg to see if the performer can be added	
					
				}
				else{
					System.out.println("cannot be added");
				}
				
			}
			else if(choice==2){														//allows the user to enter an activity supplier
				System.out.println("Enter name for activity supplier ->");
				String name=sc.nextLine();
				System.out.println("Enter what type ->");
				String type=sc.nextLine();
				System.out.println("Enter appearance fee ->");
				double fee=sc.nextDouble();
				System.out.println("Enter total sales at previous event ->");
				double past=sc.nextDouble();
				ActivitySupplier toAdd=new ActivitySupplier(name,type,fee,past);			//initializes the activity supplier
				if(list.add(toAdd)){
					System.out.println("Activity supplier "+name+" successfully added.");		//confirmation message and check if the item can be added to the list
					
				}
				else{
					System.out.println("cannot be added");
				}
			}
			else if(choice==3){										//allows for the adding of a goods vendor
				System.out.println("Enter name for goods vendor ->");
				String name=sc.nextLine();
				System.out.println("Enter what type ->");
				String type=sc.nextLine();
				System.out.println("Enter total sales at previous event ->");
				double past=sc.nextDouble();
				GoodsVendor toAdd=new GoodsVendor(name,type,past);			//initializes a goods vendor
				if(list.add(toAdd)){
					System.out.println("Goods vender "+name+" successfully added.");		//confirmation message to see if the add was successful or not
					
				}
				else{
					System.out.println("cannot be added");
				}
			}
			else if(choice==4){													//allows for adding of food vendor
				System.out.println("Enter name for food vendor ->");
				String name=sc.nextLine();
				System.out.println("Enter what type ->");
				String type=sc.nextLine();
				System.out.println("Enter total sales at previous event ->");
				double past=sc.nextDouble();
				FoodVendor toAdd=new FoodVendor(name,type,past,false);			//initializes a food vendor 
				if(list.add(toAdd)){
					System.out.println("Food vendor "+name+" successfully added.");		//confirmation message to see if the add was successful or not
					
				}
				else{
					System.out.println("cannot be added");
				}
			}
			else if(choice==5){			
				list.display();		//shows all providers
				
			}
			else if(choice==6){
				list.displayGroups();	//shows all providers sorted ingroups
			}
			else if(choice==7){
				list.sort();					//sorts all the providers by their cost
				System.out.println("Providers sorted");
			}
			else if(choice==8){
				System.out.println("Enter sales threshold ->");			//removes non performers based on a threshold sales value
				int threshold=sc.nextInt();
				int removed=list.remove(threshold);
				System.out.println("Removed "+removed+" Providers.\n");		//shows how many removed

			}
			else if(choice==9){
				list.confirmLicenseToServeFood(sc);			//changes a license to true
			}
			else if(choice==10){
				Provider toPrint=list.getPerfOrActSuplLargestFee();			//tries to find the performance or activity with the largest fee and print it out 
				if(toPrint!=null){
				System.out.println(toPrint.toString());
				}
				else{
					System.out.println("No performers or activity supplier");		//checks to see if there are performers or activity suppliers
				}
				System.out.println();
			}
		}
	}

}
