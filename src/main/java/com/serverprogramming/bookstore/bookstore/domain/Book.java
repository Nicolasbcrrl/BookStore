package com.serverprogramming.bookstore.bookstore.domain;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;
    private String years;
    private double price;

    public Book() {
    }

    public Book(String isbn,String title, String author, String years, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.years = years;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(years, book.years) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, years, isbn, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + years + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return years;
    }

    public void setYear(String year) {
        this.years = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
