package net.ukr.kondrashev;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		listPeople();
	}

	public static void listPeople() {
		ArrayList<String> listPeople = new ArrayList<>();

		listPeople.add("Ivanov");
		listPeople.add("Petrov");
		listPeople.add("Sidorov");
		listPeople.add("Pylypenko");
		listPeople.add("Harchenko");
		listPeople.add("Ivanchuk");
		listPeople.add("Gordienko");
		listPeople.add("Kovalchuk");
		listPeople.add("Stepanov");
		listPeople.add("Romanov");

		for (String people : listPeople) {
			System.out.println(people);
		}

		System.out.println();
		System.out.println("New information!!!");
		System.out.println();

		listPeople.remove(0);
		listPeople.remove(0);
		listPeople.remove(listPeople.size() - 1);

		for (String people : listPeople) {
			System.out.println(people);
		}
	}
}
