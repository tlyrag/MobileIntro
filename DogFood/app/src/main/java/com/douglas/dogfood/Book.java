package com.douglas.dogfood;

public class Book {
    int id;
    String Title;
    String Author;
    String Genre;
    Double Price;
    int Stock;

    public Book(int id, String title, String author, String genre, Double price, int stock) {
        this.id = id;
        Title = title;
        Author = author;
        Genre = genre;
        Price = price;
        Stock = stock;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Price=" + Price +
                ", Stock=" + Stock +
                '}';
    }
}
