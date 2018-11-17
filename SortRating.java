package net.ukr.kondrashev;

import java.util.Comparator;

public class SortRating implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		if (a.getRating() > b.getRating())
			return -1;
		else if (a.getRating() < b.getRating())
			return 1;
		else
			return 1;
	}
}
