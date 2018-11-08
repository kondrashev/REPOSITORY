package net.ukr.kondrashev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		FileOutputStream f = null;
		File file = new File("English_in.txt");
		StringBuilder sb = new StringBuilder();
		try (Scanner scNew = new Scanner(file)) {
			for (; scNew.hasNextLine();) {
				sb.append(scNew.nextLine()).append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] keys;
		keys = String.valueOf(sb).split("[\\s+-,.!?:]+");
		Dictionary dict = new Dictionary();
		dict.wordsEnglish();
		System.out.println();
		System.out.println(dict.translate(keys));
		byte[] b = dict.translate(keys).getBytes();
		try {
			f = new FileOutputStream("Ukrainian_out.txt");
			f.write(b);
		} catch (IOException e) {
			System.out.println("I/O Error!!!");
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				System.out.println("Error close file!!!");
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Input new English word!!!");
		String wordEnglish = sc.nextLine();
		if (wordEnglish.length() != 0) {
			System.out.println("Input translate English word!!!");
			String wordUkrainian = sc.nextLine();
			dict = new Dictionary(wordEnglish, wordUkrainian);
			dict.addNewWord();
		}
	}
}
