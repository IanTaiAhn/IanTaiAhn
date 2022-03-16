package hangman;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		System.out.println("what");
		Scanner scan = new Scanner(System.in);
		StringBuilder wordLength = new StringBuilder();
		int count = 6;
		int select = 1;
		String word = "default";

		System.out.println("Welcome to Hangman! You have three difficulties!");
		System.out.println("Enter 1 for easy");
		System.out.println("Enter 2 for medium");
		System.out.println("Enter 3 for hard");

		select = scan.nextInt();
		while (select > 3 || select <= 0) {
			System.out.println("Not a valid difficulty!");
			select = scan.nextInt();
		}

		if (select == 1) {
			System.out.println("Easy difficulty chosen, good luck!");
			word = "p e a r";
		}
		if (select == 2) {
			System.out.println("Medium difficulty chosen, good luck!");
			word = "u t o p i a";
		}
		if (select == 3) {
			System.out.println("Hard difficulty chosen, good luck!");
			word = "g y p s i e s";
		}
		System.out.println();

		for (int j = 0; j < word.length() / 2 + 1; j++) {
			wordLength.append('_');
			wordLength.append(' ');
		}
		wordLength.setLength(wordLength.length() - 1);
		StringBuilder sb = new StringBuilder(wordLength.toString());

		System.out.println("Guess a character!");
		System.out.print("Your guess: ");
		char guess = scan.next().charAt(0);
		count--;
		while (count > 0) {
			for (int i = 0; i < word.length(); i++) {
				if (guess == word.charAt(i)) {
					sb.setCharAt(i, word.charAt(i));
					count++;
				}
			}
			if (sb.toString().equals(word)) {
				break;
			}
			System.out.println(sb + "  Tries remaining: " + count);
			System.out.println();
			System.out.print("Your guess: ");
			guess = scan.next().charAt(0);
			count--;
		}
		System.out.println();
		for (int k = 0; k < word.length(); k++) {
			if (guess == word.charAt(k)) {
				sb.setCharAt(k, word.charAt(k));
			}
		}

		if (sb.toString().equals(word)) {
			System.out.println(sb.toString());
			System.out.println("Congrats you won!");

		} else {
			System.out.println("The word was " + word);
			System.out.println("This is your loss");
		}
		scan.close();
	}
}
