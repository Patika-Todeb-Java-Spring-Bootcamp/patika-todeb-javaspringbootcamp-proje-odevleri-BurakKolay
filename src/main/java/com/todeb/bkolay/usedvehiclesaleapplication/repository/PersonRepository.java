package com.todeb.bkolay.usedvehiclesaleapplication.repository;

import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByEmail(String email);

    List<Person> getAllByAboutIgnoreCase(String about);
}
