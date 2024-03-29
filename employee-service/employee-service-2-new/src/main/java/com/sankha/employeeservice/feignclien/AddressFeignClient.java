package com.sankha.employeeservice.feignclien;

import com.sankha.employeeservice.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ADDRESS-SERVICE", path = "/address-service/api/address")
public interface AddressFeignClient {//proxy
    @GetMapping("/get/{emp_id}")
    public ResponseEntity<AddressResponse> getAddressByEmpId(@PathVariable("emp_id") Integer empId);
}
