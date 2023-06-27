package com.geekster.EmployeeManagement.controller;

import com.geekster.EmployeeManagement.model.Attendance;
import com.geekster.EmployeeManagement.model.Employee;
import com.geekster.EmployeeManagement.repo.AttendanceRepository;
import com.geekster.EmployeeManagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/attendance")

public class AttendanceController {
    @Autowired
    EmployeeRepo employeeRepository;
    @Autowired
    AttendanceRepository attendanceRepository;
    @GetMapping("/{employeeId}")
    public List<Attendance> getStudentAttendance(@PathVariable Long employeeId) {
        return attendanceRepository.findAllByEmployeeIdAndDate(employeeId, LocalDate.now());
    }

    @PostMapping("/{employeeId}")
    public Attendance markAttendance(@PathVariable Long employeeId, @RequestParam("present") boolean present,
                                     @RequestParam(value = "date", required = false)
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        if (date == null) {
            date = LocalDate.now();
        }

        Attendance attendance = new Attendance();
        attendance.setEmployee(employee);
        attendance.setDate(date);
        attendance.setPresent(present);

        return attendanceRepository.save(attendance);
    }
}
