//This program is the START of a tester file for the PiggyBank class.
//Your correct PiggyBank code should compile with this file as-is.

public class PiggyBankTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
    
        PiggyBank b = new PiggyBank();
        
        System.out.println("Total: " + b.getTotal() + " cents");
        System.out.println(b.toString());  //this explicitly calls b.toString()
        System.out.println();
    
        b.insertQuarters(-1);
        b.insertDimes(-1);
        b.insertNickels(-1);
        b.insertPennies(34);

        System.out.println("Total: " + b.getTotal() + " cents");
        System.out.println(b);  //this implicitly calls b.toString()
        System.out.println();

        if (b.withdrawAmount(380)) {
            System.out.println("Withdrawing $3.80...");
            System.out.println("Total: " + b.getTotal() + " cents");
        } else {
            System.out.println("Unable to withdraw $3.80 due to insufficient funds.");
        }


        
        if (b.withdrawAmount(199)) {
            System.out.println("Withdrawing $1.99...");        
            System.out.println("Total: " + b.getTotal() + " cents");
        } else {
            System.out.println("Unable to withdraw $1.99 due to insufficient funds.");
        }
        System.out.println(b);
        System.out.println();

        System.out.println("Creating a second bank...");
        PiggyBank otherBank = new PiggyBank(-1,-1,9,30);
        System.out.println("Total: " + otherBank.getTotal() + " cents");
        System.out.println(otherBank);  //this implicitly calls otherBank.toString()
        System.out.println();

        if (b.equals(otherBank)) {
            System.out.println("The banks are considered equal!");
        } else {
            System.out.println("The banks are NOT considered equal.");
        }
        
        int result = b.compareTo(otherBank);
        if (result < 0) {
            System.out.println("b has less money than otherBank.");        
        } else if (result > 0) {
            System.out.println("b has more money than otherBank.");
        } else {
            System.out.println("The amounts in b and otherBank are the same.");
        }
        
        System.out.println();
        System.out.println("Removed " + otherBank.removeQuarters(3) + " quarters from otherBank.");
        System.out.println("Removed " + otherBank.removeNickels(2) + " nickels from otherBank.");
        otherBank.insertDimes(1);
        System.out.println("Inserted one dime into otherBank.");

        if (b.equals(otherBank)) {
            System.out.println("NOW the banks are considered equal!");
        } else {
            System.out.println("NOW the banks are NOT considered equal.");
        }
 
        System.out.println("Trying to remove 15 nickels, but got " + 
            otherBank.removeNickels(15) + " nickels out of otherBank.");

        System.out.println("Now contents of otherBank are...");
        System.out.println("Total: " + otherBank.getTotal() + " cents");
        System.out.println(otherBank);  //this implicitly calls otherBank.toString()
        System.out.println();


    }
}