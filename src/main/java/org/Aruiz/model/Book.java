package org.Aruiz.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="books")
public class Book {

    @Id
    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "title", length = 256, nullable = false)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "language")
    private String language;

    @Column(name = "editorial")
    private String editorial;

    private short binding; // encuadernación

    @Column(name = "number_pages")
    private short number_pages;

    @Column(name = "year_edition")
    private LocalDate year_edition; // año edición

    @Column(name = "publication_date")
    private LocalDate publication_date; // fecha publicación

    @Column(name = "price")
    private Double price;

    @Column(name = "image")
    private String image;

    public Book() {

    }

    public Book(String isbn, String title, String author, String genre, String sinopsis, String language, String editorial, short binding, short number_pages, LocalDate year_edition, LocalDate publication_date, Double price, String image) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.sinopsis = sinopsis;
        this.language = language;
        this.editorial = editorial;
        this.binding = binding;
        this.number_pages = number_pages;
        this.year_edition = year_edition;
        this.publication_date = publication_date;
        this.price = price;
        this.image = image;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String ISBN) {
        this.isbn = ISBN;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public short getBinding() {
        return binding;
    }

    public void setBinding(short binding) {
        this.binding = binding;
    }

    public short getNumber_pages() {
        return number_pages;
    }

    public void setNumber_pages(short number_pages) {
        this.number_pages = number_pages;
    }

    public LocalDate getYear_edition() {
        return year_edition;
    }

    public void setYear_edition(LocalDate year_edition) {
        this.year_edition = year_edition;
    }

    public LocalDate getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(LocalDate publication_date) {
        this.publication_date = publication_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", language='" + language + '\'' +
                ", editorial='" + editorial + '\'' +
                ", binding=" + binding +
                ", number_pages=" + number_pages +
                ", year_edition=" + year_edition +
                ", publication_date=" + publication_date +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}