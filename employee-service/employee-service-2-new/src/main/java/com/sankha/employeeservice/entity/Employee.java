package com.sankha.employeeservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
//    id, name, email, bloodgroup
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "bloodgroup")
    private String bloodGroup;



}
