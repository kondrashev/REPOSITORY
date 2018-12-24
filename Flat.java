package net.ukr.kondrashev;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String district;
    private String address;
    private int area;
    private int countRooms;
    private int price;

    public Flat() {
    }

    public Flat(String district, String address, int area, int countRooms, int price) {
        this.district = district;
        this.address = address;
        this.area = area;
        this.countRooms = countRooms;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", countRooms=" + countRooms +
                ", price=" + price +
                '}';
    }
}
