package com.theironyard.services;

import com.theironyard.entities.Calculation;
import com.theironyard.entities.Person;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by noellemachin on 3/14/16.
 */
public interface CalculationRepository extends CrudRepository<Calculation, Integer> {
    List<Calculation> findByPerson(Person person);
}
