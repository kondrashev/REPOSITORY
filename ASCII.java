package net.ukr.kondrashev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ASCII {
	private Map<Character, Character[][]> hm = new HashMap();
	private int hight;
	private int wight;

	public ASCII(int hight, int wight) {
		super();
		this.hight = hight;
		this.wight = wight;
	}

	public ASCII() {
		super();
	}

	public void ASCII(String fileName) {
		try (BufferedReader readerOne = new BufferedReader(new FileReader(fileName))) {
			for (char l = 'A'; l <= 'Z'; l++) {
				Character[][] chr = new Character[hight][wight];
				for (int i = 0; i < hight; i++) {
					char[] array = readerOne.readLine().toCharArray();
					for (int j = 0; j < wight; j++) {
						chr[i][j] = array[j];
					}
				}
				hm.put(l, chr);
			}
		} catch (IOException e) {
			System.out.print("Error setAsciiMap " + e);
		}
	}

	public void print(String txt) {
		char[] txtArray = txt.toUpperCase().toCharArray();
		for (int i = 0; i < hight; i++) {
			System.out.println();
			for (char chr : txtArray) {
				if (chr != ' ') {
					for (int j = 0; j < wight; j++) {
						if (hm.containsKey(chr)) {
							System.out.print(hm.get(chr)[i][j]);
						}
					}
				} else
					System.out.print("                    ");
			}
		}
	}
}
