package testingdojo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Example_3 {

	public static List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }));

	@Test
	public void removeFromMiddle() {
		list.remove(2);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 0, 1, 3, 4, 5, 6, 7, 8 });
		Assert.assertEquals(expectedList, list);
	}
	
	@Test
	public void removeFromEnd() {
		list.remove(7);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 0, 1, 3, 4, 5, 6, 7 });
		Assert.assertEquals(expectedList, list);
	}
	
	@Test
	public void removeFromBegining() {
		list.remove(0);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 1, 3, 4, 5, 6, 7 });
		Assert.assertEquals(expectedList, list);
	}
}
