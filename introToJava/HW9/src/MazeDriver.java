/*
Jason Zhang 
jzhan127
600.107
Assignment 9
Task 1
*/
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;

public class MazeDriver {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the filename with the maze->");				//prompts user for file name
		String filename = sc.nextLine();

		Maze play = new Maze(filename);					//creates new maze with a call to the constructor with the file name
		char tempmaze[][] = play.move(' ');			
		printMaze(tempmaze);						//prints the maze before the first move
		boolean finishgame = false;	
		while (finishgame == false) {					//checks if the boolean is false to keep playing
			play.setMaze(tempmaze);									//sets the new maze to what tempmaze is now
			System.out.println("Enter i to move up");
			System.out.println("Enter j to move left");
			System.out.println("Enter k to move down");
			System.out.println("Enter l to move right");

			String a = sc.nextLine().toLowerCase();
			if (a.equals("k") || a.equals("K") || a.equals("J") || a.equals("j") || a.equals("i") || a.equals("I")
					|| a.equals("l") || a.equals("L")) {						//checks for invalid characters
				System.out.println("Choice-> " + a);
				if (!play.canMove(a.charAt(0))) {				//tells user that move is invalid
					System.out.println("Invalid move");
				}
				printMaze(play.move(a.charAt(0)));					//prints out the current maze after the move

				if (!play.isX()) {						//checks if there is still an X on the map
					finishgame = true;			//sets boolean to true and ends game
				}
			} else {
				System.out.println("invalid command");				//if command invalid, reprint maze and keep playing
				printMaze(play.move(' '));
			}

		}
		System.out.println("You Won in " + play.movestaken() + " moves!!");			//final game stats
	}

	/**
	 * prints out the maze that it is given
	 * @param maze 2D array maze
	 */
	public static void printMaze(char maze[][]) {
		for (int i = 0; i < maze.length; i++) {

			for (int j = 0; j < maze[0].length; j++) {				//traverses entire 2d array and prints out every character in the array 

				System.out.print(maze[i][j]);

			}
			System.out.println();

		}
	}

}
