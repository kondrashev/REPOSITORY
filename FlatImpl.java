package net.ukr.kondrashev;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class FlatImpl {

    public void addFlat(Scanner sc, EntityManager em) throws SQLException {
        System.out.print ("Enter district flat: ");
        String district = sc.nextLine ( );
        System.out.print ("Enter address flat: ");
        String address = sc.nextLine ( );
        System.out.print ("Enter area flat: ");
        String sArea = sc.nextLine ( );
        int area = Integer.parseInt (sArea);
        System.out.print ("Enter count rooms flat: ");
        String sCountRooms = sc.nextLine ( );
        int countRooms = Integer.parseInt (sCountRooms);
        System.out.print ("Enter price flat: ");
        String sPrice = sc.nextLine ( );
        int price = Integer.parseInt (sPrice);
        em.getTransaction ( ).begin ( );
        try {
            Flat fl = new Flat (district, address, area, countRooms, price);
            em.persist (fl);
            em.getTransaction ( ).commit ( );
        } catch (Exception ex) {
            em.getTransaction ( ).rollback ( );
        }
    }

    public void deleteFlat(Scanner sc, EntityManager em) throws SQLException {
        System.out.print ("Enter flat id: ");
        String sId = sc.nextLine ( );
        long id = Long.parseLong (sId);
        Flat fl = em.find (Flat.class, id);
        if (fl == null) {
            System.out.println ("Flat not found!");
            return;
        }
        em.getTransaction ( ).begin ( );
        try {
            em.remove (fl);
            em.getTransaction ( ).commit ( );
        } catch (Exception ex) {
            em.getTransaction ( ).rollback ( );
        }
    }

    public void changeFlat(Scanner sc, EntityManager em) throws SQLException {
        System.out.print ("Enter flat id: ");
        String sId = sc.nextLine ( );
        long id = Long.parseLong (sId);
        System.out.print ("Enter new district flat: ");
        String district = sc.nextLine ( );
        System.out.print ("Enter new address flat: ");
        String address = sc.nextLine ( );
        System.out.print ("Enter new area flat: ");
        String sArea = sc.nextLine ( );
        int area = Integer.parseInt (sArea);
        System.out.print ("Enter new count rooms flat: ");
        String sCountRooms = sc.nextLine ( );
        int countRooms = Integer.parseInt (sCountRooms);
        System.out.print ("Enter new price flat: ");
        String sPrice = sc.nextLine ( );
        int price = Integer.parseInt (sPrice);
        Flat fl = null;
        try {
            Query query = em.createQuery ("SELECT c FROM Flat c WHERE c.id = :id", Flat.class);
            query.setParameter ("id", id);
            fl = (Flat) query.getSingleResult ( );
        } catch (NoResultException ex) {
            System.out.println ("Flat not found!");
            return;
        } catch (NonUniqueResultException ex) {
            System.out.println ("Non unique result!");
            return;
        }
        em.getTransaction ( ).begin ( );
        try {
            fl.setDistrict (district);
            fl.setAddress (address);
            fl.setArea (area);
            fl.setCountRooms (countRooms);
            fl.setPrice (price);
            em.getTransaction ( ).commit ( );
        } catch (Exception ex) {
            em.getTransaction ( ).rollback ( );
        }
    }

    public void listFlats(EntityManager em) throws SQLException {
        Query query = em.createQuery ("SELECT c FROM Flat c", Flat.class);
        List<Flat> list = (List<Flat>) query.getResultList ( );
        for (Flat fl : list)
            System.out.println (fl);
    }

    public void selectListFlatsArea(EntityManager em) throws SQLException {
        List<Flat> resulList;
        TypedQuery<Flat> otherQuery = em.createQuery ("SELECT c FROM Flat c WHERE c.area > :area", Flat.class);
        otherQuery.setParameter ("area", 20);
        resulList = otherQuery.getResultList ( );
        for (Flat fl : resulList)
            System.out.println (fl);
    }

    public void selectListFlatsRooms(EntityManager em) throws SQLException {
        List<Flat> resulList;
        TypedQuery<Flat> otherQuery = em.createQuery ("SELECT c FROM Flat c WHERE c.countRooms > :countRooms", Flat.class);
        otherQuery.setParameter ("countRooms", 1);
        resulList = otherQuery.getResultList ( );
        for (Flat fl : resulList)
            System.out.println (fl);
    }

    public void selectListFlatsPrice(EntityManager em) throws SQLException {
        List<Flat> resulList;
        TypedQuery<Flat> otherQuery = em.createQuery ("SELECT c FROM Flat c WHERE c.price < :price", Flat.class);
        otherQuery.setParameter ("price", 40000);
        resulList = otherQuery.getResultList ( );
        for (Flat fl : resulList)
            System.out.println (fl);
    }
}
