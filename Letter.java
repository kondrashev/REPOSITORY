package net.ukr.kondrashev;

public class Letter {

	private char letter;
	private int value;

	public Letter(char letter, int value) {
		super();
		this.letter = letter;
		this.value = value;
	}

	public Letter() {
		super();
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[" + letter + "=" + value + "]";
	}
}
