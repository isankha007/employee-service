package com.sankha.adressservice.dto;

public record AddressResponse(
        Integer id,
        String lane1,
        String lane2,
        String zip,
        String state) {
}
