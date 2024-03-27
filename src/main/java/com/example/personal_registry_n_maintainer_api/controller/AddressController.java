package com.example.personal_registry_n_maintainer_api.controller;

import com.example.personal_registry_n_maintainer_api.entity.Address;
import com.example.personal_registry_n_maintainer_api.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addresses")
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

    @PostMapping("/save")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        Address savedAddress = addressService.saveAddress(address);
        return ResponseEntity.ok(savedAddress);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@RequestParam Long id){
        addressService.deleteAddress(id);
    }

}

