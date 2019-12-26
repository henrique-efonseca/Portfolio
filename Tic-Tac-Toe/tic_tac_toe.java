/**
 * Static Class that represents the Tic Tac Toe game in a text-based version. 
 * This version is the normally known 2 Player game (1v1).
 * 
 * The rules are simple, alternately each Player enters a Row and a Column, between [1-3], 
 * to choose a House to play (Houses are represented in a [3][3] Matrix).
 * The player who plays in 3 consecutive Houses (vertically, horizontally or perpendicular) wins the game.
 * If very House is filled without this happening it's consider a Tie.
 * This game keeps track of both Player's Name; Game Winner, Overall Winner and Overall Score.
 * Players can play the game multiple times and the player who wins the most games is the Overall Winner.
 * 
 * 
 * @author Henrique Fonseca
 */


import java.util.Scanner;
import java.io.*;

public class tic_tac_toe {

	public static int row, column, score1, score2, score;
	public static Scanner scan = new Scanner(System.in);
	public static char[][] board = new char[3][3];
	public static char turn = 'X';
	public static char playAgain = 'y';
	public static char play = 'y';
	public static String player, player1, player2 = "Player 1";
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
	// Main function for the game.
	public static void main(String[] args) throws IOException {
		// Checks if the players want to play before begin the game by updating the variable 'play'.
		System.out.println("Hello! This is Tic-Tac-Toe, do you want to play? Type 'y' for YES or 'n' for NO.");
		play = scan.next().charAt(0);
		System.out.println();

		// Checks the variable 'playAgain' to begin game.
		if ((play == 'y' || play == 'Y')) {
			// Gets the Player 1 Name.
			System.out.println("Please enter Player 1 name:");
			player1 = br.readLine();
			player = player1;
			System.out.println();

			//Gets the Player 2 Name.
			System.out.println("Please enter Player 2 name:");
			player2 = br.readLine();
			System.out.println();

			// Checks if the names are equal. Player names can't have the same name.
			if (player2.equals(player1) == true) {
				while (player2.equals(player1) == true) {
					System.out.println("Players can't have the same name. Please enter another name for Player 2:");
					player2 = br.readLine();
					System.out.println();
				}
			}

			System.out.println();

			// After the game ends checks if the player wants to play again using the variable 'playAgain'
			while (playAgain == 'y' || playAgain == 'Y') {
				System.out.println("Let's play Tic-Tac-Toe! Good luck!");
				resetBoard();
				Play();
			}
		}

		// After the game ends checks if the players want to play again using the variable 'playAgain'. 
		// Behavior for negative answer.
		if (playAgain == 'n' || playAgain == 'N') {
			score();
			System.out.println();
			System.out.println(winner());
			System.out.println();
			System.out.println("Thank you for playing Tic-Tac-Toe. Goodbye!");

		}

		// Sees if the players want to play before beginning the game using the variable 'play'.
		// Behavior for negative answer.
		if (play == 'n' || play == 'N') {
			System.out.println("All right, maybe another time. Goodbye!");
		}
	}

	
	public static void Play() {
		boolean playing = true;

		System.out.println();
		while (playing) {
			// Asks the player to enter a Row and Column to play.
			System.out.println(player + ", Please enter a Row and Column [1-3]: ");
			row = scan.nextInt() - 1;
			column = scan.nextInt() - 1;
			System.out.println();

			// Behavior if the players enter an invalid Row and/or Column. Row and Column must be between 1-3.
			if (row > 2 || column > 2 || row<0 || column<0) {
				System.out.println();
				while (row > 2 || column > 2 || row<0 || column<0) {

					System.out.println("Invalid Row and/or Column. Please enter a Row and Column between 1-3 .");
					row = scan.nextInt() - 1;
					column = scan.nextInt() - 1;
					System.out.println();
				}

			}

			// Checks if the Row and Column entered are valid (weren't used before).
			if (board[row][column] == 'X' || board[row][column] == 'O') {
				while (board[row][column] == 'X' || board[row][column] == 'O') {
					// Behavior if Player 1 has already played that house.
					if (board[row][column] == 'X') {
						System.out.println(player1 + " has already choosen that House. Please enter another Row and Column [1-3].");
						row = scan.nextInt() - 1;
						column = scan.nextInt() - 1;
						System.out.println();
					}
					// Behavior if Player 1 has already played that house.
					if (board[row][column] == 'O') {
						System.out.println(player2 + " has already choosen that House. Please enter another Row and Column[1-3].");
						row = scan.nextInt() - 1;
						column = scan.nextInt() - 1;
						System.out.println();
					}

				}
			}

			// Prints the board with the Player's choosen house.
			board[row][column] = turn;
			printBoard();

			// Behavior if someone wins the game.
			if (gameOver(row, column) == true && tie(row, column) == false) {
				// Updates Player 1's score if he won the game
				if (player.equals(player1) == true) {
					score1++;
				}
				// Updates Player 1's score if he won the game.
				if (player.equals(player2) == true) {
					score2++;
				}
				// When the game ends updates the variable 'playing'.
				playing = false;

				// Prints the Game Winner and the Score so far.
				System.out.println();
				System.out.println("Game over! " + player + " wins!");
				System.out.println();
				score();
				System.out.println();

				// Asks the players if they want to play again. Updates the variable 'playAgain'.
				System.out.println("Do you want to play again [y/n] ?");
				playAgain = scan.next().charAt(0);
			}

			// Behavior if the game is a tie.
			if (gameOver(row, column) == false && tie(row, column) == true) {
				playing = false;

				// Prints the 'Tie Output String' and the Score so far.
				System.out.println();
				System.out.println("Game over! It's a tie!");
				System.out.println();
				score();
				System.out.println();
				System.out.println("Do you want to play again [y/n] ?");
				playAgain = scan.next().charAt(0);

			}

			System.out.println();

			// Updates the variable 'player' that keeps track of who's player turn is.
			// Updates the variable 'turn' that represents the Player's "marker" (Player 1 --> 'X' | Player 2 --> 'O').
			if (turn == 'X') {
				turn = 'O';
				player = player2;

			} else {
				turn = 'X';
				player = player1;
			}

		}
	}

	
	// Function to print the board.
	public static void printBoard() {
		for (int i = 0; i<3; i++) {
			System.out.println();
			for (int j = 0; j<3; j++) {
				if (j == 0) {
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " | ");
			}
		}
		System.out.println();
	}

	
	// Function to reset the Board after each game.
	public static void resetBoard() {
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				board[i][j] = '_';
			}
		}
		printBoard();
	}

	
	// Function that outputs a String with the Score so far.
	public static void score() {
		System.out.println("SCORE: ");
		System.out.println(player1 + ": " + score1);
		System.out.println(player2 + ": " + score2);
	}

	
	// Function to check if the game has ended (having a winner).
	public static boolean gameOver(int row, int column) {
		// Checks victory in perpendicular.
		if (board[0][column] == board[1][column] && board[0][column] == board[2][column]) {
			return true;
		}
		if (board[row][0] == board[row][1] && board[row][0] == board[row][2]) {
			return true;
		}

		// Checks victory in diagonal.
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_') {
			return true;
		}
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] & board[1][1] != '_') {
			return true;
		}

		return false;
	}

	
	// Function to check if the game is a Tie.
	public static boolean tie(int rowMove, int columnMove) {
		int count = 0;

		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				if (board[i][j] == 'X' || board[i][j] == 'O') {
					count++;
				}
			}
		}

		if (count == 9) {
			return true;
		} else {
			return false;
		}

	}

	
	// Function that returns the overall winner.
	public static String winner() {
		// Behavior if the Player 1 won the most games.
		if (score1 > score2) {
			return (player1 + " is the winner! Congratulations " + player1 + " !");
		}
		// Behavior if both players won the same number of games.
		if (score1 == score2) {
			return ("It's a tie! Both players won the same number of games. Congratulations " + player1 + " & " + player2 + " !");
		}
		// Behavior if the Player 1 won the most games.
		else {
			return (player2 + " is the winner! Congratulations " + player2 + " !");
		}
	}

}

