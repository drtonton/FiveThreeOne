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

    public Note(String text) {
        this.text = text;
    }

    public Note() {
    }
}
