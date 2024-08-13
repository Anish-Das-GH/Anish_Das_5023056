package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<Page<Employee>> getAllEmployees(
            @RequestParam(required = false, defaultValue = "") String nameFragment,
            @PageableDefault(sort = {"id"}) Pageable pageable) {
        Page<Employee> employees = employeeRepository.findByNameContaining(nameFragment, pageable);
        return ResponseEntity.ok(employees);
    }


}
