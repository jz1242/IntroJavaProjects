/* 
600.107, Spring 2016, HW8 Tester.
 
Use with completed Package.java and PackageList.java files.
*/


import java.util.Scanner;

public class PackageListTester {

    public static void main(String[] args) {
    
        Scanner kb = new Scanner(System.in);

        //a particular box truck model can carry up to 1484 lbs of cargo
        PackageList truck = new PackageList(1484);
        String ID;

        //output menu of options and collect user's choice
        printMenu();
        int choice = kb.nextInt(); 

        //react to the user's choice, as long as the choice was not quit
        while (choice != 0) {

            switch(choice) {
            
            case 1: //output entire package list
                System.out.println(truck);  //this implicitly calls PackageList toString()
                System.out.println("Total weight (lbs): " + truck.getTotalWeight());
                break;
                
            case 2: //add a package to the list
                System.out.print("Adding package with which tracking ID: ");
                ID = kb.next();
                System.out.print("Package length (in.): ");
                double length = kb.nextDouble();
                System.out.print("Package width (in.): ");
                double width = kb.nextDouble();
                System.out.print("Package height (in.): ");
                double height = kb.nextDouble();
                System.out.print("Package weight (lbs.): ");
                double weight = kb.nextDouble();
                if (truck.addEntry(ID, length, width, height, weight)) {
                    System.out.println("Add successful.");
                } else {
                    System.out.println("Add failed.");
                }
                break;
                
            case 3: //display info about one specific package
                System.out.print("Search for package with which ID: ");
                ID = kb.next();
                System.out.println(truck.getPackageInfo(ID) + "\n");
                break;
                
            case 4: //remove package from the list based on trackingID
                System.out.print("Remove package with which ID: ");
                ID = kb.next();
                System.out.print("Package with ID " + ID);
                if (truck.removeEntry(ID)) {
                    System.out.println(" was removed.");
                } else {
                    System.out.println(" not found.");
                }                
                break;

            case 5: //display info about all oversize packages in the list
                System.out.println(truck.getOversizePackageList() + "\n");
                break;

            default:
                System.out.println("Invalid choice.\n");
            }
            
            //output menu again, and collect next choice
            printMenu();
            choice = kb.nextInt();

        }

    }

    //helper method to output the menu details
    public static void printMenu() {
        System.out.println("\n\nMENU\n----");
        System.out.println("1: Output entire package list, including total weight");
        System.out.println("2: Add a new package to the list");
        System.out.println("3: Get info about a specific package in the list");
        System.out.println("4: Remove a specific package from the list");
        System.out.println("5: List only the oversize packages in the list");
        System.out.println("0: Quit");
        System.out.print("\nEnter your choice--> ");

    }

}    
