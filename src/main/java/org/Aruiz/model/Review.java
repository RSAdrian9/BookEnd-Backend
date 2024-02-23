package org.Aruiz.model;

import jakarta.persistence.*;

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
}
