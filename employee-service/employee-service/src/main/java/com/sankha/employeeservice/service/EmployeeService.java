package com.sankha.employeeservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sankha.employeeservice.dto.EmployeeResponse;
import com.sankha.employeeservice.entity.Employee;
import com.sankha.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public EmployeeResponse getEmployeeDetail(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return objectMapper.convertValue(employee, EmployeeResponse.class);
    }
}
