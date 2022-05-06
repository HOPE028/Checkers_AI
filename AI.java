package yup;
import java.util.ArrayList;

public class AI {
	
	public AI() {
		
	}
	
	public Board move(Board boardOriginal) throws CloneNotSupportedException {
		
		System.out.println("\nTurn: AI (Y)\n");
		
		int startX = -1;
		int startY = -1;
		int endX = -1;
		int endY = -1;
		
		int score;
		int bestScore = -100000;
		boolean kill;
		
		int depth = 4;
		
		
		
		
		Board board = (Board) boardOriginal.clone();
		
		ArrayList<int[]> arrayY = new ArrayList<int[]>(board.getArrayY());
		
		if (arrayY.size() > 11 || arrayY.size() > 4 && arrayY.size() < 7) {
			depth = 2;
		}
		
		if (arrayY.size() > 0 && arrayY.size() <= 4) {
			depth = 0;
		}
		
		int a, b;
		
		for (int i = 0; i < arrayY.size(); i++) {
			a = arrayY.get(i)[0];
			b = arrayY.get(i)[1];
			
			if (board.isValid(a,b,a+1,b+1,'Y', false)) {
				kill = board.isKill(a+1, b+1);
				if (kill) {
					Board newBoard = (Board) board.clone();
					newBoard.move(a,b,a+1,b+1,true);
					score = minimax(newBoard, false, depth, -100000, 100000);
					
				} else {
					board.move(a, b, a+1, b+1, false);
					score = minimax(board, false, depth, -100000, 100000);
					board.reverse(a, b, a+1, b+1);
				}
				if (score > bestScore) {
					bestScore = score;
					startY = a;
					startX = b;
					endY = a+1;
					endX = b+1;
				}
			}
			if (board.isValid(a,b,a+1,b-1,'Y', false)) {
				kill = board.isKill(a+1, b-1);
				if (kill) {
					Board newBoard = (Board) board.clone();
					newBoard.move(a,b,a+1,b-1,true);
					score = minimax(newBoard, false, depth, -100000, 100000);
					
				} else {
					board.move(a, b, a+1, b-1, false);
					score = minimax(board, false, depth, -100000, 100000);
					board.reverse(a, b, a+1, b-1);
				}
				if (score > bestScore) {
					bestScore = score;
					startY = a;
					startX = b;
					endY = a+1;
					endX = b-1;
				}
			}
			if (board.isValid(a,b,a-1,b+1,'Y', false)) {
				kill = board.isKill(a-1, b+1);
				if (kill) {
					Board newBoard = (Board) board.clone();
					newBoard.move(a,b,a-1,b+1,true);
					score = minimax(newBoard, false, depth, -100000, 100000);
					
				} else {
					board.move(a, b, a-1, b+1, false);
					score = minimax(board, false, depth, -100000, 100000);
					board.reverse(a, b, a-1, b+1);
				}
				if (score > bestScore) {
					bestScore = score;
					startY = a;
					startX = b;
					endY = a-1;
					endX = b+1;
				}
			}
			if (board.isValid(a,b,a-1,b-1,'Y', false)) {
				kill = board.isKill(a-1, b-1);
				if (kill) {
					Board newBoard = (Board) board.clone();
					newBoard.move(a,b,a-1,b-1,true);
					score = minimax(newBoard, false, depth, -100000, 100000);
					
				} else {
					board.move(a, b, a-1, b-1, false);
					score = minimax(board, false, depth, -100000, 100000);
					board.reverse(a, b, a-1, b-1);
				}
				if (score > bestScore) {
					bestScore = score;
					startY = a;
					startX = b;
					endY = a-1;
					endX = b-1;
				}
			}
		}
		
		kill = boardOriginal.isKill(endY, endX);
		boardOriginal.move(startY, startX, endY, endX, kill);
		return boardOriginal;
	}
	
	public int minimax(Board board, boolean isMaximising, int depth, int alpha, int beta) throws CloneNotSupportedException{
		char winner = board.gameOver();
		if (winner != ' ') {
			return scores(winner);
		}
		
		if (depth > 12) {
			return board.points();
		}
		
		int score, bestScore, a, b;
		boolean kill;
		
		ArrayList<int[]> arrayY = new ArrayList<int[]>(board.getArrayY());
		ArrayList<int[]> arrayO = new ArrayList<int[]>(board.getArrayO());
		
		if (isMaximising) {
			bestScore = -100000;
			
			for (int i = 0; i < arrayY.size(); i++) {
				a = arrayY.get(i)[0];
				b = arrayY.get(i)[1];
				if (board.isValid(a,b,a+1,b+1,'Y', false)) {
					kill = board.isKill(a+1, b+1);
					if (kill) {
						Board newBoard = (Board) board.clone();
						newBoard.move(a,b,a+1,b+1,true);
						score = minimax(newBoard, false, depth + 1, alpha, beta);
					} else {
						board.move(a, b, a+1, b+1, false);
						score = minimax(board, false, depth + 1, alpha, beta);
						board.reverse(a, b, a+1, b+1);
					}
					if (score > bestScore) {
						bestScore = score;
					}
					if (alpha < score) {
						alpha = score;
					}
					if (beta <= alpha) {
						return 700;
					}
				}
				if (board.isValid(a,b,a+1,b-1,'Y', false)) {
					kill = board.isKill(a+1, b-1);
					if (kill) {
						Board newBoard = (Board) board.clone();
						newBoard.move(a,b,a+1,b-1,true);
						score = minimax(newBoard, false, depth + 1, alpha, beta);
					} else {
						board.move(a, b, a+1, b-1, false);
						score = minimax(board, false, depth + 1, alpha, beta);
						board.reverse(a, b, a+1, b-1);
					}
					if (score > bestScore) {
						bestScore = score;
					}
					if (alpha < score) {
						alpha = score;
					}
					if (beta <= alpha) {
						return 700;
					}
				}
				if (board.isValid(a,b,a-1,b+1,'Y', false)) {
					kill = board.isKill(a-1, b+1);
					if (kill) {
						Board newBoard = (Board) board.clone();
						newBoard.move(a,b,a-1,b+1,true);
						score = minimax(newBoard, false, depth + 1, alpha, beta);
					} else {
						board.move(a, b, a-1, b+1, false);
						score = minimax(board, false, depth + 1, alpha, beta);
						board.reverse(a, b, a-1, b+1);
					}
					if (score > bestScore) {
						bestScore = score;
					}
					if (alpha < score) {
						alpha = score;
					}
					if (beta <= alpha) {
						return 700;
					}
				}
				if (board.isValid(a,b,a-1,b-1,'Y', false)) {
					kill = board.isKill(a-1, b-1);
					if (kill) {
						Board newBoard = (Board) board.clone();
						newBoard.move(a,b,a-1,b-1,true);
						score = minimax(newBoard, false, depth + 1, alpha, beta);
					} else {
						board.move(a, b, a-1, b-1, false);
						score = minimax(board, false, depth + 1, alpha, beta);
						board.reverse(a, b, a-1, b-1);
					}
					if (score > bestScore) {
						bestScore = score;
					}
					if (alpha < score) {
						alpha = score;
					}
					if (beta <= alpha) {
						return 700;
					}
				}
			}
		} else {
			bestScore = 100000;
			
			for (int i = 0; i < arrayO.size(); i++) {
				a = arrayO.get(i)[0];
				b = arrayO.get(i)[1];
				
				if (board.isValid(a,b,a+1,b+1,'O', false)) {
					kill = board.isKill(a+1, b+1);
					if (kill) {
						Board newBoard = (Board) board.clone();
						newBoard.move(a,b,a+1,b+1,true);
						score = minimax(newBoard, true, depth + 1, alpha, beta);
					} else {
						board.move(a, b, a+1, b+1, false);
						score = minimax(board, true, depth + 1, alpha, beta);
						board.reverse(a, b, a+1, b+1);
					}
					if (score < bestScore) {
						bestScore = score;
					}
					if (beta > score) {
						beta = score;
					}
					if (beta <= alpha) {
						return -700;
					}
				}
				if (board.isValid(a,b,a+1,b-1,'O', false)) {
					kill = board.isKill(a+1, b-1);
					if (kill) {
						Board newBoard = (Board) board.clone();
						newBoard.move(a,b,a+1,b-1,true);
						score = minimax(newBoard, true, depth + 1, alpha, beta);
					} else {
						board.move(a, b, a+1, b-1, false);
						score = minimax(board, true, depth + 1, alpha, beta);
						board.reverse(a, b, a+1, b-1);
					}
					if (score < bestScore) {
						bestScore = score;
					}
					if (beta > score) {
						beta = score;
					}
					if (beta <= alpha) {
						return -700;
					}
				}
				if (board.isValid(a,b,a-1,b+1,'O', false)) {
					kill = board.isKill(a-1, b+1);
					if (kill) {
						Board newBoard = (Board) board.clone();
						newBoard.move(a,b,a-1,b+1,true);
						score = minimax(newBoard, true, depth + 1, alpha, beta);
					} else {
						board.move(a, b, a-1, b+1, false);
						score = minimax(board, true, depth + 1, alpha, beta);
						board.reverse(a, b, a-1, b+1);
					}
					if (score < bestScore) {
						bestScore = score;
					}
					if (beta > score) {
						beta = score;
					}
					if (beta <= alpha) {
						return -700;
					}
				}
				if (board.isValid(a,b,a-1,b-1,'O', false)) {
					kill = board.isKill(a-1, b-1);
					if (kill) {
						Board newBoard = (Board) board.clone();
						newBoard.move(a,b,a-1,b-1,true);
						score = minimax(newBoard, true, depth + 1, alpha, beta);
					} else {
						board.move(a, b, a-1, b-1, false);
						score = minimax(board, true, depth + 1, alpha, beta);
						board.reverse(a, b, a-1, b-1);
					}
					if (score < bestScore) {
						bestScore = score;
					}
					if (beta > score) {
						beta = score;
					}
					if (beta <= alpha) {
						return -700;
					}
				}
			}
		}
		
		return bestScore;
	}
	
	public int scores(char winner) {
		int[] scores = {-100, 0, 100};
		
		switch(winner) {
			case 'Y': 
				return scores[2];
			case 'O':
				return scores[0];
			default:
				return scores[1];
		}
	}
}



















