package com.geekster.EmployeeManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotEmpty
    private String firstName;
    @Column(nullable = false)
    @NotEmpty
    private String lastName;
    @Column(nullable = false)
    @Pattern(regexp = "\\d{2}-\\d{10}", message = "Phone number should be in the format XX-XXXXXXXXXX")
    private String phoneNumber;
    @Column(nullable = false)
    @NotEmpty
    private String jobRole;
    @Column(nullable = false)
    @NotBlank
    private double salary;
}
