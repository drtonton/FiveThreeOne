package com.theironyard.services;

import com.theironyard.entities.Note;
import com.theironyard.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by noellemachin on 3/14/16.
 */
public interface NoteRepository extends CrudRepository<Note, Integer> {
    List<Note> findByPerson(Person person);
}
