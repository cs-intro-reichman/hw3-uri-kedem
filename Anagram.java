/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String first = str1.toLowerCase();
		String second = str2.toLowerCase();
		first = first.replaceAll("[^a-z]", "");
		second = second.replaceAll("[^a-z]", "");
		if (first.length() != second.length()) {
			return false;
		}
		for (int i = 0; i < first.length(); i++) {
			char c = first.charAt(i);
			if (second.indexOf(c) == -1) {
				return false;
			}
		}
		return true;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result = str.toLowerCase();
		result = result.replaceAll("[^a-z]", "");
		return result;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String given = str.toLowerCase();
		String anagram = "";
		given = given.replaceAll("[^a-z]", "");
		int totalLength = given.length() + anagram.length();
		for (int i = 0; i < totalLength; i++) {
			int random = (int) (Math.random() * given.length());
			char c = given.charAt(random);
			anagram += c;
			String stam = c + "";
			given = given.replaceFirst(stam, "");
			totalLength = given.length() + anagram.length();
		}
		return anagram;

	}
}
