import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Example_3 {

	public static List<Integer> list = Arrays.asList(new Integer[] { 0, 1, 2, 3, 0, 4, 5, 0, 1, 2, 3 });

	@Test
	public void removeSpecificFromMiddle() {
		list.remove(2);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 0, 1, 3, 0, 4, 5, 0, 1, 2, 3 });
		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void removeAtIndexFromMiddle() {
		list.remove(2);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 0, 1, 0, 4, 5, 0, 1, 2, 3 });
		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void removeSpecificFromBegin() {
		list.remove(1);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 4, 5, 1, 2, 3 });
		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void removeSpecificFromEnd() {
		list.remove(3);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 4, 5, 1, 2 });
		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void removeAtIndexFromBegin() {
		list.remove(0);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 5, 1, 2 });
		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void removeAtIndexFromEnd() {
		list.remove(2);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 5, 1 });
		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void removeSpecificEmpty() {
		list.remove(3);
		List<Integer> expectedList = new ArrayList<Integer>();
		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void removeAtIndexFromEmpty() {
		list.remove(0);
		List<Integer> expectedList = new ArrayList<Integer>();
		Assert.assertEquals(expectedList, list);
	}

}
