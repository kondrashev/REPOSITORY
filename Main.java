package net.ukr.kondrashev;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ASCII art = new ASCII(21, 25);
		art.ASCII("ASCII.txt");
		Scanner sc = new Scanner(System.in);
		System.out.println("Input everything text!!!");
		String text = sc.nextLine();
		art.print(text);
	}

}
