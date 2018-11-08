package net.ukr.kondrashev;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input everything sentence in English, and press Enter!!!");
		String sentence = sc.nextLine();
		File file = new File("FileEnglish.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(sentence);
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		try (Scanner scNew = new Scanner(file)) {
			for (; scNew.hasNextLine();) {
				sb.append(scNew.nextLine()).append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Comparator<Letter> cm = new Sort();
		TreeSet<Letter> alphabet = new TreeSet(cm);
		for (char s = 'a'; s <= 'z'; s++) {
			alphabet.add(new Letter(s, 0));
		}
		for (int i = 0; i < sb.length(); i++) {
			for (Letter lt : alphabet) {
				boolean find = String.valueOf(sb.charAt(i)).equalsIgnoreCase(String.valueOf(lt.getLetter()));
				if (find == true) {
					lt.setValue(lt.getValue() + 1);
				}
			}
		}
		TreeSet<Letter> alphabetNew = new TreeSet(cm);
		for (Letter lt : alphabet) {
			if (lt.getValue() != 0) {
				alphabetNew.add(lt);
			}
		}
		for (Letter l : alphabetNew) {
			System.out.println(l);
		}
	}
}
