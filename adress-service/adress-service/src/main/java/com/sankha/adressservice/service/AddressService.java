package com.sankha.adressservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sankha.adressservice.dto.AddressResponse;
import com.sankha.adressservice.entity.Address;
import com.sankha.adressservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository repository;
    private final ObjectMapper mapper= new ObjectMapper();
    public AddressResponse getAddressForEmployeeWithId(Integer empId) {
        Address noAddress = repository.findAddressByEmployeeId(empId).orElseThrow(() -> new RuntimeException("No Address"));
        return mapper.convertValue(noAddress,AddressResponse.class);
    }
}
