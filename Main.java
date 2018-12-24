package net.ukr.kondrashev;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner (System.in);
        emf = Persistence.createEntityManagerFactory ("Instruction");
        em = emf.createEntityManager ( );
        OrderCommodity oc = new OrderCommodity ( );
        try {
            while (true) {
                System.out.println ("1: Add client");
                System.out.println ("2: Add commodity");
                System.out.println ("3: Add order");
                System.out.print ("-> ");
                String s = sc.nextLine ( );
                switch (s) {
                    case "1":
                        oc.addClient (sc, em);
                        break;
                    case "2":
                        oc.addCommodity (sc, em);
                        break;
                    case "3":
                        oc.addOrder (sc, em);
                        break;
                    default:
                        return;
                }
            }
        } finally {
            sc.close ( );
            em.close ( );
            emf.close ( );
        }
    }
}
