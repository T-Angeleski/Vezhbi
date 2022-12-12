package AdventOfCode.Day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class SequenceTester {
	public static void main(String[] args) {
		File input = new File("D:\\School\\Vtora Godina\\Prv semester\\Algoritmi i Podatocni Strukturi\\Vezhbi\\src\\AdventOfCode\\Day6\\input.txt");

		try {
			solve(new FileInputStream(input));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private static void solve(InputStream in) {
		Scanner sc = new Scanner(in);
		String line = sc.nextLine();
		sc.close();


		int resultIndex = line.length();
		//Part 1 ( worst solution ever ?)
//		for (int i = 3; i < line.length(); i++) {
//
//			char a = line.charAt(i - 3);
//			char b = line.charAt(i - 2);
//			char c = line.charAt(i - 1);
//			char d = line.charAt(i);
//			if (a != b && a != c && a != d && b != c && b != d && c != d) {
//				resultIndex = i+1;
//				break;
//			}
//
//		}

		for(int i = 14 ; i < line.length() ; i++) {
			Set<Character> currentChars = new HashSet<>();

			for(int j = i - 14 ; j < i ; j++) {
				currentChars.add(line.charAt(j));
			}

			if(currentChars.size() == 14) {
				resultIndex = i;
				break;
			}
		}
		System.out.println(resultIndex);
	}
}
