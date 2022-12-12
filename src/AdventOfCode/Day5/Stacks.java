package AdventOfCode.Day5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Crates {
	List<String> moves;
	List<Stack<Character>> stacks;
	static int NUM_CRATES = 9;
	static int CRATE_HEIGHT_START = 8;

	public Crates() {
		this.moves = new ArrayList<>();
		this.stacks = new ArrayList<>();
		for (int i = 0; i < NUM_CRATES; i++) {
			stacks.add(new Stack<>());
		}
	}

	public void solve(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		List<String> lines = new ArrayList<>();
		String line = br.readLine();

		//Lines - entire input
		while (line != null) {
			lines.add(line);
			line = br.readLine();
		}

		//[N] [C]
		//0123456   -> 1, 5, 9, 13, 17 index of letters

		//Initialize all stacks with letters
		for (int i = CRATE_HEIGHT_START; i >= 0; i--) {
			for (int j = 0; j < lines.get(i).length(); j++) {
				char c = lines.get(i).charAt(j);
				if (Character.isLetter(c)) {
					stacks.get(j / 4).push(c);
				}
			}
		}

		//Moves
		int amountToMove, from, to;

		//Move string line
		for (int i = CRATE_HEIGHT_START + 2; i < lines.size(); i++) {
			String current = lines.get(i);

			if (current.length() == 18) { //move <10 amount of crates
				amountToMove = Integer.parseInt(String.valueOf(current.charAt(5)));
				from = Integer.parseInt(String.valueOf(current.charAt(12)));
				to = Integer.parseInt(String.valueOf(current.charAt(17)));
			} else {
				int larger = Integer.parseInt(String.valueOf(current.charAt(5)));
				int smaller = Integer.parseInt(String.valueOf(current.charAt(6)));
				amountToMove = (larger * 10) + smaller;


				from = Integer.parseInt(String.valueOf(current.charAt(13)));
				to = Integer.parseInt(String.valueOf(current.charAt(18)));
			}


			//PART 1
//			for (int j = 1; j <= amountToMove; j++) {
//				stacks.get(to - 1).push(stacks.get(from - 1).pop());
//			}

			//PART2 - Move in same order
			Stack<Character> tmp = new Stack<>();
			for (int j = 1; j <= amountToMove; j++) {
				tmp.push(stacks.get(from - 1).pop());
			}
			for (int j = 1; j <= amountToMove; j++) {
				stacks.get(to - 1).push(tmp.pop());
			}

		}


		//print top of crates
		stacks.forEach(i -> System.out.print(i.peek()));
	}

}

public class Stacks {

	public static void main(String[] args) {

		File input = new File("D:\\School\\Vtora Godina\\Prv semester\\Algoritmi i Podatocni Strukturi\\Vezhbi\\src\\AdventOfCode\\Day5\\input.txt");
		Crates crate = new Crates();
		try {
			crate.solve(new FileInputStream(input));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
