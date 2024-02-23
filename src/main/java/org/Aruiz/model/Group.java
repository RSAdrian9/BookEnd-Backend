package org.Aruiz.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    // Relación con group_user (N:M)
    @ManyToMany
    @JoinTable(name = "group_user",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;

    public Group() {

    }

    public Group(int id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
