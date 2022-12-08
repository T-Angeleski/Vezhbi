package AdventOfCode.Day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

class TotalPoints {
	int points;

	public TotalPoints() {
		this.points = 0;
	}

	public int getPoints() {
		return points;
	}

	private int calculatePoints(String line) {
		String[] parts = line.split("\\s+");
		String opponent = parts[0];
		String us = parts[1];
		int totalPoints = 0;
		//Opponent: A Rock B Paper C Scissors
		//Us: X Rock Y Paper Z Scissors
		//Points +1 Rock, +2 Paper, +3 Scissors
		// +0 loss, +3 draw, +6 win
		switch (us) {
			case "X" -> totalPoints += 1;
			case "Y" -> totalPoints += 2;
			case "Z" -> totalPoints += 3;
		}

		//Who wins
		if (opponent.equals("A")) { //Rock
			if (us.equals("X")) totalPoints += 3;// tie
			if (us.equals("Y")) totalPoints += 6;
		}
		if (opponent.equals("B")) {
			if (us.equals("Y")) totalPoints += 3;
			if (us.equals("Z")) totalPoints += 6;
		}
		if (opponent.equals("C")) {
			if (us.equals("Z")) totalPoints += 3;
			if (us.equals("X")) totalPoints += 6;
		}

		return totalPoints;
	}

	private int newStrategyPoints(String line) {
		// second is: X Lose Y draw Z win
		String[] parts = line.split("\\s+");
		String opponent = parts[0];
		String strategy = parts[1];
		int totalPoints = 0;

		if (opponent.equals("A")) {
			if (strategy.equals("X")) totalPoints += 3; //+0
			if (strategy.equals("Y")) totalPoints += 3 + 1;
			if (strategy.equals("Z")) totalPoints += 6 + 2;
		}

		if (opponent.equals("B")) {
			if (strategy.equals("X")) totalPoints += 1;
			if (strategy.equals("Y")) totalPoints += 3 + 2;
			if (strategy.equals("Z")) totalPoints += 6 + 3;
		}

		if (opponent.equals("C")) {
			if (strategy.equals("X")) totalPoints += 2;
			if (strategy.equals("Y")) totalPoints += 3 + 3;
			if (strategy.equals("Z")) totalPoints += 6 + 1;
		}
		return totalPoints;
	}

	public void readData(InputStream in) {
		Scanner sc = new Scanner(in);
		int pointsCurrent = 0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			//pointsCurrent += calculatePoints(line);
			pointsCurrent += newStrategyPoints(line);
		}
		this.points = pointsCurrent;
	}
}

public class RockPaperScissors {
	public static void main(String[] args) {
		File input = new File("D:\\School\\Vtora Godina\\Prv semester\\Algoritmi i Podatocni Strukturi\\Vezhbi\\src\\AdventOfCode\\Day2\\input.txt");
		TotalPoints totalPoints = new TotalPoints();

		try {
			totalPoints.readData(new FileInputStream(input));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		System.out.println(totalPoints.getPoints());
	}
}
