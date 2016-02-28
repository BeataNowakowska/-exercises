import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

class RandomPasswordGenerator {
	public String getRandomPassword(int length, List<Character> alphabet) {
		StringBuilder password = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			password.append(alphabet.get(random.nextInt(alphabet.size())));
		}

		return password.toString();
	}
}

public class Example_6 {
	private RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

	@Test
	public void GetRandomPasswordReturnsEmptyStringForZeroLengthPassword() {
		randomPasswordGenerator.getRandomPassword(0, new ArrayList<Character>());
	}

	@Test
	public void GetRandomPasswordReturnsDifferentLetterEachTime() {
		// given
		List<Character> alpthabet = Arrays.asList(new Character[] { 'a', 'b', 'c' });
		boolean[] result = new boolean[alpthabet.size()];

		// when
		for (int i = 0; i < 100000; i++) {
			result[alpthabet.indexOf(randomPasswordGenerator.getRandomPassword(1, alpthabet).charAt(0))] = true;
		}

		// then
		for (int i = 0; i < result.length; i++) {
			Assert.assertEquals(result[i], "Character " + alpthabet.get(i) + " not present");
		}

	}
}
