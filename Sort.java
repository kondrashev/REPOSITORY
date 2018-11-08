package net.ukr.kondrashev;

import java.util.Comparator;

public class Sort implements Comparator<Letter> {
	@Override
	public int compare(Letter a, Letter b) {
		if (a.getValue() > b.getValue())
			return -1;
		else if (a.getValue() < b.getValue())
			return 1;
		else
			return 1;
	}
}
