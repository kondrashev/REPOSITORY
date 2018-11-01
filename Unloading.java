package net.ukr.kondrashev;

public class Unloading implements Runnable {
	private Ship ship = new Ship();

	public Unloading(Ship ship) {
		super();
		this.ship = ship;
	}

	@Override
	public void run() {
		ship.unload();
	}
}
