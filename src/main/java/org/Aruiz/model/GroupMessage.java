package org.Aruiz.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "group_messages")
public class GroupMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date")
    private Date date;

    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public GroupMessage() {

    }

    public GroupMessage(int id, Date date, String text, User user, Group group) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.user = user;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "GroupMessage{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", group=" + group +
                '}';
    }
}
