package com.example.personal_registry_n_maintainer_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "birth_date")
    private String birthDate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.MERGE, targetEntity = Address.class)
    private List<Address> addresses;

    @OneToMany(mappedBy = "person", cascade = CascadeType.MERGE, targetEntity = Contact.class)
    private List<Contact> contacts;

}

