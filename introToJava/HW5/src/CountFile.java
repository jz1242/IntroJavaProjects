/*
 Jason Zhang 
 jzhan127
 600.107
 Assignment 5
 Task 1
 */
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;

public class CountFile {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String filename = sc.nextLine();				//takes userinput
		Scanner inFile = new Scanner(new FileReader(filename));		//scans the file and reads it in
		String outfilename = sc.nextLine();							//takes userinput and sets as the outfile
		PrintWriter outFile = new PrintWriter(outfilename);//creates the outfile
		int counter = 1;
		int linenumber = 1;

		String input = "";
		while (linenumber <= 9) {				//its a loop that goes up to 9 times

			if (inFile.hasNextLine()) {					//checks if there is another line from infile

				input = inFile.nextLine();					//takes in the line as a string
				String inputlower = input.toLowerCase();				
				if (inputlower.indexOf("skip") == -1) {					//checks if there is a skip
					//System.out.println(input);
					outFile.println(countLine(counter, input));			//if there is no skip it will write to the outfile

					counter++;
				} else {
					linenumber--;

				}

			} else {
				outFile.println(0);
				// counter++;

			}
			linenumber++;					//keeps track of line numbers incase of skips
		}

		inFile.close();					//closes both functions
		outFile.close();

	}

	public static int countLine(int number, String line) {				//static int function that returns the number of a certain value there is on a line
		int count = 0;
		for (int i = 0; i < line.length(); i++) {								//a for loop that goes the enter string
			if (Character.getNumericValue(line.charAt(i)) == number) {			//compare the numeric values of the string and the target number and increments if there is a match
				count++;
			}

		}
		return count;					//returns the number 
	}

}
