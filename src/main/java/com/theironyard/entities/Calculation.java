package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by noellemachin on 3/14/16.
 */
@Entity
@Table(name = "calculations")
public class Calculation {

    @Id
    @GeneratedValue
    int id;

    int wt;

   @ManyToOne
   Person person;

    public Calculation(int wt, Person person) {
        this.wt = wt;
        this.person = person;
    }

    public Calculation() {
    }
}
