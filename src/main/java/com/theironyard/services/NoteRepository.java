package com.theironyard.services;

import com.theironyard.entities.Note;
import com.theironyard.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by noellemachin on 3/14/16.
 */
public interface NoteRepository extends PagingAndSortingRepository<Note, Integer> {
    Page<Note> findByPerson(Person person, Pageable pageable);
}
