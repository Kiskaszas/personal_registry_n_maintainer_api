package com.example.personal_registry_n_maintainer_api.controller;

import com.example.personal_registry_n_maintainer_api.entity.Contact;
import com.example.personal_registry_n_maintainer_api.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contacts")
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

    @PostMapping("/save")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.saveContact(contact);
        return ResponseEntity.ok(savedContact);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContact(@RequestParam Long id){
        contactService.deleteContact(id);
    }
}

