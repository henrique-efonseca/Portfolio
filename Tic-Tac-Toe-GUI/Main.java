	/**
	 * This class represents the Tic Tac Toe GUI game.
	 * 
	 * This class complements the TicTacToeGUI class a
	 * and makes the game work properly.
	 * 
	 * @author Henrique Fonseca
	 */


import javax.swing.SwingUtilities;


public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new TicTacToeGUI();

			}
		});
	}

}