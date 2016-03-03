import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SokobanEngineTest {
	private SokobanEngine sokobanEngine;
	private char[][] simplestBoard = new char[][] { 
		"#####".toCharArray(), 
		"#@o.#".toCharArray(),
		"#####".toCharArray() };

	private char[][] simplestBoardWon = new char[][] { 
		"#####".toCharArray(), 
		"# @o#".toCharArray(),
		"#####".toCharArray() };

	private char[][] boardWallInFront = new char[][] { 
		"#####".toCharArray(), 
		"#.o@#".toCharArray(),
		"#####".toCharArray() };

	@Before
	public void testInitialize() {
		sokobanEngine = new SokobanEngine();
	}

	@Test
	public void whenGameStartedInintialBoardIsReturned() {
		// given
		sokobanEngine.start(simplestBoard);
		// when
		char[][] result = sokobanEngine.getBoard();
		// then
		assertBoardEquals(simplestBoard, result);
	}

	private void assertBoardEquals(char[][] simplestBoard, char[][] result) {
		for (int y = 0; y < simplestBoard.length; y++) {
			Assert.assertArrayEquals(simplestBoard[y], result[y]);
		}
	}
	
	@Test
	public void gamerCanMoveBoxRight(){
		//given
		sokobanEngine.start(simplestBoard);
		// when
		sokobanEngine.moveGamerRight();
		char[][] result = sokobanEngine.getBoard();
		// then
		assertBoardEquals(simplestBoardWon, result);
	}
	
	@Test
	public void gameDoesNotUseInitialBoard() {
		//given
		sokobanEngine.start(simplestBoard);
		// when
		char[][] result = sokobanEngine.getBoard();
		//then
		Assert.assertNotSame(simplestBoard, result);
	}
	
	@Test
	public void gameDoesNotRevealItsState() {
		//given
		sokobanEngine.start(simplestBoard);
		// when then
		Assert.assertNotSame(sokobanEngine.getBoard(), sokobanEngine.getBoard());
	}
	
	@Test
	public void gamerCantMoveBoxOnTheWall(){
		//given
		sokobanEngine.start(simplestBoardWon);
		// when
		sokobanEngine.moveGamerRight();
		char[][] result = sokobanEngine.getBoard();
		// then
		assertBoardEquals(simplestBoardWon, result);
	}
	
	@Test
	public void gamerCantMoveTheWallBeforeHim(){
		//given
		sokobanEngine.start(boardWallInFront);
		// when
		sokobanEngine.moveGamerRight();
		char[][] result = sokobanEngine.getBoard();
		// then
		assertBoardEquals(boardWallInFront, result);
	}
}