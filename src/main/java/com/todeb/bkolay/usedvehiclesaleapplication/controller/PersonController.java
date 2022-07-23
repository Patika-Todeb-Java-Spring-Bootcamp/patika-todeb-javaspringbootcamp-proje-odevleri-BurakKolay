package com.todeb.bkolay.usedvehiclesaleapplication.controller;


import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Person;
import com.todeb.bkolay.usedvehiclesaleapplication.model.dto.PersonDTO;
import com.todeb.bkolay.usedvehiclesaleapplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public ResponseEntity getAllPerson(){
        List<Person> allPerson = personService.getAllPerson();
        return ResponseEntity.ok(allPerson);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPersonById(@PathVariable("id") Long id){
        Person byId;
        try {
            byId = personService.getById(id);
        }catch (RuntimeException exception){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewPerson(@RequestBody PersonDTO person){
        Person respPerson = personService.create(person);
        if(respPerson==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Person could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respPerson);
    }

    @DeleteMapping
    public ResponseEntity deletePerson(@RequestParam(name = "id") Long id){
        try {
            personService.delete(id);
        }catch (RuntimeException exception){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Related Person deleted successfully");
    }

    @PutMapping("/{email}")
    public ResponseEntity updatePerson(
            @PathVariable String email,
            @RequestBody Person about)
    {
        Person update = personService.update(email, about);
        if(update == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Person could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }
}
