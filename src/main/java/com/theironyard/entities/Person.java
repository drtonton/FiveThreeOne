package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by noellemachin on 3/10/16.
 */
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String userName;

    @Column(nullable = false)
    String passwordHash;

    public Person(String userName, String passwordHash) {
        this.userName = userName;
        this.passwordHash = passwordHash;
    }

    public Person() {
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
