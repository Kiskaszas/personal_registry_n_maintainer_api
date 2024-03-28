package com.example.personal_registry_n_maintainer_api.repository;

import com.example.personal_registry_n_maintainer_api.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
