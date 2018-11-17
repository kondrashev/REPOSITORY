package net.ukr.kondrashev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class User implements Runnable {
	private Socket skt;
	private String answer;
	private Thread th;

	private Group gr = new Group("ML-71");

	public User(Socket skt) {
		super();
		this.skt = skt;
		gr.addStudent(new Student("Ivanov", 18, "man", 65));
		gr.addStudent(new Student("Stepanov", 17, "man", 75));
		gr.addStudent(new Student("Kravchenko", 17, "woman", 85));
		gr.addStudent(new Student("Petrenko", 19, "woman", 95));
		gr.addStudent(new Student("Gurevich", 17, "man", 62));
		gr.addStudent(new Student("Akimov", 18, "man", 78));
		gr.addStudent(new Student("Zaharova", 17, "woman", 73));
		gr.addStudent(new Student("Belikov", 17, "man", 55));
		gr.addStudent(new Student("Cravchenko", 18, "man", 62));
		gr.addStudent(new Student("Dronov", 18, "man", 48));
		th = new Thread(this);
		th.start();
	}

	public String listMetods() {
		String result = "";
		result = "<p>List of methods for Group of students " + "\"" + gr.getCode() + "\"" + "</p><br>";
		result += "<li><a href='?metod=1'>Show list of students</a>";
		result += "<li><a href='?metod=2'>Show list soldiers</a>";
		result += "<li><a href='?metod=3'>Show sort by surname</a>";
		result += "<li><a href='?metod=4'>Show sort by rating</a>";
		return result;
	}

	public String listStudents() {
		String result = "";
		result = "<table BORDER=1 CELLPADDING=5 CELLSPACING=1><tr class='tr1'><td>Surname</td><td>Age</td><td>Sex</td><td>Rating</td></tr>";
		ArrayList<Student> array = gr.getGroup();
		for (int i = 0; i < array.size(); i++) {
			result += "<tr>";
			result += "<td>" + array.get(i).getSurname() + "</td>";
			result += "<td>" + array.get(i).getAge() + "</td>";
			result += "<td>" + array.get(i).getSex() + "</td>";
			result += "<td>" + array.get(i).getRating() + "</td>";
			result += "</tr>";
		}
		result += "</table>";
		return result;
	}

	public String listSoldiers() {
		String result = "";
		result = "<table BORDER=1 CELLPADDING=5 CELLSPACING=1><tr class='tr1'><td>Surname</td><td>Age</td><td>Sex</td><td>Rating</td></tr>";
		ArrayList<Student> array = gr.inSoldiers();
		for (int i = 0; i < array.size(); i++) {
			result += "<tr>";
			result += "<td>" + array.get(i).getSurname() + "</td>";
			result += "<td>" + array.get(i).getAge() + "</td>";
			result += "<td>" + array.get(i).getSex() + "</td>";
			result += "<td>" + array.get(i).getRating() + "</td>";
			result += "</tr>";
		}
		result += "</table>";
		return result;
	}

	public String sortSurname() {
		String result = "";
		result = "<table BORDER=1 CELLPADDING=5 CELLSPACING=1><tr class='tr1'><td>Surname</td><td>Age</td><td>Sex</td><td>Rating</td></tr>";
		ArrayList<Student> array = gr.sortGroupToName();
		for (int i = 0; i < array.size(); i++) {
			result += "<tr>";
			result += "<td>" + array.get(i).getSurname() + "</td>";
			result += "<td>" + array.get(i).getAge() + "</td>";
			result += "<td>" + array.get(i).getSex() + "</td>";
			result += "<td>" + array.get(i).getRating() + "</td>";
			result += "</tr>";
		}
		result += "</table>";
		return result;
	}

	public String sortRating() {
		String result = "";
		result = "<table BORDER=1 CELLPADDING=5 CELLSPACING=1><tr class='tr1'><td>Surname</td><td>Age</td><td>Sex</td><td>Rating</td></tr>";
		ArrayList<Student> array = gr.sortGroupToRating();
		for (int i = 0; i < array.size(); i++) {
			result += "<tr>";
			result += "<td>" + array.get(i).getSurname() + "</td>";
			result += "<td>" + array.get(i).getAge() + "</td>";
			result += "<td>" + array.get(i).getSex() + "</td>";
			result += "<td>" + array.get(i).getRating() + "</td>";
			result += "</tr>";
		}
		result += "</table>";
		return result;
	}

	@Override
	public void run() {
		String input = "";
		try (InputStream is = skt.getInputStream();
				OutputStream os = skt.getOutputStream();
				PrintWriter pw = new PrintWriter(os)) {
			String result = "";
			for (int i = 0; i < 15; i++) {
				int j = is.read();
				result += String.valueOf((char) j);
			}
			if (result.indexOf("metod") != -1) {
				input = result.substring(result.indexOf("metod") + 6, result.indexOf("metod") + 7);
			}
			this.answer = "<html><head><title>Students</title><meta charset='utf-8'></head>"
					+ "<body style='background-color: #F8F8FF;font-family: verdana;'>" + " <style>"
					+ " ul {list-style: square outside; color: #8B4789; }" + " a:link {color: #8B4789;}"
					+ " a:visited {color: #8B2252;}" + " a:hover {color: #CD69C9;}" + " a:active  {color: #8B4789;}"
					+ " p {color: #68228B; font-weight:bold; font-size:18px; font-style:italic}"
					+ " .tr1{background-color:#E8E8E8; align:center;  color: #68228B;}" + " </style>";
			this.answer += listMetods();
			if (input.equals("1")) {
				this.answer += listStudents();
			} else if (input.equals("2")) {
				this.answer += listSoldiers();
			} else if (input.equals("3")) {
				this.answer += sortSurname();
			} else if (input.equals("4")) {
				this.answer += sortRating();
			}
			this.answer += "</table></body></html>";
			String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type:text/html\r\n"
					+ "Content-Length: " + "\r\n" + "Connection: close\r\n\r\n";
			pw.print(response + answer);
			pw.flush();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}
