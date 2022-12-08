package AdventOfCode.Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Elf implements Comparable<Elf> {
	int calories;

	public Elf(int calories) {
		this.calories = calories;
	}

	public int getCalories() {
		return calories;
	}

	@Override
	public String toString() {
		return String.format("This elf currently has %d calories", calories);
	}

	@Override
	public int compareTo(Elf o) {
		return Integer.compare(this.calories, o.calories);
	}
}

class Elves {
	List<Elf> elves;

	public Elves() {
		this.elves = new ArrayList<>();
	}

	public void readData(InputStream in) {
		Scanner sc = new Scanner(in);

		int totalCalories = 0;

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (!line.equals("")) {
				totalCalories += Integer.parseInt(line);
			} else {
				elves.add(new Elf(totalCalories));
				totalCalories = 0;
			}

		}

		sc.close();
	}

	public int findMostCalories() {
		return elves.stream().map(Elf::getCalories).max(Comparator.naturalOrder()).orElse(0);
	}

	public int totalCaloriesTopThree() {
		elves.sort(Comparator.reverseOrder());
		int total = 0;
		total += elves.get(0).getCalories();
		total += elves.get(1).getCalories();
		total += elves.get(2).getCalories();
		return total;
	}


	public void printElves(OutputStream os) {
		PrintWriter pw = new PrintWriter(os);

		elves.forEach(pw::println);

		pw.flush();
	}
}

public class HighestCalories {
	public static void main(String[] args) {
		Elves elvesFood = new Elves();
		File input = new File("D:\\School\\Vtora Godina\\Prv semester\\Algoritmi i Podatocni Strukturi\\Vezhbi\\src\\AdventOfCode\\Day1\\input.txt");
		try {
			elvesFood.readData(new FileInputStream(input));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		System.out.println(elvesFood.findMostCalories());
		System.out.println(elvesFood.totalCaloriesTopThree());
	}
}
