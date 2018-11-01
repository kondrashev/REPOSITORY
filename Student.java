package net.ukr.kondrashev;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private int age;
	private String sex;
	private String job;
	private String surname;
	private int rating;

	public Student(int age, String sex, String job, String surname, int rating) {
		super();
		this.age = age;
		this.sex = sex;
		this.job = job;
		this.surname = surname;
		this.rating = rating;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", sex=" + sex + ", job=" + job + ", surname=" + surname + ", rating=" + rating
				+ "]";
	}

}
