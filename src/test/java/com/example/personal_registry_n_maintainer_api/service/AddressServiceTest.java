package com.example.personal_registry_n_maintainer_api.service;

import com.example.personal_registry_n_maintainer_api.entity.Address;
import com.example.personal_registry_n_maintainer_api.entity.AddressType;
import com.example.personal_registry_n_maintainer_api.repository.AddressRepository;
import com.example.personal_registry_n_maintainer_api.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveAddressSuccess() {
        Address address = new Address();
        address.setStreet("123 Main Street");
        address.setCity("New York");
        address.setPostalCode("54321");
        address.setType(AddressType.PERMANENT);

        when(addressRepository.save(any(Address.class))).thenReturn(address);
        addressService.saveAddress(address);
        verify(addressRepository).save(address);
    }
}


