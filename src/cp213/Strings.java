package cp213;

/**
 * @author Giuseppe Akbari , 169057752
 * @version 2024-09-23
 */
public class Strings {
	// Constants
	public static final String VOWELS = "aeiouAEIOU";

	/**
	 * Determines if string is a "palindrome": a word, verse, or sentence (such as
	 * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
	 * case, spaces, digits, and punctuation in the string parameter s.
	 *
	 * @param string a string
	 * @return true if string is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(final String string) {

		// your code here
		int start = 0;
		int end = string.length() - 1;
		boolean pal = true;

		while (start != end && pal) {

			if (Character.isLetter(string.charAt(start)) && Character.isLetter(string.charAt(end))) {
				char first = Character.toLowerCase(string.charAt(start));
				char second = Character.toLowerCase(string.charAt(end));
				if (first != second) {

					pal = false;

				}

				start++;

				end--;
			} else {
				if (!Character.isLetter(string.charAt(start))) {
					start++;
				}
				if (!Character.isLetter(string.charAt(end))) {
					end--;
				}
			}

		}

		return pal;
	}

	/**
	 * Determines if name is a valid Java variable name. Variables names must start
	 * with a letter or an underscore, but cannot be an underscore alone. The rest
	 * of the variable name may consist of letters, numbers and underscores.
	 *
	 * @param name a string to test as a Java variable name
	 * @return true if name is a valid Java variable name, false otherwise
	 */
	public static boolean isValid(final String name) {

		// your code here
		int i = 0;
		boolean valid = false;
		if (name.charAt(i) == '_') {
			i++;
			if (i < name.length()) {
				if (Character.isLetter(name.charAt(i))) {
					valid = true;
				}
			}
		} else if (Character.isLetter(name.charAt(i))) {
			valid = true;

		}

		return valid;
	}

	/**
	 * Converts a word to Pig Latin. The conversion is:
	 * <ul>
	 * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
	 * <li>if the word begins with consonants, move the leading consonants to the
	 * end of the word and add "ay" to the end of that. "y" is treated as a
	 * consonant if it is the first character in the word, and as a vowel for
	 * anywhere else in the word.</li>
	 * </ul>
	 * Preserve the case of the word - i.e. if the first character of word is
	 * upper-case, then the new first character should also be upper case.
	 *
	 * @param word The string to convert to Pig Latin
	 * @return the Pig Latin version of word
	 */
	public static String pigLatin(String word) {

		// your code here

		String pig = "";
		// System.out.println(VOWELS.indexOf(word.charAt(0)));
		boolean toup = false;
		if (VOWELS.indexOf(word.charAt(0)) != -1) {

			pig += word + "way";

		} else if (Character.isLetter(word.charAt(0))) {
			if (Character.isUpperCase(word.charAt(0))) {
				toup = true;
			}
			char first = word.charAt(1);
			char end = Character.toLowerCase(word.charAt(0));
			String last = word.substring(2);
			if (toup) {
				first = Character.toUpperCase(first);
			}
			pig += first + last + end + "ay";
		}

		return pig;
	}

}
