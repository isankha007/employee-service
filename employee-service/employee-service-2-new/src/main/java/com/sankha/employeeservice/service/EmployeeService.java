package com.sankha.employeeservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sankha.employeeservice.dto.AddressResponse;
import com.sankha.employeeservice.dto.EmployeeResponse;
import com.sankha.employeeservice.entity.Employee;
import com.sankha.employeeservice.feignclien.AddressFeignClient;
import com.sankha.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final AddressFeignClient addressFeignClient;

    @Value("${address-service.base.url}")
    private String addressUrl;
    private final RestTemplate restTemplate ;



    public EmployeeResponse getEmployeeDetail(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeResponse employeeResponse = objectMapper.convertValue(employee, EmployeeResponse.class);
        employeeResponse.setAddressResponse(addressFeignClient.getAddressByEmpId(id).getBody());
        return employeeResponse;
    }
}
