package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Giuseppe Akbari , 169057752
 * @version 2024-09-23
 */
public class SerialNumber {

	/**
	 * Determines if a string contains all digits.
	 *
	 * @param str The string to test.
	 * @return true if str is all digits, false otherwise.
	 */
	public static boolean allDigits(final String str) {

		// your code here
		boolean is_digit = true;
		int i = 0;
		while (is_digit && i < str.length()) {
			if (!Character.isDigit(str.charAt(i))) {
				is_digit = false;
			}
			i++;
		}

		return is_digit;
	}

	/**
	 * Determines if a string is a good serial number. Good serial numbers are of
	 * the form 'SN/nnnn-nnn', where 'n' is a digit.
	 *
	 * @param sn The serial number to test.
	 * @return true if the serial number is valid in form, false otherwise.
	 */
	public static boolean validSn(final String sn) {

		// your code here
		boolean valid = true;
		int i = 0;
		while (valid && i < sn.length()) {
			if (i == 0) {
				if (sn.charAt(i) != 'S') {
					valid = false;
				}
			} else if (i == 1) {
				if (sn.charAt(i) != 'N') {
					valid = false;
				}
			} else if (i == 2) {
				if (sn.charAt(i) != '/') {
					valid = false;
				}
			} else if (i == 3 || i == 4 || i == 5 || i == 6 || i == 8 || i == 9 || i == 10) {
				if (!Character.isDigit(sn.charAt(i))) {
					valid = false;
				}
			} else if (i == 7) {
				if (sn.charAt(i) != '-') {
					valid = false;
				}
			} else {
				valid = false;
			}
			i++;
		}

		return valid;
	}

	/**
	 * Evaluates serial numbers from a file. Writes valid serial numbers to
	 * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
	 * a (possibly valid) serial number.
	 *
	 * @param fileIn  a file already open for reading
	 * @param goodSns a file already open for writing
	 * @param badSns  a file already open for writing
	 */
	public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

		// your code here
		while (fileIn.hasNextLine()) {
			String sn = fileIn.nextLine();
			if (validSn(sn)) {
				System.out.println("write the sn to the good file");
				goodSns.println(sn);
			} else {
				System.out.println("wrtie the sn to the bad file");
				badSns.println(sn);
			}
		}

		return;
	}

}
