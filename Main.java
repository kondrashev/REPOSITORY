package net.ukr.kondrashev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
		File file = new File("ListURL.txt");
		String buffer = "";
		try (BufferedReader input = new BufferedReader(new FileReader(file))) {
			for (; buffer != null;) {
				buffer = input.readLine();
				URL link = new URL(buffer);
				HttpURLConnection http = (HttpURLConnection) link.openConnection();
				System.out.println(buffer + " - " + http.getResponseMessage());
			}
		} catch (UnknownHostException e) {
			System.out.println(buffer + " - not available");
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

}
