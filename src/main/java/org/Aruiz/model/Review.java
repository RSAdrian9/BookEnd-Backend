package org.Aruiz.model;

import jakarta.persistence.*;

// Clase pendiente
@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="comment")
    private String comment;

    @Column(name="rating")
    private int rating;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    public Review(int id, String comment, int rating, Book book, User user) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.book = book;
        this.user = user;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                ", book=" + book +
                ", user=" + user +
                '}';
    }
}
