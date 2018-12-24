package net.ukr.kondrashev;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class OrderCommodity {

    public void addClient(Scanner sc, EntityManager em) throws SQLException {
        System.out.print ("Enter surname client: ");
        String surname = sc.nextLine ( );
        System.out.print ("Enter phone client: ");
        String phone = sc.nextLine ( );
        em.getTransaction ( ).begin ( );
        try {
            Client cl = new Client (surname, phone);
            em.persist (cl);
            em.getTransaction ( ).commit ( );
        } catch (Exception ex) {
            em.getTransaction ( ).rollback ( );
        }
        Query query = em.createQuery ("SELECT c FROM Client c", Client.class);
        List<Client> list = (List<Client>) query.getResultList ( );
        for (Client cl : list)
            System.out.println (cl);
    }

    public void addCommodity(Scanner sc, EntityManager em) throws SQLException {
        System.out.print ("Enter called commodity: ");
        String called = sc.nextLine ( );
        System.out.print ("Enter price commodity: ");
        String sPrice = sc.nextLine ( );
        int price = Integer.parseInt (sPrice);
        em.getTransaction ( ).begin ( );
        try {
            Commodity ct = new Commodity (called, price);
            em.persist (ct);
            em.getTransaction ( ).commit ( );
        } catch (Exception ex) {
            em.getTransaction ( ).rollback ( );
        }
        Query query = em.createQuery ("SELECT c FROM Commodity c", Commodity.class);
        List<Commodity> list = (List<Commodity>) query.getResultList ( );
        for (Commodity ct : list)
            System.out.println (ct);
    }

    public void addOrder(Scanner sc, EntityManager em) throws SQLException {
        System.out.print ("Enter client id: ");
        String sId = sc.nextLine ( );
        long id = Long.parseLong (sId);
        Client cl = null;
        try {
            Query query = em.createQuery ("SELECT c FROM Client c WHERE c.id = :id", Client.class);
            query.setParameter ("id", id);
            cl = (Client) query.getSingleResult ( );
            System.out.println (cl);
        } catch (NoResultException ex) {
            System.out.println ("Client not found!");
            return;
        } catch (NonUniqueResultException ex) {
            System.out.println ("Non unique result!");
            return;
        }
        System.out.print ("Enter commodity id: ");
        sId = sc.nextLine ( );
        id = Long.parseLong (sId);
        Commodity ct = null;
        try {
            Query query = em.createQuery ("SELECT c FROM Commodity c WHERE c.id = :id", Commodity.class);
            query.setParameter ("id", id);
            ct = (Commodity) query.getSingleResult ( );
            System.out.println (ct);
        } catch (NoResultException ex) {
            System.out.println ("Commodity not found!");
            return;
        } catch (NonUniqueResultException ex) {
            System.out.println ("Non unique result!");
            return;
        }
        em.getTransaction ( ).begin ( );
        try {
            Store st = new Store (cl.getSurname ( ), cl.getPhone ( ), ct.getCalled ( ), ct.getPrice ( ));
            em.persist (st);
            em.getTransaction ( ).commit ( );
        } catch (Exception ex) {
            em.getTransaction ( ).rollback ( );
        }
        Query query = em.createQuery ("SELECT c FROM Store c", Store.class);
        List<Store> list = (List<Store>) query.getResultList ( );
        for (Store store : list)
            System.out.println (store);
    }
}
