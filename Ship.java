package net.ukr.kondrashev;

public class Ship {
	private String name;
	private double time;

	public Ship(String name, double time) {
		super();
		this.name = name;
		this.time = time;
	}

	public Ship() {
		super();
	}

	public void unload() {
		for (double i = time; i >= 0; i -= 0.5) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (i == 5) {
				System.out.println("Ship-" + name + " unloading start!!!");
			} else if (i == 0) {
				System.out.println("Ship-" + name + " unloading finish!!!");
			} else {
				System.out.println("Ship-" + name + " time " + i);
			}
		}

	}
}
