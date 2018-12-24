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
        FlatImpl fdi = new FlatImpl ( );
        try {
            while (true) {
                System.out.println ("1: Add flat");
                System.out.println ("2: Delete flat");
                System.out.println ("3: Change flat");
                System.out.println ("4: List flats");
                System.out.println ("5: Select list flats by area");
                System.out.println ("6: Select list flats by count rooms");
                System.out.println ("7: Select list flats by price");
                System.out.print ("-> ");
                String s = sc.nextLine ( );
                switch (s) {
                    case "1":
                        fdi.addFlat (sc, em);
                        break;
                    case "2":
                        fdi.deleteFlat (sc, em);
                        break;
                    case "3":
                        fdi.changeFlat (sc, em);
                        break;
                    case "4":
                        fdi.listFlats (em);
                        break;
                    case "5":
                        fdi.selectListFlatsArea (em);
                        break;
                    case "6":
                        fdi.selectListFlatsRooms (em);
                        break;
                    case "7":
                        fdi.selectListFlatsPrice (em);
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


