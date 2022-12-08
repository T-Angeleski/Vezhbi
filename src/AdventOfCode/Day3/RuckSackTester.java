package AdventOfCode.Day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RuckSackTester {
	public static void main(String[] args) {
		File input = new File("D:\\School\\Vtora Godina\\Prv semester\\Algoritmi i Podatocni Strukturi\\Vezhbi\\src\\AdventOfCode\\Day3\\input.txt");

		try {
			int result = calculateSum(new FileInputStream(input));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private static int calculateSum(InputStream in) {
		return 1;
	}
}
