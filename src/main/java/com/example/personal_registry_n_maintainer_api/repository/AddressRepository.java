package com.example.personal_registry_n_maintainer_api.repository;

import com.example.personal_registry_n_maintainer_api.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

