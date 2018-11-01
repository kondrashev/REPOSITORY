package net.ukr.kondrashev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		ex.execute(new Unloading(new Ship("\"ANACONDA\"", 5)));
		ex.execute(new Unloading(new Ship("\"PYTHON\"", 5)));
		ex.execute(new Unloading(new Ship("\"DRAGON\"", 5)));
		ex.shutdown();
	}
}
