package com.example.personal_registry_n_maintainer_api.service;

import com.example.personal_registry_n_maintainer_api.entity.Contact;
import com.example.personal_registry_n_maintainer_api.exception.PersonalRegistryException;
import com.example.personal_registry_n_maintainer_api.repository.ContactRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact findById(Long id){
        Optional<Contact> optionalPerson = contactRepository.findById(id);
        if (optionalPerson.isPresent()){
            return optionalPerson.get();
        }else {
            throw new PersonalRegistryException("Contact not found");
        }
    }

    public String deleteContact(Long id){
        Optional<Contact> optionalAddress = contactRepository.findById(id);
        if (optionalAddress.isPresent()){
            Long personId = optionalAddress.get().getId();
            contactRepository.deleteById(personId);
            return "Delete successfull";
        } else {
            throw new PersonalRegistryException("Contact not found");
        }
    }

}
