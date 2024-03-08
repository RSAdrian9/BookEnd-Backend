package org.Aruiz.model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username",length = 256,nullable = false, unique = true)
    private String username;
    @Column(name="password",nullable = false)
    private String password;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="longitude")
    private Double longitude;

    @Column(name="image_profile")
    private String image_profile;

    @Column(name="biography", columnDefinition = "TEXT")
    private String biography;

    public User(int id, String username, String password, Double latitude, Double longitude, String image_profile, String biography) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image_profile = image_profile;
        this.biography = biography;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getImageProfile() {
        return image_profile;
    }

    public void setImageProfile(String imageProfile) {
        this.image_profile = imageProfile;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", imageProfile='" + image_profile + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}