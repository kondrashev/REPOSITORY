package net.ukr.kondrashev;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try (ServerSocket connectionSocket = new ServerSocket(8080)) {
			for (;;) {
				Socket skt = connectionSocket.accept();
				User ct = new User(skt);
			}
		} catch (IOException e) {
			System.out.println("Error to server Socket Open!!!");
		}
	}
}
