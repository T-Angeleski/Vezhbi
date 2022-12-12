package AdventOfCode.Day3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RuckSackTester {
	public static void main(String[] args) {
		File input = new File("D:\\School\\Vtora Godina\\Prv semester\\Algoritmi i Podatocni Strukturi\\Vezhbi\\src\\AdventOfCode\\Day3\\input.txt");
		try {
			solve(new FileInputStream(input));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void solve(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		List<String> lines = new ArrayList<>();
		String line = br.readLine();
		while (line != null) {
			lines.add(line);
			line = br.readLine();
			;
		}

		int resultSum = 0;
		//PART 1
		//Divide each line in half, and find matching character in both
//		for (String current : lines) {
//			String former = current.substring(0, current.length() / 2);
//			String latter = current.substring(current.length() / 2);
//
//			//loop through both till matching is found
//			char matching = findMatching(former, latter);
//
//			resultSum += convertToPriority(matching);
//		}

		//PART 2
		//Get lines 3 by 3 , find matching in all 3
		for (int i = 0; i < lines.size(); i += 3) {

			String first = lines.get(i);
			String second = lines.get(i + 1);
			String third = lines.get(i + 2);

			resultSum += convertToPriority(findMatchingPart2(first, second, third));
		}
		System.out.println(resultSum);
	}

	private static char findMatching(String former, String latter) {
		for (int i = 0; i < former.length(); i++)
			for (int j = 0; j < latter.length(); j++)
				if (former.charAt(i) == latter.charAt(j))
					return former.charAt(i);
		return ' ';
	}

	private static char findMatchingPart2(String first, String second, String third) {
		for (char a : first.toCharArray())
			for (char b : second.toCharArray())
				for (char c : third.toCharArray())
					if (a == b && a == c) return a;
		return ' ';
	}

	private static int convertToPriority(char c) {
		if (Character.isLowerCase(c)) return c - 'a' + 1;
		else return c - 'a' + 59;
	}
}

