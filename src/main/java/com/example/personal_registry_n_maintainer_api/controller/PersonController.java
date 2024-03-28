package com.example.personal_registry_n_maintainer_api.controller;

import com.example.personal_registry_n_maintainer_api.entity.Person;
import com.example.personal_registry_n_maintainer_api.exception.PersonalRegistryException;
import com.example.personal_registry_n_maintainer_api.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findOne(@PathVariable(name = "id") Long id){
        try {
            Person person = personService.findById(id);
            return ResponseEntity.ok(person);
        }catch (PersonalRegistryException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        try{
            Person savedPerson = personService.savePerson(person);
            return ResponseEntity.ok(savedPerson);
        }catch (PersonalRegistryException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        try {
            Person updatedPerson = personService.updatePerson(person);
            return ResponseEntity.ok(updatedPerson);
        }catch (PersonalRegistryException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable(name = "id") Long id){
        try {
            String message = personService.deletePerson(id);
            return ResponseEntity.ok(message);
        }catch (PersonalRegistryException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

