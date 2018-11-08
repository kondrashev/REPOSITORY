package net.ukr.kondrashev;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Group gr = new Group();
		gr.addStudent(19, "man", "student", "Ivanov", 75);
		gr.addStudent(17, "man", "student", "Petrov", 65);
		gr.addStudent(17, "woman", "student", "Lazareva", 78);
		gr.addStudent(17, "man", "student", "Stepanov", 82);
		gr.addStudent(17, "woman", "student", "Gromova", 95);
		gr.print();

		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("Wich student do you want delete!!!");
		String surname = sc.nextLine();
		gr.delStudent(surname);
		gr.print();

		System.out.println();
		System.out.println("Wich student will you want find!!!");
		surname = sc.nextLine();
		System.out.println(gr.findStudent(surname));
	}
}
