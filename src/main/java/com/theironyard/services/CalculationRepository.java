package com.theironyard.services;

import com.theironyard.entities.Calculation;
import com.theironyard.entities.Person;
import org.hibernate.mapping.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by noellemachin on 3/14/16.
 */
public interface CalculationRepository extends CrudRepository<Calculation, Integer> {
    List findByPerson(Person person);
}
