package com.todeb.bkolay.usedvehiclesaleapplication.model.mapper;

import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Person;
import com.todeb.bkolay.usedvehiclesaleapplication.model.dto.PersonDTO;

public class PersonMapper {
    public static PersonDTO toDTO(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(person.getName());
        personDTO.setSurname(person.getSurname());
        personDTO.setAbout(person.getAbout());
        personDTO.setEmail(person.getEmail());
        return personDTO;
    }

    public static Person toEntity(PersonDTO personDTO){
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setAbout(personDTO.getAbout());
        person.setEmail(personDTO.getEmail());
        return person;
    }
}
