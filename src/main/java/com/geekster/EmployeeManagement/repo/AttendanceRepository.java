package com.geekster.EmployeeManagement.repo;

import com.geekster.EmployeeManagement.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findAllByEmployeeIdAndDate(Long employeeId, LocalDate date);
}
