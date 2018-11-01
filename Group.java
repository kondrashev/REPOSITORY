package net.ukr.kondrashev;

import java.io.Serializable;

public class Group implements Serializable {
	private Student[] group = new Student[0];
	private static final long serialVersionUID = 1L;

	public void addStudent(int age, String sex, String job, String surname, int rating) {
		Student[] s = new Student[group.length + 1];
		System.arraycopy(group, 0, s, 0, group.length);
		s[s.length - 1] = new Student(age, sex, job, surname, rating);
		group = s;
	}

	public void printGroup() {
		for (Student s : group) {
			System.out.println(s);
		}
	}
}
