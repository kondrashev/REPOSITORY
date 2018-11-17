package net.ukr.kondrashev;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Group {
	private String code;
	private ArrayList<Student> al = new ArrayList<>();

	public Group(String code) {
		super();
		this.code = code;
	}

	public void addStudent(Student st) {
		al.add(st);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Student> getGroup() {
		ArrayList<Student> array = al;
		return array;
	}

	public ArrayList<Student> inSoldiers() {
		ArrayList<Student> array = getGroup();
		ArrayList<Student> arrayNew = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getSex().equalsIgnoreCase("man") && array.get(i).getAge() == 18) {
				arrayNew.add(array.get(i));
			}
		}
		return arrayNew;
	}

	public ArrayList<Student> sortGroupToName() {
		ArrayList<Student> array = getGroup();
		Comparator<Student> cm = new SortSurname();
		TreeSet<Student> ts = new TreeSet(cm);
		for (int i = 0; i < array.size(); i++) {
			ts.add(array.get(i));
		}
		int i = 0;
		for (Student student : ts) {
			array.set(i, student);
			i++;
		}
		return array;
	}

	public ArrayList<Student> sortGroupToRating() {
		ArrayList<Student> array = getGroup();
		Comparator<Student> cm = new SortRating();
		TreeSet<Student> ts = new TreeSet(cm);
		for (int i = 0; i < array.size(); i++) {
			ts.add(array.get(i));
		}
		int i = 0;
		for (Student student : ts) {
			array.set(i, student);
			i++;
		}
		return array;
	}
}
