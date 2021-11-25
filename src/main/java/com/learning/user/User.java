package com.learning.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name= "users")
public class User {
    @Id             // shows that this is primary col in table
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // allows db to auto gen id col
    private Integer id;

    @Column(nullable = false, unique=true, length = 45)               // value required and must be unique
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 45, name = "first_Name")
    private String firstName;

    @Column(nullable = false, length = 45, name = "last_Name")
    private String lastName;
}
