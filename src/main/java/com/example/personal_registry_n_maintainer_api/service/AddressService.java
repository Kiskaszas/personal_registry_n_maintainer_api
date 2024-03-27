package com.example.personal_registry_n_maintainer_api.service;

import com.example.personal_registry_n_maintainer_api.entity.Address;
import com.example.personal_registry_n_maintainer_api.exception.PersonalRegistryException;
import com.example.personal_registry_n_maintainer_api.repositoy.AddressRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address findById(Long id){
        Optional<Address> optionalPerson = addressRepository.findById(id);
        if (optionalPerson.isPresent()){
            return optionalPerson.get();
        }else {
            throw new PersonalRegistryException("Address not found");
        }
    }

    public void deleteAddress(Long id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()){
            Long personId = optionalAddress.get().getId();
            addressRepository.deleteById(personId);
        } else {
            throw new PersonalRegistryException("Address not found");
        }
    }
}

