package yup;

import java.util.ArrayList;

public class Board implements Cloneable {
	private Peices pieces[][]; //y, x
	private ArrayList<int[]> listOfO = new ArrayList<int[]>();
	private ArrayList<int[]> listOfY = new ArrayList<int[]>();
	
	public Board() {
		pieces = new Peices[8][8];
		
		pieces[0][1] = new Peices('Y');
		pieces[0][3] = new Peices('Y');
		pieces[0][5] = new Peices('Y');
		pieces[0][7] = new Peices('Y');
		listOfY.add(new int[] {0,1});
		listOfY.add(new int[] {0,3});
		listOfY.add(new int[] {0,5});
		listOfY.add(new int[] {0,7});
		
		pieces[1][0] = new Peices('Y');
		pieces[1][2] = new Peices('Y');
		pieces[1][4] = new Peices('Y');
		pieces[1][6] = new Peices('Y');
		listOfY.add(new int[] {1,0});
		listOfY.add(new int[] {1,2});
		listOfY.add(new int[] {1,4});
		listOfY.add(new int[] {1,6});
		
		pieces[2][1] = new Peices('Y');
		pieces[2][3] = new Peices('Y');
		pieces[2][5] = new Peices('Y');
		pieces[2][7] = new Peices('Y');
		
		listOfY.add(new int[] {2,1});
		listOfY.add(new int[] {2,3});
		listOfY.add(new int[] {2,5});
		listOfY.add(new int[] {2,7});
		
		pieces[0][0] = new Peices("Not used");
		pieces[0][2] = new Peices("Not used");
		pieces[0][4] = new Peices("Not used");
		pieces[0][6] = new Peices("Not used");
		
		pieces[1][1] = new Peices("Not used");
		pieces[1][3] = new Peices("Not used");
		pieces[1][5] = new Peices("Not used");
		pieces[1][7] = new Peices("Not used");
		
		pieces[2][0] = new Peices("Not used");
		pieces[2][2] = new Peices("Not used");
		pieces[2][4] = new Peices("Not used");
		pieces[2][6] = new Peices("Not used");
		
		//now for after x's places
		
		pieces[3][1] = new Peices("Not used");
		pieces[3][3] = new Peices("Not used");
		pieces[3][5] = new Peices("Not used");
		pieces[3][7] = new Peices("Not used");
		
		pieces[4][0] = new Peices("Not used");
		pieces[4][2] = new Peices("Not used");
		pieces[4][4] = new Peices("Not used");
		pieces[4][6] = new Peices("Not used");
		
		//empty's
		
		pieces[3][0] = new Peices("Empty");
		pieces[3][2] = new Peices("Empty");
		pieces[3][4] = new Peices("Empty");
		pieces[3][6] = new Peices("Empty");
		
		pieces[4][1] = new Peices("Empty");
		pieces[4][3] = new Peices("Empty");
		pieces[4][5] = new Peices("Empty");
		pieces[4][7] = new Peices("Empty");
		
		//now for the o's
		pieces[5][1] = new Peices("Not used");
		pieces[5][3] = new Peices("Not used");
		pieces[5][5] = new Peices("Not used");
		pieces[5][7] = new Peices("Not used");
		
		pieces[6][0] = new Peices("Not used");
		pieces[6][2] = new Peices("Not used");
		pieces[6][4] = new Peices("Not used");
		pieces[6][6] = new Peices("Not used");
		
		pieces[7][1] = new Peices("Not used");
		pieces[7][3] = new Peices("Not used");
		pieces[7][5] = new Peices("Not used");
		pieces[7][7] = new Peices("Not used");
		
		pieces[5][0] = new Peices('O');
		pieces[5][2] = new Peices('O');
		pieces[5][4] = new Peices('O');
		pieces[5][6] = new Peices('O');
		listOfO.add(new int[] {5,0});
		listOfO.add(new int[] {5,2});
		listOfO.add(new int[] {5,4});
		listOfO.add(new int[] {5,6});
		
		pieces[6][1] = new Peices('O');
		pieces[6][3] = new Peices('O');
		pieces[6][5] = new Peices('O');
		pieces[6][7] = new Peices('O');
		listOfO.add(new int[] {6,1});
		listOfO.add(new int[] {6,3});
		listOfO.add(new int[] {6,5});
		listOfO.add(new int[] {6,7});
		
		pieces[7][0] = new Peices('O');
		pieces[7][2] = new Peices('O');
		pieces[7][4] = new Peices('O');
		pieces[7][6] = new Peices('O');
		listOfO.add(new int[] {7,0});
		listOfO.add(new int[] {7,2});
		listOfO.add(new int[] {7,4});
		listOfO.add(new int[] {7,6});
	}
	
	public void print() {
		System.out.print("    ");
		for (int a = 1; a <= 8; a ++) {
			System.out.print(a + "   ");
		}
		System.out.print("-> X");
		
		System.out.println("\n   --- --- --- --- --- --- --- ---");
		
		for (int a = 0; a < pieces.length; a++) {
			System.out.print(a+1 + " | ");
			for (int b = 0; b < pieces[0].length; b++) {
				
				char temp = pieces[a][b].print();
				if (temp == 'E' || temp == 'N') {
					temp = ' ';
				}
				
				System.out.print(temp + " | ");
			}
			System.out.println("\n   --- --- --- --- --- --- --- ---");
		}
		System.out.println("|\nV\nY");
	}
	
	public boolean isValid(int startY, int startX, int endY, int endX, char person, boolean startOpt) {
		
		char altPerson = person == 'Y' ? 'Ÿ':'Ö';
		
		if (startOpt) {
			if (startY > 7 || startY < 0 || startX > 7 || startX < 0) {
				return false;
			} else if (pieces[startY][startX].print() != person && pieces[startY][startX].print() != altPerson) {
				return false;
			} 
		}
		
		if (endY > 7 || endY < 0 || endX > 7 || endX < 0) {
			return false;
		}
		
		
		char opp = person == 'Y' ? 'O':'Y';
		
		if (pieces[endY][endX].print() != 'E' && pieces[endY][endX].print() != opp) {
			return false;
		}
		
		if (person == 'Y') {
			if (! pieces[startY][startX].isUpgraded()) {
				if (startY + 1 != endY) {
					return false;
				}
			} else {
				if (startY + 1 != endY && startY - 1 != endY) {
					return false;
				}
			}
		} else {
			if (! pieces[startY][startX].isUpgraded()) {
				if (startY - 1 != endY) {
					return false;
				}
			} else {
				if (startY + 1 != endY && startY - 1 != endY) {
					return false;
				}
			}
		}
		
		//checking for x
		
		if (startX + 1 != endX && startX - 1 != endX) {
			return false;
		}
		
		
		//figure out what the fuck we should do if we are killing.
		
		if (pieces[endY][endX].print() == opp) {
			int dirY = (startY - endY) * -1;
			int dirX = (startX - endX) * -1;
			
			if (endY + dirY > 7 || endY + dirY < 0 || endX + dirX > 7 || endX + dirX < 0) {
				return false;
			} else if (pieces[endY+dirY][endX+dirX].print() != 'E') {
				return false;
			}
		}
		
		//end killing
		
		return true;
	}
	
	public void move(int startY, int startX, int endY, int endX, boolean kill) {
		
		if (kill) {
			int dirY = (startY - endY) * -1;
			int dirX = (startX - endX) * -1;
			
			
			int[] endArray = {endY+dirY, endX+dirX};
			
			if (pieces[startY][startX].print() == 'Y' || pieces[startY][startX].print() == 'Ÿ') {
				int size = listOfY.size();
				
				for (int a = 0; a < size; a++) {
					if (listOfY.get(a)[0] == startY) {
						if (listOfY.get(a)[1] == startX) {
							listOfY.set(a, endArray);
						}
					}
				}
				
				size = listOfO.size();
				
				int remove = 0;
				
				for (int a = 0; a < size; a++) {
					if (listOfO.get(a)[0] == endY) {
						if (listOfO.get(a)[1] == endX) {
							remove = a;
						}
					}
				}
				
				listOfO.remove(remove);
				
			} else {
				int size = listOfO.size();
				
				for (int a = 0; a < size; a++) {
					if (listOfO.get(a)[0] == startY) {
						if (listOfO.get(a)[1] == startX) {
							listOfO.set(a, endArray);
						}
					}
				}
				
				size = listOfY.size();
				
				int remove = 0;
				
				for (int a = 0; a < size; a++) {
					if (listOfY.get(a)[0] == endY) {
						if (listOfY.get(a)[1] == endX) {
							remove = a;
						}
					}
				}
				
				listOfY.remove(remove);
			}
			
			
			
			//update board
			
			pieces[endY+dirY][endX+dirX] = pieces[startY][startX];
			pieces[endY][endX] = new Peices("Empty");
			pieces[startY][startX] = new Peices("Empty");
			
			
			//we could go again if we just run the isValid function through here except we look at every option.
			
			if (isValid(endY+dirY, endX+dirX, endY+dirY+1, endX+dirX+1, pieces[endY+dirY][endX+dirX].print(), false)) {
				if (isKill(endY+dirY+1, endX+dirX+1)) {
					move(endY+dirY, endX+dirX, endY+dirY+1, endX+dirX+1, true);
				}
			} else if (isValid(endY+dirY, endX+dirX, endY+dirY+1, endX+dirX-1, pieces[endY+dirY][endX+dirX].print(), false)) {
				if (isKill(endY+dirY+1, endX+dirX-1)) {
					move(endY+dirY, endX+dirX, endY+dirY+1, endX+dirX-1, true);
				}
			} else if (isValid(endY+dirY, endX+dirX, endY+dirY-1, endX+dirX+1, pieces[endY+dirY][endX+dirX].print(), false)) {
				if (isKill(endY+dirY-1, endX+dirX+1)) {
					move(endY+dirY, endX+dirX, endY+dirY-1, endX+dirX+1, true);
				}
			} else if (isValid(endY+dirY, endX+dirX, endY+dirY-1, endX+dirX-1, pieces[endY+dirY][endX+dirX].print(), false)) {
				if (isKill(endY+dirY-1, endX+dirX-1)) {
					move(endY+dirY, endX+dirX, endY+dirY-1, endX+dirX-1, true);
				}
			}
			
			//did it reach the end
			
			if (pieces[endY+dirY][endX+dirX].print() == 'Y' && endY+dirY == 7) {
				pieces[endY+dirY][endX+dirX].setUpgraded(true);
			} 
			else if (pieces[endY+dirY][endX+dirX].print() == 'O' && endY+dirY == 0){
				pieces[endY+dirY][endX+dirX].setUpgraded(true);
			}
			
		} else {
			
			int[] endArray = {endY, endX};
				
			if (pieces[startY][startX].print() == 'Y' || pieces[startY][startX].print() == 'Ÿ') {
				int size = listOfY.size();
				
				for (int a = 0; a < size; a++) {
					if (listOfY.get(a)[0] == startY) {
						if (listOfY.get(a)[1] == startX) {
							listOfY.set(a, endArray);
						}
					}
				}
			} else {
				int size = listOfO.size();
				
				for (int a = 0; a < size; a++) {
					if (listOfO.get(a)[0] == startY) {
						if (listOfO.get(a)[1] == startX) {
							listOfO.set(a, endArray);
						}
					}
				}
			}
			
			
			
			//updating the board
			
			pieces[endY][endX] = pieces[startY][startX];
			pieces[startY][startX] = new Peices("Empty");
			
			//did it reach the end
			
			if (pieces[endY][endX].print() == 'Y' && endY == 7) {
				pieces[endY][endX].setUpgraded(true);
			} 
			else if (pieces[endY][endX].print() == 'O' && endY == 0){
				pieces[endY][endX].setUpgraded(true);
			}
		}
	}
	
	public void reverse(int endY, int endX, int startY, int startX) {
		
		int[] endArray = {endY, endX};
		
		if (pieces[startY][startX].print() == 'Y' || pieces[startY][startX].print() == 'Ÿ') {
			int size = listOfY.size();
			
			for (int a = 0; a < size; a++) {
				if (listOfY.get(a)[0] == startY) {
					if (listOfY.get(a)[1] == startX) {
						listOfY.set(a, endArray);
					}
				}
			}
		} else {
			int size = listOfO.size();
			
			for (int a = 0; a < size; a++) {
				if (listOfO.get(a)[0] == startY) {
					if (listOfO.get(a)[1] == startX) {
						listOfO.set(a, endArray);
					}
				}
			}
		}
			
		//updating the board
			
		pieces[endY][endX] = pieces[startY][startX];
		pieces[startY][startX] = new Peices("Empty");
		
		
	}
	
	public boolean isKill(int endY, int endX) {
		if (pieces[endY][endX].print() != 'E'|| pieces[endY][endX].print() == 'N') {
			return true;
		}
		return false;
	}
	
	public char gameOver() {
		if (listOfY.size() > 0 && listOfO.size() > 0) {
			return ' ';
		} else if (listOfY.size() > 0 && listOfO.size() == 0) {
			return 'Y';
		} else if (listOfY.size() == 0 && listOfO.size() > 0){
			return 'O';
		} else {
			return 'T';
		}
	}
	
	public int points() {
		
		int counterY = listOfY.size();
		int counterO = listOfO.size();
		
		for (int a = 0; a < listOfY.size(); a++) {
			if (pieces[listOfY.get(a)[0]][listOfY.get(a)[1]].print() == 'Ÿ') {
				counterY++;
			}
		}
		for (int a = 0; a < listOfO.size(); a++) {
			if (pieces[listOfO.get(a)[0]][listOfO.get(a)[1]].print() == 'Ö') {
				counterO++;
			}
		}
		
		return counterY - counterO;
	}
	
	public Peices[][] getPeices() {
		return pieces;
	}
	
	public void setPeices(Peices[][] pieces) {
		this.pieces = pieces;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		//peices
		
		Board newBoard = (Board) super.clone();
		Peices[][] practice = new Peices[8][8];
		
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				practice[a][b] = (Peices) pieces[a][b].clone();
			}
		}
		
		newBoard.setPeices(practice);
		
		//arraylist
		
		
		
		ArrayList<int[]> arrayO = new ArrayList<int[]>(newBoard.getArrayO());
		ArrayList<int[]> arrayONew = new ArrayList<int[]>();
		
		
		for (int a = 0; a < arrayO.size(); a++) {
			int[] newSubsitution = new int[2];
			newSubsitution[0] = arrayO.get(a)[0];
			newSubsitution[1] = arrayO.get(a)[1];
			
			arrayONew.add(newSubsitution);
		}
		
		newBoard.setArrayO(arrayONew);
		
		ArrayList<int[]> arrayY = new ArrayList<int[]>(newBoard.getArrayY());
		ArrayList<int[]> arrayYNew = new ArrayList<int[]>();
		
		for (int a = 0; a < arrayY.size(); a++) {
			int[] newSubsitution = new int[2];
			newSubsitution[0] = arrayY.get(a)[0];
			newSubsitution[1] = arrayY.get(a)[1];
			
			arrayYNew.add(newSubsitution);
		}
		
		newBoard.setArrayY(arrayY);
		
//		System.out.println(setArrayY);
		
		return newBoard;
	}
	
	public ArrayList<int[]> getArrayO() {
		return listOfO;
	}
	
	public ArrayList<int[]> getArrayY() {
		return listOfY;
	}
	
	public void setArrayO(ArrayList<int[]> arrayO) {
		this.listOfO = arrayO;
	}
	
	public void setArrayY(ArrayList<int[]> arrayY) {
		this.listOfY = arrayY;
	}
}





 






















