package com.example.personal_registry_n_maintainer_api.service;

import com.example.personal_registry_n_maintainer_api.entity.Address;
import com.example.personal_registry_n_maintainer_api.entity.AddressType;
import com.example.personal_registry_n_maintainer_api.entity.Person;
import com.example.personal_registry_n_maintainer_api.exception.PersonalRegistryException;
import com.example.personal_registry_n_maintainer_api.repository.PersonRepository;
import com.example.personal_registry_n_maintainer_api.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    public PersonServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSavePersonSuccess() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setBirthDate("1990-05-15");

        Address address1 = new Address();
        address1.setType(AddressType.PERMANENT);
        Address address2 = new Address();
        address2.setType(AddressType.TEMPORARY);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);

        person.setAddresses(addresses);

        when(personRepository.save(any(Person.class))).thenReturn(person);

        Person savedPerson = personService.savePerson(person);

        assert(savedPerson != null);
    }

    @Test
    public void testSavePerson_DuplicateAddresses_Failure() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setBirthDate("1990-05-15");

        Address address1 = new Address();
        address1.setType(AddressType.PERMANENT);
        Address address2 = new Address();
        address2.setType(AddressType.PERMANENT);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);

        person.setAddresses(addresses);

        assertThrows(PersonalRegistryException.class, () -> {
            personService.savePerson(person);
        });

        verify(personRepository, never()).save(person);
    }
}

