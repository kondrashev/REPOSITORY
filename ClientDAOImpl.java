package net.ukr.kondrashev;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Scanner;

public class ClientDAOImpl implements ClientDAO {
    private final Connection conn;

    public ClientDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void initDB() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE IF EXISTS Clients");
            st.execute("CREATE TABLE Clients (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Surname VARCHAR(20) NOT NULL, Age INT)");
        } finally {
            st.close();
        }
    }

    @Override
    public void addClient(Object o) throws SQLException {
        try {
            Field[] fields = o.getClass().getDeclaredFields();
            StringBuilder names = new StringBuilder();
            StringBuilder values = new StringBuilder();
            for (Field f : fields) {
                f.setAccessible(true);
                names.append(f.getName()).append(',');
                values.append('"').append(f.get(o)).append("\",");
            }
            names.deleteCharAt(names.length() - 1);
            values.deleteCharAt(values.length() - 1);
            String sql = "INSERT INTO Clients" + "(" + names.toString() +
                    ") VALUES(" + values.toString() + ")";
            try (Statement st = conn.createStatement()) {
                st.execute(sql.toString());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleteClient(Scanner sc) throws SQLException {
        System.out.print("Enter client Surname: ");
        String Surname = sc.nextLine();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM Clients WHERE Surname = ?");
        try {
            ps.setString(1, Surname);
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

    @Override
    public void changeClient(Scanner sc) throws SQLException {
        System.out.println("Enter client Surname: ");
        String Surname = sc.nextLine();
        System.out.println("Enter client new Surname: ");
        String newSurname = sc.nextLine();
        System.out.println("Enter client new Age: ");
        String sAge = sc.nextLine();
        int Age = Integer.parseInt(sAge);
        PreparedStatement ps = conn.prepareStatement("UPDATE Clients SET Surname=?, Age = ? WHERE Surname = ?");
        try {
            ps.setString(1, newSurname);
            ps.setInt(2, Age);
            ps.setString(3, Surname);
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

    @Override
    public void listClients() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients");
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();
                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
    }
}
