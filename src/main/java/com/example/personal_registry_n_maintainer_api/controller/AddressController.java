package com.example.personal_registry_n_maintainer_api.controller;

import com.example.personal_registry_n_maintainer_api.entity.Address;
import com.example.personal_registry_n_maintainer_api.exception.PersonalRegistryException;
import com.example.personal_registry_n_maintainer_api.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findOne(@PathVariable(name = "id") Long id){
        try {
            Address address = addressService.findById(id);
            return ResponseEntity.ok(address);
        }catch (PersonalRegistryException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        Address savedAddress = addressService.saveAddress(address);
        return ResponseEntity.ok(savedAddress);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable(name = "id") Long id){
        try {
            String message = addressService.deleteAddress(id);
            return ResponseEntity.ok(message);
        }catch (PersonalRegistryException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}

