package com.example.personal_registry_n_maintainer_api.controller;

import com.example.personal_registry_n_maintainer_api.entity.Person;
import com.example.personal_registry_n_maintainer_api.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/persons")
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

    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        Person savedPerson = personService.savePerson(person);
        return ResponseEntity.ok(savedPerson);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@RequestParam Long id){
        personService.deletePerson(id);
    }
}

