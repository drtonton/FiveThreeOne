package com.theironyard.entities;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by noellemachin on 3/14/16.
 */
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    @ManyToOne
    Person person;

    public Note(String text, Person person) {
        this.text = text;
        this.person = person;
    }

    public Note() {
    }
}
