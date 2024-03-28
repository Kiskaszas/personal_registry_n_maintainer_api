package com.example.personal_registry_n_maintainer_api.controller;

import com.example.personal_registry_n_maintainer_api.entity.Address;
import com.example.personal_registry_n_maintainer_api.entity.Contact;
import com.example.personal_registry_n_maintainer_api.exception.PersonalRegistryException;
import com.example.personal_registry_n_maintainer_api.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findOne(@PathVariable(name = "id") Long id){
        try {
            Contact contact = contactService.findById(id);
            return ResponseEntity.ok(contact);
        }catch (PersonalRegistryException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.saveContact(contact);
        return ResponseEntity.ok(savedContact);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable(name = "id") Long id){
        try {
            String message = contactService.deleteContact(id);
            return ResponseEntity.ok(message);
        }catch (PersonalRegistryException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

