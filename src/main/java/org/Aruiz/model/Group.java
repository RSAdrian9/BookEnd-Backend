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

    @Column(name = "description")
    private String description;

    // Relación con group_user (N:M)
    @ManyToMany
    @JoinTable(name = "group_user",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;

    // Relación con MensajesGrupales (1:N)
    @OneToMany(mappedBy = "group_messages")
    private List<GroupMessage> groupMessages;

    public Group() {

    }

    public Group(int id, String name, String description, List<User> users, List<GroupMessage> groupMessages) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
        this.groupMessages = groupMessages;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<GroupMessage> getGroupMessages() {
        return groupMessages;
    }

    public void setGroupMessages(List<GroupMessage> groupMessages) {
        this.groupMessages = groupMessages;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                ", groupMessages=" + groupMessages +
                '}';
    }
}
