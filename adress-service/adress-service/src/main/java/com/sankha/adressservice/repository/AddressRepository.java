package com.sankha.adressservice.repository;

import com.sankha.adressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query(nativeQuery = true,value = "SELECT ea.id,ea.lane1,ea.lane2,ea.zip,ea.state FROM `employee-db-all`.address ea join `employee-db-all`.employee e on e.id=ea.id where e.id=:employeeId")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
