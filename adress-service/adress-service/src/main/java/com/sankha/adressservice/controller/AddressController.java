package com.sankha.adressservice.controller;

import com.sankha.adressservice.dto.AddressResponse;
import com.sankha.adressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get/{emp_id}")
    public ResponseEntity<AddressResponse> getAddressByEmpId(@PathVariable("emp_id") Integer empId){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressForEmployeeWithId(empId));
    }
}
