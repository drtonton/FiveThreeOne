package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by noellemachin on 3/10/16.
 */
@Entity
@Table(name = "maxes")
public class Max {

    @Id
    @GeneratedValue
    int id;

    int bench;
    int squat;
    int shoulderPress;
    int deadLift;

    @ManyToOne
    Person person;

    public Max(int bench, int squat, int shoulderPress, int deadLift, Person person) {
        this.bench = bench;
        this.squat = squat;
        this.shoulderPress = shoulderPress;
        this.deadLift = deadLift;
        this.person = person;
    }

    public Max() {
    }
}
