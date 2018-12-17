package net.ukr.kondrashev;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static Connection conn;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password SQL: ");
        String DB_PASSWORD = sc.nextLine();
        try {
            try {
                conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                ClientDAOImpl dao = new ClientDAOImpl(conn);
                dao.initDB();

                while (true) {
                    System.out.println("1: Add client");
                    System.out.println("2: Delete client");
                    System.out.println("3: Change client");
                    System.out.println("4: List clients");
                    System.out.print("-> ");

                    String s = sc.nextLine();
                    switch (s) {
                        case "1":
                            System.out.print("Enter client Surname: ");
                            String surname = sc.nextLine();
                            System.out.print("Enter client Age: ");
                            String sAge = sc.nextLine();
                            int age = Integer.parseInt(sAge);
                            dao.addClient(new Client(surname, age));
                            break;
                        case "2":
                            dao.deleteClient(sc);
                            break;
                        case "3":
                            dao.changeClient(sc);
                            break;
                        case "4":
                            dao.listClients();
                            break;
                        default:
                            return;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                sc.close();
                if (conn != null) conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }
    }
}
