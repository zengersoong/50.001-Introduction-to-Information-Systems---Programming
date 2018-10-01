package piwords;

import java.util.Arrays;

public class TestCase {

	public static void main(String[] args) {
		
		int [] digits = new int[5];
		digits[0] = 3;
		digits[1] = 17;
		digits[2] = 18;
		digits[3] = 16;
		digits[4] = 4;
		char [] alphabet = Main.BASIC_ALPHABET;
		String res = piwords.DigitsToStringConverter.convertDigitsToString(digits, 26, alphabet);
		System.out.println(res);
	}

}
