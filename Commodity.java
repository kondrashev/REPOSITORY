package net.ukr.kondrashev;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Commodity {
    @Id
    @GeneratedValue
    private long id;
    private String called;
    private int price;

    public Commodity() {
    }

    public Commodity(String called, int price) {
        this.called = called;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalled() {
        return called;
    }

    public void setCalled(String called) {
        this.called = called;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", called='" + called + '\'' +
                ", price=" + price +
                '}';
    }
}
