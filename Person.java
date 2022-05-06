package yup;
import java.util.Scanner;

public class Person {
	
	private int startY;
	private int startX; 
	private int endY; 
	private int endX; 
	private boolean kill; 
	private Scanner in = new Scanner(System.in);
	
	public Person() {
		startY = -1;
		startX = -1;
		endY = -1;
		endX = -1;
		kill = false;
	}
	
	public Board move(Board board) {
		System.out.println("\nTurn: YOURS (O)");
		
		System.out.println("\nEnter: Start Y, Start X, End Y, End X");
		
		boolean correctInput = false;
		
		while (! correctInput) {
			startY = in.nextInt() -1;
			startX = in.nextInt() -1;
			endY = in.nextInt() -1;
			endX = in.nextInt() -1;
			
			if (board.isValid(startY, startX, endY, endX, 'O', true)) {
				correctInput = true;
				kill = board.isKill(endY, endX);
				board.move(startY, startX, endY, endX, kill);
			} else {
				System.out.println("Incorrect, Try again");
			}
		}
		
		return board;
	}
}
