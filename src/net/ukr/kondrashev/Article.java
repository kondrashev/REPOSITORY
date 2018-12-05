package net.ukr.kondrashev;

public class Article {
    private String surname;
    private long date;
    private String author;
    private String article;

    public Article(String surname, String author, String article) {
        this.surname = surname;
        this.date = System.currentTimeMillis();
        this.author = author;
        this.article = article;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
