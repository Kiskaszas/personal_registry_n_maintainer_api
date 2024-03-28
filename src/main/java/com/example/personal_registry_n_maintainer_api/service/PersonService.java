package com.example.personal_registry_n_maintainer_api.service;

import com.example.personal_registry_n_maintainer_api.entity.Address;
import com.example.personal_registry_n_maintainer_api.entity.AddressType;
import com.example.personal_registry_n_maintainer_api.entity.Person;
import com.example.personal_registry_n_maintainer_api.exception.PersonalRegistryException;
import com.example.personal_registry_n_maintainer_api.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressService addressService;
    private final ContactService contactService;

    public PersonService(PersonRepository personRepository, AddressService addressService, ContactService contactService) {
        this.personRepository = personRepository;
        this.addressService = addressService;
        this.contactService = contactService;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        Map<AddressType, Long> addressTypeCount = person.getAddresses().stream()
                .collect(Collectors.groupingBy(Address::getType, Collectors.counting()));
        boolean hasDuplicateAddresses = addressTypeCount.values().stream()
                .anyMatch(count -> count > 1);

        if (!hasDuplicateAddresses) {
           Person savedPerson = personRepository.save(person);
           if (savedPerson.getAddresses() != null || savedPerson.getContacts() != null){
               if (savedPerson.getAddresses() != null) {
                   savedPerson.getAddresses().stream().filter(address -> address.getPerson() == null).forEach(address -> address.setPerson(savedPerson));
               }else if (savedPerson.getContacts() != null) {
                   savedPerson.getContacts().stream().filter(contact -> contact.getPerson() == null).forEach(contact -> contact.setPerson(savedPerson));
               }
           }
           return personRepository.save(savedPerson);
       } else {
           throw new PersonalRegistryException("Person has only permanent or temporary address type");
       }
    }

    public Person findById(Long id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()){
            return optionalPerson.get();
        }else {
            throw new PersonalRegistryException("Person not found");
        }
    }
    public String deletePerson(Long id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()){
            Long personId = optionalPerson.get().getId();
            personRepository.deleteById(personId);
            return "Delete successfull.";
        } else {
            throw new PersonalRegistryException("Person not found");
        }
    }

    public Person updatePerson(Person person) {
        Optional<Person> optionalPerson = personRepository.findById(person.getId());
        if (optionalPerson.isPresent()){
            return savePerson(person);
        }else {
            throw new PersonalRegistryException("Person not found");
        }
    }

}
