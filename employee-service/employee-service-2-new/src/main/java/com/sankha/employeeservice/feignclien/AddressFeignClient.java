package com.sankha.employeeservice.feignclien;

import com.sankha.employeeservice.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "abc", url = "http://localhost:8182/address-service/api/")
public interface AddressFeignClient {//proxy
    @GetMapping("address/get/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
}
