package AdventOfCode.Day4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pairs {
	int count;
	List<String> lines;



	public Pairs() {
		this.count = 0;
		this.lines = new ArrayList<>();
	}

	public int getCount() {
		return count;
	}

	public void readInput(InputStream in) {
		Scanner sc = new Scanner(in);

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			lines.add(line);
		}
	}

	private boolean calculatePart1(String line) {
		//2-4,6-8  a-b, c-d
		String[] parts = line.split(",");
		String[] left = parts[0].split("-");
		String[] right = parts[1].split("-");

		int a = Integer.parseInt(left[0]);
		int b = Integer.parseInt(left[1]);
		int c = Integer.parseInt(right[0]);
		int d = Integer.parseInt(right[1]);

		//does first contain second
		// 2 - 8 fully contains 3-7
		if(a <= c && b >= d) return true;
		//second contain first
		return c <= a && d >= b;

	}

	private boolean calculatePart2(String line) {
		//Return all that overlap
		String[] parts = line.split(",");
		String[] left = parts[0].split("-");
		String[] right = parts[1].split("-");

		int a = Integer.parseInt(left[0]);
		int b = Integer.parseInt(left[1]);
		int c = Integer.parseInt(right[0]);
		int d = Integer.parseInt(right[1]);
		//(a,b)   (c,d)

		//(2,5)   (1,4)  -> true
		// (1,3)  (4,6) -> false
		// 4-5 1-2
		return b >= c && a <= d;
	}

	public void increaseCountPart1() {
		this.count = (int) lines.stream().filter(this::calculatePart1).count();
	}

	public void increaseCountPart2() {
		this.count = (int) lines.stream().filter(this::calculatePart2).count();
	}
}

public class PairsTester {
	public static void main(String[] args) {
		File input = new File("D:\\School\\Vtora Godina\\Prv semester\\Algoritmi i Podatocni Strukturi\\Vezhbi\\src\\AdventOfCode\\Day4\\input.txt");

		Pairs pairs = new Pairs();
		try {
			pairs.readInput(new FileInputStream(input));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}


		//pairs.increaseCountPart1();
		pairs.increaseCountPart2();
		System.out.println(pairs.getCount());
	}
}
