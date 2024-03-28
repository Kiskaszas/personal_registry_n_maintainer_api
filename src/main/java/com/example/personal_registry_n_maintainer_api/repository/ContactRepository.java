package com.example.personal_registry_n_maintainer_api.repository;

import com.example.personal_registry_n_maintainer_api.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
