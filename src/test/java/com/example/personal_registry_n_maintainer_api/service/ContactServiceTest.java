package com.example.personal_registry_n_maintainer_api.service;

import com.example.personal_registry_n_maintainer_api.entity.Contact;
import com.example.personal_registry_n_maintainer_api.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveContactSuccess() {
        Contact contact = new Contact();
        contact.setType(contact.getType());
        contact.setValue("example@example.com");

        when(contactRepository.save(any(Contact.class))).thenReturn(contact);
        contactService.saveContact(contact);
        verify(contactRepository).save(contact);
    }
}
