package net.ukr.kondrashev;

public class Student {
	private String surname;
	private int age;
	private String sex;
	private int rating;
	
	public Student(String surname, int age, String sex, int rating) {
		super();
		this.surname = surname;
		this.age = age;
		this.sex = sex;
		this.rating = rating;
	}

	public Student() {
		super();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Student [surname=" + surname + ", age=" + age + ", sex=" + sex + ", rating=" + rating + "]";
	}

}
