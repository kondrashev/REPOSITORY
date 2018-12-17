package net.ukr.kondrashev;

import java.sql.SQLException;
import java.util.Scanner;

public interface ClientDAO {
    void initDB() throws SQLException;

    void addClient(Object o) throws SQLException;

    void deleteClient(Scanner sc) throws SQLException;

    void changeClient(Scanner sc) throws SQLException;

    void listClients() throws SQLException;
}
