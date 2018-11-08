package net.ukr.kondrashev;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.addPersonInQueue("Sheldon");
		queue.addPersonInQueue("Leonard");
		queue.addPersonInQueue("Volovitc");
		queue.addPersonInQueue("Kutrapalli");
		queue.addPersonInQueue("Penny");
		Scanner sc = new Scanner(System.in);
		System.out.println("Input amount glasses of cola-");
		int amount = sc.nextInt();
		System.out.println("Queque");
		queue.drink(amount);
		sc.close();
	}

}
