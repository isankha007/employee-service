package com.sankha.employeeservice.dto;

public record EmployeeResponse(
        String name,
        Integer id,
        String email,
        String bloodGroup
) {
}
