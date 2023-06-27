package com.geekster.EmployeeManagement.repo;

import com.geekster.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
