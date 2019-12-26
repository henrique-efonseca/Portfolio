	/**
	 * This class represents the Tic Tac Toe GUI game.
	 * 
	 * For the game work properly use the Main class.
	 * This version is the normally known 2 Player game (1v1).
	 * Alternately each Player clicks with the mouse
	 * to choose a House to play (Houses are represented in a [3][3] JButton Matrix).
	 * After the game ends it restarts automatically.
	 *
	 * @author Henrique Fonseca
	 */

	import java.awt.Container;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JOptionPane;

	public class TicTacToeGUI extends JFrame {

		private static final long serialVersionUID = 1L;
		private int count;
		private Container pane;
		private String currentPlayer;
		private JButton[][] board;
		private boolean hasWinner, playing;
		private JMenuBar menuBar;
		private JMenu menu;
		private JMenuItem quit;

		// Class COnstructor
		public TicTacToeGUI() {
			super();
			pane = getContentPane();
			pane.setLayout(new GridLayout(3, 3));
			setTitle("Tic Tac Toe");
			setSize(800, 800);
			setResizable(false);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			currentPlayer = "X";
			board = new JButton[3][3];
			hasWinner = false;
			playing = true;
			initializeBoard();
			initializeMenuBar();
		}

		private void initializeMenuBar() {
			// Creates a Menu Bar
			menuBar = new JMenuBar();

			// Creates a section "File".
			menu = new JMenu("File");

			// Creates the option "Quit" 
			quit = new JMenuItem("Quit");

			// If "Quit" options is selected the game exists
			quit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});

			// Sets the Menu Bar
			setJMenuBar(menuBar);

			// Adds the section "File" to the Menu Bar
			menuBar.add(menu);

			// Adds the option "Quit" to the section "File".
			menu.add(quit);

		}

		// Function to reset the Board after the game ends.
		// Every game player "X" is the first to play.
		private void resetBoard() {
			currentPlayer = "X";
			hasWinner = false;
			playing = true;
			for (int i = 0; i<3; i++) {
				for (int j = 0; j<3; j++) {
					board[i][j].setText("");
				}
			}
		}

		// Function to initialize the Board, check if a move is valid and if the game as ended.
		private void initializeBoard() {
			for (int i = 0; i<3; i++) {
				for (int j = 0; j<3; j++) {
					JButton btn = new JButton();
					btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
					board[i][j] = btn;
					btn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (((JButton) e.getSource()).getText().equals("") && hasWinner == false && playing == true) {
								btn.setText(currentPlayer);
								gameOver();
								togglePlayer();
							}
							if (playing == false) {
								resetBoard();
							}
						}
					});

					pane.add(btn);
				}
			}
		}

		// Function to switch the "maker" ('X' or 'O') depending on each player's turn.
		private void togglePlayer() {
			if (currentPlayer.equals("X")) {
				currentPlayer = "O";
			} else {
				currentPlayer = "X";
			}
		}

		// Function to check if someone has won.
		// After someone win the game a "Message Dialog" appears and shows a message with the winner ('X' or 'O').
		private void gameOver() {
			// Checks win in vertical
			if (board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
				hasWinner = true;
				playing = false;

			} else if (board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
				hasWinner = true;
				playing = false;

			} else if (board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
				hasWinner = true;
				playing = false;

				// Checks win in horizontal
			} else if (board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
				hasWinner = true;
				playing = false;

			} else if (board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
				hasWinner = true;
				playing = false;

			} else if (board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
				hasWinner = true;
				playing = false;

				// Checks win in perpendicular
			} else if (board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
				hasWinner = true;
				playing = false;

				// Shows a message if the game is considered a Tie.
			} else if (tie() == true) {
				JOptionPane.showMessageDialog(null, "It's a Tie!");
				hasWinner = true;
				playing = false;
			}
		}

		// Function to check if the game is a Tie.
		private boolean tie() {
			count = 0;
			for (int i = 0; i<3; i++) {
				for (int j = 0; j<3; j++) {
					if (hasWinner == false && (board[i][j].getText().equals("X") || board[i][j].getText().equals("O"))) {
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

		
	}
