package com.todeb.bkolay.usedvehiclesaleapplication.service;

import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Person;
import com.todeb.bkolay.usedvehiclesaleapplication.model.dto.PersonDTO;
import com.todeb.bkolay.usedvehiclesaleapplication.model.mapper.PersonMapper;
import com.todeb.bkolay.usedvehiclesaleapplication.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAllPerson(){
        List<Person> allPerson = personRepository.findAll();
        return allPerson;
    }

    public Person getById(Long id){
        Optional<Person> byId = personRepository.findById(id);
        return byId.orElseThrow(()-> new RuntimeException("Person not found"));
    }

    public Person create(PersonDTO personDTO){
        Person person = PersonMapper.toEntity(personDTO);
        Person person1 = personRepository.save(person);
        return personRepository.save(person1);
    }

    public void delete(Long id){
        getById(id);
        personRepository.deleteById(id);
    }

    public Person update(String email, Person person){
        Optional<Person> personByEmail = personRepository.findPersonByEmail(email);
        if(!personByEmail.isPresent()){
            return null;
        }
        Person updatedPerson = personByEmail.get();
        if(!StringUtils.isEmpty(person.getEmail())){
            updatedPerson.setEmail(person.getEmail());
        }
        if(!StringUtils.isEmpty(person.getAbout())){
            updatedPerson.setAbout(person.getAbout());
        }
        return personRepository.save(updatedPerson);
    }
}
