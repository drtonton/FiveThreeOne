package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by noellemachin on 3/10/16.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}