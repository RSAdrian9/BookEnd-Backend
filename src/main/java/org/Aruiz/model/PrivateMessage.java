package org.Aruiz.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "private_messages")
public class PrivateMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    public PrivateMessage() {
    }

    public PrivateMessage(int id, Date date, String text, User user, User receiver) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.user = user;
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "PrivateMessage{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", receiver=" + receiver +
                '}';
    }
}
