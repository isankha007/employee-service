package com.sankha.employeeservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sankha.employeeservice.dto.AddressResponse;
import com.sankha.employeeservice.dto.EmployeeResponse;
import com.sankha.employeeservice.entity.Employee;
import com.sankha.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${address-service.base.url}")
    private String addressUrl;
    private final RestTemplate restTemplate ;

    private final DiscoveryClient discoveryClient;
    private final LoadBalancerClient loadBalancerClient;



    public EmployeeResponse getEmployeeDetail(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeResponse employeeResponse = objectMapper.convertValue(employee, EmployeeResponse.class);
        employeeResponse.setAddressResponse(getAddress(id));
        return employeeResponse;
    }

    private AddressResponse getAddress(int id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("ADDRESS-SERVICE");
//        String uri = instances.get(0).getUri().toString();
        ServiceInstance instance = loadBalancerClient.choose("ADDRESS-SERVICE");
        String uri = instance.getUri().toString();
        String contextRoot = instance.getMetadata().get("configPath");
        System.out.println("uri = " + uri+contextRoot);
        return restTemplate.getForObject(uri +contextRoot+ "/address/get/{id}", AddressResponse.class, id);
    }
}
