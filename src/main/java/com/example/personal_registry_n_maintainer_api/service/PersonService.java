package com.example.personal_registry_n_maintainer_api.service;

import com.example.personal_registry_n_maintainer_api.entity.Contact;
import com.example.personal_registry_n_maintainer_api.entity.Person;
import com.example.personal_registry_n_maintainer_api.exception.PersonalRegistryException;
import com.example.personal_registry_n_maintainer_api.repositoy.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person findById(Long id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()){
            return optionalPerson.get();
        }else {
            throw new PersonalRegistryException("Person not found");
        }
    }
    public void deletePerson(Long id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()){
            Long personId = optionalPerson.get().getId();
            personRepository.deleteById(personId);
        } else {
            throw new PersonalRegistryException("Person not found");
        }
    }

}
