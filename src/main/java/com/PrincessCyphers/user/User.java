package com.PrincessCyphers.user;

import javax.persistence.*;

@Entity
@Table(name= "users")

public class User {
    @Id             // shows that this is primary col in table
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // allows db to auto gen id col
    private int id;

    @Column(nullable = false, unique=true, length = 50)               // value required and must be unique
    private String email;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 50, nullable = false, name = "first_Name")
    private String firstName;

    @Column(length = 50, nullable = false, name = "last_Name")
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
