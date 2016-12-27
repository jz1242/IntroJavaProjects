/*
Jason Zhang 
jzhan127
600.107
Assignment 10
Task 1
*/
import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Maze {
	private char[][] maze;				//private variables for maze, positions, mushrooms, and moves
	private int rowpos = 0;
	private int colpos = 0;
	private int mushrooms = 0;
	private int moves = 0;

	/**
	 * constructor method that generates a maze and takes input from the txt file
	 * @param inp 2d array
	 * @throws IOException
	 */
	public Maze(String inp) throws IOException {
		Scanner file = new Scanner(new FileReader(inp));			//takes input from the txt file
		char[][] initialmaze;										//creates an initial maze to set later
		int rows = 0;
		int columns = 0;
		int mushrooms = 0;
		for (int i = 0; i < 3; i++) {					//reads in the first three numbers for rows, columns, and mushrooms
			if (i == 0) {
				rows = file.nextInt();
			} else if (i == 1) {
				columns = file.nextInt();
			} else {
				mushrooms = file.nextInt();
			}
		}

		initialmaze = new char[rows][columns];				//creates the 2d array with rows and columns as size

		String mazeholder = "";
		while (file.hasNextLine()) {

			mazeholder += file.nextLine();					//stores the maze in the txt file in a string 

		}

		int k = 0;
		for (int i = 0; i < rows; i++) {								//using the string maze, we set every value in the 2d array using charAt to get individual chars to store

			for (int j = 0; j < columns; j++) {

				if (k < mazeholder.length()) {
					initialmaze[i][j] = mazeholder.charAt(k);
					k++;
				}

			}

		}
		file.close();								//closes scanner file
		maze = initialmaze;		//sets the maze to the inital maze
	}

	/**
	 * sets a new maze 
	 * @param maze 2d array maze
	 */
	public void setMaze(char[][] maze) {			
		this.maze = maze;					//sets the new maze based on the given maze
		findMario();						//finds mario and counts how many mushrooms
		countMushrooms();

	}

	/**
	 * finds the exact location of mario and sets his position at to the rows and columns variables at the top
	 * 
	 * 
	 */
	public void findMario() {
		for (int i = 0; i < maze.length; i++) {							//traverses the entire 2d array until it finds an 'M' character which would be mario 

			for (int j = 0; j < maze[0].length; j++) {

				if (maze[i][j] == 'M') {
					rowpos = i;
					colpos = j;
				}

			}

		}
	}

	/**
	 * moves the character in a direction
	 * @param motion takes the direction character that the user wants to move in
	 * @return the maze at this moment
	 */
	public char[][] move(char motion) {

		if (motion == 'i') {										//checks for the direction 
			if (canMove('i')) {										//checks if direction is valid
				if (maze[rowpos - 1][colpos] == 'S') {
					mushrooms--;								//subtracts a mushroom
				}
				maze[rowpos][colpos] = '.';				//puts a . in previous pos
				maze[rowpos - 1][colpos] = 'M';				//Mario moves in that direction
				mushrooms = 0;								//mushrooms reset
				moves++;
			}
			return maze;
		} else if (motion == 'k') {					//checks direction and if the direction is valid 

			if (canMove('k')) {
				if (maze[rowpos + 1][colpos] == 'S') {
					mushrooms--;							//subtracts mushroom
				}
				maze[rowpos][colpos] = '.';
				maze[rowpos + 1][colpos] = 'M';				//places dot in previous and moves mario

				mushrooms = 0;
				moves++;				
			}

			return maze;
		} else if (motion == 'j') {									//checks direction and validity 
			if (canMove('j')) {
				if (maze[rowpos - 1][colpos] == 'S') {
					mushrooms--;

				}
				maze[rowpos][colpos] = '.';						//moves mario, and places dot
				maze[rowpos][colpos - 1] = 'M';

				mushrooms = 0;
				moves++;

			}
			return maze;
		} else if (motion == 'l') {									//check for direction and validity
			if (canMove('l')) {
				if (maze[rowpos + 1][colpos] == 'S') {	
					mushrooms--;
				}
				maze[rowpos][colpos] = '.';							//moves mario and places dot
				maze[rowpos][colpos + 1] = 'M';

				mushrooms = 0;
				moves++;
			}
			return maze;
		}
		return maze;
	}

	/**
	 * checks if the direction desired is a valid point
	 * @param motion the direction in which the user wants to move
	 * @return boolean whether or not the move can be made
	 */
	public boolean canMove(char motion) {
		if (motion == 'i' && rowpos != 0) {																					//the following code checks each direction i, j, k, l to see if there is a valid spot in the direction desired
			if (maze[rowpos - 1][colpos] == ' ' || maze[rowpos - 1][colpos] == 'S'													//returns true if possible, false otherwise
					|| (maze[rowpos - 1][colpos] == 'X' && mushrooms == 0) || maze[rowpos - 1][colpos] == '.') {

				return true;
			}
		}
		if (motion == 'k' && rowpos != maze.length - 1) {
			if (maze[rowpos + 1][colpos] == ' ' || maze[rowpos + 1][colpos] == 'S'
					|| (maze[rowpos + 1][colpos] == 'X' && mushrooms == 0) || maze[rowpos + 1][colpos] == '.') {
				return true;
			}
		}
		if (motion == 'j' && colpos != 0) {
			if (maze[rowpos][colpos - 1] == ' ' || maze[rowpos][colpos - 1] == 'S'
					|| (maze[rowpos][colpos - 1] == 'X' && mushrooms == 0) || maze[rowpos][colpos - 1] == '.') {
				return true;
			}
		}
		if (motion == 'l' && colpos != maze[0].length - 1) {
			if (maze[rowpos][colpos + 1] == ' ' || maze[rowpos][colpos + 1] == 'S'
					|| (maze[rowpos][colpos + 1] == 'X' && mushrooms == 0) || maze[rowpos][colpos + 1] == '.') {
				return true;
			}
		}
		return false;
	}

	/**
	 * finds the total number of moves
	 * @return the number of moves taken
	 */
	public int movestaken() {

		return moves;									//returns moves

	}

	/**
	 * finds if there is still an X on the map
	 * @return boolean to see if the target is still in the maze
	 */
	public boolean isX() {
		for (int i = 0; i < maze.length; i++) {

			for (int j = 0; j < maze[0].length; j++) {					//traverses entire maze to see if the X is still ther

				if (maze[i][j] == 'X') {
					return true;
				}

			}

		}
		return false;
	}

	/**
	 * counts the number of mushrooms currently in the maze to use for the move method
	 * 
	 */
	public void countMushrooms() {
		for (int i = 0; i < maze.length; i++) {

			for (int j = 0; j < maze[0].length; j++) {							//method traverses maze and counts number of S

				if (maze[i][j] == 'S') {
					mushrooms++;
				}

			}

		}

	}
}
