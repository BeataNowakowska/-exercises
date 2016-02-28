package testingdojo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Example_1 {
	@Test
	public void CreateArray() {
		ArrayList<String> l = new ArrayList<String>();
		Assert.assertEquals(0, l.size());

		l = new ArrayList<String>(10);
		Assert.assertEquals(0, l.size());

		ArrayList<String> l2 = new ArrayList<String>(l);
		Assert.assertEquals(0, l2.size());
	}

	@Test
	public void Test3() {
		String a = "a";
		String b = "b";
		ArrayList<String> l = new ArrayList<String>();
		l.add(a);
		l.add(b);
		ArrayList<String> l2 = new ArrayList<String>(l);

		Assert.assertEquals(a, l2.get(0));
		Assert.assertEquals(b, l2.get(1));
	}

	@Test
	public void FindIndexReturnsFirstOccurrenceOfElementsThatFulfillsDefinedInArgumentConditionWithinGivenRange() {
		// given
		String toFind_ala = "ala";
		String toFind_akaa = "akaa";
		String toFind_aa = "aa";
		String toFind_a = "a";

		String[] array = new String[] { "first", // 0
				"second", // 1
				"", // 2
				toFind_ala, // 3
				toFind_akaa, // 4
				"", // 5
				toFind_a, // 6
				"", // 7
				toFind_aa, // 8
				"dsfdasfdsa98-978798=", // 9
				"dsfdasfdsa98-978798=", // 10
				"dsfdasfdsa98-978798=", // 11
				toFind_aa, // 12
				toFind_a, // 13
				"", // 14
				toFind_akaa, // 15
				"first", // 16
				"second", // 17
				toFind_ala, // 18
				"", // 19
				"dsfdasfdsa98-978798=", // 20
				toFind_akaa, // 21
				toFind_aa, // 22
				toFind_ala, // 23
		};

		ArrayList<String> l = new ArrayList<String>(Arrays.asList(array));

		// when
		l.removeIf(t -> condition(t));

		// then
		Assert.assertEquals(13, l.size());
		Assert.assertFalse(l.contains(toFind_a));
		Assert.assertFalse(l.contains(toFind_aa));
		Assert.assertFalse(l.contains(toFind_akaa));
		Assert.assertFalse(l.contains(toFind_ala));
	}

	private boolean condition(String text) {
		if (text != null) {
			if (text.length() >= 2) {
				if (text.charAt(0) == 'a') {
					if (text.charAt(text.length() - 1) == 'a') {
						return true;
					}
				}
			} else {
				if (text.length() == 1) {
					if (text.charAt(0) == 'a')
						return true;
				}
			}
		}
		return false;

	}
}
