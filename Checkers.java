package yup;

public class Checkers { 

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Board board = new Board();
		Person human = new Person();
		AI ai = new AI();
		char winner = ' ';
		
		board.print();
		
		while (winner == ' ') {
			board = human.move(board);
			board.print();
			
			winner = board.gameOver();
			if (winner != ' ') {
				winnerSpeach(winner);
				return;
			}
			
			board = ai.move(board);
			board.print();
			
			winner = board.gameOver();
			if (winner != ' ') {
				winnerSpeach(winner);
				return;
			}
		}
		
	}
	
	public static void winnerSpeach(char winner) {
		if (winner == 'T') {
			System.out.println("\n\n ** It is a DRAW ** ");
		} else {
			System.out.println("\n\n ** The winner is " + winner + " **");
		}
	}

}
