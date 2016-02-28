import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SokobanEngineTest {
	private SokobanEngine sokobanEngine;
	private char[][] simplestBoard = new char[][] { 
		"#####".toCharArray(), 
		"#@o.#".toCharArray(),
		"#####".toCharArray() };

	@Before
	public void TestInitialize() {
		sokobanEngine = new SokobanEngine();
	}

	@Test
	public void whenGameStartedInintialBoardIsReturned() {
		// given
		sokobanEngine.start(simplestBoard);
		// when
		char[][] result = sokobanEngine.getBoard();
		// then
		assertBoard(simplestBoard, result);
	}

	private void assertBoard(char[][] simplestBoard, char[][] result) {
		for (int y = 0; y < simplestBoard.length; y++) {
			Assert.assertArrayEquals(simplestBoard[y], result[y]);
		}
	}

}
