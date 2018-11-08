package net.ukr.kondrashev;

public class Student {
	
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

	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", sex=" + sex + ", job=" + job + ", surname=" + surname + ", rating=" + rating
				+ "]";
	}

}
