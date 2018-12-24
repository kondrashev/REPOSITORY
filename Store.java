package net.ukr.kondrashev;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Store {
    @Id
    @GeneratedValue
    private long id;
    private String surnameClient;
    private String phoneClient;
    private String called;
    private int price;

    public Store() {
    }

    public Store(String surnameClient, String phoneClient, String called, int price) {
        this.surnameClient = surnameClient;
        this.phoneClient = phoneClient;
        this.called = called;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public void setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
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
        return "Store{" +
                "id=" + id +
                ", surnameClient='" + surnameClient + '\'' +
                ", phoneClient='" + phoneClient + '\'' +
                ", called='" + called + '\'' +
                ", price=" + price +
                '}';
    }
}
