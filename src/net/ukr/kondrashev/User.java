package net.ukr.kondrashev;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.management.relation.Role;

public class User {
    private String login;
    private String Password;
    private String surname;
    private String role;

    public User(String login, String password, String surname, String role) {
        this.login = login;
        Password = password;
        this.surname = surname;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
