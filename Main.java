package net.ukr.kondrashev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Group gr = new Group();
		gr.addStudent(17, "man", "student", "Petrenko", 60);
		gr.addStudent(18, "woman", "student", "Ivanova", 65);
		gr.addStudent(19, "man", "student", "Zinchenko", 62);
		gr.addStudent(17, "man", "student", "Akimenko", 75);
		gr.addStudent(17, "woman", "student", "Mironova", 82);
		File file = new File("ML81.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ML81.txt"))) {
			oos.writeObject(gr);
		} catch (IOException e) {
			System.out.println("ERROR save group!!!");
		}

		gr = new Group();
		gr.addStudent(19, "man", "student", "Levchenko", 85);
		gr.addStudent(21, "woman", "student", "Doroshenko", 95);
		gr.addStudent(22, "man", "student", "Stepanov", 78);
		gr.addStudent(17, "woman", "student", "Lapteva", 68);
		gr.addStudent(17, "man", "student", "Klimov", 72);
		file = new File("ML82.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ML82.txt"))) {
			oos.writeObject(gr);
		} catch (IOException e) {
			System.out.println("ERROR save group!!!");
		}

		gr = new Group();
		gr.addStudent(17, "man", "student", "Gunko", 75);
		gr.addStudent(18, "woman", "student", "Maksimovich", 92);
		gr.addStudent(17, "man", "student", "Tichenko", 73);
		gr.addStudent(17, "woman", "student", "Taranenko", 67);
		gr.addStudent(17, "man", "student", "Andriichuk", 70);
		file = new File("ML83.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ML83.txt"))) {
			oos.writeObject(gr);
		} catch (IOException e) {
			System.out.println("ERROR save group!!!");
		}

		gr = new Group();
		gr.addStudent(17, "man", "student", "Gendega", 78);
		gr.addStudent(17, "woman", "student", "Duda", 88);
		gr.addStudent(17, "man", "student", "Kot", 73);
		gr.addStudent(18, "woman", "student", "Kravchenko", 45);
		gr.addStudent(17, "man", "student", "Revun", 32);
		file = new File("ML84.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ML84.txt"))) {
			oos.writeObject(gr);
		} catch (IOException e) {
			System.out.println("ERROR save group!!!");
		}

		gr = new Group();
		gr.addStudent(19, "man", "student", "Kasyan", 75);
		gr.addStudent(17, "woman", "student", "Nesterenko", 87);
		gr.addStudent(18, "man", "student", "Pylypenko", 73);
		gr.addStudent(18, "woman", "student", "Samchuk", 55);
		gr.addStudent(17, "man", "student", "Xomenko", 42);
		file = new File("ML85.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ML85.txt"))) {
			oos.writeObject(gr);
		} catch (IOException e) {
			System.out.println("ERROR save group!!!");
		}

		System.out.println("Which group input monitor!!!");
		Scanner sc = new Scanner(System.in);
		String groupNumber = sc.nextLine();
		gr = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(groupNumber + ".txt"))) {
			gr = (Group) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("This's group not found!!!");
			return;
		}
		System.out.println();
		System.out.println("Output current group!!!");
		System.out.println();
		gr.printGroup();
	}
}
