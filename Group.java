package net.ukr.kondrashev;

import java.util.ArrayList;

public class Group {

	private ArrayList<Student> group = new ArrayList<>();
	private Student st;

	public void addStudent(int age, String sex, String job, String surname, int rating) {
		group.add(new Student(age, sex, job, surname, rating));
	}

	public void print() {
		for (Student st : group) {
			System.out.println(st);
		}
	}

	public void delStudent(String surname) {
		boolean qvest = false;
		for (int i = 0; i < group.size(); i++) {
			qvest = String.valueOf(group.get(i)).contains(surname);
			if (qvest == true) {
				group.remove(i);
				break;
			}
		}
	}

	public Student findStudent(String surname) {
		boolean qvest = false;
		for (int i = 0; i < group.size(); i++) {
			qvest = String.valueOf(group.get(i)).contains(surname);
			if (qvest == true) {
				st = group.get(i);
				break;
			}
		}
		return st;
	}
}
