package com.example.personal_registry_n_maintainer_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AddressType type;

    private String street;
    private String city;
    private String country;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
