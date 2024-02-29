package com.sankha.employeeservice.controller;

import com.sankha.employeeservice.dto.EmployeeResponse;
import com.sankha.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse getEmployeeDetails(@PathVariable("id") int id){
        return employeeService.getEmployeeDetail(id);
    }

}
