import java.util.Arrays;

public class SokobanEngine {

	private static final char GAMER = '@';
	private static final char EMPTY = ' ';
	private static final char BOX = 'o';
	private static final char WALL = '#';
	
	private char[][] board;

	private int xGamerPossition = -1;
	private int yGamerPossition = -1;
	
	
	public void start(char[][] board) {
		this.board = copyBoard(board);
		determineGamerPossition();
	}

	public char[][] getBoard() {
		return copyBoard(board);
	}

	private char [][] copyBoard(char [][] board){
		char [][] copy = new char[board.length][];
		
		for (int y = 0; y < board.length; y++){
			copy[y] = Arrays.copyOf(board[y], board[y].length);
		}
		
		return copy;
	}
	
	public void moveGamerRight() {
		
		if (!isMoveValid()){ 
			return;
		}
		
		board[yGamerPossition][xGamerPossition] = EMPTY;
		board[yGamerPossition][xGamerPossition + 1] = GAMER;
		board[yGamerPossition][xGamerPossition + 2] = BOX;
		
		xGamerPossition++;
	}

	private boolean isMoveValid() {
		if (isBoxBlockedByWall())
			return false;
		
		if (isGamerBlockedByWall()) {
			return false;
		}
		return true;
	}

	private boolean isGamerBlockedByWall() {
		return board[yGamerPossition][xGamerPossition + 1] == WALL;
	}

	private boolean isBoxBlockedByWall() {
		return board[yGamerPossition][xGamerPossition + 1] == BOX &&
				board[yGamerPossition][xGamerPossition + 2] == WALL;
	}

	private void determineGamerPossition() {
		for (int y = 0; y < board.length; y++){
			for (int x = 0; x < board[y].length; x++){
				if (board[y][x] == GAMER){
					xGamerPossition = x;
					yGamerPossition = y;
					return;
				}
			}
		}
	}

}