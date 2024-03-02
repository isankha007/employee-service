package com.sankha.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeResponse {
    private  String name;
    private  Integer id;
    private  String email;
    private  String bloodGroup;
    private AddressResponse addressResponse;


}
