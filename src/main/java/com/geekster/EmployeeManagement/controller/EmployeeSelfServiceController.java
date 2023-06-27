package com.geekster.EmployeeManagement.controller;

import com.geekster.EmployeeManagement.model.Employee;
import com.geekster.EmployeeManagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/self-service")
public class EmployeeSelfServiceController {


    @Autowired
    EmployeeRepo employeeRepository;

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        // Update employee's personal information
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());

        return employeeRepository.save(employee);
    }
}
