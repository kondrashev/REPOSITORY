package net.ukr.kondrashev;

import java.util.ArrayDeque;

public class Queue {

	ArrayDeque<String> ad = new ArrayDeque<>();

	public void addPersonInQueue(String surname) {
		ad.addLast(surname);
	}

	public void drink(int amount) {
		String temp;
		for (int i = 0; i < amount; i++) {
			temp = ad.pollFirst();
			ad.addLast(temp);
			ad.addLast(temp);
		}
		System.out.println(ad.toString());
	}
}
