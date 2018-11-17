package net.ukr.kondrashev;

import java.util.Comparator;

public class SortSurname implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		return a.getSurname().compareTo(b.getSurname());
	}
}
